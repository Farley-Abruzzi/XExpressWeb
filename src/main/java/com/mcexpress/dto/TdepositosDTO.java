package com.mcexpress.dto;

import java.io.Serializable;
import java.util.Date;

public class TdepositosDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer nrodeposito;
	private Integer codmensageiro;
	private Integer qtdrecibos;
	private Double totalarrecadado;
	private Date dtfechamento;
	private String periodo;
	
	public TdepositosDTO() {
		
	}

	public Integer getNrodeposito() {
		return nrodeposito;
	}

	public Integer getCodmensageiro() {
		return codmensageiro;
	}

	public Integer getQtdrecibos() {
		return qtdrecibos;
	}

	public Double getTotalarrecadado() {
		return totalarrecadado;
	}

	public Date getDtfechamento() {
		return dtfechamento;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setNrodeposito(Integer nrodeposito) {
		this.nrodeposito = nrodeposito;
	}

	public void setCodmensageiro(Integer codmensageiro) {
		this.codmensageiro = codmensageiro;
	}

	public void setQtdrecibos(Integer qtdrecibos) {
		this.qtdrecibos = qtdrecibos;
	}

	public void setTotalarrecadado(Double totalarrecadado) {
		this.totalarrecadado = totalarrecadado;
	}

	public void setDtfechamento(Date dtfechamento) {
		this.dtfechamento = dtfechamento;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	

}
