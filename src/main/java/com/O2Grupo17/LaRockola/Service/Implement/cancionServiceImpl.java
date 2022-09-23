/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Service.Implement;

import com.O2Grupo17.LaRockola.Dao.cancionDao;
import com.O2Grupo17.LaRockola.Model.cancion;
import com.O2Grupo17.LaRockola.Service.cancionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Notebook_EXE
 */
@Service
public class cancionServiceImpl implements cancionService {

    @Autowired
    private cancionDao cancionDao;

    @Override
    @Transactional(readOnly = false)
    public cancion save(cancion cancion) {
        return cancionDao.save(cancion);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        cancionDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public cancion findById(Integer id) {
        return cancionDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<cancion> findAll() {
        return (List<cancion>) cancionDao.findAll();
    }

}

