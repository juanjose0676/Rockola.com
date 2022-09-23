/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Service.Implement;

import com.O2Grupo17.LaRockola.Dao.perfilDao;
import com.O2Grupo17.LaRockola.Model.perfil;
import com.O2Grupo17.LaRockola.Service.perfilService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Notebook_EXE
 */
@Service
public class perfilServicesImpl implements perfilService {
    
    @Autowired
    private perfilDao perfilDao;

    @Override
    @Transactional(readOnly = false)
    public perfil save(perfil perfil) {
        return perfilDao.save(perfil);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        perfilDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public perfil findById(Integer id) {
        return perfilDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<perfil> findAll() {
        return (List<perfil>) perfilDao.findAll();
    }
}
