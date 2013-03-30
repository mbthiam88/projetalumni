package com.alumni.model.entities;
// Generated 30 mars 2013 12:40:35 by Hibernate Tools 3.2.1.GA



/**
 * Entreprise generated by hbm2java
 */
public class Entreprise  implements java.io.Serializable {


     private int identreprise;
     private int idcompte;
     private String nomresponsable;
     private String siteweb;
     private String nomentreprise;
     private String adressesiege;
     private String mail;
     private Integer tel;

    public Entreprise() {
    }

	
    public Entreprise(int identreprise, int idcompte, String nomresponsable, String mail) {
        this.identreprise = identreprise;
        this.idcompte = idcompte;
        this.nomresponsable = nomresponsable;
        this.mail = mail;
    }
    public Entreprise(int identreprise, int idcompte, String nomresponsable, String siteweb, String nomentreprise, String adressesiege, String mail, Integer tel) {
       this.identreprise = identreprise;
       this.idcompte = idcompte;
       this.nomresponsable = nomresponsable;
       this.siteweb = siteweb;
       this.nomentreprise = nomentreprise;
       this.adressesiege = adressesiege;
       this.mail = mail;
       this.tel = tel;
    }
   
    public int getIdentreprise() {
        return this.identreprise;
    }
    
    public void setIdentreprise(int identreprise) {
        this.identreprise = identreprise;
    }
    public int getIdcompte() {
        return this.idcompte;
    }
    
    public void setIdcompte(int idcompte) {
        this.idcompte = idcompte;
    }
    public String getNomresponsable() {
        return this.nomresponsable;
    }
    
    public void setNomresponsable(String nomresponsable) {
        this.nomresponsable = nomresponsable;
    }
    public String getSiteweb() {
        return this.siteweb;
    }
    
    public void setSiteweb(String siteweb) {
        this.siteweb = siteweb;
    }
    public String getNomentreprise() {
        return this.nomentreprise;
    }
    
    public void setNomentreprise(String nomentreprise) {
        this.nomentreprise = nomentreprise;
    }
    public String getAdressesiege() {
        return this.adressesiege;
    }
    
    public void setAdressesiege(String adressesiege) {
        this.adressesiege = adressesiege;
    }
    public String getMail() {
        return this.mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }
    public Integer getTel() {
        return this.tel;
    }
    
    public void setTel(Integer tel) {
        this.tel = tel;
    }




}


