/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.O2Grupo17.LaRockola.Model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "genero")
public class genero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgenero", unique = true, nullable = false)
    private Integer idgenero;

    @Column(name = "Nombregenero")
    private String nombregenero;

    public Integer getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(Integer idgenero) {
        this.idgenero = idgenero;
    }

    public String getNombregenero() {
        return nombregenero;
    }

    public void setNombregenero(String nombregenero) {
        this.nombregenero = nombregenero;
    }

}
