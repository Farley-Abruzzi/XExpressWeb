package com.mcexpress.dto;

import java.io.Serializable;
import java.util.Date;

public class TdepositoDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private Integer nrodeposito;
	private Integer codmensageiro;
	private Integer codvaliadcao;
	private Integer codusuario;
	private Integer qtdrecibos;
	private Double totalarrecadado;
	private Date dtfechamento;
	private String periodo;
	private Double valorDeposito;
	private String entidade;
	
	
	public TdepositoDTO() {	
	}
	
	public TdepositoDTO(Integer nrodeposito, Integer codmensageiro, Integer codvaliadcao, Integer codusuario,
			Integer qtdrecibos, Double totalarrecadado, Date dtfechamento, String periodo, Double valorDeposito,
			String entidade) {
		super();
		this.nrodeposito = nrodeposito;
		this.codmensageiro = codmensageiro;
		this.codvaliadcao = codvaliadcao;
		this.codusuario = codusuario;
		this.qtdrecibos = qtdrecibos;
		this.totalarrecadado = totalarrecadado;
		this.dtfechamento = dtfechamento;
		this.periodo = periodo;
		this.valorDeposito = valorDeposito;
		this.entidade = entidade;
	}




	public Integer getNrodeposito() {
		return nrodeposito;
	}


	public Integer getCodmensageiro() {
		return codmensageiro;
	}


	public Integer getCodvaliadcao() {
		return codvaliadcao;
	}


	public Integer getCodusuario() {
		return codusuario;
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


	public Double getValorDeposito() {
		return valorDeposito;
	}


	public String getEntidade() {
		return entidade;
	}


	public void setNrodeposito(Integer nrodeposito) {
		this.nrodeposito = nrodeposito;
	}


	public void setCodmensageiro(Integer codmensageiro) {
		this.codmensageiro = codmensageiro;
	}


	public void setCodvaliadcao(Integer codvaliadcao) {
		this.codvaliadcao = codvaliadcao;
	}


	public void setCodusuario(Integer codusuario) {
		this.codusuario = codusuario;
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


	public void setValorDeposito(Double valorDeposito) {
		this.valorDeposito = valorDeposito;
	}


	public void setEntidade(String entidade) {
		this.entidade = entidade;
	}

}

