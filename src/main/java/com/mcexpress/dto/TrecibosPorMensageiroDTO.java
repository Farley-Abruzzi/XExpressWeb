package com.mcexpress.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mcexpress.domain.Trecibos;

public class TrecibosPorMensageiroDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer nrorecibo;
	private String nomenorecibo;
	private String telefone;
	private Double valor;
	private String statusrec;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtcobranca;
	private String cidade;
	private String bairro;
	private String endereco;
	private Integer codmensageiro;
	private Date dtrecebimento;
	private Integer codcontrib;
	
	

	public TrecibosPorMensageiroDTO(Trecibos trecibo) {
		super();
		this.nrorecibo = trecibo.getNrorecibo();
		this.nomenorecibo = trecibo.getTconbribuintes().getNOMENORECIBO();
		this.telefone = trecibo.getTconbribuintes().getTELEFONEPRINCIPAL();
		this.valor = trecibo.getValorgerado();
		this.statusrec = trecibo.getStatusrec();
		this.dtcobranca = trecibo.getDtcobranca();
		this.cidade = trecibo.getTconbribuintes().getCIDADEPRINCIPAL();
		this.bairro = trecibo.getTconbribuintes().getBAIRROSECUNDARIO();
		this.endereco = trecibo.getTconbribuintes().getENDERECOSECUNDARIO();
		this.codmensageiro = trecibo.getCodmensageiro();
		this.dtrecebimento = trecibo.getDtrecebimento();
		this.codcontrib = trecibo.getCodcontrib();
	}
	
	

	public Integer getCodcontrib() {
		return codcontrib;
	}

	public void setCodcontrib(Integer codcontrib) {
		this.codcontrib = codcontrib;
	}

	public Integer getNrorecibo() {
		return nrorecibo;
	}

	public String getNomenorecibo() {
		return nomenorecibo;
	}

	public String getTelefone() {
		return telefone;
	}

	public Double getValor() {
		return valor;
	}

	public String getStatusrec() {
		return statusrec;
	}

	public Date getDtrecebimento() {
		return dtrecebimento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setNrorecibo(Integer nrorecibo) {
		this.nrorecibo = nrorecibo;
	}

	public void setNomenorecibo(String nomenorecibo) {
		this.nomenorecibo = nomenorecibo;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void setStatusrec(String statusrec) {
		this.statusrec = statusrec;
	}

	public void setDtrecebimento(Date dtrecebimento) {
		this.dtrecebimento = dtrecebimento;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getMensageiro() {
		return codmensageiro;
	}

	public void setMensageiro(Integer codmensageiro) {
		this.codmensageiro = codmensageiro;
	}

	public Date getDtcobranca() {
		return dtcobranca;
	}

	public void setDtcobranca(Date dtcobranca) {
		this.dtcobranca = dtcobranca;
	}
	
	

}
