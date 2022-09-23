/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.O2Grupo17.LaRockola.Service;

import java.util.List;
import com.O2Grupo17.LaRockola.Model.genero;

public interface generoService {

    public genero save(genero genero);

    public void delete(Integer id);

    public genero findById(Integer id);

    public List<genero> findAll();
}
