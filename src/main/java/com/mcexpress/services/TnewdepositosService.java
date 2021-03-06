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
		UserSS user = UserService.authenticated();
		if(user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		//obj.setCODMENSAGEIRO(user.getId());
		System.out.println("\n\t CODIGO DO MENSAGEIRO JÁ AUTENTICADO: "+ user.getId() + ", E DATA FECHAMENTO: " + obj.getDTFECHAMENTO());
		
		List<String> listaDeposito = repoRecibos.findByDeposito(user.getId(), obj.getDTFECHAMENTO());
		
		String var;
		String[] vetLista = new String[2];
		
		TdepositoDTO depositoDTO = new TdepositoDTO();
		
		for (int i = 0; i < listaDeposito.size(); i++) {
			
			var = listaDeposito.get(i);
			vetLista = var.split(",");
			
			depositoDTO.setQtdrecibos(Integer.parseInt(vetLista[0]));
			depositoDTO.setValorDeposito(Double.parseDouble(vetLista[1]));
			
			System.out.println("\nTOTAL OBJ WEB (Back-end): " + depositoDTO.getValorDeposito() + "\nTotal OBJ APP (App): " + obj.getTOTALARRECADADO());
		}
		
		if (obj.getTOTALARRECADADO().equals(depositoDTO.getValorDeposito())) {
			Integer nrodeposito = findMax()+1;
			obj.setNRODEPOSITO(nrodeposito);
			obj.setQTDRECIBOS(depositoDTO.getQtdrecibos());
			//obj.setEmail(user.getUsername());
			//obj.setCODMENSAGEIRO(user.getId());
			
			System.out.println("\nTOTAL OBJ WEB (Back-end): " + depositoDTO.getValorDeposito() + "\nTotal OBJ APP (App): " + obj.getTOTALARRECADADO());
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
		
//		Tnewdepositos obj = repo.findId(user.getId());
//		obj.setIMAGEURL(uri.toString());
//		repo.save(obj);
		
		return uri;
	}
	
}
