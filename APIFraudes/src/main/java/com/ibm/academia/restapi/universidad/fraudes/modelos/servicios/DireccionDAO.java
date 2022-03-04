package com.ibm.academia.restapi.universidad.fraudes.modelos.servicios;

import java.util.Optional;

import com.ibm.academia.restapi.universidad.fraudes.modelos.dto.PaisDTO;
import com.ibm.academia.restapi.universidad.fraudes.modelos.entidades.Direccion;

public interface DireccionDAO {

	public Optional<Direccion> buscarPorIpEnListaNegra(String ip);
	public PaisDTO BuscarPorIp(String ip);

}
