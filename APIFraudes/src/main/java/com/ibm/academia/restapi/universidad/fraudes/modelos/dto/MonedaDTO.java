package com.ibm.academia.restapi.universidad.fraudes.modelos.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;



public class MonedaDTO implements  Serializable{

	private String moneda;
	
	@JsonProperty("currencies")
	private void listaDeMonedas(List<Map<String, Object>> currencies) {
		moneda = (String)currencies.get(0).get("code");
	}

	public MonedaDTO(String moneda) {
		this.moneda = moneda;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	private static final long serialVersionUID = -5827125952642038869L;

}
