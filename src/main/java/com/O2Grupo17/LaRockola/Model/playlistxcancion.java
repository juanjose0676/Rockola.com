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
@Table(name = "playlistxcancion")
public class playlistxcancion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPlaylistXCancion", unique = true, nullable=false)
    private Integer idPlaylistXCancion;
    
    @Column(name = "PlayList")
    private int PlayList;
    
    @Column(name = "Cancion")
    private int Cancion;

    public Integer getIdPlaylistXCancion() {
        return idPlaylistXCancion;
    }

    public void setIdPlaylistXCancion(Integer idPlaylistXCancion) {
        this.idPlaylistXCancion = idPlaylistXCancion;
    }

    public int getPlayList() {
        return PlayList;
    }

    public void setPlayList(int PlayList) {
        this.PlayList = PlayList;
    }

    public int getCancion() {
        return Cancion;
    }

    public void setCancion(int Cancion) {
        this.Cancion = Cancion;
    }
     
     
}
