/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Controller;

import com.O2Grupo17.LaRockola.Model.genero;
import com.O2Grupo17.LaRockola.Service.generoService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/genero")

    public class generoController {

        @Autowired
        private generoService generoservice;

        /*(value = "/")*/
        @PostMapping()
        public ResponseEntity<genero> agregar(@RequestBody genero genero) {
            genero obj = generoservice.save(genero);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }

        @DeleteMapping(value = "/{id}")
        public ResponseEntity<genero> eliminar(@PathVariable Integer id) {
            genero obj = generoservice.findById(id);
            if (obj != null) {
                generoservice.delete(id);
            } else {
                return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }

        @PutMapping(value = "/")
        public ResponseEntity<genero> editar(@RequestBody genero genero) {
            genero obj = generoservice.findById(genero.getIdgenero());
            if (obj != null) {
                obj.setNombregenero(genero.getNombregenero());
                generoservice.save(obj);
            } else {
                return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }

        @GetMapping("/list")
        public List<genero> consultarTodo() {
            return generoservice.findAll();
        }

        @GetMapping("/list/{id}")
        public genero consultaPorId(@PathVariable Integer id) {
            return generoservice.findById(id);
        }
    }
