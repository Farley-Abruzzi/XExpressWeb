package com.mcexpress.dto;

import java.io.Serializable;
import java.util.Date;

import com.mcexpress.domain.Tcontribuintes;

public class TcontribuintesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codcontrib;

	private String HORARIO;
	private String DTPAGTO;
	private Double VALORULTDOACAO;
	private String LEMBRETE;
	private String NOME;
	private String NOMENORECIBO;
	private String TELEFONEPRINCIPAL;
	private String TELEFONESECUNDARIO;
	private String ENDERECOPRINCIPAL;
	private String NUMEROPRINCIPAL;
	private String COMPLEPRINCIPAL;
	private String CEPPRINCIPAL;
	private String ENDERECOSECUNDARIO;
	private String NUMEROSECUNDARIO;
	private String COMPLESECUNDARIO;
	private String CEPSECUNDARIO;
	private String OBSERVACOES;
	private String TIPOFJ;
	private String SEXO;
	private String BAIRROPRINCIPAL;
	private String BAIRROSECUNDARIO;
	private String CIDADESECUNDARIO;
	private String UFSECUNDARIO;
	private String UFPRINCIPAL;
	private String CIDADEPRINCIPAL;
	private Date DTULTDOACAO;
	private Date DATAULTLIGACAO;
	private Date DTREPIQUE;
	private String TIPOOPER;
	private Date DTNASC;
	private String CONTRIBEMAIL;
	private String BCKPBAIRROCOBRANCA;
	private String LOTEAMENTOSECUNDARIO;
	private String LOTEAMENTOPRINCIPAL;
	private String HORACADASTRO;
	private Date DTCADASTRO;
	private String TELEFONECAMPANHA;
	private Integer STATUSLIGACAO;
	private Integer CODCAMPANHA;
	private Integer CODIGOIBGE;
	private String CPFCONTRIB;
	private String NROCARTAO;
	private String CODSEGCARTAO;
	private String VALIDADECARTAO;
	private Date RETAGENDADO;
	private Integer PERIODICIDADE;
	private String TIPOTELEFONECONTA;
	private String TELEFONECONTA;
	private String AGENCIADEBITO;
	private String CONTACORRENTEDEBITO;
	private Integer DOADORASSINOU;
	private String ALTEROUDADOS;
	private Date DATA_ALTERACAO;
	private String ATUALIZOUWEB;
	private String CODIGOOPER;
	private String TIPOTELEFONEGRAVACAO;
	private String TELEFONEGRAVACAO;
	private Integer CODUSUARIOQLD;
	private Date DATAQLD;
	private String HORAQLD;
	private Integer TABULACAO;
	private Integer CODATENDIMENTO;
	private String LOGINMENSAGEIRO;
	private String STATUS;

	public TcontribuintesDTO() {
	}

	public TcontribuintesDTO(Tcontribuintes tcontribuintes) {

		codcontrib = tcontribuintes.getCodcontrib();
		HORARIO = tcontribuintes.getHORARIO();
		DTPAGTO = tcontribuintes.getDTPAGTO();
		VALORULTDOACAO = tcontribuintes.getVALORULTDOACAO();
		LEMBRETE = tcontribuintes.getLEMBRETE();
		NOME = tcontribuintes.getNOME();
		NOMENORECIBO = tcontribuintes.getNOMENORECIBO();
		TELEFONEPRINCIPAL = tcontribuintes.getTELEFONEPRINCIPAL();
		TELEFONESECUNDARIO = tcontribuintes.getTELEFONESECUNDARIO();
		ENDERECOPRINCIPAL = tcontribuintes.getENDERECOPRINCIPAL();
		NUMEROPRINCIPAL = tcontribuintes.getNUMEROPRINCIPAL();
		COMPLEPRINCIPAL = tcontribuintes.getCOMPLEPRINCIPAL();
		CEPPRINCIPAL = tcontribuintes.getCEPPRINCIPAL();
		ENDERECOSECUNDARIO = tcontribuintes.getENDERECOSECUNDARIO();
		NUMEROSECUNDARIO = tcontribuintes.getNUMEROSECUNDARIO();
		COMPLESECUNDARIO = tcontribuintes.getCOMPLESECUNDARIO();
		CEPSECUNDARIO = tcontribuintes.getCEPSECUNDARIO();
		OBSERVACOES = tcontribuintes.getOBSERVACOES();
		TIPOFJ = tcontribuintes.getTIPOFJ();
		SEXO = tcontribuintes.getSEXO();
		BAIRROPRINCIPAL = tcontribuintes.getBAIRROPRINCIPAL();
		BAIRROSECUNDARIO = tcontribuintes.getBAIRROSECUNDARIO();
		CIDADESECUNDARIO = tcontribuintes.getCIDADESECUNDARIO();
		UFSECUNDARIO = tcontribuintes.getUFSECUNDARIO();
		UFPRINCIPAL = tcontribuintes.getUFPRINCIPAL();
		CIDADEPRINCIPAL = tcontribuintes.getCIDADEPRINCIPAL();
		DTULTDOACAO = tcontribuintes.getDTULTDOACAO();
		DATAULTLIGACAO = tcontribuintes.getDATAULTLIGACAO();
		DTREPIQUE = tcontribuintes.getDTREPIQUE();
		TIPOOPER = tcontribuintes.getTIPOOPER();
		DTNASC = tcontribuintes.getDTNASC();
		CONTRIBEMAIL = tcontribuintes.getCONTRIBEMAIL();
		BCKPBAIRROCOBRANCA = tcontribuintes.getBCKPBAIRROCOBRANCA();
		LOTEAMENTOSECUNDARIO = tcontribuintes.getLOTEAMENTOSECUNDARIO();
		LOTEAMENTOPRINCIPAL = tcontribuintes.getLOTEAMENTOPRINCIPAL();
		HORACADASTRO = tcontribuintes.getHORACADASTRO();
		DTCADASTRO = tcontribuintes.getDTCADASTRO();
		TELEFONECAMPANHA = tcontribuintes.getTELEFONECAMPANHA();
		STATUSLIGACAO = tcontribuintes.getSTATUSLIGACAO();
		CODCAMPANHA = tcontribuintes.getCODCAMPANHA();
		CODIGOIBGE = tcontribuintes.getCODIGOIBGE();
		CPFCONTRIB = tcontribuintes.getCPFCONTRIB();
		NROCARTAO = tcontribuintes.getNROCARTAO();
		CODSEGCARTAO = tcontribuintes.getCODSEGCARTAO();
		VALIDADECARTAO = tcontribuintes.getVALIDADECARTAO();
		RETAGENDADO = tcontribuintes.getRETAGENDADO();
		PERIODICIDADE = tcontribuintes.getPERIODICIDADE();
		TIPOTELEFONECONTA = tcontribuintes.getTIPOTELEFONECONTA();
		TELEFONECONTA = tcontribuintes.getTELEFONECONTA();
		AGENCIADEBITO = tcontribuintes.getAGENCIADEBITO();
		CONTACORRENTEDEBITO = tcontribuintes.getCONTACORRENTEDEBITO();
		DOADORASSINOU = tcontribuintes.getDOADORASSINOU();
		ALTEROUDADOS = tcontribuintes.getALTEROUDADOS();
		DATA_ALTERACAO = tcontribuintes.getDATA_ALTERACAO();
		ATUALIZOUWEB = tcontribuintes.getATUALIZOUWEB();
		CODIGOOPER = tcontribuintes.getCODIGOOPER();
		TIPOTELEFONEGRAVACAO = tcontribuintes.getTIPOTELEFONEGRAVACAO();
		TELEFONEGRAVACAO = tcontribuintes.getTELEFONEGRAVACAO();
		CODUSUARIOQLD = tcontribuintes.getCODUSUARIOQLD();
		DATAQLD = tcontribuintes.getDATAQLD();
		HORAQLD = tcontribuintes.getHORAQLD();
		TABULACAO = tcontribuintes.getTABULACAO();
		CODATENDIMENTO = tcontribuintes.getCODATENDIMENTO();
		LOGINMENSAGEIRO = tcontribuintes.getLOGINMENSAGEIRO();
		
	}
	
	public Integer getCodcontrib() {
		return codcontrib;
	}

	public String getHORARIO() {
		return HORARIO;
	}

	public String getDTPAGTO() {
		return DTPAGTO;
	}

	public Double getVALORULTDOACAO() {
		return VALORULTDOACAO;
	}

	public String getLEMBRETE() {
		return LEMBRETE;
	}

	public String getNOME() {
		return NOME;
	}

	public String getNOMENORECIBO() {
		return NOMENORECIBO;
	}

	public String getTELEFONEPRINCIPAL() {
		return TELEFONEPRINCIPAL;
	}

	public String getTELEFONESECUNDARIO() {
		return TELEFONESECUNDARIO;
	}

	public String getENDERECOPRINCIPAL() {
		return ENDERECOPRINCIPAL;
	}

	public String getNUMEROPRINCIPAL() {
		return NUMEROPRINCIPAL;
	}

	public String getCOMPLEPRINCIPAL() {
		return COMPLEPRINCIPAL;
	}

	public String getCEPPRINCIPAL() {
		return CEPPRINCIPAL;
	}

	public String getENDERECOSECUNDARIO() {
		return ENDERECOSECUNDARIO;
	}

	public String getNUMEROSECUNDARIO() {
		return NUMEROSECUNDARIO;
	}

	public String getCOMPLESECUNDARIO() {
		return COMPLESECUNDARIO;
	}

	public String getCEPSECUNDARIO() {
		return CEPSECUNDARIO;
	}

	public String getOBSERVACOES() {
		return OBSERVACOES;
	}

	public String getTIPOFJ() {
		return TIPOFJ;
	}

	public String getSEXO() {
		return SEXO;
	}

	public String getBAIRROPRINCIPAL() {
		return BAIRROPRINCIPAL;
	}

	public String getBAIRROSECUNDARIO() {
		return BAIRROSECUNDARIO;
	}

	public String getCIDADESECUNDARIO() {
		return CIDADESECUNDARIO;
	}

	public String getUFSECUNDARIO() {
		return UFSECUNDARIO;
	}

	public String getUFPRINCIPAL() {
		return UFPRINCIPAL;
	}

	public String getCIDADEPRINCIPAL() {
		return CIDADEPRINCIPAL;
	}

	public Date getDTULTDOACAO() {
		return DTULTDOACAO;
	}

	public Date getDATAULTLIGACAO() {
		return DATAULTLIGACAO;
	}

	public Date getDTREPIQUE() {
		return DTREPIQUE;
	}

	public String getTIPOOPER() {
		return TIPOOPER;
	}

	public Date getDTNASC() {
		return DTNASC;
	}

	public String getCONTRIBEMAIL() {
		return CONTRIBEMAIL;
	}

	public String getBCKPBAIRROCOBRANCA() {
		return BCKPBAIRROCOBRANCA;
	}

	public String getLOTEAMENTOSECUNDARIO() {
		return LOTEAMENTOSECUNDARIO;
	}

	public String getLOTEAMENTOPRINCIPAL() {
		return LOTEAMENTOPRINCIPAL;
	}

	public String getHORACADASTRO() {
		return HORACADASTRO;
	}

	public Date getDTCADASTRO() {
		return DTCADASTRO;
	}

	public String getTELEFONECAMPANHA() {
		return TELEFONECAMPANHA;
	}

	public Integer getSTATUSLIGACAO() {
		return STATUSLIGACAO;
	}

	public Integer getCODCAMPANHA() {
		return CODCAMPANHA;
	}

	public Integer getCODIGOIBGE() {
		return CODIGOIBGE;
	}

	public String getCPFCONTRIB() {
		return CPFCONTRIB;
	}

	public String getNROCARTAO() {
		return NROCARTAO;
	}

	public String getCODSEGCARTAO() {
		return CODSEGCARTAO;
	}

	public String getVALIDADECARTAO() {
		return VALIDADECARTAO;
	}

	public Date getRETAGENDADO() {
		return RETAGENDADO;
	}

	public Integer getPERIODICIDADE() {
		return PERIODICIDADE;
	}

	public String getTIPOTELEFONECONTA() {
		return TIPOTELEFONECONTA;
	}

	public String getTELEFONECONTA() {
		return TELEFONECONTA;
	}

	public String getAGENCIADEBITO() {
		return AGENCIADEBITO;
	}

	public String getCONTACORRENTEDEBITO() {
		return CONTACORRENTEDEBITO;
	}

	public Integer getDOADORASSINOU() {
		return DOADORASSINOU;
	}

	public String getALTEROUDADOS() {
		return ALTEROUDADOS;
	}

	public Date getDATA_ALTERACAO() {
		return DATA_ALTERACAO;
	}

	public String getATUALIZOUWEB() {
		return ATUALIZOUWEB;
	}

	public String getCODIGOOPER() {
		return CODIGOOPER;
	}

	public String getTIPOTELEFONEGRAVACAO() {
		return TIPOTELEFONEGRAVACAO;
	}

	public String getTELEFONEGRAVACAO() {
		return TELEFONEGRAVACAO;
	}

	public Integer getCODUSUARIOQLD() {
		return CODUSUARIOQLD;
	}

	public Date getDATAQLD() {
		return DATAQLD;
	}

	public String getHORAQLD() {
		return HORAQLD;
	}

	public Integer getTABULACAO() {
		return TABULACAO;
	}

	public Integer getCODATENDIMENTO() {
		return CODATENDIMENTO;
	}

	public String getLOGINMENSAGEIRO() {
		return LOGINMENSAGEIRO;
	}

	public void setCODCONTRIB(Integer codcontrib) {
		this.codcontrib = codcontrib;
	}

	public void setHORARIO(String hORARIO) {
		HORARIO = hORARIO;
	}

	public void setDTPAGTO(String dTPAGTO) {
		DTPAGTO = dTPAGTO;
	}

	public void setVALORULTDOACAO(Double vALORULTDOACAO) {
		VALORULTDOACAO = vALORULTDOACAO;
	}

	public void setLEMBRETE(String lEMBRETE) {
		LEMBRETE = lEMBRETE;
	}

	public void setNOME(String nOME) {
		NOME = nOME;
	}

	public void setNOMENORECIBO(String nOMENORECIBO) {
		NOMENORECIBO = nOMENORECIBO;
	}

	public void setTELEFONEPRINCIPAL(String tELEFONEPRINCIPAL) {
		TELEFONEPRINCIPAL = tELEFONEPRINCIPAL;
	}

	public void setTELEFONESECUNDARIO(String tELEFONESECUNDARIO) {
		TELEFONESECUNDARIO = tELEFONESECUNDARIO;
	}

	public void setENDERECOPRINCIPAL(String eNDERECOPRINCIPAL) {
		ENDERECOPRINCIPAL = eNDERECOPRINCIPAL;
	}

	public void setNUMEROPRINCIPAL(String nUMEROPRINCIPAL) {
		NUMEROPRINCIPAL = nUMEROPRINCIPAL;
	}

	public void setCOMPLEPRINCIPAL(String cOMPLEPRINCIPAL) {
		COMPLEPRINCIPAL = cOMPLEPRINCIPAL;
	}

	public void setCEPPRINCIPAL(String cEPPRINCIPAL) {
		CEPPRINCIPAL = cEPPRINCIPAL;
	}

	public void setENDERECOSECUNDARIO(String eNDERECOSECUNDARIO) {
		ENDERECOSECUNDARIO = eNDERECOSECUNDARIO;
	}

	public void setNUMEROSECUNDARIO(String nUMEROSECUNDARIO) {
		NUMEROSECUNDARIO = nUMEROSECUNDARIO;
	}

	public void setCOMPLESECUNDARIO(String cOMPLESECUNDARIO) {
		COMPLESECUNDARIO = cOMPLESECUNDARIO;
	}

	public void setCEPSECUNDARIO(String cEPSECUNDARIO) {
		CEPSECUNDARIO = cEPSECUNDARIO;
	}

	public void setOBSERVACOES(String oBSERVACOES) {
		OBSERVACOES = oBSERVACOES;
	}

	public void setTIPOFJ(String tIPOFJ) {
		TIPOFJ = tIPOFJ;
	}

	public void setSEXO(String sEXO) {
		SEXO = sEXO;
	}

	public void setBAIRROPRINCIPAL(String bAIRROPRINCIPAL) {
		BAIRROPRINCIPAL = bAIRROPRINCIPAL;
	}

	public void setBAIRROSECUNDARIO(String bAIRROSECUNDARIO) {
		BAIRROSECUNDARIO = bAIRROSECUNDARIO;
	}

	public void setCIDADESECUNDARIO(String cIDADESECUNDARIO) {
		CIDADESECUNDARIO = cIDADESECUNDARIO;
	}

	public void setUFSECUNDARIO(String uFSECUNDARIO) {
		UFSECUNDARIO = uFSECUNDARIO;
	}

	public void setUFPRINCIPAL(String uFPRINCIPAL) {
		UFPRINCIPAL = uFPRINCIPAL;
	}

	public void setCIDADEPRINCIPAL(String cIDADEPRINCIPAL) {
		CIDADEPRINCIPAL = cIDADEPRINCIPAL;
	}

	public void setDTULTDOACAO(Date dTULTDOACAO) {
		DTULTDOACAO = dTULTDOACAO;
	}

	public void setDATAULTLIGACAO(Date dATAULTLIGACAO) {
		DATAULTLIGACAO = dATAULTLIGACAO;
	}

	public void setDTREPIQUE(Date dTREPIQUE) {
		DTREPIQUE = dTREPIQUE;
	}

	public void setTIPOOPER(String tIPOOPER) {
		TIPOOPER = tIPOOPER;
	}

	public void setDTNASC(Date dTNASC) {
		DTNASC = dTNASC;
	}

	public void setCONTRIBEMAIL(String cONTRIBEMAIL) {
		CONTRIBEMAIL = cONTRIBEMAIL;
	}

	public void setBCKPBAIRROCOBRANCA(String bCKPBAIRROCOBRANCA) {
		BCKPBAIRROCOBRANCA = bCKPBAIRROCOBRANCA;
	}

	public void setLOTEAMENTOSECUNDARIO(String lOTEAMENTOSECUNDARIO) {
		LOTEAMENTOSECUNDARIO = lOTEAMENTOSECUNDARIO;
	}

	public void setLOTEAMENTOPRINCIPAL(String lOTEAMENTOPRINCIPAL) {
		LOTEAMENTOPRINCIPAL = lOTEAMENTOPRINCIPAL;
	}

	public void setHORACADASTRO(String hORACADASTRO) {
		HORACADASTRO = hORACADASTRO;
	}

	public void setDTCADASTRO(Date dTCADASTRO) {
		DTCADASTRO = dTCADASTRO;
	}

	public void setTELEFONECAMPANHA(String tELEFONECAMPANHA) {
		TELEFONECAMPANHA = tELEFONECAMPANHA;
	}

	public void setSTATUSLIGACAO(Integer sTATUSLIGACAO) {
		STATUSLIGACAO = sTATUSLIGACAO;
	}

	public void setCODCAMPANHA(Integer cODCAMPANHA) {
		CODCAMPANHA = cODCAMPANHA;
	}

	public void setCODIGOIBGE(Integer cODIGOIBGE) {
		CODIGOIBGE = cODIGOIBGE;
	}

	public void setCPFCONTRIB(String cPFCONTRIB) {
		CPFCONTRIB = cPFCONTRIB;
	}

	public void setNROCARTAO(String nROCARTAO) {
		NROCARTAO = nROCARTAO;
	}

	public void setCODSEGCARTAO(String cODSEGCARTAO) {
		CODSEGCARTAO = cODSEGCARTAO;
	}

	public void setVALIDADECARTAO(String vALIDADECARTAO) {
		VALIDADECARTAO = vALIDADECARTAO;
	}

	public void setRETAGENDADO(Date rETAGENDADO) {
		RETAGENDADO = rETAGENDADO;
	}

	public void setPERIODICIDADE(Integer pERIODICIDADE) {
		PERIODICIDADE = pERIODICIDADE;
	}

	public void setTIPOTELEFONECONTA(String tIPOTELEFONECONTA) {
		TIPOTELEFONECONTA = tIPOTELEFONECONTA;
	}

	public void setTELEFONECONTA(String tELEFONECONTA) {
		TELEFONECONTA = tELEFONECONTA;
	}

	public void setAGENCIADEBITO(String aGENCIADEBITO) {
		AGENCIADEBITO = aGENCIADEBITO;
	}

	public void setCONTACORRENTEDEBITO(String cONTACORRENTEDEBITO) {
		CONTACORRENTEDEBITO = cONTACORRENTEDEBITO;
	}

	public void setDOADORASSINOU(Integer dOADORASSINOU) {
		DOADORASSINOU = dOADORASSINOU;
	}

	public void setALTEROUDADOS(String aLTEROUDADOS) {
		ALTEROUDADOS = aLTEROUDADOS;
	}

	public void setDATA_ALTERACAO(Date dATA_ALTERACAO) {
		DATA_ALTERACAO = dATA_ALTERACAO;
	}

	public void setATUALIZOUWEB(String aTUALIZOUWEB) {
		ATUALIZOUWEB = aTUALIZOUWEB;
	}

	public void setCODIGOOPER(String cODIGOOPER) {
		CODIGOOPER = cODIGOOPER;
	}

	public void setTIPOTELEFONEGRAVACAO(String tIPOTELEFONEGRAVACAO) {
		TIPOTELEFONEGRAVACAO = tIPOTELEFONEGRAVACAO;
	}

	public void setTELEFONEGRAVACAO(String tELEFONEGRAVACAO) {
		TELEFONEGRAVACAO = tELEFONEGRAVACAO;
	}

	public void setCODUSUARIOQLD(Integer cODUSUARIOQLD) {
		CODUSUARIOQLD = cODUSUARIOQLD;
	}

	public void setDATAQLD(Date dATAQLD) {
		DATAQLD = dATAQLD;
	}

	public void setHORAQLD(String hORAQLD) {
		HORAQLD = hORAQLD;
	}

	public void setTABULACAO(Integer tABULACAO) {
		TABULACAO = tABULACAO;
	}

	public void setCODATENDIMENTO(Integer cODATENDIMENTO) {
		CODATENDIMENTO = cODATENDIMENTO;
	}

	public void setLOGINMENSAGEIRO(String lOGINMENSAGEIRO) {
		LOGINMENSAGEIRO = lOGINMENSAGEIRO;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	
}
