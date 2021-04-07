package com.mcexpress.dto;

import java.io.Serializable;
import java.util.List;

public class TresumoRecibosDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String mensageiro;
	// B = baixado
	private Integer qtdRecebido = 0;
	private Double valorRecebido = 0.0;
	private Double percentualRecebido = 0.0;

	// D = devolvido
	private Integer qtdDevolvido = 0;
	private Double valorDevolvido = 0.0;
	private Double percentualDevolvido = 0.0;

	// C = cancelado
	private Integer qtdCancelado = 0;
	private Double valorCancelado = 0.0;
	private Double percentualCancelado = 0.0;

	// G = "Em aberto"
	Integer qtdEmAberto = 0;
	Double valorEmAberto = 0.0;

	// Total de todos
	public Integer totalQtd;
	public Double totalValorGerado;

	public TresumoRecibosDTO() {
	}

	public TresumoRecibosDTO(Integer qtdRecebido, Double valorRecebido, Double percentualRecebido, Integer qtdDevolvido,
			Double valorDevolvido, Double percentualDevolvido, Integer qtdCancelado, Double valorCancelado,
			Double percentualCancelado, Integer qtdEmAberto, Double valorEmAberto, Integer totalQtd,
			Double totalValorGerado, String mensageiro) {
		super();
		this.qtdRecebido = qtdRecebido;
		this.valorRecebido = valorRecebido;
		this.percentualRecebido = percentualRecebido;
		this.qtdDevolvido = qtdDevolvido;
		this.valorDevolvido = valorDevolvido;
		this.percentualDevolvido = percentualDevolvido;
		this.qtdCancelado = qtdCancelado;
		this.valorCancelado = valorCancelado;
		this.percentualCancelado = percentualCancelado;
		this.qtdEmAberto = qtdEmAberto;
		this.valorEmAberto = valorEmAberto;
		this.totalQtd = totalQtd;
		this.totalValorGerado = totalValorGerado;
		this.mensageiro = mensageiro;
		
	}

	public Integer getQtdRecebido() {
		return qtdRecebido;
	}

	public Double getValorRecebido() {
		return valorRecebido;
	}

	public Double getPercentualRecebido() {
		return percentualRecebido;
	}

	public Integer getQtdDevolvido() {
		return qtdDevolvido;
	}

	public Double getValorDevolvido() {
		return valorDevolvido;
	}

	public Double getPercentualDevolvido() {
		return percentualDevolvido;
	}

	public Integer getQtdCancelado() {
		return qtdCancelado;
	}

	public Double getValorCancelado() {
		return valorCancelado;
	}

	public Double getPercentualCancelado() {
		return percentualCancelado;
	}

	public Integer getQtdEmAberto() {
		return qtdEmAberto;
	}

	public Double getValorEmAberto() {
		return valorEmAberto;
	}

	public Integer getTotalQtd() {
		return totalQtd;
	}

	public Double getTotalValorGerado() {
		return totalValorGerado;
	}

	public void setQtdRecebido(Integer qtdRecebido) {
		this.qtdRecebido = qtdRecebido;
	}

	public void setValorRecebido(Double valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	public void setPercentualRecebido(Double percentualRecebido) {
		this.percentualRecebido = percentualRecebido;
	}

	public void setQtdDevolvido(Integer qtdDevolvido) {
		this.qtdDevolvido = qtdDevolvido;
	}

	public void setValorDevolvido(Double valorDevolvido) {
		this.valorDevolvido = valorDevolvido;
	}

	public void setPercentualDevolvido(Double percentualDevolvido) {
		this.percentualDevolvido = percentualDevolvido;
	}

	public void setQtdCancelado(Integer qtdCancelado) {
		this.qtdCancelado = qtdCancelado;
	}

	public void setValorCancelado(Double valorCancelado) {
		this.valorCancelado = valorCancelado;
	}

	public void setPercentualCancelado(Double percentualCancelado) {
		this.percentualCancelado = percentualCancelado;
	}

	public void setQtdEmAberto(Integer qtdEmAberto) {
		this.qtdEmAberto = qtdEmAberto;
	}

	public void setValorEmAberto(Double valorEmAberto) {
		this.valorEmAberto = valorEmAberto;
	}

	public void setTotalQtd(Integer totalQtd) {
		this.totalQtd = totalQtd;
	}

	public void setTotalValorGerado(Double totalValorGerado) {
		this.totalValorGerado = totalValorGerado;
	}

	public String getMensageiro() {
		return mensageiro;
	}

	public void setMensageiro(String mensageiro) {
		this.mensageiro = mensageiro;
	}

	public void resumoDtoString(List<String> listString, List<String> listRecibosEmAberto, String nomeMensageiro) {

		// B = Recebido
		Integer qtdRecebido = 0;
		Double valorRecebido = 0.0;
		Double percentualRecebido = 0.0;

		// D = devolvido
		Integer qtdDevolvido = 0;
		Double valorDevolvido = 0.0;
		Double percentualDevolvido = 0.0;

		// C = cancelado
		Integer qtdCancelado = 0;
		Double valorCancelado = 0.0;
		Double percentualCancelado = 0.0;
		
		// G = Gerado
		Integer qtdEmAberto = 0;
		Double valorEmAberto = 0.0;

		// Total de todos
		Integer totalQtd = 0;
		Double totalValorGerado = 0.0;

		String var;
		String[] vetLista = new String[4];

		for (int i = 0; i < listString.size(); i++) {

			var = listString.get(i);
			vetLista = var.split(",");

			switch (vetLista[0]) {
			case "B": // Recebido

				qtdRecebido += Integer.parseInt(vetLista[1]);
				valorRecebido += Double.parseDouble(vetLista[2]);

				break;
			case "D": // Devolvido

				qtdDevolvido += Integer.parseInt(vetLista[1]);
				valorDevolvido += Double.parseDouble(vetLista[2]);

				break;
			case "C": // Cancelado

				qtdCancelado += Integer.parseInt(vetLista[1]);
				valorCancelado += Double.parseDouble(vetLista[2]);

				break;
			default:
				break;
			}

			totalQtd += Integer.parseInt(vetLista[1]);
			totalValorGerado += Double.parseDouble(vetLista[2]);
		}
		
		percentualRecebido = (double) qtdRecebido / totalQtd;
		percentualRecebido = percentualRecebido.isNaN() ? 0.0 : percentualRecebido * 100;

		percentualDevolvido = (double) qtdDevolvido / totalQtd;
		percentualDevolvido = percentualDevolvido.isNaN() ? 0.0 : percentualDevolvido * 100;

		percentualCancelado = (double) qtdCancelado / totalQtd;
		percentualCancelado = percentualCancelado.isNaN() ? 0.0 : percentualCancelado * 100;
		
		
		String ver;
		String[] vetorLista = new String[2];
		for (int i = 0; i < listRecibosEmAberto.size(); i++) {
			
			ver = listRecibosEmAberto.get(i);
			vetorLista = ver.split(",");
			
			qtdEmAberto = Integer.parseInt(vetorLista[1]);
			valorEmAberto = Double.parseDouble(vetorLista[2]);
			
		}

		setQtdRecebido(qtdRecebido);
		setValorRecebido(valorRecebido);
		setPercentualRecebido(percentualRecebido);
		setQtdDevolvido(qtdDevolvido);
		setValorDevolvido(valorDevolvido);
		setPercentualDevolvido(percentualDevolvido);
		setQtdCancelado(qtdCancelado);
		setValorCancelado(valorCancelado);
		setPercentualCancelado(percentualCancelado);
		setTotalQtd(totalQtd);
		setTotalValorGerado(totalValorGerado);
		setQtdEmAberto(qtdEmAberto);
		setValorEmAberto(valorEmAberto);
		setMensageiro(nomeMensageiro);

	}

	
}
