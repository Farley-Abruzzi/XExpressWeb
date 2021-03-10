package com.mcexpress.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mcexpress.domain.Trecibos;

public class TrecibosDTO5 implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer nrorecibo;
	private String nomenorecibo;
	private String entregaweb;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtcobranca;
	private String reagendado;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dtreagendamento;
	private Double valorgerado;
	private String statusrec;
	private Date dtbaixa;
	private String parcela;
	private Integer via;
	private String motivodevol;
	private String enderecosecundario;
	private String numerosecundario;
	private String bairrosecundario;
	private String cidadesecundario;
	private String complementosecundario;
	private String cepsecundario;
	private String telefonesecundario;
	private String desccategoria;
	private String observacoes;
	private Integer codmensageiro;
	
	public TrecibosDTO5() {
	}
		
	public TrecibosDTO5(Trecibos trecibo) {
		super();
		
		nrorecibo = trecibo.getNrorecibo();
		nomenorecibo = trecibo.getTconbribuintes().getNOMENORECIBO();
		dtcobranca = trecibo.getDtcobranca();
		reagendado = trecibo.getReagendado();
		dtreagendamento = trecibo.getDtreagendamento();
		valorgerado = trecibo.getValorgerado();
		statusrec = trecibo.getStatusrec();
		dtbaixa = trecibo.getDtbaixa();
		parcela = trecibo.getParcela();
		via = trecibo.getVia();
		motivodevol = trecibo.getMotivodevol();
		enderecosecundario = trecibo.getTconbribuintes().getENDERECOSECUNDARIO();
		numerosecundario = trecibo.getTconbribuintes().getNUMEROSECUNDARIO();
		bairrosecundario = trecibo.getTconbribuintes().getBAIRROSECUNDARIO();
		cidadesecundario = trecibo.getTconbribuintes().getCIDADESECUNDARIO();
		complementosecundario = trecibo.getTconbribuintes().getCOMPLESECUNDARIO();
		cepsecundario = trecibo.getTconbribuintes().getCEPSECUNDARIO();
		telefonesecundario = trecibo.getTconbribuintes().getTELEFONESECUNDARIO();
		desccategoria = trecibo.getTconbribuintes().getCATEGORIAS().getDESCCATEGORIA();
		observacoes = trecibo.getTconbribuintes().getOBSERVACOES();
		codmensageiro = trecibo.getCodmensageiro();
		entregaweb = trecibo.getEntregaweb();
	}

	
	
	public String getEntregaweb() {
		return entregaweb;
	}

	public void setEntregaweb(String entregaweb) {
		this.entregaweb = entregaweb;
	}

	public String getCidadesecundario() {
		return cidadesecundario;
	}

	public void setCidadesecundario(String cidadesecundario) {
		this.cidadesecundario = cidadesecundario;
	}

	public Integer getNrorecibo() {
		return nrorecibo;
	}

	public String getNomenorecibo() {
		return nomenorecibo;
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

	public Double getValorgerado() {
		return valorgerado;
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

	public String getEnderecosecundario() {
		return enderecosecundario;
	}

	public String getNumerosecundario() {
		return numerosecundario;
	}

	public String getBairrosecundario() {
		return bairrosecundario;
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

	public Integer getCodmensageiro() {
		return codmensageiro;
	}

	public void setNrorecibo(Integer nrorecibo) {
		this.nrorecibo = nrorecibo;
	}

	public void setNomenorecibo(String nomenorecibo) {
		this.nomenorecibo = nomenorecibo;
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

	public void setValorgerado(Double valorgerado) {
		this.valorgerado = valorgerado;
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

	public void setEnderecosecundario(String enderecosecundario) {
		this.enderecosecundario = enderecosecundario;
	}

	public void setNumerosecundario(String numerosecundario) {
		this.numerosecundario = numerosecundario;
	}

	public void setBairrosecundario(String bairrosecundario) {
		this.bairrosecundario = bairrosecundario;
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

	public void setCodmensageiro(Integer codmensageiro) {
		this.codmensageiro = codmensageiro;
	}
 	
}
