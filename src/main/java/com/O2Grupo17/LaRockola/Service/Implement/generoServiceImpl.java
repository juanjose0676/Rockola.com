/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Service.Implement;

import com.O2Grupo17.LaRockola.Dao.generoDao;
import com.O2Grupo17.LaRockola.Model.genero;
import com.O2Grupo17.LaRockola.Service.generoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class generoServiceImpl implements generoService {

    @Autowired
    private generoDao generoDao;

    @Override
    @Transactional(readOnly = false)
    public genero save(genero genero) {
        return generoDao.save(genero);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        generoDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public genero findById(Integer id) {
        return generoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<genero> findAll() {
        return (List<genero>) generoDao.findAll();
    }
}


