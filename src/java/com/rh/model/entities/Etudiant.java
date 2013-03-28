/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rh.model.entities;

import java.io.Serializable;

/**
 *
 * @author Calbrix && Ikerchalene
 */
public class Etudiant implements Serializable {
    private String name;
    private String motDePasse;

    public Etudiant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

}
