package com.mcexpress.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Trecibos implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nrorecibo;
	private String impresso;
	//@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtoperacao;
	private String statusrec;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date entrega;
	private Integer formulario;
	//@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtcobranca;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtrecebimento;
	private Date dtbaixa;
	private String parcela;
	private Integer via;	
	private Double valordinheiro;
	private Double valorcheque;
	private Double valorgerado;
	private Integer doacaoespecial;
	private String parceladoacaoespecial;
	private Integer aumentodefinitivo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtoperacaobaixa;
	private Integer periodicidade;
	private Double valoralterado;
	private Double valornaoalterado;
	private String entregaweb;
	private Timestamp dtvaloralteradobaixa;
	private Double valorbakp;
	private String valorhorabkp;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date valordatabkp;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataqld;
	private Integer naorecebido;
	private Integer nrosorte;
	private String motivodevol;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtremarc;
	private Double valorremarcado;
	private Integer codoperador;
	private Integer codmensageiro;
	private Integer codcategoria;
	private String reagendado;
	private Date dtreagendamento;
	
	private Integer codcontrib;
	private Integer codusuario;
	
	
	@ManyToOne
	@JoinColumn(name="codcontrib", insertable = false, updatable = false)
	private Tcontribuintes tconbribuintes; 
	
	@ManyToOne
	@JoinColumn(name="codusuario", insertable = false, updatable = false)
	private Tusuarios tusuarios;
	
	public Trecibos(Integer nRORECIBO, String iMPRESSO, Date dTOPERACAO, String sTATUSREC, Date eNTREGA,
			Integer fORMULARIO, Date dTCOBRANCA, Date dTRECEBIMENTO, Date dTBAIXA, String pARCELA, Integer vIA,
			Double vALORDINHEIRO, Double vALORCHEQUE, Double vALORGERADO, Integer dOACAOESPECIAL,
			String pARCELADOACAOESPECIAL, Integer aUMENTODEFINITIVO, Date dTOPERACAOBAIXA, Integer pERIODICIDADE,
			Double vALORALTERADO, Double vALORNAOALTERADO, String eNTREGAWEB, Timestamp dTVALORALTERADOBAIXA,
			Double vALORBAKP, String vALORHORABKP, Date vALORDATABKP, Date dATAQLD, Integer nAORECEBIDO,
			Integer nROSORTE, String mOTIVODEVOL, Date dTREMARC,Double vALORREMARCADO, Integer cODOPERADOR, Integer cODMENSAGEIRO,
			Integer cODCATEGORIA, String rEAGENDADO, Date dTREAGENDAMENTO, Integer cODCONTRIB, Tcontribuintes tconbribuintes, Tusuarios tusuarios) {
		super();
		
		nrorecibo=nRORECIBO;
		impresso=iMPRESSO;
		dtoperacao=dTOPERACAO;
		statusrec=sTATUSREC;
		entrega=eNTREGA;
		formulario=fORMULARIO;
		dtcobranca=dTCOBRANCA;
		dtrecebimento=dTRECEBIMENTO;
		dtbaixa=dTBAIXA;
		parcela=pARCELA;
		via=vIA;
		valordinheiro=vALORDINHEIRO;
		valorcheque=vALORCHEQUE;
		valorgerado=vALORGERADO;
		doacaoespecial=dOACAOESPECIAL;
		parceladoacaoespecial=pARCELADOACAOESPECIAL;
		aumentodefinitivo=aUMENTODEFINITIVO;
		dtoperacaobaixa=dTOPERACAOBAIXA;
		periodicidade=pERIODICIDADE;
		valoralterado=vALORALTERADO;
		valornaoalterado=vALORNAOALTERADO;
		entregaweb=eNTREGAWEB;
		dtvaloralteradobaixa=dTVALORALTERADOBAIXA;
		valorbakp=vALORBAKP;
		valorhorabkp=vALORHORABKP;
		valordatabkp=vALORDATABKP;
		dataqld=dATAQLD;
		naorecebido=nAORECEBIDO;
		nrosorte=nROSORTE;
		motivodevol=mOTIVODEVOL;
		dtremarc=dTREMARC;
		valorremarcado=vALORREMARCADO;
		codoperador=cODOPERADOR;
		codmensageiro=cODMENSAGEIRO;
		codcategoria=cODCATEGORIA;
		reagendado = rEAGENDADO;
		dtreagendamento = dTREAGENDAMENTO;
		codcontrib = cODCONTRIB;
		
		this.tconbribuintes=tconbribuintes;
		this.tusuarios=tusuarios;
	}
	
	public Trecibos() {
	}

	public Integer getNrorecibo() {
		return nrorecibo;
	}


	public String getImpresso() {
		return impresso;
	}


	public Date getDtoperacao() {
		return dtoperacao;
	}


	public String getStatusrec() {
		return statusrec;
	}


	public Date getEntrega() {
		return entrega;
	}


	public Integer getFormulario() {
		return formulario;
	}


	public Date getDtcobranca() {
		return dtcobranca;
	}


	public Date getDtrecebimento() {
		return dtrecebimento;
	}


	public Date getDtbaixa() {
		return dtbaixa;
	}


	public String getParcela() {
		return parcela;
	}


	public Integer getVia() {
		return via;
	}


	public Double getValordinheiro() {
		return valordinheiro;
	}


	public Double getValorcheque() {
		return valorcheque;
	}


	public Double getValorgerado() {
		return valorgerado;
	}


	public Integer getDoacaoespecial() {
		return doacaoespecial;
	}


	public String getParceladoacaoespecial() {
		return parceladoacaoespecial;
	}


	public Integer getAumentodefinitivo() {
		return aumentodefinitivo;
	}


	public Date getDtoperacaobaixa() {
		return dtoperacaobaixa;
	}


	public Integer getPeriodicidade() {
		return periodicidade;
	}


	public Double getValoralterado() {
		return valoralterado;
	}


	public Double getValornaoalterado() {
		return valornaoalterado;
	}


	public String getEntregaweb() {
		return entregaweb;
	}


	public Timestamp getDtvaloralteradobaixa() {
		return dtvaloralteradobaixa;
	}


	public Double getValorbakp() {
		return valorbakp;
	}


	public String getValorhorabkp() {
		return valorhorabkp;
	}


	public Date getValordatabkp() {
		return valordatabkp;
	}


	public Date getDataqld() {
		return dataqld;
	}


	public Integer getNaorecebido() {
		return naorecebido;
	}


	public Integer getNrosorte() {
		return nrosorte;
	}


	public String getMotivodevol() {
		return motivodevol;
	}


	public Date getDtremarc() {
		return dtremarc;
	}


	public Double getValorremarcado() {
		return valorremarcado;
	}


	public Integer getCodoperador() {
		return codoperador;
	}


	public Integer getCodmensageiro() {
		return codmensageiro;
	}


	public Integer getCodcategoria() {
		return codcategoria;
	}
	
	public Integer getCodusuario() {
		return codusuario;
	}


	public void setNrorecibo(Integer nrorecibo) {
		this.nrorecibo = nrorecibo;
	}


	public void setImpresso(String impresso) {
		this.impresso = impresso;
	}


	public void setDtoperacao(Date dtoperacao) {
		this.dtoperacao = dtoperacao;
	}


	public void setStatusrec(String statusrec) {
		this.statusrec = statusrec;
	}


	public void setEntrega(Date entrega) {
		this.entrega = entrega;
	}


	public void setFormulario(Integer formulario) {
		this.formulario = formulario;
	}


	public void setDtcobranca(Date dtcobranca) {
		this.dtcobranca = dtcobranca;
	}


	public void setDtrecebimento(Date dtrecebimento) {
		this.dtrecebimento = dtrecebimento;
	}


	public void setDtbaixa(Date dtbaixa) {
		this.dtbaixa = dtbaixa;
	}


	public void setParcela(String parcela) {
		this.parcela = parcela;
	}


	public void setVia(Integer via) {
		this.via = via;
	}


	public void setValordinheiro(Double valordinheiro) {
		this.valordinheiro = valordinheiro;
	}


	public void setValorcheque(Double valorcheque) {
		this.valorcheque = valorcheque;
	}


	public void setValorgerado(Double valorgerado) {
		this.valorgerado = valorgerado;
	}


	public void setDoacaoespecial(Integer doacaoespecial) {
		this.doacaoespecial = doacaoespecial;
	}


	public void setParceladoacaoespecial(String parceladoacaoespecial) {
		this.parceladoacaoespecial = parceladoacaoespecial;
	}


	public void setAumentodefinitivo(Integer aumentodefinitivo) {
		this.aumentodefinitivo = aumentodefinitivo;
	}


	public void setDtoperacaobaixa(Date dtoperacaobaixa) {
		this.dtoperacaobaixa = dtoperacaobaixa;
	}


	public void setPeriodicidade(Integer periodicidade) {
		this.periodicidade = periodicidade;
	}


	public void setValoralterado(Double valoralterado) {
		this.valoralterado = valoralterado;
	}


	public void setValornaoalterado(Double valornaoalterado) {
		this.valornaoalterado = valornaoalterado;
	}


	public void setEntregaweb(String entregaweb) {
		this.entregaweb = entregaweb;
	}


	public void setDtvaloralteradobaixa(Timestamp dtvaloralteradobaixa) {
		this.dtvaloralteradobaixa = dtvaloralteradobaixa;
	}


	public void setValorbakp(Double valorbakp) {
		this.valorbakp = valorbakp;
	}


	public void setValorhorabkp(String valorhorabkp) {
		this.valorhorabkp = valorhorabkp;
	}


	public void setValordatabkp(Date valordatabkp) {
		this.valordatabkp = valordatabkp;
	}


	public void setDataqld(Date dataqld) {
		this.dataqld = dataqld;
	}


	public void setNaorecebido(Integer naorecebido) {
		this.naorecebido = naorecebido;
	}


	public void setNrosorte(Integer nrosorte) {
		this.nrosorte = nrosorte;
	}


	public void setMotivodevol(String motivodevol) {
		this.motivodevol = motivodevol;
	}


	public void setDtremarc(Date dtremarc) {
		this.dtremarc = dtremarc;
	}


	public void setValorremarcado(Double valorremarcado) {
		this.valorremarcado = valorremarcado;
	}


	public void setCodoperador(Integer codoperador) {
		this.codoperador = codoperador;
	}


	public void setCodmensageiro(Integer codmensageiro) {
		this.codmensageiro = codmensageiro;
	}


	public void setCodcategoria(Integer codcategoria) {
		this.codcategoria = codcategoria;
	}
	

	public String getReagendado() {
		return reagendado;
	}


	public Date getDtreagendamento() {
		return dtreagendamento;
	}


	public void setReagendado(String reagendado) {
		this.reagendado = reagendado;
	}


	public void setDtreagendamento(Date dtreagendamento) {
		this.dtreagendamento = dtreagendamento;
	}
	
	public Integer getCodcontrib() {
		return codcontrib;
	}
	
	public void setCodcontrib(Integer codcontrib) {
		this.codcontrib = codcontrib;
	}

	public void setCodusuario(Integer codusuario) {
		this.codusuario = codusuario;
	}


	public Tcontribuintes getTconbribuintes() {
		return tconbribuintes;
	}

	public void setTconbribuintes(Tcontribuintes tconbribuintes) {
		this.tconbribuintes = tconbribuintes;
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
		Trecibos other = (Trecibos) obj;
		if (nrorecibo == null) {
			if (other.nrorecibo != null)
				return false;
		} else if (!nrorecibo.equals(other.nrorecibo))
			return false;
		return true;
	}

	public String[] split(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
