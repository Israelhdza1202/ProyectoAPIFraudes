package com.ibm.academia.restapi.universidad.fraudes.excepciones;

public class BadRequestExternalApiException extends RuntimeException 
{

	public BadRequestExternalApiException(String mensaje)
	{
		super(mensaje);
	}
	private static final long serialVersionUID = 5843422199686658883L;

}

