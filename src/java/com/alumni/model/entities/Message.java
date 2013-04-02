package com.alumni.model.entities;
// Generated 2 avr. 2013 10:45:10 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Message generated by hbm2java
 */
public class Message  implements java.io.Serializable {


     private int idmessage;
     private int idcompteemmetteur;
     private int idcomptedestinataire;
     private Date dateenvoie;
     private String message;

    public Message() {
    }

	
    public Message(int idmessage, int idcompteemmetteur, int idcomptedestinataire, String message) {
        this.idmessage = idmessage;
        this.idcompteemmetteur = idcompteemmetteur;
        this.idcomptedestinataire = idcomptedestinataire;
        this.message = message;
    }
    public Message(int idmessage, int idcompteemmetteur, int idcomptedestinataire, Date dateenvoie, String message) {
       this.idmessage = idmessage;
       this.idcompteemmetteur = idcompteemmetteur;
       this.idcomptedestinataire = idcomptedestinataire;
       this.dateenvoie = dateenvoie;
       this.message = message;
    }
   
    public int getIdmessage() {
        return this.idmessage;
    }
    
    public void setIdmessage(int idmessage) {
        this.idmessage = idmessage;
    }
    public int getIdcompteemmetteur() {
        return this.idcompteemmetteur;
    }
    
    public void setIdcompteemmetteur(int idcompteemmetteur) {
        this.idcompteemmetteur = idcompteemmetteur;
    }
    public int getIdcomptedestinataire() {
        return this.idcomptedestinataire;
    }
    
    public void setIdcomptedestinataire(int idcomptedestinataire) {
        this.idcomptedestinataire = idcomptedestinataire;
    }
    public Date getDateenvoie() {
        return this.dateenvoie;
    }
    
    public void setDateenvoie(Date dateenvoie) {
        this.dateenvoie = dateenvoie;
    }
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }




}


