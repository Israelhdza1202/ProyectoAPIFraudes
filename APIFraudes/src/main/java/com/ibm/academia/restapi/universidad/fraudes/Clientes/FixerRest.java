package com.ibm.academia.restapi.universidad.fraudes.Clientes;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.academia.restapi.universidad.fraudes.excepciones.BadRequestExternalApiException;

@FeignClient(name = "api-fixer", url = "${fixer.url}")
//@FeignClient(name = "api-fixer", url = "http://api.countrylayer.com/v2")
public interface FixerRest {

	//@GetMapping("/latest?access_key=")
	@GetMapping("/latest")
	public Map<String,Object> buscarInfoDetalle(@RequestParam(name = "access_key") String apiKey) 
			throws BadRequestExternalApiException;
}
