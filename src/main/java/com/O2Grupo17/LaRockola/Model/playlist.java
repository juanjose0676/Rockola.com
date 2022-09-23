/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Notebook_EXE
 */
@Entity
@Table(name = "playlist")
public class playlist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPlayList", unique = true, nullable=false)
    private Integer idPlayList;
    
    @Column(name = "NombrePlayList")
    private String nombrePlayList;
    
    @Column(name = "Usuario")
    private String Usuario;

    public Integer getIdPlayList() {
        return idPlayList;
    }

    public void setIdPlayList(Integer idPlayList) {
        this.idPlayList = idPlayList;
    }

    public String getNombrePlayList() {
        return nombrePlayList;
    }

    public void setNombrePlayList(String nombrePlayList) {
        this.nombrePlayList = nombrePlayList;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    
}
