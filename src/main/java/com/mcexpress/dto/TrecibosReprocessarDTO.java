package com.mcexpress.dto;

import java.io.Serializable;

public class TrecibosReprocessarDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private Integer codmensageiro;
	private Integer quantidadeRecibos;
	private Double valorRecibos;
	
	public TrecibosReprocessarDTO() {
	}
	
	public TrecibosReprocessarDTO(String nome, Integer codmensageiro, Integer quantidadeRecibos, Double valorRecibos) {
		super();
		this.nome = nome;
		this.codmensageiro = codmensageiro;
		this.quantidadeRecibos = quantidadeRecibos;
		this.valorRecibos = valorRecibos;
	}

	public String getNome() {
		return nome;
	}

	public Integer getCodmensageiro() {
		return codmensageiro;
	}

	public Integer getQuantidadeRecibos() {
		return quantidadeRecibos;
	}

	public Double getValorRecibos() {
		return valorRecibos;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCodmensageiro(Integer codmensageiro) {
		this.codmensageiro = codmensageiro;
	}

	public void setQuantidadeRecibos(Integer quantidadeRecibos) {
		this.quantidadeRecibos = quantidadeRecibos;
	}

	public void setValorRecibos(Double valorRecibos) {
		this.valorRecibos = valorRecibos;
	}

}
