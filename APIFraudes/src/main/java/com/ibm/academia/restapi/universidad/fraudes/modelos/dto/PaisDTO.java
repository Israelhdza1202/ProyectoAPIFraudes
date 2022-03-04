package com.ibm.academia.restapi.universidad.fraudes.modelos.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class PaisDTO implements Serializable {

	private String ip;
	private String estatus;
	private String nombre;
	private String iso;
	private String moneda;
	@JsonProperty("rate_coin")
	private String rateCoin = "EUR";
	@JsonProperty("actual_rate")
	private Double Tasacambio;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getRateCoin() {
		return rateCoin;
	}

	public void setRateCoin(String rateCoin) {
		this.rateCoin = rateCoin;
	}

	public Double getTasacambio() {
		return Tasacambio;
	}

	public void setTasacambio(Double tasacambio) {
		Tasacambio = tasacambio;
	}

	private static final long serialVersionUID = -2146152665001923640L;

}
