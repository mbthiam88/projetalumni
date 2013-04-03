package com.alumni.model.entities;
// Generated 2 avr. 2013 12:32:25 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Poste generated by hbm2java
 */
public class Poste  implements java.io.Serializable {


     private int idposte;
     private String intitule;
     private String description;
     private String localisation;
     private Date datedebut;
     private Double salaire;

    public Poste() {
    }

	
    public Poste(int idposte, String localisation) {
        this.idposte = idposte;
        this.localisation = localisation;
    }
    public Poste(int idposte, String intitule, String description, String localisation, Date datedebut, Double salaire) {
       this.idposte = idposte;
       this.intitule = intitule;
       this.description = description;
       this.localisation = localisation;
       this.datedebut = datedebut;
       this.salaire = salaire;
    }
   
    public int getIdposte() {
        return this.idposte;
    }
    
    public void setIdposte(int idposte) {
        this.idposte = idposte;
    }
    public String getIntitule() {
        return this.intitule;
    }
    
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getLocalisation() {
        return this.localisation;
    }
    
    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
    public Date getDatedebut() {
        return this.datedebut;
    }
    
    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }
    public Double getSalaire() {
        return this.salaire;
    }
    
    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }




}


