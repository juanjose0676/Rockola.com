/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Controller;


import com.O2Grupo17.LaRockola.Model.artista;
import com.O2Grupo17.LaRockola.Service.artistaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/artista")

public class artistaController {

    @Autowired
    private artistaService artistaservice;

    /*(value = "/")*/
    @PostMapping()
    public ResponseEntity<artista> agregar(@RequestBody artista artista) {
        artista obj = artistaservice.save(artista);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<artista> eliminar(@PathVariable Integer id) {
        artista obj = artistaservice.findById(id);
        if (obj != null) {
            artistaservice.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<artista> editar(@RequestBody artista artista) {
        artista obj = artistaservice.findById(artista.getIdartista());
        if (obj != null) {
            obj.setNombreartista(artista.getNombreartista());
            artistaservice.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<artista> consultarTodo() {
        return artistaservice.findAll();
    }

    @GetMapping("/list/{id}")
    public artista consultaPorId(@PathVariable Integer id) {
        return artistaservice.findById(id);
    }
}
