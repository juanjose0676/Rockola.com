/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Dao;

import com.O2Grupo17.LaRockola.Model.playlistxcancion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Notebook_EXE
 */
@Repository
public interface playlistxcancionDao extends CrudRepository<playlistxcancion,Integer>  {
    
}
