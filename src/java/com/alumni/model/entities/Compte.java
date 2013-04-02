package com.alumni.model.entities;
// Generated 2 avr. 2013 12:32:25 by Hibernate Tools 3.2.1.GA



/**
 * Compte generated by hbm2java
 */
public class Compte  implements java.io.Serializable {


     private int idcompte;
     private String login;
     private String pass;
     private String statut;

    public Compte() {
    }

	
    public Compte(int idcompte, String login, String pass) {
        this.idcompte = idcompte;
        this.login = login;
        this.pass = pass;
    }
    public Compte(int idcompte, String login, String pass, String statut) {
       this.idcompte = idcompte;
       this.login = login;
       this.pass = pass;
       this.statut = statut;
    }
   
    public int getIdcompte() {
        return this.idcompte;
    }
    
    public void setIdcompte(int idcompte) {
        this.idcompte = idcompte;
    }
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPass() {
        return this.pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getStatut() {
        return this.statut;
    }
    
    public void setStatut(String statut) {
        this.statut = statut;
    }




}


