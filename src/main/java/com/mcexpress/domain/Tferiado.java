package com.mcexpress.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Tferiado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	private Integer CODFERIADO;
	@NotEmpty(message="Preenchimento obrigatório")
	private String DESCRICAO;
	@NotEmpty(message="Preenchimento obrigatório")
	private String ESTADO;
	@NotEmpty(message="Preenchimento obrigatório")
	private String CIDADE;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date DATAFERIADO;
	private Integer REPLICAR;
	
	
	public Tferiado() {
	}

	public Tferiado(Integer cODFERIADO, String dESCRICAO, String eSTADO, String cIDADE, Date dATAFERIADO, Integer rEPLICAR) {
		super();
		CODFERIADO = cODFERIADO;
		DESCRICAO = dESCRICAO;
		ESTADO = eSTADO;
		CIDADE = cIDADE;
		DATAFERIADO = dATAFERIADO;
		REPLICAR = rEPLICAR;
	}

	public Integer getCODFERIADO() {
		return CODFERIADO;
	}

	public String getDESCRICAO() {
		return DESCRICAO;
	}

	public String getESTADO() {
		return ESTADO;
	}

	public String getCIDADE() {
		return CIDADE;
	}

	public Date getDATAFERIADO() {
		return DATAFERIADO;
	}

	public void setCODFERIADO(Integer cODFERIADO) {
		CODFERIADO = cODFERIADO;
	}

	public void setDESCRICAO(String dESCRICAO) {
		DESCRICAO = dESCRICAO;
	}

	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}

	public void setCIDADE(String cIDADE) {
		CIDADE = cIDADE;
	}

	public void setDATAFERIADO(Date dATAFERIADO) {
		DATAFERIADO = dATAFERIADO;
	}
	
	public Integer getREPLICAR() {
		return REPLICAR;
	}

	public void setREPLICAR(Integer rEPLICAR) {
		REPLICAR = rEPLICAR;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CODFERIADO == null) ? 0 : CODFERIADO.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tferiado other = (Tferiado) obj;
		if (CODFERIADO == null) {
			if (other.CODFERIADO != null)
				return false;
		} else if (!CODFERIADO.equals(other.CODFERIADO))
			return false;
		return true;
	}

}
