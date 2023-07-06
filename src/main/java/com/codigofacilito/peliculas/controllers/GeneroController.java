package com.codigofacilito.peliculas.controllers;

import com.codigofacilito.peliculas.dao.IGeneroRepository;
import com.codigofacilito.peliculas.entities.Genero;
import com.codigofacilito.peliculas.services.IGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GeneroController {

    private IGeneroService generoService;

    public GeneroController(IGeneroService generoService){
        this.generoService = generoService;
    }

    @PostMapping("/generos")
    public Long guardar(@RequestParam String nombre){
        Genero genero = new Genero();
        genero.setNombre(nombre);

        generoService.save(genero);

        return genero.getId();
    }


    @GetMapping("/generos/{id}")
    public String buscarPorId(@PathVariable(name = "id") Long id){
        return generoService.findById(id).getNombre();
    }
}
