package com.example.servicioweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.CiudadRequest;
import io.spring.guides.gs_producing_web_service.CiudadResponse;

public class CiudadEndpoint {
    private static final String NAMESPACE_URI= "http://spring.io/guides/gs-producing-web-service";

    private CiudadRepositorio ciudadRepositorio;

    @Autowired
    public CiudadEndpoint(CiudadRepositorio ciudadRepositorio){
        this.ciudadRepositorio= ciudadRepositorio;
    }

    @PayloadRoot(namespace =  NAMESPACE_URI, localPart= "HarinaRequest")
    @ResponsePayload
    public CiudadResponse dameCiudad(@RequestPayload CiudadRequest peticion){
        CiudadResponse respuesta= new CiudadResponse();
        respuesta.setCiudad(ciudadRepositorio.findCiudad(peticion.getNombre()));

        return respuesta;
    }
}
