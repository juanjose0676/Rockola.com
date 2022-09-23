/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Service.Implement;
import com.O2Grupo17.LaRockola.Dao.albumDao;
import com.O2Grupo17.LaRockola.Model.album;
import com.O2Grupo17.LaRockola.Service.albumService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author asus
 */
@Service
public class albumServicesImpl implements albumService {
    
    @Autowired
    private albumDao albumDao;

    @Override
    @Transactional(readOnly = false)
    public album save(album album) {
        return albumDao.save(album);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        albumDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public album findById(Integer id) {
        return albumDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<album> findAll() {
        return (List<album>) albumDao.findAll();
    }
}

