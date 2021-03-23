package com.example.demo;

import org.example.calculadora.SumarRequest;
import org.example.calculadora.SumarResponse;
import org.example.calculadora.RestartRequest;
import org.example.calculadora.RestartResponse;
import org.example.calculadora.DiviRequest;
import org.example.calculadora.DiviResponse;
import org.example.calculadora.MultRequest;
import org.example.calculadora.MultResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class calculadoraEndPoint {

    @PayloadRoot(namespace = "http://www.example.org/calculadora", localPart = "SumarRequest")
    @PayloadRoot(namespace = "http://www.example.org/calculadora", localPart = "RestarRequest")

    @ResponsePayload
    public SumarResponse dameSuma(@RequestPayload SumarRequest peticion){
        SumarResponse respuesta= new SumarResponse();
        respuesta.setResultado(String.valueOf(
            Integer.parseInt( peticion.getA() ) +
            Integer.parseInt( peticion.getB() )
        ));

        return respuesta;
    }

    @ResponsePayload
    public RestartResponse dameResta(@RequestPayload RestarRequest peticion){
        RestarRequest respuesta= new RestartResponse();
        respuesta.setResultado(String.valueOf(
            Integer.parseInt( peticion.getA() ) +
            Integer.parseInt( peticion.getB() )
        ));

        return respuesta;
    }

    @ResponsePayload
    public DiviResponse dameDivi(@RequestPayload DiviRequest peticion){
        DiviRequest respuesta= new DiviResponse();
        respuesta.setResultado(String.valueOf(
            Integer.parseInt( peticion.getA() ) +
            Integer.parseInt( peticion.getB() )
        ));

        return respuesta;
    }

    @ResponsePayload
    public MultResponse dameMult(@RequestPayload MultRequest peticion){
        MultRequest respuesta= new MultResponse();
        respuesta.setResultado(String.valueOf(
            Integer.parseInt( peticion.getA() ) +
            Integer.parseInt( peticion.getB() )
        ));

        return respuesta;
    }

}
