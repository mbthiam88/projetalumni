/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rh.view;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author compte utilisateur
 */
public class AddForm2 extends ActionForm {

    private String nom = null;
    private String prenom = null;
    private String mail2 = null;
    private String mdp = null;
    private String name_var = null;

    public String getName_var() {
        return name_var;
    }

    public void setName_var(String name_var) {
        this.name_var = name_var;
    }

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

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        String nom = null;
        String prenom = null;
        String mail2 = null;
        String mdp = null;
        String name_var = null;
}
}
