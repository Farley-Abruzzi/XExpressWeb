package com.mcexpress.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tcargos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer CODCARGO;
	public String DESCCARGO;
	
	public Tcargos() {
	}

	public Tcargos(Integer cODCARGO, String dESCCARGO) {
		CODCARGO = cODCARGO;
		DESCCARGO = dESCCARGO;
	}

	public Integer getCODCARGO() {
		return CODCARGO;
	}

	public String getDESCCARGO() {
		return DESCCARGO;
	}

	public void setCODCARGO(Integer cODCARGO) {
		CODCARGO = cODCARGO;
	}

	public void setDESCCARGO(String dESCCARGO) {
		DESCCARGO = dESCCARGO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CODCARGO == null) ? 0 : CODCARGO.hashCode());
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
		Tcargos other = (Tcargos) obj;
		if (CODCARGO == null) {
			if (other.CODCARGO != null)
				return false;
		} else if (!CODCARGO.equals(other.CODCARGO))
			return false;
		return true;
	}
		
}
