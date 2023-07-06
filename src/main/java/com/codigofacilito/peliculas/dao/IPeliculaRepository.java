package com.codigofacilito.peliculas.dao;

import com.codigofacilito.peliculas.entities.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPeliculaRepository extends JpaRepository<Pelicula, Long> {
}
