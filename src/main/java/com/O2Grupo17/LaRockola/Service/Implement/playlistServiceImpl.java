/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Service.Implement;

import com.O2Grupo17.LaRockola.Dao.playlistDao;
import com.O2Grupo17.LaRockola.Model.playlist;
import com.O2Grupo17.LaRockola.Service.playlistService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Notebook_EXE
 */
@Service
public class playlistServiceImpl implements playlistService {
    
     @Autowired
    private playlistDao playlistDao;

    @Override
    @Transactional(readOnly = false)
    public playlist save(playlist playlist) {
        return playlistDao.save(playlist);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        playlistDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public playlist findById(Integer id) {
        return playlistDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<playlist> findAll() {
        return (List<playlist>) playlistDao.findAll();
    }
    
}
