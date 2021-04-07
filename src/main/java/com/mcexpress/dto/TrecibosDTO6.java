package com.mcexpress.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mcexpress.domain.Trecibos;

public class TrecibosDTO6 implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer nrorecibo;
	private String impresso;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtoperacao;
	private Date entrega;
	private Integer formulario;
	private String nomenorecibo;
	private String entregaweb;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtcobranca;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtrecebimento;
	private Double valorgerado;
	private Double valordinheiro;
	private Double valorcheque;
	private Integer doacaoespecial;
	private String parceladoacaoespecial;
	private Integer aumentodefinitivo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtoperacaobaixa;
	private Integer periodicidade;
	private Double valoralterado;
	private Double valornaoalterado;
	private Timestamp dtvaloralteradobaixa;
	private Double valorbakp;
	private String valorhorabkp;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date valordatabkp;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataqld;
	private Integer naorecebido;
	private Integer nrosorte;
	private String statusrec;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtbaixa;
	private String parcela;
	private Integer via;
	private String motivodevol;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtremarc;
	private Double valorremarcado;
	private Integer codoperador;
	private Integer codmensageiro;
	private Integer codcategoria;
	private String reagendado;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dtreagendamento;
	private Integer codcontrib;
	private Integer codusuario;
	private String enderecosecundario;
	private String numerosecundario;
	private String bairrosecundario;
	private String cidadesecundario;
	private String complementosecundario;
	private String cepsecundario;
	private String telefonesecundario;
	private String desccategoria;
	private String observacoes;
	
	
	public TrecibosDTO6() {
	}
		
	public TrecibosDTO6(Trecibos trecibo) {
		super();
		
		nrorecibo = trecibo.getNrorecibo();
		impresso = trecibo.getImpresso();
		dtoperacao = trecibo.getDtoperacao();
		entrega = trecibo.getEntrega();
		nomenorecibo = trecibo.getTconbribuintes().getNOMENORECIBO();
		entregaweb = trecibo.getEntregaweb();
		dtcobranca = trecibo.getDtcobranca();
		formulario = trecibo.getFormulario();
		entregaweb = trecibo.getEntregaweb();
		dtcobranca = trecibo.getDtcobranca();
		dtrecebimento = trecibo.getDtrecebimento();
		valorgerado = trecibo.getValorgerado();
		valordinheiro = trecibo.getValordinheiro();
		valorcheque = trecibo.getValorcheque();
		doacaoespecial = trecibo.getDoacaoespecial();
		parceladoacaoespecial = trecibo.getParceladoacaoespecial();
		aumentodefinitivo = trecibo.getAumentodefinitivo();
		dtoperacaobaixa = trecibo.getDtoperacaobaixa();
		periodicidade = trecibo.getPeriodicidade();
		valoralterado = trecibo.getValoralterado();
		valornaoalterado = trecibo.getValornaoalterado();
		dtvaloralteradobaixa = trecibo.getDtvaloralteradobaixa();
		valorbakp = trecibo.getValorbakp();
		valorhorabkp = trecibo.getValorhorabkp();
		valordatabkp = trecibo.getValordatabkp();
		dataqld = trecibo.getDataqld();
		naorecebido = trecibo.getNaorecebido();
		nrosorte = trecibo.getNrosorte();
		statusrec = trecibo.getStatusrec();
		dtbaixa = trecibo.getDtbaixa();
		parcela = trecibo.getParcela();
		via = trecibo.getVia();
		motivodevol = trecibo.getMotivodevol();
		dtremarc = trecibo.getDtremarc();
		valorremarcado = trecibo.getValorremarcado();
		codoperador = trecibo.getCodoperador();
		codmensageiro = trecibo.getCodmensageiro();
		codcategoria = trecibo.getCodcategoria();
		dtreagendamento = trecibo.getDtreagendamento();
		reagendado = trecibo.getReagendado();
		codcontrib = trecibo.getCodcontrib();
		codusuario = trecibo.getCodusuario();
		enderecosecundario = trecibo.getTconbribuintes().getENDERECOSECUNDARIO();
		numerosecundario = trecibo.getTconbribuintes().getNUMEROSECUNDARIO();
		bairrosecundario = trecibo.getTconbribuintes().getBAIRROSECUNDARIO();
		cidadesecundario = trecibo.getTconbribuintes().getCIDADESECUNDARIO();
		complementosecundario = trecibo.getTconbribuintes().getCOMPLESECUNDARIO();
		cepsecundario = trecibo.getTconbribuintes().getCEPSECUNDARIO();
		telefonesecundario = trecibo.getTconbribuintes().getTELEFONESECUNDARIO();
		desccategoria = trecibo.getTconbribuintes().getCATEGORIAS().getDESCCATEGORIA();
		observacoes = trecibo.getTconbribuintes().getOBSERVACOES();
		
		
	}

	public Integer getNrorecibo() {
		return nrorecibo;
	}

	public String getImpresso() {
		return impresso;
	}

	public Date getDtoperacao() {
		return dtoperacao;
	}

	public Date getEntrega() {
		return entrega;
	}

	public Integer getFormulario() {
		return formulario;
	}

	public String getNomenorecibo() {
		return nomenorecibo;
	}

	public String getEntregaweb() {
		return entregaweb;
	}

	public Date getDtcobranca() {
		return dtcobranca;
	}

	public String getReagendado() {
		return reagendado;
	}

	public Date getDtreagendamento() {
		return dtreagendamento;
	}

	public Date getDtrecebimento() {
		return dtrecebimento;
	}

	public Double getValorgerado() {
		return valorgerado;
	}

	public Double getValordinheiro() {
		return valordinheiro;
	}

	public Double getValorcheque() {
		return valorcheque;
	}

	public Integer getDoacaoespecial() {
		return doacaoespecial;
	}

	public String getParceladoacaoespecial() {
		return parceladoacaoespecial;
	}

	public Integer getAumentodefinitivo() {
		return aumentodefinitivo;
	}

	public Date getDtoperacaobaixa() {
		return dtoperacaobaixa;
	}

	public Integer getPeriodicidade() {
		return periodicidade;
	}

	public Double getValoralterado() {
		return valoralterado;
	}

	public Double getValornaoalterado() {
		return valornaoalterado;
	}

	public Timestamp getDtvaloralteradobaixa() {
		return dtvaloralteradobaixa;
	}

	public Double getValorbakp() {
		return valorbakp;
	}

	public String getValorhorabkp() {
		return valorhorabkp;
	}

	public Date getValordatabkp() {
		return valordatabkp;
	}

	public Date getDataqld() {
		return dataqld;
	}

	public Integer getNaorecebido() {
		return naorecebido;
	}

	public Integer getNrosorte() {
		return nrosorte;
	}

	public String getStatusrec() {
		return statusrec;
	}

	public Date getDtbaixa() {
		return dtbaixa;
	}

	public String getParcela() {
		return parcela;
	}

	public Integer getVia() {
		return via;
	}

	public String getMotivodevol() {
		return motivodevol;
	}

	public Date getDtremarc() {
		return dtremarc;
	}

	public Double getValorremarcado() {
		return valorremarcado;
	}

	public Integer getCodoperador() {
		return codoperador;
	}

	public Integer getCodmensageiro() {
		return codmensageiro;
	}

	public Integer getCodcategoria() {
		return codcategoria;
	}

	public Integer getCodcontrib() {
		return codcontrib;
	}

	public String getEnderecosecundario() {
		return enderecosecundario;
	}

	public String getNumerosecundario() {
		return numerosecundario;
	}

	public String getBairrosecundario() {
		return bairrosecundario;
	}

	public String getCidadesecundario() {
		return cidadesecundario;
	}

	public String getComplementosecundario() {
		return complementosecundario;
	}

	public String getCepsecundario() {
		return cepsecundario;
	}

	public String getTelefonesecundario() {
		return telefonesecundario;
	}

	public String getDesccategoria() {
		return desccategoria;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setNrorecibo(Integer nrorecibo) {
		this.nrorecibo = nrorecibo;
	}

	public void setImpresso(String impresso) {
		this.impresso = impresso;
	}

	public void setDtoperacao(Date dtoperacao) {
		this.dtoperacao = dtoperacao;
	}

	public void setEntrega(Date entrega) {
		this.entrega = entrega;
	}

	public void setFormulario(Integer formulario) {
		this.formulario = formulario;
	}

	public void setNomenorecibo(String nomenorecibo) {
		this.nomenorecibo = nomenorecibo;
	}

	public void setEntregaweb(String entregaweb) {
		this.entregaweb = entregaweb;
	}

	public void setDtcobranca(Date dtcobranca) {
		this.dtcobranca = dtcobranca;
	}

	public void setReagendado(String reagendado) {
		this.reagendado = reagendado;
	}

	public void setDtreagendamento(Date dtreagendamento) {
		this.dtreagendamento = dtreagendamento;
	}

	public void setDtrecebimento(Date dtrecebimento) {
		this.dtrecebimento = dtrecebimento;
	}

	public void setValorgerado(Double valorgerado) {
		this.valorgerado = valorgerado;
	}

	public void setValordinheiro(Double valordinheiro) {
		this.valordinheiro = valordinheiro;
	}

	public void setValorcheque(Double valorcheque) {
		this.valorcheque = valorcheque;
	}

	public void setDoacaoespecial(Integer doacaoespecial) {
		this.doacaoespecial = doacaoespecial;
	}

	public void setParceladoacaoespecial(String parceladoacaoespecial) {
		this.parceladoacaoespecial = parceladoacaoespecial;
	}

	public void setAumentodefinitivo(Integer aumentodefinitivo) {
		this.aumentodefinitivo = aumentodefinitivo;
	}

	public void setDtoperacaobaixa(Date dtoperacaobaixa) {
		this.dtoperacaobaixa = dtoperacaobaixa;
	}

	public void setPeriodicidade(Integer periodicidade) {
		this.periodicidade = periodicidade;
	}

	public void setValoralterado(Double valoralterado) {
		this.valoralterado = valoralterado;
	}

	public void setValornaoalterado(Double valornaoalterado) {
		this.valornaoalterado = valornaoalterado;
	}

	public void setDtvaloralteradobaixa(Timestamp dtvaloralteradobaixa) {
		this.dtvaloralteradobaixa = dtvaloralteradobaixa;
	}

	public void setValorbakp(Double valorbakp) {
		this.valorbakp = valorbakp;
	}

	public void setValorhorabkp(String valorhorabkp) {
		this.valorhorabkp = valorhorabkp;
	}

	public void setValordatabkp(Date valordatabkp) {
		this.valordatabkp = valordatabkp;
	}

	public void setDataqld(Date dataqld) {
		this.dataqld = dataqld;
	}

	public void setNaorecebido(Integer naorecebido) {
		this.naorecebido = naorecebido;
	}

	public void setNrosorte(Integer nrosorte) {
		this.nrosorte = nrosorte;
	}

	public void setStatusrec(String statusrec) {
		this.statusrec = statusrec;
	}

	public void setDtbaixa(Date dtbaixa) {
		this.dtbaixa = dtbaixa;
	}

	public void setParcela(String parcela) {
		this.parcela = parcela;
	}

	public void setVia(Integer via) {
		this.via = via;
	}

	public void setMotivodevol(String motivodevol) {
		this.motivodevol = motivodevol;
	}

	public void setDtremarc(Date dtremarc) {
		this.dtremarc = dtremarc;
	}

	public void setValorremarcado(Double valorremarcado) {
		this.valorremarcado = valorremarcado;
	}

	public void setCodoperador(Integer codoperador) {
		this.codoperador = codoperador;
	}

	public void setCodmensageiro(Integer codmensageiro) {
		this.codmensageiro = codmensageiro;
	}

	public void setCodcategoria(Integer codcategoria) {
		this.codcategoria = codcategoria;
	}

	public void setCodcontrib(Integer codcontrib) {
		this.codcontrib = codcontrib;
	}

	public void setEnderecosecundario(String enderecosecundario) {
		this.enderecosecundario = enderecosecundario;
	}

	public void setNumerosecundario(String numerosecundario) {
		this.numerosecundario = numerosecundario;
	}

	public void setBairrosecundario(String bairrosecundario) {
		this.bairrosecundario = bairrosecundario;
	}

	public void setCidadesecundario(String cidadesecundario) {
		this.cidadesecundario = cidadesecundario;
	}

	public void setComplementosecundario(String complementosecundario) {
		this.complementosecundario = complementosecundario;
	}

	public void setCepsecundario(String cepsecundario) {
		this.cepsecundario = cepsecundario;
	}

	public void setTelefonesecundario(String telefonesecundario) {
		this.telefonesecundario = telefonesecundario;
	}

	public void setDesccategoria(String desccategoria) {
		this.desccategoria = desccategoria;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Integer getCodusuario() {
		return codusuario;
	}

	public void setCodusuario(Integer codusuario) {
		this.codusuario = codusuario;
	}
	

 	
}
