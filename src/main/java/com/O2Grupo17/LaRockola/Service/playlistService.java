/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Service;

import com.O2Grupo17.LaRockola.Model.playlist;
import java.util.List;

/**
 *
 * @author Notebook_EXE
 */
public interface playlistService {
    
    public playlist save(playlist playlist);

    public void delete(Integer id);

    public playlist findById(Integer id);

    public List<playlist> findAll();
    
}
