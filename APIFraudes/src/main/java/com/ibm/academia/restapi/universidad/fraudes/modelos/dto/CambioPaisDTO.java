package com.ibm.academia.restapi.universidad.fraudes.modelos.dto;

import java.io.Serializable;


public class CambioPaisDTO implements Serializable {
	
	private Double Tasacambio;
	
	private static final long serialVersionUID = 724271093415473485L;

	public Double getTasacambio() {
		return Tasacambio;
	}

	public void setTasacambio(Double tasacambio) {
		Tasacambio = tasacambio;
	}
}
