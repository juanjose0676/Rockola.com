/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.O2Grupo17.LaRockola.Dao;

import com.O2Grupo17.LaRockola.Model.artista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface artistaDao extends CrudRepository<artista, Integer> {

}
