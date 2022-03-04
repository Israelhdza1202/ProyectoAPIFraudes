package com.ibm.academia.restapi.universidad.fraudes.Clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.academia.restapi.universidad.fraudes.excepciones.BadRequestExternalApiException;
import com.ibm.academia.restapi.universidad.fraudes.modelos.dto.MonedaDTO;

@FeignClient(name = "api-countrylayer", url = "${restcountry.url}")
//@FeignClient(name = "api-countrylayer", url = "https://restcountries.com/v2")
public interface CountryRest {
	@GetMapping("/alpha/{code}")//buscar tambien como alpha2
	public MonedaDTO buscarPaisPorCode3(
			@PathVariable("code") String code3
			) throws BadRequestExternalApiException;
}
