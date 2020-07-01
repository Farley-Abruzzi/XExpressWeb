package com.mcexpress.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tstatussistema implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CODSTATUS;
	private String DESCSTATUSSIS;

	public Tstatussistema() {
	}

	public Tstatussistema(Integer cODSTATUS, String dESCSTATUSSIS) {
		super();
		CODSTATUS = cODSTATUS;
		DESCSTATUSSIS = dESCSTATUSSIS;
	}

	public Integer getCODSTATUS() {
		return CODSTATUS;
	}

	public String getDESCSTATUSSIS() {
		return DESCSTATUSSIS;
	}

	public void setCODSTATUS(Integer cODSTATUS) {
		CODSTATUS = cODSTATUS;
	}

	public void setDESCSTATUSSIS(String dESCSTATUSSIS) {
		DESCSTATUSSIS = dESCSTATUSSIS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CODSTATUS == null) ? 0 : CODSTATUS.hashCode());
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
		Tstatussistema other = (Tstatussistema) obj;
		if (CODSTATUS == null) {
			if (other.CODSTATUS != null)
				return false;
		} else if (!CODSTATUS.equals(other.CODSTATUS))
			return false;
		return true;
	}
	
	
	
}
