package com.codigofacilito.peliculas.services;

import com.codigofacilito.peliculas.entities.Pelicula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPeliculaService {
    public void save(Pelicula pelicula);
    public Pelicula findById(Long id);
    public List<Pelicula> findAll();
    public Page<Pelicula> findAll(Pageable pageable);
    public void delete(Long id);
}
