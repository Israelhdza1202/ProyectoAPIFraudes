package com.ibm.academia.restapi.universidad.fraudes.modelos.servicios;


import java.util.Map;
import java.util.Optional;

import com.ibm.academia.restapi.universidad.fraudes.excepciones.BadRequestExternalApiException;
import com.ibm.academia.restapi.universidad.fraudes.modelos.dto.CambioPaisDTO;
import com.ibm.academia.restapi.universidad.fraudes.modelos.mapper.CountryMapper;
import com.ibm.academia.restapi.universidad.fraudes.modelos.mapper.FixerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.restapi.universidad.fraudes.Clientes.CountryRest;
import com.ibm.academia.restapi.universidad.fraudes.Clientes.FixerRest;
import com.ibm.academia.restapi.universidad.fraudes.Clientes.Ip2CountryRest;
import com.ibm.academia.restapi.universidad.fraudes.excepciones.NotFoundException;
import com.ibm.academia.restapi.universidad.fraudes.modelos.dto.MonedaDTO;
import com.ibm.academia.restapi.universidad.fraudes.modelos.dto.PaisDTO;
import com.ibm.academia.restapi.universidad.fraudes.modelos.dto.PaisNombreDTO;
import com.ibm.academia.restapi.universidad.fraudes.modelos.entidades.Direccion;
import com.ibm.academia.restapi.universidad.fraudes.modelos.repositorios.DireccionRepository;

import org.springframework.web.client.RestTemplate;

@Service
public class DireccionDAOImpl implements DireccionDAO {

	@Autowired
	private RestTemplate direccionRestTemp;

	@Autowired
	private DireccionRepository direccionRepository;

	@Autowired
	private Ip2CountryRest ipCliente;
	
	@Autowired
	private CountryRest  paisCliente;
	
	@Autowired
	private FixerRest  fixerCliente;

	@Value("${fixer.api-key}")
	private String apiKeyFixer;


	@Override
	@Transactional(readOnly = true)
	public Optional<Direccion> buscarPorIpEnListaNegra(String ip)
	{
		Optional<Direccion> ipListaegra = direccionRepository.buscarPorIpEnListaNegra(ip);

		if (ipListaegra.isPresent())
		throw new NotFoundException(String.format("La direccion se encuentra actualmente en Lista Negra, lo siento"+ipListaegra.get().getIp(), ip));

		return ipListaegra;
	}


	@Override
	@Transactional(readOnly = true)
	public PaisDTO BuscarPorIp(String ip) {
		Optional<Direccion> ipIngresada = direccionRepository.buscarPorIp(ip);

		if(ipIngresada.isPresent())
			throw new NotFoundException("Ip inhabilitada"+ipIngresada.get());
		
		PaisNombreDTO paisNombreDTO = ipCliente.buscarPaisPorIp(ip);
		MonedaDTO monedaDTO = paisCliente.buscarPaisPorCode3(paisNombreDTO.getIso());

		
		if(monedaDTO.getMoneda() == null)
			throw new BadRequestExternalApiException("No se encontro ninguna moneda para el pais"+ paisNombreDTO.getNombre());
		Map<String, Object> responseFixer = fixerCliente.buscarInfoDetalle(apiKeyFixer);
		
		@SuppressWarnings("unchecked")
		Map<String, Double> cambios = (Map<String, Double>) responseFixer.get("cambios");
		
		if(!cambios.containsKey(monedaDTO.getMoneda()))
			throw new NotFoundException("La moneda no cuenta con tasa de cambio"+monedaDTO.getMoneda());
		
		CambioPaisDTO cambioPaisDTO = FixerMapper.mapWithCoin(cambios, monedaDTO.getMoneda());
		return CountryMapper.mapIpInfo(paisNombreDTO, monedaDTO, cambioPaisDTO);
	}
}
























