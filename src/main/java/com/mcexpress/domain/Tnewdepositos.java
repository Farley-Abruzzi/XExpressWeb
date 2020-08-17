package com.mcexpress.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tnewdepositos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer NRODEPOSITO;
	//@JsonFormat(pattern = "dd/MM/yyyy")
	private Date DTFECHAMENTO;
	private Integer CODVALIDACAO;
	private Double VALORDEPOSITO;
	private String ENTIDADE;
	private Integer CODUSUARIO;
	private Integer CODMENSAGEIRO;
	private Double TOTALARRECADADO;
	private Integer QTDRECIBOS;
	private Double VALORDESPESA;
	private String DESCRICAODESPESA;
	
	
	@ManyToOne
	@JoinColumn(name="CODUSUARIO", insertable = false, updatable = false)
	private Tusuarios USUARIO;
	
	@ManyToOne
	@JoinColumn(name="CODMENSAGEIRO", insertable = false, updatable = false)
	private Tfuncionarios MENSAGEIRO;
	
	public Tnewdepositos() {
	}

	public Tnewdepositos(Integer nRODEPOSITO, Date dTFECHAMENTO, Integer cODVALIDACAO, Double vALORDEPOSITO,
			String eNTIDADE, Integer cODUSUARIO, Integer cODMENSAGEIRO, Double tOTALARRECADADO, Integer qTDRECIBOS, Double vALORDESPESA, String dESCRICAODESPESA) {
		super();
		NRODEPOSITO = nRODEPOSITO;
		DTFECHAMENTO = dTFECHAMENTO;
		CODVALIDACAO = cODVALIDACAO;
		VALORDEPOSITO = vALORDEPOSITO;
		ENTIDADE = eNTIDADE;
		CODUSUARIO = cODUSUARIO;
		CODMENSAGEIRO = cODMENSAGEIRO;
		TOTALARRECADADO = tOTALARRECADADO;
		QTDRECIBOS = qTDRECIBOS;
		VALORDESPESA = vALORDESPESA;
		DESCRICAODESPESA = dESCRICAODESPESA;
	}

	public Integer getNRODEPOSITO() {
		return NRODEPOSITO;
	}

	public Date getDTFECHAMENTO() {
		return DTFECHAMENTO;
	}

	public Integer getCODVALIDACAO() {
		return CODVALIDACAO;
	}

	public Double getVALORDEPOSITO() {
		return VALORDEPOSITO;
	}

	public String getENTIDADE() {
		return ENTIDADE;
	}
	
	public Integer getCODUSUARIO() {
		return CODUSUARIO;
	}
	
	public Integer getCODMENSAGEIRO() {
		return CODMENSAGEIRO;
	}
	
	public Double getTOTALARRECADADO() {
		return TOTALARRECADADO;
	}
	
	public Integer getQTDRECIBOS() {
		return QTDRECIBOS;
	}
	
	public Double getVALORDESPESA() {
		return VALORDESPESA;
	}
	
	public String getDESCRICAODESPESA() {
		return DESCRICAODESPESA;
	}

	public void setNRODEPOSITO(Integer nRODEPOSITO) {
		NRODEPOSITO = nRODEPOSITO;
	}

	public void setDTFECHAMENTO(Date dTFECHAMENTO) {
		DTFECHAMENTO = dTFECHAMENTO;
	}

	public void setCODVALIDACAO(Integer cODVALIDACAO) {
		CODVALIDACAO = cODVALIDACAO;
	}

	public void setVALORDEPOSITO(Double vALORDEPOSITO) {
		VALORDEPOSITO = vALORDEPOSITO;
	}

	public void setENTIDADE(String eNTIDADE) {
		ENTIDADE = eNTIDADE;
	}
	
	public void setCODUSUARIO(Integer cODUSUARIO) {
		CODUSUARIO = cODUSUARIO;
	}
	
	public void setCODMENSAGEIRO(Integer cODMENSAGEIRO) {
		CODMENSAGEIRO = cODMENSAGEIRO;
	}
	
	public void setTOTALARRECADADO(Double tOTALARRECADADO) {
		TOTALARRECADADO = tOTALARRECADADO;
	}
	
	public void setQTDRECIBOS(Integer qTDRECIBOS) {
		QTDRECIBOS = qTDRECIBOS;
	}
	
	public void setVALORDESPESA(Double vALORDESPESA) {
		VALORDESPESA = vALORDESPESA;
	}
	
	public void setDESCRICAODESPESA(String dESCRICAODESPESA) {
		DESCRICAODESPESA = dESCRICAODESPESA;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NRODEPOSITO == null) ? 0 : NRODEPOSITO.hashCode());
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
		Tnewdepositos other = (Tnewdepositos) obj;
		if (NRODEPOSITO == null) {
			if (other.NRODEPOSITO != null)
				return false;
		} else if (!NRODEPOSITO.equals(other.NRODEPOSITO))
			return false;
		return true;
	}
	
}
