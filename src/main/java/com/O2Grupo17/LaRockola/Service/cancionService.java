/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Service;

import java.util.List;
import com.O2Grupo17.LaRockola.Model.cancion;
import com.O2Grupo17.LaRockola.Model.cancionesMostrar;
/**
 *
 * @author Notebook_EXE
 */
public interface cancionService {
    
    public cancion save(cancion cancion);

    public void delete(Integer id);

    public cancion findById(Integer id);

    public List<cancion> findAll();
    
}
