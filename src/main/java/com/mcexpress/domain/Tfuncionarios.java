package com.mcexpress.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tfuncionarios implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	Integer CODFUNC;
	private String NOME;
	private String SITUACAO;
	private Double COMISSAO;
	private String SUPERVISOR;
	private String ENDERECO;
	private String NUMERO;
	private String COMPLEMENTO;
	private String BAIRRO;
	private String CEP;
	private String CIDADE;
	private String UF;
	private String TELEFONE;
	private String OBSERVACOES;
	private String LOGINMENSAGEIRO;
	private Integer CODMENSAGEIROAMAIS;
	
	
	@ManyToOne
	@JoinColumn(name="CODCARGO")
	private Tcargos CODCARGO;
	
	@ManyToOne
	@JoinColumn(name="CODTURNO")
	private Tturnos TURNO;
	
	
	public Tfuncionarios() {
	}

	public Tfuncionarios(Integer cODFUNC, String nOME, String sITUACAO, Double cOMISSAO, String sUPERVISOR,
			String eNDERECO, String nUMERO, String cOMPLEMENTO, String bAIRRO, String cEP, String cIDADE, String uF,
			String tELEFONE, String oBSERVACOES, String lOGINMENSAGEIRO, Integer cODMENSAGEIROAMAIS, Tcargos cARGO, Tturnos tURNO) {
		super();
		CODFUNC = cODFUNC;
		NOME = nOME;
		SITUACAO = sITUACAO;
		COMISSAO = cOMISSAO;
		SUPERVISOR = sUPERVISOR;
		ENDERECO = eNDERECO;
		NUMERO = nUMERO;
		COMPLEMENTO = cOMPLEMENTO;
		BAIRRO = bAIRRO;
		CEP = cEP;
		CIDADE = cIDADE;
		UF = uF;
		TELEFONE = tELEFONE;
		OBSERVACOES = oBSERVACOES;
		LOGINMENSAGEIRO = lOGINMENSAGEIRO;
		CODMENSAGEIROAMAIS = cODMENSAGEIROAMAIS;
		CODCARGO = cARGO;
		TURNO = tURNO;
	
	}

	public Tcargos getCARGO() {
		return CODCARGO;
	}

	public void setCARGO(Tcargos cARGO) {
		CODCARGO = cARGO;
	}

	public Integer getCODFUNC() {
		return CODFUNC;
	}

	public String getNOME() {
		return NOME;
	}

	public String getSITUACAO() {
		return SITUACAO;
	}

	public Double getCOMISSAO() {
		return COMISSAO;
	}

	public String getSUPERVISOR() {
		return SUPERVISOR;
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

	public String getLOGINMENSAGEIRO() {
		return LOGINMENSAGEIRO;
	}


	public void setCODFUNC(Integer cODFUNC) {
		CODFUNC = cODFUNC;
	}

	public void setNOME(String nOME) {
		NOME = nOME;
	}

	public void setSITUACAO(String sITUACAO) {
		SITUACAO = sITUACAO;
	}

	public void setCOMISSAO(Double cOMISSAO) {
		COMISSAO = cOMISSAO;
	}

	public void setSUPERVISOR(String sUPERVISOR) {
		SUPERVISOR = sUPERVISOR;
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

	public void setLOGINMENSAGEIRO(String lOGINMENSAGEIRO) {
		LOGINMENSAGEIRO = lOGINMENSAGEIRO;
	}

	

	public Tturnos getTURNO() {
		return TURNO;
	}

	public void setTURNO(Tturnos tURNO) {
		TURNO = tURNO;
	}
	
	

	public Integer getCODMENSAGEIROAMAIS() {
		return CODMENSAGEIROAMAIS;
	}

	public void setCODMENSAGEIROAMAIS(Integer cODMENSAGEIROAMAIS) {
		CODMENSAGEIROAMAIS = cODMENSAGEIROAMAIS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CODFUNC == null) ? 0 : CODFUNC.hashCode());
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
		Tfuncionarios other = (Tfuncionarios) obj;
		if (CODFUNC == null) {
			if (other.CODFUNC != null)
				return false;
		} else if (!CODFUNC.equals(other.CODFUNC))
			return false;
		return true;
	}
	
	
	
	
}
