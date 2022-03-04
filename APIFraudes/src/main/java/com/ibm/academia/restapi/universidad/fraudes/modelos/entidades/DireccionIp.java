package com.ibm.academia.restapi.universidad.fraudes.modelos.entidades;

import java.io.Serializable;

public class DireccionIp implements Serializable
{
    private Direccion direccion;
    private Integer cantidad;

    public DireccionIp(Direccion direccion)
    {
        this.direccion = direccion;

    }

    public String getTotal()
    {
        return direccion.getIp();
    }

    private static final long serialVersionUID = 39821731143264882L;
}
