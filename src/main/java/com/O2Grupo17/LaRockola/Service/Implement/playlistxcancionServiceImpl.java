/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Service.Implement;

import com.O2Grupo17.LaRockola.Dao.playlistxcancionDao;
import com.O2Grupo17.LaRockola.Model.playlistxcancion;
import com.O2Grupo17.LaRockola.Service.playlistxcancionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Notebook_EXE
 */
@Service
public class playlistxcancionServiceImpl implements playlistxcancionService {
    
     @Autowired
    private playlistxcancionDao playlistxcancionDao;

    @Override
    @Transactional(readOnly = false)
    public playlistxcancion save(playlistxcancion playlistxcancion) {
        return playlistxcancionDao.save(playlistxcancion);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        playlistxcancionDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public playlistxcancion findById(Integer id) {
        return playlistxcancionDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<playlistxcancion> findAll() {
        return (List<playlistxcancion>) playlistxcancionDao.findAll();
    }
    
}
