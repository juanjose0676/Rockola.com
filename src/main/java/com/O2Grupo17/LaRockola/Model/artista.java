/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "artista")

public class artista implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idartista", unique = true, nullable = false)
    private Integer idartista;

    @Column(name = "Nombreartista")
    private String nombreartista;

    public Integer getIdartista() {
        return idartista;
    }

    public void setIdartista(Integer idartista) {
        this.idartista = idartista;
    }

    public String getNombreartista() {
        return nombreartista;
    }

    public void setNombreartista(String nombreartista) {
        this.nombreartista = nombreartista;
    }

}
