/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Controller;

import com.O2Grupo17.LaRockola.Model.usuario;
import com.O2Grupo17.LaRockola.Service.usuarioService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author DANIEL
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class usuarioController {
    @Autowired
    private usuarioService usuarioservice;
/*(value = "/")*/
    @PostMapping()
    public ResponseEntity<usuario> agregar(@RequestBody usuario usuario) {
        usuario obj = usuarioservice.save(usuario);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    
    }
@DeleteMapping(value = "/{id}")
    public ResponseEntity<usuario> eliminar(@PathVariable String id) {
        usuario obj = usuarioservice.findById(id);
        if (obj != null) {
            usuarioservice.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
     @PutMapping(value = "/")
    public ResponseEntity<usuario> editar(@RequestBody usuario usuario) {
        usuario obj = usuarioservice.findById(usuario.getIdUsuario());
        if (obj != null) {
            
            obj.setNombreUsuario(usuario.getNombreUsuario());
            obj.setEstado(usuario.getEstado());
            obj.setPerfil(usuario.getPerfil());
            usuarioservice.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<usuario> consultarTodo() {
        return usuarioservice.findAll();
    }

    @GetMapping("/list/{id}")
    public usuario consultaPorId(@PathVariable String id) {
        return usuarioservice.findById(id);
    }
}