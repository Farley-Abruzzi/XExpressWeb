package com.mcexpress.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Thistoricorecibo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer nrorecibo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataacao;
	private String horaacao;
	private String usuario;
	private String acao;
	
	
	public Thistoricorecibo() {
	}

	public Thistoricorecibo(Integer nrorecibo, Date dataacao, String horaacao, String usuario,String acao) {
		super();
		this.nrorecibo = nrorecibo;
		this.dataacao = dataacao;
		this.horaacao = horaacao;
		this.usuario = usuario;
		this.acao = acao;
	}
		
	public Integer getNrorecibo() {
		return nrorecibo;
	}

	public Date getDataacao() {
		return dataacao;
	}

	public String getHoraacao() {
		return horaacao;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getAcao() {
		return acao;
	}

	public void setNrorecibo(Integer nrorecibo) {
		this.nrorecibo = nrorecibo;
	}

	public void setDataacao(Date dataacao) {
		this.dataacao = dataacao;
	}

	public void setHoraacao(String horaacao) {
		this.horaacao = horaacao;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nrorecibo == null) ? 0 : nrorecibo.hashCode());
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
		Thistoricorecibo other = (Thistoricorecibo) obj;
		if (nrorecibo == null) {
			if (other.nrorecibo != null)
				return false;
		} else if (!nrorecibo.equals(other.nrorecibo))
			return false;
		return true;
	}


}
