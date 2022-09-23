/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Controller;



import com.O2Grupo17.LaRockola.Model.perfil;
import com.O2Grupo17.LaRockola.Service.perfilService;

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
@RequestMapping("/perfil")
public class perfilController {
    
    @Autowired
    private perfilService perfilservice;
/*(value = "/")*/
    @PostMapping()
    public ResponseEntity<perfil> agregar(@RequestBody perfil perfil) {
        perfil obj = perfilservice.save(perfil);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<perfil> eliminar(@PathVariable Integer id) {
        perfil obj = perfilservice.findById(id);
        if (obj != null) {
            perfilservice.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<perfil> editar(@RequestBody perfil perfil) {
        perfil obj = perfilservice.findById(perfil.getIdPerfil());
        if (obj != null) {
            obj.setNombrePerfil(perfil.getNombrePerfil());
            perfilservice.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<perfil> consultarTodo() {
        return perfilservice.findAll();
    }

    @GetMapping("/list/{id}")
    public perfil consultaPorId(@PathVariable Integer id) {
        return perfilservice.findById(id);
    }
}
