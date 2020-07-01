package com.mcexpress.dto;

import java.io.Serializable;

public class TrecebidoMensageiroDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer codmensageiro;
	private String nomeDoMensageiro;
	private Integer qtdRecebido = 0;
	private Double valorRecebido = 0.0;
	private Integer qtdAcoesMensageiro;
	
	
	
	public TrecebidoMensageiroDTO() {	
	}
	
	
	public TrecebidoMensageiroDTO(Integer codmensageiro, String nomeDoMensageiro,
			Integer qtdRecebido, Double valorRecebido, Integer qtdAcoesMensageiro) {
		super();
		this.codmensageiro = codmensageiro;
		this.nomeDoMensageiro = nomeDoMensageiro;
		this.qtdRecebido = qtdRecebido;
		this.valorRecebido = valorRecebido;
		this.qtdAcoesMensageiro = qtdAcoesMensageiro;
	}



	public Integer getCodmensageiro() {
		return codmensageiro;
	}

	public String getNomeDoMensageiro() {
		return nomeDoMensageiro;
	}


	public Integer getQtdRecebido() {
		return qtdRecebido;
	}

	public Double getValorRecebido() {
		return valorRecebido;
	}

	public Integer getQtdAcoesMensageiro() {
		return qtdAcoesMensageiro;
	}

	public void setCodmensageiro(Integer codmensageiro) {
		this.codmensageiro = codmensageiro;
	}

	public void setNomeDoMensageiro(String nomeDoMensageiro) {
		this.nomeDoMensageiro = nomeDoMensageiro;
	}

	public void setQtdrecebido(Integer qtdRecebido) {
		this.qtdRecebido = qtdRecebido;
	}

	public void setValorrecebido(Double valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	public void setQtdAcoesMensageiro(Integer qtdAcoesMensageiro) {
		this.qtdAcoesMensageiro = qtdAcoesMensageiro;
	}
	
	
	

}
