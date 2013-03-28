/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rh.view;

import org.apache.struts.action.ActionForm;

/**
 *
 * @author compte utilisateur
 */
public class AddForm2 extends ActionForm{

    private String nom = null;
    private String prenom = null;
    private String mail2 = null;
    private String mdp = null;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getMail2() {
        return mail2;
    }

    public void setMail2(String mail) {
        this.mail2 = mail;
    }
}
