package com.codigofacilito.peliculas.services;


import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.io.InputStream;


public interface IArchivosService {

    public void guardar(String archivo, InputStream bytes);
    public void eliminar (String archivo);
    public ResponseEntity<Resource> get(String archivo);
}
