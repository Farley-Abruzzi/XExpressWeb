package com.mcexpress.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public abstract class Tlog implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer CODUSUARIO;
	private Date DATA;
	private String HORA;
	private String DESCRICAO;
	
	//Associação
	@JsonIgnore
	@JoinColumn(name="CODUSUARIO")
	@ManyToOne
	@MapsId  //aqui eu não vou gerar o ID automático, vou gerar o ID do pto correspondente ao pedido, para isso o maps id
	private Tusuarios USUARIO;
	
	public Tlog() {
	}

	public Tlog(Integer cODUSUARIO, Date dATA, String hORA, String dESCRICAO, Tusuarios uSUARIO) {
		super();
		CODUSUARIO = cODUSUARIO;
		DATA = dATA;
		HORA = hORA;
		DESCRICAO = dESCRICAO;
		USUARIO = uSUARIO;
	}

	public Integer getCODUSUARIO() {
		return CODUSUARIO;
	}

	public Date getDATA() {
		return DATA;
	}

	public String getHORA() {
		return HORA;
	}

	public String getDESCRICAO() {
		return DESCRICAO;
	}

	public Tusuarios getUSUARIO() {
		return USUARIO;
	}

	public void setDATA(Date dATA) {
		DATA = dATA;
	}

	public void setHORA(String hORA) {
		HORA = hORA;
	}

	public void setDESCRICAO(String dESCRICAO) {
		DESCRICAO = dESCRICAO;
	}

	public void setUSUARIO(Tusuarios uSUARIO) {
		USUARIO = uSUARIO;
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
		Tlog other = (Tlog) obj;
		if (CODUSUARIO == null) {
			if (other.CODUSUARIO != null)
				return false;
		} else if (!CODUSUARIO.equals(other.CODUSUARIO))
			return false;
		return true;
	}

	
	
	
	
	
	

}
