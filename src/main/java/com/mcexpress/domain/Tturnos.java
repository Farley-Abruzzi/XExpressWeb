package com.mcexpress.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tturnos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CODTURNO;
	private String ABREVTURNO;
	private String DESCTURNO;
	private String HORAINICIAL;
	private String HORAFINAL;
	
	public Tturnos() {
	}

	public Tturnos(Integer cODTURNO, String aBREVTURNO, String dESCTURNO, String hORAINICIAL, String hORAFINAL) {
		super();
		CODTURNO = cODTURNO;
		ABREVTURNO = aBREVTURNO;
		DESCTURNO = dESCTURNO;
		HORAINICIAL = hORAINICIAL;
		HORAFINAL = hORAFINAL;
	}

	public Integer getCODTURNO() {
		return CODTURNO;
	}

	public String getABREVTURNO() {
		return ABREVTURNO;
	}

	public String getDESCTURNO() {
		return DESCTURNO;
	}

	public String getHORAINICIAL() {
		return HORAINICIAL;
	}

	public String getHORAFINAL() {
		return HORAFINAL;
	}

	public void setCODTURNO(Integer cODTURNO) {
		CODTURNO = cODTURNO;
	}

	public void setABREVTURNO(String aBREVTURNO) {
		ABREVTURNO = aBREVTURNO;
	}

	public void setDESCTURNO(String dESCTURNO) {
		DESCTURNO = dESCTURNO;
	}

	public void setHORAINICIAL(String hORAINICIAL) {
		HORAINICIAL = hORAINICIAL;
	}

	public void setHORAFINAL(String hORAFINAL) {
		HORAFINAL = hORAFINAL;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CODTURNO == null) ? 0 : CODTURNO.hashCode());
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
		Tturnos other = (Tturnos) obj;
		if (CODTURNO == null) {
			if (other.CODTURNO != null)
				return false;
		} else if (!CODTURNO.equals(other.CODTURNO))
			return false;
		return true;
	}
	
}
