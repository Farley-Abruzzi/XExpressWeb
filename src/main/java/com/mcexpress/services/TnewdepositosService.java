package com.mcexpress.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcexpress.domain.Tnewdepositos;
import com.mcexpress.dto.TdepositoDTO;
import com.mcexpress.repositories.TnewdepositosRepository;
import com.mcexpress.repositories.TrecibosRepository;
import com.mcexpress.services.exceptions.ObjectNotFountException;

@Service
public class TnewdepositosService {
	
	@Autowired
	private TnewdepositosRepository repo;
	
	@Autowired
	private TrecibosRepository repoRecibos;
	
	
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
	
	
//	public List<TdepositosDTO> validarDeposito(Integer codmensageiro, Date dtfechamento) {
//		
//			
//		List<String> listDeposito = repo.findByDeposito(codmensageiro, dtfechamento);
//		
//		String var;
//		String[] vetLista = new String[2];
//		
//		List<TdepositosDTO> listDepositoDTO = new ArrayList<>();
//		
//		for (int i = 0; i < listDeposito.size(); i++) {
//			
//			TdepositosDTO depositoDTO = new TdepositosDTO();
//			
//			var = listDeposito.get(i);
//			vetLista = var.split(",");
//			
//			depositoDTO.setTotalarrecadado(Double.parseDouble(vetLista[0]));
//			depositoDTO.setQtdrecibos(Integer.parseInt(vetLista[1]));
//			
//			listDepositoDTO.add(depositoDTO);
//		}
//		
//		return listDepositoDTO;
//	}
	
	public Tnewdepositos insert(Tnewdepositos obj) {
		
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
			
			System.out.println("\nTOTAL ARRECADADO OBJ WEB: " + obj.getTOTALARRECADADO() + "\nTotal arrecadado ObjDTO BD: " + depositoDTO.getValorDeposito());
			return repo.save(obj);
		} else {
			System.out.println("\nVALOR DE DEPOSITO INCORRETO: "+ obj.getTOTALARRECADADO());
			return null;
		}
		
	}
	
}
