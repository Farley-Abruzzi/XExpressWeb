package com.mcexpress.dto;

import java.io.Serializable;

import com.mcexpress.domain.Tcontribuintes;

public class TcontribuintesDTO2 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codcontrib;
	private Integer codmensageiro;
	private String NOMENORECIBO;
	private String TELEFONEPRINCIPAL;
	private String ENDERECOPRINCIPAL;
	private String NUMEROPRINCIPAL;
	private String CIDADEPRINCIPAL;
	
	

	public TcontribuintesDTO2() {
	}



	public TcontribuintesDTO2(Tcontribuintes tcontribuintes) {
		codcontrib = tcontribuintes.getCodcontrib();
		codmensageiro = tcontribuintes.getCODMENSAGEIRO();
		NOMENORECIBO = tcontribuintes.getNOMENORECIBO();
		TELEFONEPRINCIPAL = tcontribuintes.getTELEFONEPRINCIPAL();
		ENDERECOPRINCIPAL = tcontribuintes.getENDERECOPRINCIPAL();
		NUMEROPRINCIPAL = tcontribuintes.getNUMEROPRINCIPAL();
		CIDADEPRINCIPAL = tcontribuintes.getCIDADEPRINCIPAL();
	}



	public Integer getCodcontrib() {
		return codcontrib;
	}

	public Integer getCodmensageiro() {
		return codmensageiro;
	}

	public String getNOMENORECIBO() {
		return NOMENORECIBO;
	}

	public String getTELEFONEPRINCIPAL() {
		return TELEFONEPRINCIPAL;
	}

	public String getENDERECOPRINCIPAL() {
		return ENDERECOPRINCIPAL;
	}

	public String getNUMEROPRINCIPAL() {
		return NUMEROPRINCIPAL;
	}

	public String getCIDADEPRINCIPAL() {
		return CIDADEPRINCIPAL;
	}

	public void setCodcontrib(Integer codcontrib) {
		this.codcontrib = codcontrib;
	}

	public void setCodmensageiro(Integer codmensageiro) {
		this.codmensageiro = codmensageiro;
	}

	public void setNOMENORECIBO(String nOMENORECIBO) {
		NOMENORECIBO = nOMENORECIBO;
	}

	public void setTELEFONEPRINCIPAL(String tELEFONEPRINCIPAL) {
		TELEFONEPRINCIPAL = tELEFONEPRINCIPAL;
	}

	public void setENDERECOPRINCIPAL(String eNDERECOPRINCIPAL) {
		ENDERECOPRINCIPAL = eNDERECOPRINCIPAL;
	}

	public void setNUMEROPRINCIPAL(String nUMEROPRINCIPAL) {
		NUMEROPRINCIPAL = nUMEROPRINCIPAL;
	}

	public void setCIDADEPRINCIPAL(String cIDADEPRINCIPAL) {
		CIDADEPRINCIPAL = cIDADEPRINCIPAL;
	}
			
}
