package com.rh.model.entities;
// Generated 29 mars 2013 11:16:42 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Promotion generated by hbm2java
 */
public class Promotion  implements java.io.Serializable {


     private int idpromotion;
     private Date annee;
     private String type;

    public Promotion() {
    }

    public Promotion(int idpromotion, Date annee, String type) {
       this.idpromotion = idpromotion;
       this.annee = annee;
       this.type = type;
    }
   
    public int getIdpromotion() {
        return this.idpromotion;
    }
    
    public void setIdpromotion(int idpromotion) {
        this.idpromotion = idpromotion;
    }
    public Date getAnnee() {
        return this.annee;
    }
    
    public void setAnnee(Date annee) {
        this.annee = annee;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }




}


