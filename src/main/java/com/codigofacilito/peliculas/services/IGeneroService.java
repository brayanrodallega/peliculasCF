package com.codigofacilito.peliculas.services;

import com.codigofacilito.peliculas.entities.Genero;

import java.util.List;

public interface IGeneroService {
    public void save(Genero genero);
    public Genero findById(Long id);
    public void delete(Long id);
    public List<Genero> findAll();
}
