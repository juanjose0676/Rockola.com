/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Controller;

import com.O2Grupo17.LaRockola.Model.usuario;
import com.O2Grupo17.LaRockola.Model.perfil;
import com.O2Grupo17.LaRockola.Model.usuariosMostrar;
import com.O2Grupo17.LaRockola.Service.perfilService;
import com.O2Grupo17.LaRockola.Service.usuarioService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
@RequestMapping("/usuario")
public class usuarioController {
    
    @Autowired
    private usuarioService usuarioservice;
        
    @Autowired
    private perfilService pservice;
    
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
            obj.setPassword(usuario.getPassword());
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
    
    @GetMapping("/showall/")
    public List<usuariosMostrar> consultaAll() {
               
        List<usuario> listAll;
        List<perfil> listperfiles;

        List<usuariosMostrar> cMostrar = new ArrayList<>();
        
        listAll = usuarioservice.findAll();
        listperfiles = pservice.findAll();
        
        for (usuario s : listAll) {
            usuariosMostrar c = new usuariosMostrar();
            
            c.setIdUsuario(s.getIdUsuario());
            c.setNombreUsuario(s.getNombreUsuario());
            c.setEstado(s.getEstado());
            c.setPassword(s.getPassword());
            
            String Gen = "";
           
            for (perfil g : listperfiles){
                if(g.getIdPerfil() == s.getPerfil())
                    Gen = g.getNombrePerfil();
            }
            
            c.setPerfil(Gen);
            
            cMostrar.add(c);
        }
        
        return cMostrar;
    }
}
