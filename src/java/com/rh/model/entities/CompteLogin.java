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
public class CompteLogin implements Serializable {
    private int id_compte;
    private String login;
    private String pass;

    public CompteLogin() {
    }

    public int getId_compte() {
        return id_compte;
    }

    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
    }

    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    

}
