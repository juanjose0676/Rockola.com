/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Controller;

import com.O2Grupo17.LaRockola.Model.playlist;
import com.O2Grupo17.LaRockola.Service.playlistService;
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
@RequestMapping("/playlist")

public class playlistController {
    @Autowired
    private playlistService playlistservice;
/*(value = "/")*/
    @PostMapping()
    public ResponseEntity<playlist> agregar(@RequestBody playlist playlist) {
        playlist obj = playlistservice.save(playlist);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<playlist> eliminar(@PathVariable Integer id) {
        playlist obj = playlistservice.findById(id);
        if (obj != null) {
            playlistservice.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<playlist> editar(@RequestBody playlist playlist) {
        playlist obj = playlistservice.findById(playlist.getIdPlayList());
        if (obj != null) {
            obj.setNombrePlayList(playlist.getNombrePlayList());
            playlistservice.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<playlist> consultarTodo() {
        return playlistservice.findAll();
    }

    @GetMapping("/list/{id}")
    public playlist consultaPorId(@PathVariable Integer id) {
        return playlistservice.findById(id);
    }
    
}
