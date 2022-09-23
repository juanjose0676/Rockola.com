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
public class usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "idUsuario", unique = true, nullable=false)
    private String idUsuario;
    
    @Column(name = "NombreUsuario")
    private String nombreUsuario;
    
     @Column(name = "Estado")
    private Boolean Estado;
     
     @ManyToOne
      @JoinColumn(name = "Perfil")
    private perfil Perfil;

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

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean Estado) {
        this.Estado = Estado;
    }

    public perfil getPerfil() {
        return Perfil;
    }

    public void setPerfil(perfil Perfil) {
        this.Perfil = Perfil;
    }

     
    
}

    

