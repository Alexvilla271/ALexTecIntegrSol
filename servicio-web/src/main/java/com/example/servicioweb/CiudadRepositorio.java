package com.example.servicioweb;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import io.spring.guides.gs_producing_web_service.Ciudad;
import io.spring.guides.gs_producing_web_service.Harina;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CiudadRepositorio {
    private static final Map<String, Ciudad> ciudades= new HashMap<>();

    @PostConstruct
    public void iniData(){
        Ciudad xalapa= new Ciudad();
        xalapa.setNombre("Xalapa");
        xalapa.setSucursal("Av. Xalapa");
        xalapa.setHarina(Harina.AVENA);
        xalapa.setInventario(3000);

        ciudades.put(xalapa.getNombre(), xalapa);

        Ciudad coatepec= new Ciudad();
        coatepec.setNombre("Coatepec");
        coatepec.setSucursal("Calle Centro");
        coatepec.setHarina(Harina.TRIGO);
        coatepec.setInventario(260);

        ciudades.put(coatepec.getNombre(), coatepec);

        Ciudad orizaba= new Ciudad();
        orizaba.setNombre("Orizaba");
        orizaba.setSucursal("Cri-Cri");
        orizaba.setHarina(Harina.MAIZ);
        orizaba.setInventario(2400);

        ciudades.put(orizaba.getNombre(), orizaba);
    }

    public Ciudad findCiudad(String nombre){
        Assert.notNull(nombre, "El nombre de la ciudad no debe ser nulo.");
        return ciudades.get(nombre);
    }
}
