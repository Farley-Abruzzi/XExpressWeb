package com.mcexpress.dto;

import java.io.Serializable;
import java.util.Date;


public class TrecibosRelatorioDiarioDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private Double valorgerado;
	private Integer qtdRecebido;
	private Double valorRecebido;
	private Double qtdAreceber;
	private Date dtrecebimento;
	
	
	public TrecibosRelatorioDiarioDTO() {
	}

	
	public TrecibosRelatorioDiarioDTO(Double valorgerado, Integer qtdRecebido, Double valorRecebido, Double qtdAreceber,
			Date dtrecebimento) {
		super();
		this.valorgerado = valorgerado;
		this.qtdRecebido = qtdRecebido;
		this.valorRecebido = valorRecebido;
		this.qtdAreceber = qtdAreceber;
		this.dtrecebimento = dtrecebimento;
	}



	public Double getValorgerado() {
		return valorgerado;
	}

	public Integer getQtdRecebido() {
		return qtdRecebido;
	}

	public Double getValorRecebido() {
		return valorRecebido;
	}


	public Double getQtdAreceber() {
		return qtdAreceber;
	}
	
	public Date getDtrecebimento() {
		return dtrecebimento;
	}

	public void setValorgerado(Double valorgerado) {
		this.valorgerado = valorgerado;
	}

	public void setQtdRecebido(Integer qtdRecebido) {
		this.qtdRecebido = qtdRecebido;
	}

	public void setValorRecebido(Double valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	public void setQtdAreceber(Double qtdAreceber) {
		this.qtdAreceber = qtdAreceber;
	}
	
	public void setDtrecebimento(Date dtrecebimento) {
		this.dtrecebimento = dtrecebimento;
	}


	
}
