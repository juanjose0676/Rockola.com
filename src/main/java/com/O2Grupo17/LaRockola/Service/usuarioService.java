/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Service;

import java.util.List;
import com.O2Grupo17.LaRockola.Model.usuario;
/**
 *
 * @author Notebook_EXE
 */
public interface usuarioService {
    
    public usuario save(usuario usuario);

    public void delete(String id);

    public usuario findById(String id);

    public List<usuario> findAll();
}
