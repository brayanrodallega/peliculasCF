package com.codigofacilito.peliculas.services;

import com.codigofacilito.peliculas.entities.Actor;

import java.util.List;

public interface IActorService {
    public List<Actor> findAll();
    public List<Actor> findAllById(List<Long> ids);
}
