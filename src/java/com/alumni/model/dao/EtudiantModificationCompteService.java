/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author compte utilisateur
 */
public class EtudiantModificationCompteService {

    Transaction transaction;
    Session session;
    
     public EtudiantModificationCompteService() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
     
     public void modificationNom(String nom){
          session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
//            session.save(compte);
            session.getTransaction().commit();
            System.out.println("______________OK");
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            //session.close();
        }
     }
     
     public void modificationPrenom(String nom){
         
     }
     
     public void modificationMail(String nom){
         
     }
     
     public void modificationAdresse(String nom){
         
     }
     
     public void modificationTelephone(String nom){
         
     }
}
