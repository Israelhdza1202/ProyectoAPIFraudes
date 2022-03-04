package com.ibm.academia.restapi.universidad.fraudes.modelos.mapper;

import com.ibm.academia.restapi.universidad.fraudes.modelos.dto.CambioPaisDTO;

import java.util.Map;

public class FixerMapper {

	public static CambioPaisDTO mapWithCoin(Map<String, ?> cambios, String moneda) {
		CambioPaisDTO cambioPaisDTO = new CambioPaisDTO();
		cambioPaisDTO.setTasacambio(Double.valueOf(cambios.get(moneda).toString()));

		return cambioPaisDTO;
	}
}
