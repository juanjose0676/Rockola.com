/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author DANIEL
 */
@Entity
@Table(name = "usuario")
public class usuario implements Serializable{
    
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario", unique = true, nullable=false)
    private String idUsuario;
    
    @Column(name = "NombreUsuario")
    private String nombreUsuario;
    
    @Column(name = "Estado")
    private String estado;

    @Column(name = "Password")
    private String password;
    
    @Column(name = "Perfil")
    private int perfil;
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

     
}
