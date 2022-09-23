/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Controller;
import com.O2Grupo17.LaRockola.Model.album;
import com.O2Grupo17.LaRockola.Service.albumService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author asus
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/album")
public class albumController {
    
    @Autowired
    private albumService albumservice;
/*(value = "/")*/
    @PostMapping()
    public ResponseEntity<album> agregar(@RequestBody album c) {
        album obj = albumservice.save(c);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<album> eliminar(@PathVariable Integer id) {
        album obj = albumservice.findById(id);
        if (obj != null) {
            albumservice.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

   @PutMapping(value = "/")
    public ResponseEntity<album> editar(@RequestBody album album) {
        album obj = albumservice.findById(album.getIdAlbum());
        if (obj != null) {
            obj.setNombreAlbum(album.getNombreAlbum());
            albumservice.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<album> consultarTodo() {
        return albumservice.findAll();
    }

    @GetMapping("/list/{id}")
    public album consultaPorId(@PathVariable Integer id) {
        return albumservice.findById(id);
    }
}

