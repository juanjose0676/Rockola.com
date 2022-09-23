/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Service.Implement;

import com.O2Grupo17.LaRockola.Dao.artistaDao;
import com.O2Grupo17.LaRockola.Model.artista;
import com.O2Grupo17.LaRockola.Service.artistaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class artistaServices implements artistaService {

    @Autowired
    private artistaDao artistaDao;

    @Override
    @Transactional(readOnly = false)
    public artista save(artista artista) {
        return artistaDao.save(artista);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        artistaDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public artista findById(Integer id) {
        return artistaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<artista> findAll() {
        return (List<artista>) artistaDao.findAll();
    }
}
