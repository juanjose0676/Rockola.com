/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Service;

import java.util.List;
import com.O2Grupo17.LaRockola.Model.perfil;

/**
 *
 * @author Notebook_EXE
 */
public interface perfilService {

    public perfil save(perfil perfil);

    public void delete(Integer id);

    public perfil findById(Integer id);

    public List<perfil> findAll();
}