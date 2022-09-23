/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Service;
import java.util.List;
import com.O2Grupo17.LaRockola.Model.album;

/**
 *
 * @author asus
 */
public interface albumService {

    public album save(album album);

    public void delete(Integer id);

    public album findById(Integer id);

    public List<album> findAll();
}
