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
@Table(name = "cancion")
public class cancion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCancion", unique = true, nullable=false)
    private Integer idCancion;
    
    @Column(name = "NombreCancion")
    private String nombreCancion;
    
    @Column(name = "Link")
    private String Link;
    
    @Column(name = "Genero")
    private int Genero;
    
    @Column(name = "Album")
    private int Album;
    
    @Column(name = "Artista")
    private int Artista;

    public Integer getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }

    public int getGenero() {
        return Genero;
    }

    public void setGenero(int Genero) {
        this.Genero = Genero;
    }

    public int getAlbum() {
        return Album;
    }

    public void setAlbum(int Album) {
        this.Album = Album;
    }

    public int getArtista() {
        return Artista;
    }

    public void setArtista(int Artista) {
        this.Artista = Artista;
    }
    
    
}
