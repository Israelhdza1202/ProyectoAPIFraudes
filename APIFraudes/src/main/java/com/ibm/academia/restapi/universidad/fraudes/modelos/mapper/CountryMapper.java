package com.ibm.academia.restapi.universidad.fraudes.modelos.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.academia.restapi.universidad.fraudes.modelos.dto.CambioPaisDTO;
import com.ibm.academia.restapi.universidad.fraudes.modelos.dto.MonedaDTO;
import com.ibm.academia.restapi.universidad.fraudes.modelos.dto.PaisDTO;
import com.ibm.academia.restapi.universidad.fraudes.modelos.dto.PaisNombreDTO;

public class CountryMapper {

	public static PaisDTO mapIpInfo(PaisNombreDTO ipDTO, MonedaDTO layerDTO, CambioPaisDTO fixerDTO ) {
	
		PaisDTO paisDTO = new PaisDTO();
		paisDTO.setNombre(ipDTO.getNombre());
		paisDTO.setIso(ipDTO.getIso());
		paisDTO.setMoneda(layerDTO.getMoneda());
		paisDTO.setTasacambio(fixerDTO.getTasacambio());

		return paisDTO;
	}

		
}
