package com.ibm.academia.restapi.universidad.fraudes.modelos.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PaisNombreDTO implements Serializable {
	
	@JsonProperty("countryCode3")
	private String iso;
	@JsonProperty("countryName")
	private String nombre;

	public PaisNombreDTO(String iso, String nombre) {
		this.iso = iso;
		this.nombre = nombre;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private static final long serialVersionUID = 2457491903583350154L;
}
