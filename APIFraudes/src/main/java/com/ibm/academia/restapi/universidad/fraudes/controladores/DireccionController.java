package com.ibm.academia.restapi.universidad.fraudes.controladores;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import com.ibm.academia.restapi.universidad.fraudes.excepciones.BadRequestExternalApiException;
import com.ibm.academia.restapi.universidad.fraudes.modelos.dto.PaisDTO;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ibm.academia.restapi.universidad.fraudes.modelos.entidades.Direccion;
import com.ibm.academia.restapi.universidad.fraudes.modelos.servicios.DireccionDAO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@RestController
@RequestMapping("/direcccion")
public class DireccionController {
	
	@Autowired
	private DireccionDAO direccionDAO;

	private final static Logger logger = LoggerFactory.getLogger(DireccionController.class);

	/**
	 * Metodo para buscar una Ip dentro de la lista negra creada en H2
	 * @param ip para hacer la busqueda y validar si se encuentra presente
	 * @return devuelve la ip que se encontro en la lista negra
	 * @author IHA 01-02-2022
	 */
	@GetMapping("/ver-detalle/direccionIp/{ip}")
	public ResponseEntity<?> buscarPorIpEnListaNegra(@PathVariable String ip)
	{
		Optional<Direccion> direccion = null;
		try
		{
			direccion = direccionDAO.buscarPorIpEnListaNegra(ip);
		} catch (Exception e)

		{
			logger.info("mensaje: " + e.getMessage() + " Causa: " + e.getCause());
			throw e;
			}

		return new ResponseEntity<Direccion>(direccion.get(), HttpStatus.OK);	
	}


	/**
	 * Metodo generado para hacer busqueda por ip que no se encuentra en lista negra y obtener datos de los clientes(API´s)
	 * @param ip valor ingresado para genrar la consukta en las diferentes API´s
	 * @return devuelve los valores obtenidos de las API´s, atravez de los DTO
	 * @author IHA 01-02-2022
	 */
	@CircuitBreaker(name = "info-pais-por-ip", fallbackMethod = "methodAlternative")
	@TimeLimiter(name = "info-pais-por-ip")
	@GetMapping("/ver-detalle/info-pais-por-ip" + "" + "")
	public CompletableFuture<ResponseEntity<?>> BuscarPorIp(@RequestParam(value = "prueba") String ip) {

		return CompletableFuture.supplyAsync( () -> new ResponseEntity< PaisDTO >(direccionDAO.BuscarPorIp(ip), HttpStatus.OK));
	}

	/**
	 * Método alternativo para controlar las excepciones de BuscarPorIp
	 * @param e valor de la excepción obtenida
	 * @return Devuelve como respuesta el error que genere
	 * @author IHA 01-02-2022
	 */
	public CompletableFuture<ResponseEntity<?>> methodAlternative(Throwable e)
	{
		logger.warn(e.getMessage());

		Map<String, Object> respuesta = new HashMap<>();
		respuesta.put("error", e.getMessage());

		if(e.getClass() == BadRequestExternalApiException.class)
			throw new BadRequestExternalApiException(e.getMessage());

		if(e instanceof FeignException.BadRequest)
			throw new BadRequestExternalApiException("No se encontro informacion co la ip ingresada, intentelo con alguna otra diferente");

		respuesta.put("data", new PaisDTO());
		return CompletableFuture.supplyAsync( () -> new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK));
	}
}

























