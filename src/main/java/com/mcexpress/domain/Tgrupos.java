package com.mcexpress.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tgrupos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CODGRUPO;
	private String DESCRICAO;
	private String PERMISSAO1;
	private String PERMISSAO2;
	private String PERMISSAO3;
	private String PERMISSAO4;
	private String PERMISSAO5;
	private String PERMISSAO6;
	
	public Tgrupos() {
	}

	public Tgrupos(Integer cODGRUPO, String dESCRICAO, String pERMISSAO1, String pERMISSAO2, String pERMISSAO3,
			String pERMISSAO4, String pERMISSAO5, String pERMISSAO6) {
		super();
		CODGRUPO = cODGRUPO;
		DESCRICAO = dESCRICAO;
		PERMISSAO1 = pERMISSAO1;
		PERMISSAO2 = pERMISSAO2;
		PERMISSAO3 = pERMISSAO3;
		PERMISSAO4 = pERMISSAO4;
		PERMISSAO5 = pERMISSAO5;
		PERMISSAO6 = pERMISSAO6;
	}

	public Integer getCODGRUPO() {
		return CODGRUPO;
	}

	public String getDESCRICAO() {
		return DESCRICAO;
	}

	public String getPERMISSAO1() {
		return PERMISSAO1;
	}

	public String getPERMISSAO2() {
		return PERMISSAO2;
	}

	public String getPERMISSAO3() {
		return PERMISSAO3;
	}

	public String getPERMISSAO4() {
		return PERMISSAO4;
	}

	public String getPERMISSAO5() {
		return PERMISSAO5;
	}

	public String getPERMISSAO6() {
		return PERMISSAO6;
	}

	public void setCODGRUPO(Integer cODGRUPO) {
		CODGRUPO = cODGRUPO;
	}

	public void setDESCRICAO(String dESCRICAO) {
		DESCRICAO = dESCRICAO;
	}

	public void setPERMISSAO1(String pERMISSAO1) {
		PERMISSAO1 = pERMISSAO1;
	}

	public void setPERMISSAO2(String pERMISSAO2) {
		PERMISSAO2 = pERMISSAO2;
	}

	public void setPERMISSAO3(String pERMISSAO3) {
		PERMISSAO3 = pERMISSAO3;
	}

	public void setPERMISSAO4(String pERMISSAO4) {
		PERMISSAO4 = pERMISSAO4;
	}

	public void setPERMISSAO5(String pERMISSAO5) {
		PERMISSAO5 = pERMISSAO5;
	}

	public void setPERMISSAO6(String pERMISSAO6) {
		PERMISSAO6 = pERMISSAO6;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CODGRUPO == null) ? 0 : CODGRUPO.hashCode());
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
		Tgrupos other = (Tgrupos) obj;
		if (CODGRUPO == null) {
			if (other.CODGRUPO != null)
				return false;
		} else if (!CODGRUPO.equals(other.CODGRUPO))
			return false;
		return true;
	}
	
	
	
}
