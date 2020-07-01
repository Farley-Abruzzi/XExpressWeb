package com.mcexpress.dto;

import java.io.Serializable;


import com.mcexpress.domain.Trecibos;

public class TrecibosReimpressosDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nomenorecibo;
	private Integer codmensageiro;
	private String telefone;
	private Integer nrorecibo;
	private Double valor;
	private Double valorOriginal;
	private Integer status;
	private String nomeMensageiro;
	private Integer codfunc;
	private Integer codmensageiroamais;
	private Integer codcontrib;

	
	public TrecibosReimpressosDTO(Trecibos trecibo) {
		super();
		this.nomenorecibo = trecibo.getTconbribuintes().getNOMENORECIBO();
		this.codmensageiro = trecibo.getCodmensageiro();
		this.telefone = trecibo.getTconbribuintes().getTELEFONEPRINCIPAL();
		this.nrorecibo = trecibo.getNrorecibo();
		this.valor = trecibo.getValorgerado();
		this.status = trecibo.getVia();
		this.codfunc = trecibo.getTconbribuintes().getFUNCIONARIO().getCODFUNC();
		this.nomeMensageiro = trecibo.getTconbribuintes().getFUNCIONARIO().getNOME();
		this.codcontrib = trecibo.getCodcontrib();
	}
	


	public String getNomenorecibo() {
		return nomenorecibo;
	}

	public Integer getCodmensageiro() {
		return codmensageiro;
	}
	
	public Integer getCodmensageiroAmais() {
		return codmensageiroamais;
	}


	public String getTelefone() {
		return telefone;
	}


	public Integer getNrorecibo() {
		return nrorecibo;
	}


	public Double getValor() {
		return valor;
	}


	public Double getValorOriginal() {
		return valorOriginal;
	}


	public Integer getStatus() {
		return status;
	}


	public String getNomeMensageiro() {
		return nomeMensageiro;
	}


	public Integer getCodfunc() {
		return codfunc;
	}
	
	public Integer getCodcontrib() {
		return codcontrib;
	}


	public void setNomenorecibo(String nomenorecibo) {
		this.nomenorecibo = nomenorecibo;
	}


	public void setCodmensageiro(Integer codmensageiro) {
		this.codmensageiro = codmensageiro;
	}
	
	public void setCodmensageiroAmais(Integer codmensageiroamais) {
		this.codmensageiroamais = codmensageiroamais;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public void setNrorecibo(Integer nrorecibo) {
		this.nrorecibo = nrorecibo;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public void setValorOriginal(Double valorOriginal) {
		this.valorOriginal = valorOriginal;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public void setNomeMensageiro(String nomeMensageiro) {
		this.nomeMensageiro = nomeMensageiro;
	}


	public void setCodfunc(Integer codfunc) {
		this.codfunc = codfunc;
	}
	
	public void setCodcontrib(Integer codcontrib) {
		this.codcontrib = codcontrib;
	}
	
	
	
}
