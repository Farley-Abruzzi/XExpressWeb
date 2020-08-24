package com.mcexpress.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.mcexpress.domain.Tfuncionarios;

public class TusuarioDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private Integer CODFUNC;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String NOME;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String ENDERECO;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String NUMERO;
	private String COMPLEMENTO;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String BAIRRO;
	private String CEP;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String CIDADE;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String UF;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String TELEFONE;
	private String OBSERVACOES;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String SENHA;
	
	
	
	public TusuarioDTO() {
		
	}
	
	public TusuarioDTO(Tfuncionarios tfuncionarios) {
		this.CODFUNC = tfuncionarios.getCODFUNC();
		this.NOME = tfuncionarios.getNOME();
		this.ENDERECO = tfuncionarios.getENDERECO();
		this.NUMERO = tfuncionarios.getNUMERO();
		this.COMPLEMENTO = tfuncionarios.getCOMPLEMENTO();
		this.BAIRRO = tfuncionarios.getBAIRRO();
		this.CEP = tfuncionarios.getCEP();
		this.CIDADE = tfuncionarios.getCIDADE();
		this.UF = tfuncionarios.getUF();
		this.TELEFONE = tfuncionarios.getTELEFONE();
		this.OBSERVACOES = tfuncionarios.getOBSERVACOES();
		
	}

	public Integer getCODFUNC() {
		return CODFUNC;
	}

	public String getNOME() {
		return NOME;
	}

	public String getENDERECO() {
		return ENDERECO;
	}

	public String getNUMERO() {
		return NUMERO;
	}

	public String getCOMPLEMENTO() {
		return COMPLEMENTO;
	}

	public String getBAIRRO() {
		return BAIRRO;
	}

	public String getCEP() {
		return CEP;
	}

	public String getCIDADE() {
		return CIDADE;
	}

	public String getUF() {
		return UF;
	}
	
	public String getTELEFONE() {
		return TELEFONE;
	}

	public String getOBSERVACOES() {
		return OBSERVACOES;
	}

	public void setCODFUNC(Integer cODFUNC) {
		CODFUNC = cODFUNC;
	}

	public void setNOME(String nOME) {
		NOME = nOME;
	}

	public void setENDERECO(String eNDERECO) {
		ENDERECO = eNDERECO;
	}

	public void setNUMERO(String nUMERO) {
		NUMERO = nUMERO;
	}

	public void setCOMPLEMENTO(String cOMPLEMENTO) {
		COMPLEMENTO = cOMPLEMENTO;
	}

	public void setBAIRRO(String bAIRRO) {
		BAIRRO = bAIRRO;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public void setCIDADE(String cIDADE) {
		CIDADE = cIDADE;
	}

	public void setUF(String uF) {
		UF = uF;
	}
	
	public void setTELEFONE(String tELEFONE) {
		TELEFONE = tELEFONE;
	}

	public void setOBSERVACOES(String oBSERVACOES) {
		OBSERVACOES = oBSERVACOES;
	}
	
}
