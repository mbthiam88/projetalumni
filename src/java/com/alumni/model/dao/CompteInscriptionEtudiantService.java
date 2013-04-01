/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.model.dao;

import com.alumni.model.entities.Compte;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author thiam
 */
public class CompteInscriptionEtudiantService {

    Transaction transaction;
    Session session;

    public CompteInscriptionEtudiantService() {
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public void ajouterCompte(Compte compte) {
         Transaction trns = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(compte);
            session.getTransaction().commit();
            System.out.println("______________OK");
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
}
