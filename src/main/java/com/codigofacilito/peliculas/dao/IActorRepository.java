package com.codigofacilito.peliculas.dao;

import com.codigofacilito.peliculas.entities.Actor;
import org.springframework.data.repository.CrudRepository;

public interface IActorRepository extends CrudRepository<Actor, Long> {
}
