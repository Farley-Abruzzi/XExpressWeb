package com.mcexpress.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tcategorias implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CODCATEGORIA;
	private String ABREVCATEGORIA;
	private String DESCCATEGORIA;
	private Integer LIMAGENDAMENTO;
	private Integer TEMPODESCANSO;
	private Integer PERIODICIDADE;
	
	public Tcategorias() {
	}

	public Tcategorias(Integer cODCATEGORIA, String aBREVCATEGORIA, String dESCCATEGORIA, Integer lIMAGENDAMENTO,
			Integer tEMPODESCANSO, Integer pERIODICIDADE) {
		super();
		CODCATEGORIA = cODCATEGORIA;
		ABREVCATEGORIA = aBREVCATEGORIA;
		DESCCATEGORIA = dESCCATEGORIA;
		LIMAGENDAMENTO = lIMAGENDAMENTO;
		TEMPODESCANSO = tEMPODESCANSO;
		PERIODICIDADE = pERIODICIDADE;
	}

	public Integer getCODCATEGORIA() {
		return CODCATEGORIA;
	}

	public String getABREVCATEGORIA() {
		return ABREVCATEGORIA;
	}

	public String getDESCCATEGORIA() {
		return DESCCATEGORIA;
	}

	public Integer getLIMAGENDAMENTO() {
		return LIMAGENDAMENTO;
	}

	public Integer getTEMPODESCANSO() {
		return TEMPODESCANSO;
	}

	public Integer getPERIODICIDADE() {
		return PERIODICIDADE;
	}

	public void setCODCATEGORIA(Integer cODCATEGORIA) {
		CODCATEGORIA = cODCATEGORIA;
	}

	public void setABREVCATEGORIA(String aBREVCATEGORIA) {
		ABREVCATEGORIA = aBREVCATEGORIA;
	}

	public void setDESCCATEGORIA(String dESCCATEGORIA) {
		DESCCATEGORIA = dESCCATEGORIA;
	}

	public void setLIMAGENDAMENTO(Integer lIMAGENDAMENTO) {
		LIMAGENDAMENTO = lIMAGENDAMENTO;
	}

	public void setTEMPODESCANSO(Integer tEMPODESCANSO) {
		TEMPODESCANSO = tEMPODESCANSO;
	}

	public void setPERIODICIDADE(Integer pERIODICIDADE) {
		PERIODICIDADE = pERIODICIDADE;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CODCATEGORIA == null) ? 0 : CODCATEGORIA.hashCode());
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
		Tcategorias other = (Tcategorias) obj;
		if (CODCATEGORIA == null) {
			if (other.CODCATEGORIA != null)
				return false;
		} else if (!CODCATEGORIA.equals(other.CODCATEGORIA))
			return false;
		return true;
	}

}
