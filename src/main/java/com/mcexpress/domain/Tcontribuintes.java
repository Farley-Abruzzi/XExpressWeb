package com.mcexpress.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tcontribuintes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer codcontrib;
	
	private String HORARIO;
	@JsonFormat(pattern = "dd/MM/yyyy")
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
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date DTULTDOACAO;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date DATAULTLIGACAO; 
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date DTREPIQUE;
	private String TIPOOPER;
	//@JsonFormat(pattern = "dd/MM/yyyy")
	private Date DTNASC;
	private String CONTRIBEMAIL;
	private String BCKPBAIRROCOBRANCA;
	private String LOTEAMENTOSECUNDARIO;
	private String LOTEAMENTOPRINCIPAL;
	private String HORACADASTRO;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date DTCADASTRO;
	private String TELEFONECAMPANHA;
	private Integer STATUSLIGACAO;
	private Integer CODCAMPANHA;
	private Integer CODIGOIBGE;
	private String CPFCONTRIB;
	private String NROCARTAO;
	private String CODSEGCARTAO;
	private String VALIDADECARTAO;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date RETAGENDADO;
	private Integer PERIODICIDADE;
	private String TIPOTELEFONECONTA;
	private String TELEFONECONTA;
	private String AGENCIADEBITO;
	private String CONTACORRENTEDEBITO;
	private Integer DOADORASSINOU;
	private String ALTEROUDADOS;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date DATA_ALTERACAO;
	private String ATUALIZOUWEB;
	private String CODIGOOPER;
	private String TIPOTELEFONEGRAVACAO;
	private String TELEFONEGRAVACAO;
	private Integer CODUSUARIOQLD;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date DATAQLD;
	private String HORAQLD;
	private Integer TABULACAO;
	private Integer CODATENDIMENTO;
	private String LOGINMENSAGEIRO;
	
	private Integer CODMENSAGEIRO;
	private Integer CODFUNC;
	private Integer CODSTATUS;
	private Integer CODCATEGORIA;
	private Integer CODUSUARIO;
	private Integer STSISTEMA;
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "tconbribuintes", cascade = CascadeType.ALL)
	private List<Trecibos> trecibos = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="CODFUNC", insertable = false, updatable = false) 
	private Tfuncionarios FUNCIONARIO;
	
	@ManyToOne
	@JoinColumn(name="CODSTATUS", insertable = false, updatable = false)
	private Tstatus STATUS;
	
	@ManyToOne
	@JoinColumn(name="CODCATEGORIA", insertable = false, updatable = false)
	private Tcategorias CATEGORIAS;
	
	@ManyToOne
	@JoinColumn(name="CODUSUARIO", insertable = false, updatable = false)
	private Tusuarios USUARIO;
	
	@ManyToOne
	@JoinColumn(name="STSISTEMA", insertable = false, updatable = false)
	private Tstatussistema STATUSSISTEMA;

	public Tcontribuintes() {
	}

	public Tcontribuintes(Integer codcontrib, String hORARIO, String dTPAGTO, Double vALORULTDOACAO, String lEMBRETE,
			String nOME, String nOMENORECIBO, String tELEFONEPRINCIPAL, String tELEFONESECUNDARIO,
			String eNDERECOPRINCIPAL, String nUMEROPRINCIPAL, String cOMPLEPRINCIPAL, String cEPPRINCIPAL,
			String eNDERECOSECUNDARIO, String nUMEROSECUNDARIO, String cOMPLESECUNDARIO, String cEPSECUNDARIO,
			String oBSERVACOES, String tIPOFJ, String sEXO, String bAIRROPRINCIPAL, String bAIRROSECUNDARIO,
			String cIDADESECUNDARIO, String uFSECUNDARIO, String uFPRINCIPAL, String cIDADEPRINCIPAL, Date dTULTDOACAO,
			Date dATAULTLIGACAO, Date dTREPIQUE, String tIPOOPER, Date dTNASC, String cONTRIBEMAIL,
			String bCKPBAIRROCOBRANCA, String lOTEAMENTOSECUNDARIO, String lOTEAMENTOPRINCIPAL, String hORACADASTRO,
			Date dTCADASTRO, String tELEFONECAMPANHA, Integer sTATUSLIGACAO, Integer cODCAMPANHA, Integer cODIGOIBGE,
			String cPFCONTRIB, String nROCARTAO, String cODSEGCARTAO, String vALIDADECARTAO, Date rETAGENDADO,
			Integer pERIODICIDADE, String tIPOTELEFONECONTA, String tELEFONECONTA, String aGENCIADEBITO,
			String cONTACORRENTEDEBITO, Integer dOADORASSINOU, String aLTEROUDADOS, Date dATA_ALTERACAO,
			String aTUALIZOUWEB, String cODIGOOPER, String tIPOTELEFONEGRAVACAO, String tELEFONEGRAVACAO,
			Integer cODUSUARIOQLD, Date dATAQLD, String hORAQLD, Integer tABULACAO, Integer cODATENDIMENTO,
			String lOGINMENSAGEIRO,  Tfuncionarios fUNCIONARIO, Tstatus sTATUS,
			Tcategorias cATEGORIAS, Tusuarios uSUARIO, Tstatussistema sTATUSSISTEMA, Integer cODMENSAGEIRO, Integer cODFUNC,
			Integer cODSTATUS, Integer cODCATEGORIA,Integer cODUSUARIO, Integer sTSISTEMA ) {
		super();
		this.codcontrib = codcontrib;
		HORARIO = hORARIO;
		DTPAGTO = dTPAGTO;
		VALORULTDOACAO = vALORULTDOACAO;
		LEMBRETE = lEMBRETE;
		NOME = nOME;
		NOMENORECIBO = nOMENORECIBO;
		TELEFONEPRINCIPAL = tELEFONEPRINCIPAL;
		TELEFONESECUNDARIO = tELEFONESECUNDARIO;
		ENDERECOPRINCIPAL = eNDERECOPRINCIPAL;
		NUMEROPRINCIPAL = nUMEROPRINCIPAL;
		COMPLEPRINCIPAL = cOMPLEPRINCIPAL;
		CEPPRINCIPAL = cEPPRINCIPAL;
		ENDERECOSECUNDARIO = eNDERECOSECUNDARIO;
		NUMEROSECUNDARIO = nUMEROSECUNDARIO;
		COMPLESECUNDARIO = cOMPLESECUNDARIO;
		CEPSECUNDARIO = cEPSECUNDARIO;
		OBSERVACOES = oBSERVACOES;
		TIPOFJ = tIPOFJ;
		SEXO = sEXO;
		BAIRROPRINCIPAL = bAIRROPRINCIPAL;
		BAIRROSECUNDARIO = bAIRROSECUNDARIO;
		CIDADESECUNDARIO = cIDADESECUNDARIO;
		UFSECUNDARIO = uFSECUNDARIO;
		UFPRINCIPAL = uFPRINCIPAL;
		CIDADEPRINCIPAL = cIDADEPRINCIPAL;
		DTULTDOACAO = dTULTDOACAO;
		DATAULTLIGACAO = dATAULTLIGACAO;
		DTREPIQUE = dTREPIQUE;
		TIPOOPER = tIPOOPER;
		DTNASC = dTNASC;
		CONTRIBEMAIL = cONTRIBEMAIL;
		BCKPBAIRROCOBRANCA = bCKPBAIRROCOBRANCA;
		LOTEAMENTOSECUNDARIO = lOTEAMENTOSECUNDARIO;
		LOTEAMENTOPRINCIPAL = lOTEAMENTOPRINCIPAL;
		HORACADASTRO = hORACADASTRO;
		DTCADASTRO = dTCADASTRO;
		TELEFONECAMPANHA = tELEFONECAMPANHA;
		STATUSLIGACAO = sTATUSLIGACAO;
		CODCAMPANHA = cODCAMPANHA;
		CODIGOIBGE = cODIGOIBGE;
		CPFCONTRIB = cPFCONTRIB;
		NROCARTAO = nROCARTAO;
		CODSEGCARTAO = cODSEGCARTAO;
		VALIDADECARTAO = vALIDADECARTAO;
		RETAGENDADO = rETAGENDADO;
		PERIODICIDADE = pERIODICIDADE;
		TIPOTELEFONECONTA = tIPOTELEFONECONTA;
		TELEFONECONTA = tELEFONECONTA;
		AGENCIADEBITO = aGENCIADEBITO;
		CONTACORRENTEDEBITO = cONTACORRENTEDEBITO;
		DOADORASSINOU = dOADORASSINOU;
		ALTEROUDADOS = aLTEROUDADOS;
		DATA_ALTERACAO = dATA_ALTERACAO;
		ATUALIZOUWEB = aTUALIZOUWEB;
		CODIGOOPER = cODIGOOPER;
		TIPOTELEFONEGRAVACAO = tIPOTELEFONEGRAVACAO;
		TELEFONEGRAVACAO = tELEFONEGRAVACAO;
		CODUSUARIOQLD = cODUSUARIOQLD;
		DATAQLD = dATAQLD;
		HORAQLD = hORAQLD;
		TABULACAO = tABULACAO;
		CODATENDIMENTO = cODATENDIMENTO;
		LOGINMENSAGEIRO = lOGINMENSAGEIRO;
		FUNCIONARIO = fUNCIONARIO;
		STATUS = sTATUS;
		CATEGORIAS = cATEGORIAS;
		USUARIO = uSUARIO;
		STATUSSISTEMA = sTATUSSISTEMA;
		CODMENSAGEIRO = cODMENSAGEIRO;
		CODFUNC = cODFUNC;
		CODSTATUS = cODSTATUS;
		CODCATEGORIA = cODCATEGORIA;
		CODUSUARIO = cODUSUARIO;
		STSISTEMA = sTSISTEMA;
	}

	public Tcategorias getCATEGORIAS() {
		return CATEGORIAS;
	}

	public void setCATEGORIAS(Tcategorias cATEGORIAS) {
		CATEGORIAS = cATEGORIAS;
	}

	public Tstatus getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(Tstatus sTATUS) {
		STATUS = sTATUS;
	}

	public List<Trecibos> getTrecibos() {
		return trecibos;
	}

	public void setTrecibos(List<Trecibos> trecibos) {
		this.trecibos = trecibos;
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

	public void setCodcontrib(Integer codcontrib) {
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
	
	public Tfuncionarios getFUNCIONARIO() {
		return FUNCIONARIO;
	}

	public void setFUNCIONARIO(Tfuncionarios fUNCIONARIO) {
		FUNCIONARIO = fUNCIONARIO;
	}
	
	public Tusuarios getUSUARIO() {
		return USUARIO;
	}

	public void setUSUARIO(Tusuarios uSUARIO) {
		USUARIO = uSUARIO;
	}
	
	public Tstatussistema getSTATUSSISTEMA() {
		return STATUSSISTEMA;
	}

	public void setSTATUSSISTEMA(Tstatussistema sTATUSSISTEMA) {
		STATUSSISTEMA = sTATUSSISTEMA;
	}
	
	public Integer getCODMENSAGEIRO() {
		return CODMENSAGEIRO;
	}

	public Integer getCODFUNC() {
		return CODFUNC;
	}

	public Integer getCODSTATUS() {
		return CODSTATUS;
	}

	public Integer getCODCATEGORIA() {
		return CODCATEGORIA;
	}

	public Integer getCODUSUARIO() {
		return CODUSUARIO;
	}

	public Integer getSTSISTEMA() {
		return STSISTEMA;
	}

	public void setCODMENSAGEIRO(Integer cODMENSAGEIRO) {
		CODMENSAGEIRO = cODMENSAGEIRO;
	}

	public void setCODFUNC(Integer cODFUNC) {
		CODFUNC = cODFUNC;
	}

	public void setCODSTATUS(Integer cODSTATUS) {
		CODSTATUS = cODSTATUS;
	}

	public void setCODCATEGORIA(Integer cODCATEGORIA) {
		CODCATEGORIA = cODCATEGORIA;
	}

	public void setCODUSUARIO(Integer cODUSUARIO) {
		CODUSUARIO = cODUSUARIO;
	}

	public void setSTSISTEMA(Integer sTSISTEMA) {
		STSISTEMA = sTSISTEMA;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codcontrib == null) ? 0 : codcontrib.hashCode());
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
		Tcontribuintes other = (Tcontribuintes) obj;
		if (codcontrib == null) {
			if (other.codcontrib != null)
				return false;
		} else if (!codcontrib.equals(other.codcontrib))
			return false;
		return true;
	}
	
}
