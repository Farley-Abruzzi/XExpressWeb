package com.mcexpress.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



@Entity
public class Tusuarios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CODUSUARIO;
	private String 	LOGIN;
	private String SENHA;
	private Date DTULTALTERACAO;
	private String SENHAJAVA;
	@OneToOne
	@JoinColumn(name="CODFUNC")
	private Tfuncionarios FUNCIONARIO;
	@OneToOne
	@JoinColumn(name="CODGRUPO")
	private Tgrupos GRUPO;
	
		
	public Tusuarios() {
	}


	public Tusuarios(Integer cODUSUARIO, String lOGIN, String sENHA, Date dTULTALTERACAO, String sENHAJAVA,
			Tfuncionarios fUNCIONARIO, Tgrupos gRUPO) {
		super();
		CODUSUARIO = cODUSUARIO;
		LOGIN = lOGIN;
		SENHA = sENHA;
		DTULTALTERACAO = dTULTALTERACAO;
		SENHAJAVA = sENHAJAVA;
		FUNCIONARIO = fUNCIONARIO;
		GRUPO = gRUPO;
	}


	public Integer getCODUSUARIO() {
		return CODUSUARIO;
	}


	public String getLOGIN() {
		return LOGIN;
	}


	public String getSENHA() {
		return SENHA;
	}


	public Date getDTULTALTERACAO() {
		return DTULTALTERACAO;
	}


	public String getSENHAJAVA() {
		return SENHAJAVA;
	}


	public Tfuncionarios getFUNCIONARIO() {
		return FUNCIONARIO;
	}


	public Tgrupos getGRUPO() {
		return GRUPO;
	}


	public void setCODUSUARIO(Integer cODUSUARIO) {
		CODUSUARIO = cODUSUARIO;
	}


	public void setLOGIN(String lOGIN) {
		LOGIN = lOGIN;
	}


	public void setSENHA(String sENHA) {
		SENHA = sENHA;
	}


	public void setDTULTALTERACAO(Date dTULTALTERACAO) {
		DTULTALTERACAO = dTULTALTERACAO;
	}


	public void setSENHAJAVA(String sENHAJAVA) {
		SENHAJAVA = sENHAJAVA;
	}


	public void setFUNCIONARIO(Tfuncionarios fUNCIONARIO) {
		FUNCIONARIO = fUNCIONARIO;
	}


	public void setGRUPO(Tgrupos gRUPO) {
		GRUPO = gRUPO;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CODUSUARIO == null) ? 0 : CODUSUARIO.hashCode());
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
		Tusuarios other = (Tusuarios) obj;
		if (CODUSUARIO == null) {
			if (other.CODUSUARIO != null)
				return false;
		} else if (!CODUSUARIO.equals(other.CODUSUARIO))
			return false;
		return true;
	}
	
	
}
