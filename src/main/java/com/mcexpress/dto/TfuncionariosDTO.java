package com.mcexpress.dto;

import java.io.Serializable;

import com.mcexpress.domain.Tfuncionarios;

public class TfuncionariosDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	
	private String NOME;
	private Integer CODMENSAGEIROAMAIS;
	private Integer CODFUNC;
	
	
	public TfuncionariosDTO(Tfuncionarios obj) {
		super();
		NOME = obj.getNOME();
		CODMENSAGEIROAMAIS = obj.getCODMENSAGEIROAMAIS();
		CODFUNC = obj.getCODFUNC();
	}


	public String getNOME() {
		return NOME;
	}


	public Integer getCODMENSAGEIROAMAIS() {
		return CODMENSAGEIROAMAIS;
	}


	public void setNOME(String nOME) {
		NOME = nOME;
	}


	public void setCODMENSAGEIROAMAIS(Integer cODMENSAGEIROAMAIS) {
		CODMENSAGEIROAMAIS = cODMENSAGEIROAMAIS;
	}


	public Integer getCODFUNC() {
		return CODFUNC;
	}


	public void setCODFUNC(Integer cODFUNC) {
		CODFUNC = cODFUNC;
	}
	
	
	
}
