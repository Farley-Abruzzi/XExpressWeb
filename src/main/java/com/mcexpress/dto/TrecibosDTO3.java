package com.mcexpress.dto;

import java.io.Serializable;

public class TrecibosDTO3 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String cidade;
	private Integer qtdRecibos;
	private Double valorGerado;
	private String status;
	
	public TrecibosDTO3() {
	}
	
	public TrecibosDTO3(String cidade, Integer qtdRecibos, Double valorGerado, String status) {
		this.cidade = cidade;
		this.qtdRecibos = qtdRecibos;
		this.valorGerado = valorGerado;
		this.status = status;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getQtdRecibos() {
		return qtdRecibos;
	}
	
	public void setQtdRecibos(Integer qtdRecibos) {
		this.qtdRecibos = qtdRecibos;
	}
	
	public Double getValorGerado() {
		return valorGerado;
	}
	
	public void setValorGerado(Double valorGerado) {
		this.valorGerado = valorGerado;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/*
	 //Método compare to com implements Comparable<TrecibosDTO3>
	@Override
	public int compareTo(TrecibosDTO3 outraCidade) {
		// TODO Auto-generated method stub
		return cidade.compareTo(outraCidade.getCidade());
	}*/
}
