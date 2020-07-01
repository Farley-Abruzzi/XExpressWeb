package com.mcexpress.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tstatus implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CODSTATUS;
	private String DESCSTATUS;
	private String ATIVO;
	private String CONTRIBUIU;
	private String ABREVSTATUS;
	
	public Tstatus(){
	}

	public Tstatus(Integer cODSTATUS, String dESCSTATUS, String aTIVO, String cONTRIBUIU, String aBREVSTATUS) {
		super();
		CODSTATUS = cODSTATUS;
		DESCSTATUS = dESCSTATUS;
		ATIVO = aTIVO;
		CONTRIBUIU = cONTRIBUIU;
		ABREVSTATUS = aBREVSTATUS;
	}

	public Integer getCODSTATUS() {
		return CODSTATUS;
	}

	public String getDESCSTATUS() {
		return DESCSTATUS;
	}

	public String getATIVO() {
		return ATIVO;
	}

	public String getCONTRIBUIU() {
		return CONTRIBUIU;
	}

	public String getABREVSTATUS() {
		return ABREVSTATUS;
	}

	public void setCODSTATUS(Integer cODSTATUS) {
		CODSTATUS = cODSTATUS;
	}

	public void setDESCSTATUS(String dESCSTATUS) {
		DESCSTATUS = dESCSTATUS;
	}

	public void setATIVO(String aTIVO) {
		ATIVO = aTIVO;
	}

	public void setCONTRIBUIU(String cONTRIBUIU) {
		CONTRIBUIU = cONTRIBUIU;
	}

	public void setABREVSTATUS(String aBREVSTATUS) {
		ABREVSTATUS = aBREVSTATUS;
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
		Tstatus other = (Tstatus) obj;
		if (CODSTATUS == null) {
			if (other.CODSTATUS != null)
				return false;
		} else if (!CODSTATUS.equals(other.CODSTATUS))
			return false;
		return true;
	}
	
	

}
