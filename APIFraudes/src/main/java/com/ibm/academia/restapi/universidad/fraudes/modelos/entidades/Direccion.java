package com.ibm.academia.restapi.universidad.fraudes.modelos.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import org.jetbrains.annotations.NotNull;
import javax.validation.constraints.*;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Direccion")
public class Direccion implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "No puede estar vacio")
	//@NotNull(message = "No puede ser nulo")
	@Size(min = 3, max = 20)
	@Column(name = "ip", nullable = false)
	private String ip;
	
	@NotEmpty(message = "No puede estar vacio")
	//@NotNull(message = "No puede ser nulo")
	@Size(min = 3, max = 20)
	@Column(name = "estatus", nullable = false)
	private String estatus;
	
	@NotEmpty(message = "No puede estar vacio")
	//@NotNull(message = "No puede ser nulo")
	@Size(min = 3, max = 80)
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@NotEmpty(message = "No puede estar vacio")
	//@NotNull(message = "No puede ser nulo")
	@Size(min = 3, max = 10)
	@Column(name = "iso", nullable = false)
	private String iso;

	@NotEmpty(message = "No puede estar vacio")
	//@NotNull(message = "No puede ser nulo")
	@Size(min = 3, max = 10)
	@Column(name = "moneda", nullable = false)
	private String modena;

	@NotEmpty(message = "No puede estar vacio")
	//@NotNull(message = "No puede ser nulo")
	@Size(min = 3, max = 10)
	@Column(name = "precio", nullable = false)
	private String precio;
	
	@NotEmpty(message = "No puede ser vacio")
	//@NotNull(message = "No puede ser nulo")
	@Size(min = 3, max = 100)
	@Column(name = "usuario_creacion", nullable = false)
	private String usuarioCreacion;
	
	@Column(name = "fecha_creacion", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion; 
	
	@Transient
	private Integer puerto;

	public Direccion(Long id,
			@NotEmpty(message = "No puede estar vacio")  @Size(min = 3, max = 20) String ip,
			@NotEmpty(message = "No puede estar vacio")  @Size(min = 3, max = 20) String estatus,
			@NotEmpty(message = "No puede estar vacio")  @Size(min = 3, max = 80) String nombre,
			@NotEmpty(message = "No puede estar vacio")  @Size(min = 3, max = 10) String iso,
			@NotEmpty(message = "No puede estar vacio")  @Size(min = 3, max = 10) String modena,
			@NotEmpty(message = "No puede estar vacio")  @Size(min = 3, max = 10) String precio) {
		super();
		this.id = id;
		this.ip = ip;
		this.estatus = estatus;
		this.nombre = nombre;
		this.iso = iso;
		this.modena = modena;
		this.precio = precio;
	}




	private static final long serialVersionUID = -1200597275512010113L;

}

























