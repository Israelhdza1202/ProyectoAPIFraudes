package com.ibm.academia.restapi.universidad.fraudes.Clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.academia.restapi.universidad.fraudes.excepciones.BadRequestExternalApiException;
import com.ibm.academia.restapi.universidad.fraudes.modelos.dto.PaisNombreDTO;

@FeignClient(name = "api-ip2country", url = "${ip2country.url}" )
//@FeignClient(name = "api-ip2country", url = "https://api.ip2country.info" )
public interface Ip2CountryRest{
	@GetMapping("/ip?{ip}")
	public PaisNombreDTO buscarPaisPorIp(@PathVariable String ip) throws BadRequestExternalApiException;
}
