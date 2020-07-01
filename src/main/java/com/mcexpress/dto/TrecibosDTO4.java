package com.mcexpress.dto;

import java.io.Serializable;

public class TrecibosDTO4 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String cidade;
	private Integer qtdRecebidos;
	private Double valorRecebidos;
	private Integer qtdTotal;
	private Double valorTotal;
	private Double percentualRecebido = 0.0;;
	
	public TrecibosDTO4() {
	}

	public String getCidade() {
		return cidade;
	}

	public Integer getQtdRecebidos() {
		return qtdRecebidos;
	}

	public Double getValorRecebidos() {
		return valorRecebidos;
	}

	public Integer getQtdTotal() {
		return qtdTotal;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public Double getPercentualRecebido() {
		return percentualRecebido;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setQtdRecebidos(Integer qtdRecebidos) {
		this.qtdRecebidos = qtdRecebidos;
	}

	public void setValorRecebidos(Double valorRecebidos) {
		this.valorRecebidos = valorRecebidos;
	}

	public void setQtdTotal(Integer qtdTotal) {
		this.qtdTotal = qtdTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setPercentualRecebido(Double percentualRecebido) {
		this.percentualRecebido = percentualRecebido;
	}

}
