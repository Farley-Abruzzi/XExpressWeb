package com.mcexpress.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcexpress.domain.Tnewdepositos;
import com.mcexpress.repositories.TnewdepositosRepository;

@Service
public class TnewdepositosService {
	
	@Autowired
	private TnewdepositosRepository repo;
	
	public Integer findMax() {
		Integer obj = repo.findMax();
		return obj;
		// tipo do objeto que trouxe essa exceção
	}
	
	public Tnewdepositos insert(Tnewdepositos obj) {
		
		try {
			Integer nrodeposito = findMax()+1;
			obj.setNRODEPOSITO(nrodeposito);
			return repo.save(obj);
		} catch (Exception e) {
			obj.setNRODEPOSITO(1);
			return repo.save(obj);
		}
		
	}
	
}
