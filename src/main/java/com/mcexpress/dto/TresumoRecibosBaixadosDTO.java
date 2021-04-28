package com.mcexpress.dto;

public class TresumoRecibosBaixadosDTO {
	
	private Integer nrorecibo;
	private Double valorgerado;
	
	public TresumoRecibosBaixadosDTO() {
		
	}
	
	public TresumoRecibosBaixadosDTO(Integer nrorecibo, Double valorgerado) {
		this.nrorecibo = nrorecibo;
		this.valorgerado = valorgerado;
	}

	public Integer getNrorecibo() {
		return nrorecibo;
	}

	public Double getValorgerado() {
		return valorgerado;
	}

	public void setNrorecibo(Integer nrorecibo) {
		this.nrorecibo = nrorecibo;
	}

	public void setValorgerado(Double valorgerado) {
		this.valorgerado = valorgerado;
	}
	

}
