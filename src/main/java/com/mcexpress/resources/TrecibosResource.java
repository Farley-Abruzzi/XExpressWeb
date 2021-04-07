package com.mcexpress.resources; // o nome Resources é utilizado para criar a classe de controlador rest

import java.net.URI;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mcexpress.domain.Tfuncionarios;
import com.mcexpress.domain.Trecibos;
import com.mcexpress.dto.TrecebidoMensageiroDTO;
import com.mcexpress.dto.TrecibosDTO;
import com.mcexpress.dto.TrecibosDTO3;
import com.mcexpress.dto.TrecibosDTO4;
import com.mcexpress.dto.TrecibosDTO5;
import com.mcexpress.dto.TrecibosDTO6;
import com.mcexpress.dto.TrecibosPorMensageiroDTO;
import com.mcexpress.dto.TrecibosReimpressosDTO;
import com.mcexpress.dto.TrecibosRelatorioDiarioDTO;
import com.mcexpress.dto.TrecibosReprocessarDTO;
import com.mcexpress.dto.TresumoRecibosDTO;
import com.mcexpress.resources.utils.URL;
import com.mcexpress.services.TfuncionariosService;
import com.mcexpress.services.TrecibosService;

@RestController
@RequestMapping(value = "/recibos")
public class TrecibosResource {

	@Autowired // Instanciar automaticamente
	private TrecibosService service;

	@Autowired // Instanciar automaticamente
	private TfuncionariosService serviceFunc;

	// =================================Receibo por numero do recibo
	//@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR', 'OPERADORA')")
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Trecibos> find(@PathVariable Integer id) {

		Trecibos obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		// Exemplo URL: http://localhost:8081/recibos/2400055
		// consulta por numero do recibo
	}

