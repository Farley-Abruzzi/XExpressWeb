package com.mcexpress.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Trecdevolvidosweb implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer nrorecibo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtdevol;
	private String horaoper;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtoperacao;
	private Integer codoperador;
	private Integer codusuario;
	private String motivodevolucao;
	private Integer statendimento;
	private String dscatendimento;
	
	public Trecdevolvidosweb() {
	}

	public Trecdevolvidosweb(Integer nRORECIBO, Date dTDEVOL, String hORAOPER, Date dTOPERACAO, Integer cODOPERADOR,
			Integer cODUSUARIO, String mOTIVODEVOLUCAO, Integer sTATENDIMENTO, String dSCATENDIMENTO) {
		super();
		nrorecibo = nRORECIBO;
		dtdevol = dTDEVOL;
		horaoper = hORAOPER;
		dtoperacao = dTOPERACAO;
		codoperador = cODOPERADOR;
		codusuario = cODUSUARIO;
		motivodevolucao = mOTIVODEVOLUCAO;
		statendimento = sTATENDIMENTO;
		dscatendimento = dSCATENDIMENTO;
	}

	public Integer getNrorecibo() {
		return nrorecibo;
	}

	public Date getDtdevol() {
		return dtdevol;
	}

	public String getHoraoper() {
		return horaoper;
	}

	public Date getDtoperacao() {
		return dtoperacao;
	}

	public Integer getCodoperador() {
		return codoperador;
	}

	public Integer getCodusuario() {
		return codusuario;
	}

	public String getMotivodevolucao() {
		return motivodevolucao;
	}

	public Integer getStatendimento() {
		return statendimento;
	}

	public String getDscatendimento() {
		return dscatendimento;
	}

	public void setNrorecibo(Integer nrorecibo) {
		this.nrorecibo = nrorecibo;
	}

	public void setDtdevol(Date dtdevol) {
		this.dtdevol = dtdevol;
	}

	public void setHoraoper(String horaoper) {
		this.horaoper = horaoper;
	}

	public void setDtoperacao(Date dtoperacao) {
		this.dtoperacao = dtoperacao;
	}

	public void setCodoperador(Integer codoperador) {
		this.codoperador = codoperador;
	}

	public void setCodusuario(Integer codusuario) {
		this.codusuario = codusuario;
	}

	public void setMotivodevolucao(String motivodevolucao) {
		this.motivodevolucao = motivodevolucao;
	}

	public void setStatendimento(Integer statendimento) {
		this.statendimento = statendimento;
	}

	public void setDscatendimento(String dscatendimento) {
		this.dscatendimento = dscatendimento;
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
		Trecdevolvidosweb other = (Trecdevolvidosweb) obj;
		if (nrorecibo == null) {
			if (other.nrorecibo != null)
				return false;
		} else if (!nrorecibo.equals(other.nrorecibo))
			return false;
		return true;
	}

}
