/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Controller;

import com.O2Grupo17.LaRockola.Model.album;
import com.O2Grupo17.LaRockola.Model.artista;
import com.O2Grupo17.LaRockola.Model.cancion;
import com.O2Grupo17.LaRockola.Model.cancionesMostrar;
import com.O2Grupo17.LaRockola.Model.genero;
import com.O2Grupo17.LaRockola.Service.artistaService;
import com.O2Grupo17.LaRockola.Service.albumService;
import com.O2Grupo17.LaRockola.Service.cancionService;
import com.O2Grupo17.LaRockola.Service.generoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Notebook_EXE
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/cancion")
public class cancionController {
    
    @Autowired
    private cancionService cancionservice;
    
    @Autowired
    private generoService gservice;
    
    @Autowired
    private artistaService arservice;
    
    @Autowired
    private albumService alservice;
/*(value = "/")*/
    @PostMapping()
    public ResponseEntity<cancion> agregar(@RequestBody cancion cancion) {
        cancion obj = cancionservice.save(cancion);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<cancion> eliminar(@PathVariable Integer id) {
        cancion obj = cancionservice.findById(id);
        if (obj != null) {
            cancionservice.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<cancion> editar(@RequestBody cancion cancion) {
        cancion obj = cancionservice.findById(cancion.getIdCancion());
        if (obj != null) {
            obj.setNombreCancion(cancion.getNombreCancion());
            obj.setLink(cancion.getLink());
            obj.setGenero(cancion.getGenero());
            obj.setAlbum(cancion.getAlbum());
            obj.setArtista(cancion.getArtista());
            cancionservice.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/showall/")
    public List<cancionesMostrar> consultaAll() {
               
        List<cancion> listAll;
        List<genero> listgeneros;
        List<artista> listartistas;
        List<album> listalbum;
        List<cancionesMostrar> cMostrar = new ArrayList<>();
        
        listAll = cancionservice.findAll();
        listgeneros = gservice.findAll();
        listartistas = arservice.findAll();
        listalbum = alservice.findAll();
        
        for (cancion s : listAll) {
            cancionesMostrar c = new cancionesMostrar();
            
            c.setIdCancion(s.getIdCancion());
            c.setNombreCancion(s.getNombreCancion());
            c.setLink(s.getLink());
            
            String Gen = "";
            String Art = "";
            String Alb = "";
            
            for (genero g : listgeneros){
                if(g.getIdgenero() == s.getGenero())
                    Gen = g.getNombregenero();
            }
            
            for (album a : listalbum){
                if(a.getIdAlbum() == s.getAlbum())
                    Alb = a.getNombreAlbum();
            }
            
            for (artista ar : listartistas){
                if(ar.getIdartista() == s.getArtista())
                    Art = ar.getNombreartista();
            }
            c.setGenero(Gen);
            c.setAlbum(Alb);
            c.setArtista(Art);
            
            cMostrar.add(c);
        }
        
        return cMostrar;
    }
    @GetMapping("/list")
    public List<cancion> consultarTodo() {
        return cancionservice.findAll();
    }

    @GetMapping("/list/{id}")
    public cancion consultaPorId(@PathVariable Integer id) {
        return cancionservice.findById(id);
    }

    
}