	// =================================Recibos por id do mensageiro com paginação
	//@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR', 'OPERADORA')")
	@CrossOrigin
	@RequestMapping(value = "/mensageiro", method = RequestMethod.GET)
	public ResponseEntity<Page<TrecibosDTO>> findAllByMensRecibo(
			@RequestParam(value = "cod", defaultValue = "6") Integer cod,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "25") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "impresso") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		System.out.println("\n\n\n" + cod + "\n\n\n");

		Page<Trecibos> list = service.findAllByMensRecibo(cod, page, linesPerPage, orderBy, direction);
		Page<TrecibosDTO> listDto = list.map(obj -> new TrecibosDTO(obj));

		Tfuncionarios mensageiro;
		for (TrecibosDTO x : listDto) {
			mensageiro = serviceFunc.findById(x.getCodmensageiro());
			x.setCodmensageiroamais(mensageiro.getCODMENSAGEIROAMAIS());
		}

		return ResponseEntity.ok().body(listDto);
		// http://localhost:8081/recibos/mensageiro?cod=303
	}

	// ==================================Recibos por id do mensageiro entre datas
	//@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR', 'OPERADORA')")
	@CrossOrigin
	@RequestMapping(value = "/recibomensageiro", method = RequestMethod.GET)
	public ResponseEntity<List<TrecibosDTO>> findByMensageiroRecibo(
			@RequestParam(value = "cod", defaultValue = "6") Integer cod,
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

		List<Trecibos> list = service.findByMensageiroRecibo(cod, startDate, endDate);
		List<TrecibosDTO> listDto = list.stream().map(obj -> new TrecibosDTO(obj)).collect(Collectors.toList());

		Tfuncionarios mensageiro;
		for (TrecibosDTO x : listDto) {
			mensageiro = serviceFunc.findById(x.getCodmensageiro());
			x.setCodmensageiroamais(mensageiro.getCODMENSAGEIROAMAIS());
		}

		return ResponseEntity.ok().body(listDto);
		// http://localhost:8081/recibos/recibomensageiro?cod=11&startDate=2018-12-01&endDate=2018-12-31
	}
	

	// ====== Recibos por id do mensageiro entre datas (recebido) com paginação =================
	//@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR', 'OPERADORA')")
	@CrossOrigin
	@RequestMapping(value = "/findrecibosrecebidos", method = RequestMethod.GET)
	public ResponseEntity<Page<TrecibosDTO5>> findRecibosRecebidos(
			@RequestParam(value = "cod", defaultValue = "315") Integer cod,
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "25") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "dtbaixa") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction) {

		Page<Trecibos> list = service.findRecibosRecebidos(cod, startDate, endDate, page, linesPerPage, orderBy,
				direction);
		Page<TrecibosDTO5> listDto = list.map(obj -> new TrecibosDTO5(obj));

		return ResponseEntity.ok().body(listDto);
		// http://localhost:8081/recibos/findrecibosrecebidos?cod=315&startDate=2019-07-01&endDate=2019-07-31
	}

	// ========	Recibos por id do mensageiro entre datas (Em aberto) com paginação  =================
	//@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR', 'OPERADORA')")
	@CrossOrigin
	@RequestMapping(value = "/findrecibosaberto", method = RequestMethod.GET)
	public ResponseEntity<Page<TrecibosDTO5>> findRecibosAbertos(
			@RequestParam(value = "cod", defaultValue = "315") Integer cod,
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "25") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "dtcobranca") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction) {

			Page<Trecibos> list = service.findRecibosAbertos(cod, startDate, endDate, page, linesPerPage, orderBy,
					direction);
			Page<TrecibosDTO5> listDto = list.map(obj -> new TrecibosDTO5(obj));

		return ResponseEntity.ok().body(listDto);
		// http://localhost:8081/recibos/findrecibosaberto?cod=315&startDate=2019-07-01&endDate=2019-07-31
	}

	// =======Recibos por id do mensageiro entre datas - tabela do app mobile =================
	//@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR', 'MENSAGEIRO', 'OPERADORA')")
	@CrossOrigin
	@RequestMapping(value = "/listarecibosapp", method = RequestMethod.GET)
	public ResponseEntity<List<TrecibosDTO6>> findRecibosApp(
			@RequestParam(value = "cod", defaultValue = "6") Integer cod,
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
			@RequestParam(value = "bairro", defaultValue = "") String bairro) {

		List<Trecibos> list = service.findRecibosApp(cod, startDate, endDate, bairro);
		List<TrecibosDTO6> listDto = list.stream().map(obj -> new TrecibosDTO6(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);
		// http://192.168.0.243:8081/recibos/listarecibosapp?cod=315&startDate=2019-07-01&endDate=2019-07-31
	}
	
	//@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR', 'MENSAGEIRO')")
//	@CrossOrigin
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<List<Trecibos>> findRecibosApp() {
//
//		List<Trecibos> list = service.findByFuncionario();
//
//		return ResponseEntity.ok().body(list);
//		// http://192.168.0.243:8081/recibos
//	}
	
	// =======Recibos por id do mensageiro entre datas e seleção do status - Lista Recibos por mensageiro WEB ==================
	//@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR', 'OPERADORA')")
	@CrossOrigin
	@RequestMapping(value = "/listarecibosweb", method = RequestMethod.GET)
	public ResponseEntity<List<TrecibosPorMensageiroDTO>> findRecibosWeb(
			@RequestParam(value = "cod", defaultValue = "6") Integer cod,
			@RequestParam(value = "status", defaultValue = "G") String status,
			//@RequestParam(value = "cidade", defaultValue = "2389") String cidade,
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
		
		List<Trecibos> list = service.findRecibosPorMensageiro(cod, status, startDate, endDate);
		List<TrecibosPorMensageiroDTO> listDto = list.stream().map(obj -> new TrecibosPorMensageiroDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
		// http://192.168.0.243:8081/recibos/listarecibosweb?cod=315&status=G&startDate=2019-07-01&endDate=2019-07-31
		
	}
	
	// ========Recibos reimpressos entre datas *** ==============================================
	//@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR', 'OPERADORA')")
	@CrossOrigin
	@RequestMapping(value = "/listarecibosreimpressos", method = RequestMethod.GET)
	public ResponseEntity<List<TrecibosReimpressosDTO>> findRecibosReimpressos(
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
		
		List<Trecibos> list = service.findRecibosReimpressos(startDate, endDate);
		List<TrecibosReimpressosDTO> listDto = list.stream().map(obj -> new TrecibosReimpressosDTO(obj)).collect(Collectors.toList());
		
		
		Tfuncionarios mensageiro;
		for(TrecibosReimpressosDTO x : listDto) {
			mensageiro = serviceFunc.findById(x.getCodmensageiro());
			x.setCodmensageiroAmais(mensageiro.getCODMENSAGEIROAMAIS());
			x.setNomeMensageiro(mensageiro.getNOME());		
		}
		return ResponseEntity.ok().body(listDto);
	}
	
	
	// ======Recibos por numero do recibo com o objeto - TrecibosDTO5 para o app mobile =================
	//@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR', 'MENSAGEIRO')")
	@CrossOrigin
	@RequestMapping(value = "/app/{id}", method = RequestMethod.GET)
	public ResponseEntity<TrecibosDTO5> findReciboApp(@PathVariable Integer id) {

		Trecibos obj = service.find(id);
		TrecibosDTO5 objApp = new TrecibosDTO5(obj);
		return ResponseEntity.ok().body(objApp);
		// Exemplo URL: http://localhost:8081/recibos/app/11382872
		// consulta por numero do recibo
	}

	// ======= Atualiza recibos por id do mensageiro entre datas tabela do app mobile (Baixar) =================
	//@PreAuthorize("hasAnyRole('ADMIN', 'MENSAGEIRO')")
	@CrossOrigin
	@RequestMapping(value = "/updateRecibosapp", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateRecibosApp(@RequestParam(value = "cod", defaultValue = "6") Integer cod,
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

		service.updateRecibosApp(cod, startDate, endDate);


		return ResponseEntity.noContent().build();
		// http://localhost:8081/recibos/updateRecibosapp?cod=315&startDate=2019-07-01&endDate=2019-07-31
	}
	
	// ===== Lista recidos baixados entre datas *** ===========================
	//@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR', 'OPERADORA')")
	@CrossOrigin
	@RequestMapping(value = "/recebidomensageiro", method = RequestMethod.GET)
	public ResponseEntity<List<TrecebidoMensageiroDTO>> findRecebidoMensageiro(
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
		
		List<TrecebidoMensageiroDTO> list = service.findRecebidoMensageiro(startDate, endDate);
		
		return ResponseEntity.ok().body(list);
		
		// http://localhost:8081/recibos/recebidomensageiro?&startDate=2019-07-01&endDate=2019-07-31
		
	}
	

	// ===== Lista de recibos entre datas a reprocessar =================
	//@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR')")
	@CrossOrigin
	@RequestMapping(value = "/recibosreprocessar", method = RequestMethod.GET)
	public ResponseEntity<List<TrecibosReprocessarDTO>> findRecibosReprocesssar(
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

		List<TrecibosReprocessarDTO> resumo = service.findRecibosReprocesssar(startDate, endDate);

		return ResponseEntity.ok().body(resumo);

		// http://localhost:8081/recibos/recibosreprocessar?startDate=2019-07-01&endDate=2019-07-31
	}

	// ============= Resumo por id do mensageiro entre datas =====================
	//@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR', 'OPERADORA')")
	@CrossOrigin
	@RequestMapping(value = "/resumomensageiro", method = RequestMethod.GET)
	public ResponseEntity<TresumoRecibosDTO> ResumoRecibosMensageiroData(
			@RequestParam(value = "cod", defaultValue = "6") Integer cod,
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

		TresumoRecibosDTO resumo = service.ResumoRecibosMensageiroData(cod, startDate, endDate);

		String s = URL.decodeParam(resumo.getMensageiro());

		System.out.println("\n\nResumo: " + s + "\n\n");

		return ResponseEntity.ok().body(resumo);

		// http://localhost:8081/recibos/resumomensageiro?cod=11&startDate=2018-01-01&endDate=2018-02-01
	}
	
	//@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR', 'OPERADORA')")
	@CrossOrigin
	@RequestMapping(value = "/relatoriodiario", method = RequestMethod.GET)
	public ResponseEntity<List<TrecibosRelatorioDiarioDTO>> findRelatorioDiario(
			@RequestParam(value = "cod", defaultValue = "6") Integer cod,
			@RequestParam(value = "mes") Integer mes,
			@RequestParam(value = "ano") Integer ano) {
		
		List<TrecibosRelatorioDiarioDTO> relatorio = service.findRelatorioDiario(cod, mes, ano);

		
		return ResponseEntity.ok().body(relatorio);
		
		// http://localhost:8081/recibos/relatoriodiario?&cod=11&mes=06&ano=2019
	}
	

	// ======== Resumo do mensageiro por cidade ==========================
	//@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR', 'OPERADORA')")
	@CrossOrigin
	@RequestMapping(value = "/mensageiroporcidade", method = RequestMethod.GET)
	public ResponseEntity<List<TrecibosDTO3>> recibosMensageiroPorCidade(
			@RequestParam(value = "cod", defaultValue = "6") Integer cod,
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

		List<TrecibosDTO3> resumo = service.recibosMensageiroPorCidade(cod, startDate, endDate);

		return ResponseEntity.ok().body(resumo);

		// http://localhost:8081/recibos/mensageiroporcidade?&cod=11&startDate=2018-01-01&endDate=2018-02-01
	}

	// ===== Resumo do mensageiro por cidade 1 - valido =================================
	//@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR', 'OPERADORA')")
	@CrossOrigin
	@RequestMapping(value = "/mensageiroporcidade1", method = RequestMethod.GET)
	public ResponseEntity<List<TrecibosDTO4>> recibosMensageiroPorCidade1(
			@RequestParam(value = "cod", defaultValue = "6") Integer cod,
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

		List<TrecibosDTO4> resumo = service.recibosMensageiroPorCidade1(cod, startDate, endDate);

		Collections.sort(resumo, Comparator.comparing(TrecibosDTO4::getQtdTotal));

		return ResponseEntity.ok().body(resumo);

		// http://localhost:8081/recibos/mensageiroporcidade1?&cod=11&startDate=2018-01-01&endDate=2018-02-01
	}

	// ============Recibos por id do contribuinte ativo ==== entre datas ===
	//@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR', 'OPERADORA')")
	@CrossOrigin
	@RequestMapping(value = "/recibocontribuinte", method = RequestMethod.GET)
	public ResponseEntity<List<TrecibosDTO>> buscarRecibosContribData(
			@RequestParam(value = "cod", defaultValue = "6") Integer cod,
			@RequestParam(value = "startDate", defaultValue = "2001-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam(value = "endDate", defaultValue = "2002-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

		List<Trecibos> list = service.buscarRecibosContribData(cod, startDate, endDate);
		List<TrecibosDTO> listDto = list.stream().map(obj -> new TrecibosDTO(obj)).collect(Collectors.toList());

		Tfuncionarios mensageiro;

		for (TrecibosDTO x : listDto) {
			mensageiro = serviceFunc.findById(x.getCodmensageiro());
			x.setCodmensageiroamais(mensageiro.getCODMENSAGEIROAMAIS());
		}

		return ResponseEntity.ok().body(listDto);
		// http://localhost:8081/recibos/recibocontribuinte?&cod=303&startDate=2018-01-01&endDate=2018-12-01
	}

	// =================Recibos por id do contribuinte ativo TOP 25 ===
	//@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR', 'OPERADORA')")
	@CrossOrigin
	@RequestMapping(value = "/reciboscontrib", method = RequestMethod.GET)
	public ResponseEntity<Page<TrecibosDTO>> buscarRecibosContrib(
			@RequestParam(value = "cod", defaultValue = "6") Integer cod,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "50") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nrorecibo") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction) {

		Date dataAtual = new Date();

		System.out.println("\n\ndata atual: " + dataAtual + "\n\n");

		Page<Trecibos> list = service.buscarRecibosContrib(cod, dataAtual, page, linesPerPage, orderBy, direction);
		Page<TrecibosDTO> listDto = list.map(obj -> new TrecibosDTO(obj));

		String[] nome;

		Tfuncionarios mensageiro;
		for (TrecibosDTO x : listDto) {
			mensageiro = serviceFunc.findById(x.getCodmensageiro());
			x.setCodmensageiroamais(mensageiro.getCODMENSAGEIROAMAIS());
			x.setNomedomensageiro(mensageiro.getNOME());
			nome = mensageiro.getNOME().split(" ");
			x.setNomedomensageirofirst(nome[0]);
		}
		return ResponseEntity.ok().body(listDto);
		// http://localhost:8081/recibos/reciboscontrib?cod=303
	}

	// Recebe o objeto dto5 do xexpress mobile e atualiza as ações do mensageiro no
	// recibo.
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody TrecibosDTO5 objDto, @PathVariable Integer id) {

		Trecibos objRec = service.find(id);
		Trecibos obj = service.updateData(objDto, objRec);
		System.out.println("\n\tDTREAGENDAMENTO: "+ objDto.getDtreagendamento());
		// Para garantir que a categoria a ser atualizada é realmente a que foi passada
		// como parâmetro
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	// http://localhost:8081/recibos/2400055

	/*
	 * @RequestMapping(method = RequestMethod.POST) //A anotação @Valid indica que o
	 * metodo irá usar o BeanValidation na Trecibos DTO public ResponseEntity<Void>
	 * insert(@Valid @RequestBody TrecibosDTO objDto){ //Para o objeto ser
	 * construido a partir dos dados JSON que eu enviar é preciso a anotação antes
	 * da variável
	 * 
	 * Trecibos obj = service.fromDTO(objDto); obj = service.insert(obj); //O HTTP
	 * quando estou inserindo um novo recurso há um codigo de resposta particular, o
	 * codigo adequado é 201 Created //Vamos usar a chave da categoria para inserir
	 * a URL HTTP URI uri =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
	 * (obj.getId()).toUri(); // o fromCurrentRequest pega o URL base ex:
	 * "http://localhost:8081/categorias" e o buildAndExpand() o id do objeto
	 * Inserido.
	 * 
	 * return ResponseEntity.created(uri).build(); }
	 
	/*
	 * 
	 * @RequestMapping(value="/{id}", method=RequestMethod.DELETE) public
	 * ResponseEntity<Void> delete(@PathVariable Integer id) {
	 * 
	 * service.delete(id); return ResponseEntity.noContent().build();
	 * 
	 * }
	 * 
	 * @RequestMapping(method=RequestMethod.GET) public
	 * ResponseEntity<List<TrecibosDTO>> findAll() { List<Trecibos> list =
	 * service.findAll(); //Preciso percorrer a lista list e para cada elemento dela
	 * instanciar o DTO (id e nome) correspondentes, //depois vou percorrer usando o
	 * recurso do java 8 "stream", e usar o map (fazer uma operação para cada
	 * elemento da lista) //que tera um apelido (obj) usando "(->) uma função
	 * anonima que recebe o objeto e instancia o TrecibosDTO //passanso o obj como
	 * argumento, depois voltar o stream de objeto para o tipo lista usando o
	 * ".collect(Collectors.toList()" List<TrecibosDTO> listDTO =
	 * list.stream().map(obj -> new TrecibosDTO(obj)).collect(Collectors.toList());
	 * 
	 * return ResponseEntity.ok().body(listDTO); }
	 */
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	// vou concategar um /page para diferenciar do categorias ex:
	// http://localhost:8081/categorias/page
	public ResponseEntity<Page<Trecibos>> findPage(@RequestParam(value = "page", defaultValue = "6") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "25") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "IMPRESSO") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<Trecibos> list = service.findPage(page, linesPerPage, orderBy, direction);

		return ResponseEntity.ok().body(list);
		// exemplo URL:
		// http://localhost:8081/recibos/page?linesPerPage=3&page=1&direction=ASC&orderBy=IMPRESSO
		// Consulta lista de recibos
		

	}
	
	//======================== Inserir novo recibo =================
	//@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR', 'MENSAGEIRO')")
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST) //A anotação @Valid indica que o metodo irá usar o BeanValidation na Trecibos DTO
	public ResponseEntity<Void> insert(@RequestBody Trecibos obj) { //Para o objeto ser construido a partir dos dados JSON que eu enviar é preciso a anotação antes da variável @RequestBody
		
		obj = service.insert(obj);
		
		//O HTTP quando estou inserindo um novo recurso há um codigo de resposta particular, o codigo adequado é 201 Created
		//Vamos usar a chave da categoria para inserir a URL HTTP
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getNrorecibo()).toUri();
		// o fromCurrentRequest pega o URL base ex: "http://localhost:8081/feriado" e o buildAndExpand() o id do objeto Inserido.
		
		return ResponseEntity.created(uri).build();
		// http://localhost:8081/recibos
	}

}
