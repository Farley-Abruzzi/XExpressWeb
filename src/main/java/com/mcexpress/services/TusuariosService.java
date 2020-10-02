package com.mcexpress.services;

import java.net.URI;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mcexpress.domain.Tusuarios;
import com.mcexpress.domain.enums.Perfil;
import com.mcexpress.repositories.TusuariosRepository;
import com.mcexpress.security.UserSS;
import com.mcexpress.services.exceptions.AuthorizationException;
import com.mcexpress.services.exceptions.ObjectNotFountException;

@Service
public class TusuariosService {

	@Autowired
	private BCryptPasswordEncoder pe;

//	pe.encode(objDto.getSenha());

	@Autowired
	private TusuariosRepository repo;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private S3Service s3Service;

	// ========================================Usuario por ID

	public Tusuarios findById(Integer id) {
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Tusuarios> obj = repo.findById(id);

		// Agora o meu método de serviço lança uma exceção caso o id não exista, porém o rest tem
		// que capturar a exceção e enviar um JSON apropriado para a resposta HTTP do meu recurso  
		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Tusuarios.class.getName()));
		// tipo do objeto que trouxe essa exceção
	}

	// =================================Usuário código máximo de incremento no BD
	// Firebird=============
	public Integer findMax() {
		Integer obj = repo.findMax();
		return obj;
		// tipo do objeto que trouxe essa exceção
	}

	public Tusuarios insert(Tusuarios obj) {
		// tratar exceção caso banco for vazio
		try {
			Integer codUsuario = findMax() + 1;
			// apontar proximo id do usuario
			obj.setCODUSUARIO(codUsuario);
			String senha = pe.encode(obj.getSENHAJAVA());
			obj.setSENHAJAVA(senha);
			obj.setDTULTALTERACAO(new Date(System.currentTimeMillis()));
			emailService.sendOrderConfirmationHtmlEmail(obj);
			return repo.save(obj);
		} catch (Exception e) {
			// apontar id inicial do banco
			obj.setCODUSUARIO(1);
			return repo.save(obj);
		}
	}
	
	public URI uploadProfilePicture(MultipartFile multipartFile) {
		UserSS user = UserService.authenticated();
		if(user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		URI uri = s3Service.uploadFile(multipartFile);
		
		Tusuarios mensageiro = repo.findOne(user.getId());
		mensageiro.setImageUrl(uri.toString());
		repo.save(mensageiro);
		
		return uri;
	}

}
