/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Service.Implement;

import com.O2Grupo17.LaRockola.Dao.usuarioDao;
import com.O2Grupo17.LaRockola.Model.usuario;
import com.O2Grupo17.LaRockola.Service.usuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Notebook_EXE
 */
@Service
public class usuarioServiceImpl implements usuarioService  {
    
    @Autowired
    private usuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = false)
    public usuario save(usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(String id) {
        usuarioDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public usuario findById(String id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<usuario> findAll() {
        return (List<usuario>) usuarioDao.findAll();
    }
}
