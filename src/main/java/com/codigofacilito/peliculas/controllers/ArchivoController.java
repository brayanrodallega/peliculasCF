package com.codigofacilito.peliculas.controllers;

import com.codigofacilito.peliculas.services.IArchivosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArchivoController {

    @Autowired
    private IArchivosService archivosService;


    @GetMapping("/archivo")
    public ResponseEntity<Resource> get(@RequestParam("n") String archivo) {
        return archivosService.get(archivo);
    }

}
