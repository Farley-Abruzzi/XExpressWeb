package com.mcexpress.services;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mcexpress.domain.Tnewdepositos;
import com.mcexpress.dto.TdepositoDTO;
import com.mcexpress.repositories.TnewdepositosRepository;
import com.mcexpress.repositories.TrecibosRepository;
import com.mcexpress.security.UserSS;
import com.mcexpress.services.exceptions.AuthorizationException;
import com.mcexpress.services.exceptions.ObjectNotFountException;

@Service
public class TnewdepositosService {
	
	@Autowired
	private TnewdepositosRepository repo;
	
	@Autowired
	private TrecibosRepository repoRecibos;
	
	@Autowired
	private S3Service s3Service;
	
	
	public Tnewdepositos find(Integer id) {
		Optional<Tnewdepositos> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Tnewdepositos.class.getName()));
		//tipo do objeto que trouxe essa exceção
	}
	
	public Integer findMax() {
		Integer obj = repo.findMax();
		return obj;
	}
	
	
	public Tnewdepositos insert(Tnewdepositos obj) {
//		UserSS user = UserService.authenticated();
//		if(user == null) {
//			throw new AuthorizationException("Acesso negado");
//		}
		
		List<String> listaDeposito = repoRecibos.findByDeposito(obj.getCODMENSAGEIRO(), obj.getDTFECHAMENTO());
		
		String var;
		String[] vetLista = new String[2];
		
		TdepositoDTO depositoDTO = new TdepositoDTO();
		
		for (int i = 0; i < listaDeposito.size(); i++) {
			
			var = listaDeposito.get(i);
			vetLista = var.split(",");
			
			depositoDTO.setQtdrecibos(Integer.parseInt(vetLista[0]));
			depositoDTO.setValorDeposito(Double.parseDouble(vetLista[1]));
		}
		
		if (obj.getTOTALARRECADADO().equals(depositoDTO.getValorDeposito())) {
			Integer nrodeposito = findMax()+1;
			obj.setNRODEPOSITO(nrodeposito);
			obj.setQTDRECIBOS(depositoDTO.getQtdrecibos());
//			obj.setEmail(user.getUsername());
			
			System.out.println("\nTOTAL OBJ WEB: " + obj.getTOTALARRECADADO() + "\nTotal ObjDTO BD: " + depositoDTO.getValorDeposito());
			return repo.save(obj);
		} else {
			System.out.println("\nVALOR DE DEPOSITO INCORRETO: "+ obj.getTOTALARRECADADO());
			return null;
		}
	}
	
	public URI uploadProfilePicture(MultipartFile multipartFile) {
		UserSS user = UserService.authenticated();
		if(user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		URI uri = s3Service.uploadFile(multipartFile);
		
		Tnewdepositos obj = repo.findByEmail(user.getUsername());
		obj.setIMAGEURL(uri.toString());
		repo.save(obj);
		
		return uri;
	}
	
}
