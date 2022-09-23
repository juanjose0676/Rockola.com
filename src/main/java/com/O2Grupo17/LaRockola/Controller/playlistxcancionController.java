/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Controller;

import com.O2Grupo17.LaRockola.Model.playlistxcancion;
import com.O2Grupo17.LaRockola.Service.playlistxcancionService;
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
@RequestMapping("/playlistxcancion")
public class playlistxcancionController {
    @Autowired
    private playlistxcancionService playlistxcancionservice;
/*(value = "/")*/
    @PostMapping()
    public ResponseEntity<playlistxcancion> agregar(@RequestBody playlistxcancion playlist) {
        playlistxcancion obj = playlistxcancionservice.save(playlist);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<playlistxcancion> eliminar(@PathVariable Integer id) {
        playlistxcancion obj = playlistxcancionservice.findById(id);
        if (obj != null) {
            playlistxcancionservice.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<playlistxcancion> editar(@RequestBody playlistxcancion playlistxcancion) {
        playlistxcancion obj =playlistxcancionservice.findById(playlistxcancion.getIdPlaylistXCancion());
        if (obj != null) {
            obj.setPlayList(playlistxcancion.getPlayList());
            obj.setCancion(playlistxcancion.getCancion());
            playlistxcancionservice.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<playlistxcancion> consultarTodo() {
        return playlistxcancionservice.findAll();
    }

    @GetMapping("/list/{id}")
    public playlistxcancion consultaPorId(@PathVariable Integer id) {
        return playlistxcancionservice.findById(id);
    }
}
