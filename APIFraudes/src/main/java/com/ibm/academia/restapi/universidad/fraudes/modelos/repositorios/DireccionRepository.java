package com.ibm.academia.restapi.universidad.fraudes.modelos.repositorios;

import java.util.Optional;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ibm.academia.restapi.universidad.fraudes.modelos.entidades.Direccion;
import org.springframework.stereotype.Repository;

@Repository("repositorioAlumno")
public interface DireccionRepository extends CrudRepository<Direccion, Long> 
{
	@Query("select d from Direccion d where d.ip like %?1%")
	public Optional<Direccion> buscarPorIpEnListaNegra(String ip);

	@Query("select d from Direccion d where d.ip like %?1%")
	public Optional<Direccion> buscarPorIp(String ip);

	
}
