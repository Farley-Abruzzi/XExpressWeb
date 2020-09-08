package com.mcexpress.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mcexpress.domain.Trecibos;
import com.mcexpress.dto.TrecebidoMensageiroDTO;
import com.mcexpress.dto.TrecibosDTO3;
import com.mcexpress.dto.TrecibosDTO4;
import com.mcexpress.dto.TrecibosDTO5;
import com.mcexpress.dto.TrecibosRelatorioDiarioDTO;
//import com.mcexpress.dto.TrecibosPorMensageiroDTO;
import com.mcexpress.dto.TrecibosReprocessarDTO;
import com.mcexpress.dto.TresumoRecibosDTO;
import com.mcexpress.repositories.TfuncionariosRepository;
import com.mcexpress.repositories.TrecibosRepository;
import com.mcexpress.security.UserSS;
import com.mcexpress.services.exceptions.AuthorizationException;
import com.mcexpress.services.exceptions.DataIntegrityException;
import com.mcexpress.services.exceptions.ObjectNotFountException;

//anotação de serviço do springboot
@Service
public class TrecibosService {

	@Autowired
	private TrecibosRepository repo;

	@Autowired
	private TfuncionariosRepository repoFunc;

	public Trecibos find(Integer id) {
		Optional<Trecibos> obj = repo.findId(id);

		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Trecibos.class.getName()));
		// tipo do objeto que trouxe essa exceção
	}

	// =================================Recibos por id do mensageiro com paginação
	public Page<Trecibos> findAllByMensRecibo(Integer cod, Integer page, Integer linesPerPage, String orderBy,
			String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAllByMensRecibo(cod, pageRequest);

	}

	// ==================================Recibos por id do mensageiro entre datas
	public List<Trecibos> findByMensageiroRecibo(Integer cod, Date startDate, Date endDate) {

		System.out.println("\n\n\n cod: " + cod + " StartDate: " + startDate + " EndDate: " + endDate + "\n\n\n");
		List<Trecibos> list = repo.findByMensageiroRecibo(cod, startDate, endDate);
		return list;
	}
	
	//================================== Recibos por id do mensageiro entre datas (recebido) =================
	public Page<Trecibos> findRecibosRecebidos(Integer cod, Date startDate, Date endDate, Integer page, Integer linesPerPage, String orderBy,
			String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<Trecibos> list = repo.findRecibosRecebidos(cod, startDate, endDate, pageRequest);
		return list;
		
	}
	
	//================================== Recibos por id do mensageiro entre datas (Em abertdo) =================
	public Page<Trecibos> findRecibosAbertos(Integer cod, Date startDate, Date endDate, Integer page, Integer linesPerPage, String orderBy,
			String direction) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<Trecibos> list = repo.findRecibosAbertos(cod, startDate, endDate, pageRequest);
		return list;
		
	}
	
	// ==================================Recibos por id do mensageiro entre datas ==== Tabela do App mobile
	public List<Trecibos> findRecibosApp(Integer cod, Date startDate, Date endDate) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		List<Trecibos> list = repo.findRecibosApp(user.getId(), startDate, endDate);
		return list;
	}
	
	// ==================================Recibos por mensageiro *** Lista recibos Web
	public List<Trecibos> findRecibosPorMensageiro(Integer cod, String status, Date startDate, Date endDate) {
			
		List<Trecibos> list = repo.findRecibosPorMensageiro(cod, status, startDate, endDate);
		return list;
			
	}
	
	// ==================================Recibos reimpressos entre datas ***
	public List<Trecibos> findRecibosReimpressos(Date startDate, Date endDate) {
		
		List<Trecibos> list = repo.findRecibosReimpressos(startDate, endDate);
		return list;
	}
	
	
	//================================== Atualiza recibos por id do mensageiro entre datas tabela do app mobile (Baixar) =================
	public void updateRecibosApp(Integer cod, Date startDate, Date endDate) {
		repo.updateRecibosApp(cod, startDate, endDate);
	}
	
	//==================================Lista de recibos baixados por mensageiro entre datas *** =============
	public List<TrecebidoMensageiroDTO> findRecebidoMensageiro(Date startDate, Date endDate) {
		
		List<String> listRecebidos = repo.findRecebidoMensageiro(startDate, endDate);
		
		return listDtoString(listRecebidos);
	}
	
	//==================================Lista de recibos baixados por mensageiro entre datas *** =============
	public List<TrecebidoMensageiroDTO> listDtoString(List<String> listRecebidos) {

		List<TrecebidoMensageiroDTO> listRecebidoMensageiro = new ArrayList<>();

		String[] vetLista = new String[4];

		for (int i = 0; i < listRecebidos.size(); i++) {
			
			TrecebidoMensageiroDTO recebidoMensageiro = new TrecebidoMensageiroDTO();

			vetLista = listRecebidos.get(i).split(",");

			String nomeDoMensageiro = repoFunc.getOne(Integer.parseInt(vetLista[0])).getNOME();
			
			recebidoMensageiro.setCodmensageiro(Integer.parseInt(vetLista[0]));
			recebidoMensageiro.setNomeDoMensageiro(nomeDoMensageiro);
			recebidoMensageiro.setQtdrecebido(Integer.parseInt(vetLista[1]));
			recebidoMensageiro.setValorrecebido(Double.parseDouble(vetLista[2]));
			
			listRecebidoMensageiro.add(recebidoMensageiro);
			
		}
		return listRecebidoMensageiro;

	}
	
	
	//==================================Lista de recibos entre datas a reprocessar =================
	public List<TrecibosReprocessarDTO> findRecibosReprocesssar(Date startDate, Date endDate) {

		List<String> listRecibos = repo.findRecibosReprocesssar(startDate, endDate);
		
	
		return listaDtoString(listRecibos);

	}
	
	public List<TrecibosReprocessarDTO> listaDtoString(List<String> listString) {

		List<TrecibosReprocessarDTO> listRecibosReprocessar = new ArrayList<>();

		String[] vetLista = new String[4];

		for (int i = 0; i < listString.size(); i++) {
			
			TrecibosReprocessarDTO recibosReprocessar = new TrecibosReprocessarDTO();

			vetLista = listString.get(i).split(",");

			String nomeDoMensageiro = repoFunc.getOne(Integer.parseInt(vetLista[0])).getNOME();
			
			recibosReprocessar.setCodmensageiro(Integer.parseInt(vetLista[0]));
			recibosReprocessar.setNome(nomeDoMensageiro);
			recibosReprocessar.setQuantidadeRecibos(Integer.parseInt(vetLista[1]));
			recibosReprocessar.setValorRecibos(Double.parseDouble(vetLista[2]));
			
			listRecibosReprocessar.add(recibosReprocessar);
			
		}
		return listRecibosReprocessar;

	}
	

	// ==================================Resumo por id do mensageiro entre datas
	public TresumoRecibosDTO ResumoRecibosMensageiroData(Integer cod, Date startDate, Date endDate) {

		List<String> listRecibos = repo.ResumoRecibosMensageiroData(cod, startDate, endDate);

		TresumoRecibosDTO resumo = new TresumoRecibosDTO();
		String nomeDoMensageiro = repoFunc.getOne(cod).getNOME();

		resumo.resumoDtoString(listRecibos, nomeDoMensageiro);

		return resumo;

	}
	
	
	//=================================== Relatorio Diario de recebimento por mensageiro, mes e ano *** ==========
	public List<TrecibosRelatorioDiarioDTO> findRelatorioDiario(Integer cod, Integer mes, Integer ano) {

		List<String> listRelatorioDto = repo.findRelatorioDiario(cod, mes, ano);
			
			String var;
			String[] vetLista = new String[2];
			
			List<TrecibosRelatorioDiarioDTO> listaRelatorioDiario = new ArrayList<>();
			

			for (int i = 0; i < listRelatorioDto.size(); i++) {
				
				TrecibosRelatorioDiarioDTO relatorioDiario = new TrecibosRelatorioDiarioDTO();
				
				var = listRelatorioDto.get(i);
				vetLista = var.split(",");

				relatorioDiario.setQtdRecebido(Integer.parseInt(vetLista[0]));
				relatorioDiario.setValorRecebido(Double.parseDouble(vetLista[1]));
				
				listaRelatorioDiario.add(relatorioDiario);
				
			}
			return listaRelatorioDiario;
	}
	
	
	// ==================================Resumo do mensageiro por cidade
	public List<TrecibosDTO3> recibosMensageiroPorCidade(Integer cod, Date startDate, Date endDate) {

		List<String> listRecibos = repo.recibosMensageiroPorCidade(cod, startDate, endDate);

		String var;
		String[] vetLista = new String[4];

		List<TrecibosDTO3> listaResumoRecibos = new ArrayList<>();

		for (int i = 0; i < listRecibos.size(); i++) {

			TrecibosDTO3 resumoRecibos = new TrecibosDTO3();

			var = listRecibos.get(i);
			vetLista = var.split(",");

			resumoRecibos.setCidade(vetLista[0]);
			resumoRecibos.setQtdRecibos(Integer.parseInt(vetLista[1]));
			resumoRecibos.setValorGerado(Double.parseDouble(vetLista[2]));
			resumoRecibos.setStatus(vetLista[3]);

			listaResumoRecibos.add(resumoRecibos);
		}

		return listaResumoRecibos;
	}

	// ==================================Resumo do mensageiro por cidade
	public List<TrecibosDTO4> recibosMensageiroPorCidade1(Integer cod, Date startDate, Date endDate) {

		List<String> listRecibos = repo.recibosMensageiroPorCidade(cod, startDate, endDate);

		String var;
		String[] vetLista = new String[4];

		List<TrecibosDTO3> listaResumoRecibos = new ArrayList<>();
		List<TrecibosDTO4> listaResumoDto4 = new ArrayList<>();

		for (int i = 0; i < listRecibos.size(); i++) {

			TrecibosDTO3 resumoRecibos = new TrecibosDTO3();

			var = listRecibos.get(i);
			vetLista = var.split(",");

			resumoRecibos.setCidade(vetLista[0]);
			resumoRecibos.setQtdRecibos(Integer.parseInt(vetLista[1]));
			resumoRecibos.setValorGerado(Double.parseDouble(vetLista[2]));
			resumoRecibos.setStatus(vetLista[3]);

			listaResumoRecibos.add(resumoRecibos);
		}

		// listaResumoRecibos = listaResumoRecibos.stream().filter(p ->
		// p.getStatus().startsWith("B")).collect(Collectors.toList());
		String cidade = "";

		Integer qtdRecebido = 0;
		Double valorRecebido = 0.0;
		Integer qtdTotal = 0;
		Double valorTotal = 0.0;

		for (int i = 0; i < listaResumoRecibos.size(); i++) {

			if (listaResumoRecibos.get(i).getStatus().equals("B")) {

				qtdRecebido = listaResumoRecibos.get(i).getQtdRecibos();
				valorRecebido = listaResumoRecibos.get(i).getValorGerado();
				qtdTotal = qtdRecebido;
				valorTotal = valorRecebido;
			} else {
				qtdTotal += listaResumoRecibos.get(i).getQtdRecibos();
				valorTotal += listaResumoRecibos.get(i).getValorGerado();
			}

			if ((listaResumoRecibos.size() - 1) == i) {

				cidade = listaResumoRecibos.get(i).getCidade();

				listaResumoDto4.add(addObjDto4(cidade, qtdRecebido, valorRecebido, qtdTotal, valorTotal));

				qtdRecebido = 0;
				valorRecebido = 0.0;
				qtdTotal = 0;
				valorTotal = 0.0;

			} else if (!listaResumoRecibos.get(i).getCidade().equals(listaResumoRecibos.get(i + 1).getCidade())) {

				cidade = listaResumoRecibos.get(i).getCidade();

				listaResumoDto4.add(addObjDto4(cidade, qtdRecebido, valorRecebido, qtdTotal, valorTotal));

				qtdRecebido = 0;
				valorRecebido = 0.0;
				qtdTotal = 0;
				valorTotal = 0.0;
			}

		}

		return listaResumoDto4;
	}

	public TrecibosDTO4 addObjDto4(String cidade, Integer qtdRecebido, Double valorRecebido, Integer qtdTotal,
			Double valorTotal) {

		String cidadeComposta = "";
		String[] vetPalavra = cidade.split(" ");

		for (int j = 0; j < vetPalavra.length; j++) {

			if (cidadeComposta == "") {

				cidadeComposta = vetPalavra[j].substring(0, 1).toUpperCase()
						.concat(vetPalavra[j].substring(1, vetPalavra[j].length()).toLowerCase());
			} else {
				cidadeComposta += " " + vetPalavra[j].substring(0, 1).toUpperCase()
						.concat(vetPalavra[j].substring(1, vetPalavra[j].length()).toLowerCase());
			}
		}

		Double percentualRecebido = 0.0;

		percentualRecebido = (double) qtdRecebido / qtdTotal;
		percentualRecebido = percentualRecebido.isNaN() ? 0.0 : percentualRecebido * 100;

		TrecibosDTO4 resumoRecibos = new TrecibosDTO4();

		resumoRecibos.setCidade(cidadeComposta);
		resumoRecibos.setQtdRecebidos(qtdRecebido);
		resumoRecibos.setValorRecebidos(valorRecebido);
		resumoRecibos.setQtdTotal(qtdTotal);
		resumoRecibos.setValorTotal(valorTotal);
		resumoRecibos.setPercentualRecebido(percentualRecebido);

		return resumoRecibos;
	}

	// ====================================Recibos por id do contribuinte ativo
	// entre datas
	public List<Trecibos> buscarRecibosContribData(Integer cod, Date startDate, Date endDate) {

		List<Trecibos> list = repo.buscarRecibosContribData(cod, startDate, endDate);
		return list;
	}

	// ====================================Recibos por id do contribuinte ativo TOP
	// 25
	public Page<Trecibos> buscarRecibosContrib(Integer cod, Date dtAtual, Integer page, Integer linesPerPage,
			String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.buscarRecibosContrib(cod, dtAtual, pageRequest);

	}

	public Trecibos insert(Trecibos obj) {
		obj.setNrorecibo(null);
		return repo.save(obj);
	}

	public Trecibos update(Trecibos obj) {
		// objeto monitorado pelo JPA
		find(obj.getNrorecibo());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir o recibo");
		}
	}

	public List<Trecibos> findAll() {

		return repo.findAll();

	}

	// Vou criar uma função de paginação, vou usar o sistema do spring data chamado
	// page
	public Page<Trecibos> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		// para retornar uma página de dados preciso criar um objeto pageRequest
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		return repo.findAll(pageRequest);
		// agora retornei o repositorio passando o pagerequest como argumento
	}
	
//	public List<Trecibos> findByFuncionario() {
//		UserSS user = UserService.authenticated();
//		if (user == null) {
//			throw new AuthorizationException("Acesso negado");
//		}
//		Tfuncionarios funcionario = repoFunc.findOne(user.getId());
//		return repo.findByTfuncionarios(funcionario);
//	}

	

	//Recebe o objeto dto5 do xexpress mobile e atualiza as ações do mensageiro no recibo.
	public Trecibos updateData(TrecibosDTO5 newObj, Trecibos obj) {
		// método de dentro da classe
		obj.setValorgerado(newObj.getValorgerado());
		obj.setReagendado(newObj.getReagendado());
		obj.setDtreagendamento(newObj.getDtreagendamento());
		obj.setStatusrec(newObj.getStatusrec());
		obj.setDtbaixa(newObj.getDtbaixa());
		obj.setMotivodevol(newObj.getMotivodevol());
		return obj;
		
	}

}
