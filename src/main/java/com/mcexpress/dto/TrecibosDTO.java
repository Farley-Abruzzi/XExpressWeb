package com.mcexpress.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mcexpress.domain.Trecibos;

public class TrecibosDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nome;
	private String nomenorecibo;
	private String nomedomensageiro;
	private String nomedomensageirofirst;
	private Integer codmensageiro;
	private Integer nrorecibo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtcobranca;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtbaixa;
	private String statusrec;
	private String impresso;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date entrega;
	private Double valorgerado;
	private Integer periodicidade;
	private Integer codoperador;
	private Integer codmensageiroamais;
	private Integer codstatus;
	private String descstatus;
	private String parcela;
	private Integer via;
	
	public TrecibosDTO(Trecibos trecibo) {
		super();
		
		codmensageiro = trecibo.getCodmensageiro();
		nrorecibo = trecibo.getNrorecibo();
		dtcobranca = trecibo.getDtcobranca();
		dtbaixa = trecibo.getDtbaixa();
		statusrec = trecibo.getStatusrec();
		entrega = trecibo.getEntrega();
		valorgerado = trecibo.getValorgerado();
		periodicidade = trecibo.getPeriodicidade();
		codoperador = trecibo.getCodoperador();
		codstatus = trecibo.getTconbribuintes().getSTATUS().getCODSTATUS();
		descstatus = trecibo.getTconbribuintes().getSTATUS().getDESCSTATUS();
		nome = trecibo.getTconbribuintes().getNOME();
		nomenorecibo = trecibo.getTconbribuintes().getNOMENORECIBO();
		parcela = trecibo.getParcela();
		via = trecibo.getVia();
	}

	public String getNome() {
		return nome;
	}

	public String getNomenorecibo() {
		return nomenorecibo;
	}

	public String getNomedomensageiro() {
		return nomedomensageiro;
	}

	public String getNomedomensageirofirst() {
		return nomedomensageirofirst;
	}

	public Integer getCodmensageiro() {
		return codmensageiro;
	}

	public Integer getNrorecibo() {
		return nrorecibo;
	}

	public Date getDtcobranca() {
		return dtcobranca;
	}

	public Date getDtbaixa() {
		return dtbaixa;
	}

	public String getStatusrec() {
		return statusrec;
	}

	public String getImpresso() {
		return impresso;
	}

	public Date getEntrega() {
		return entrega;
	}

	public Double getValorgerado() {
		return valorgerado;
	}

	public Integer getPeriodicidade() {
		return periodicidade;
	}

	public Integer getCodoperador() {
		return codoperador;
	}

	public Integer getCodmensageiroamais() {
		return codmensageiroamais;
	}

	public Integer getCodstatus() {
		return codstatus;
	}

	public String getDescstatus() {
		return descstatus;
	}

	public String getParcela() {
		return parcela;
	}

	public Integer getVia() {
		return via;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNomenorecibo(String nomenorecibo) {
		this.nomenorecibo = nomenorecibo;
	}

	public void setNomedomensageiro(String nomedomensageiro) {
		this.nomedomensageiro = nomedomensageiro;
	}

	public void setNomedomensageirofirst(String nomedomensageirofirst) {
		this.nomedomensageirofirst = nomedomensageirofirst;
	}

	public void setCodmensageiro(Integer codmensageiro) {
		this.codmensageiro = codmensageiro;
	}

	public void setNrorecibo(Integer nrorecibo) {
		this.nrorecibo = nrorecibo;
	}

	public void setDtcobranca(Date dtcobranca) {
		this.dtcobranca = dtcobranca;
	}

	public void setDtbaixa(Date dtbaixa) {
		this.dtbaixa = dtbaixa;
	}

	public void setStatusrec(String statusrec) {
		this.statusrec = statusrec;
	}

	public void setImpresso(String impresso) {
		this.impresso = impresso;
	}

	public void setEntrega(Date entrega) {
		this.entrega = entrega;
	}

	public void setValorgerado(Double valorgerado) {
		this.valorgerado = valorgerado;
	}

	public void setPeriodicidade(Integer periodicidade) {
		this.periodicidade = periodicidade;
	}

	public void setCodoperador(Integer codoperador) {
		this.codoperador = codoperador;
	}

	public void setCodmensageiroamais(Integer codmensageiroamais) {
		this.codmensageiroamais = codmensageiroamais;
	}

	public void setCodstatus(Integer codstatus) {
		this.codstatus = codstatus;
	}

	public void setDescstatus(String descstatus) {
		this.descstatus = descstatus;
	}

	public void setParcela(String parcela) {
		this.parcela = parcela;
	}

	public void setVia(Integer via) {
		this.via = via;
	}
	
}
