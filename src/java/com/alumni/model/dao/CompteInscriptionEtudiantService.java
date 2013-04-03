/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.model.dao;

import com.alumni.model.entities.Compte;
import com.alumni.model.entities.Etudiant;
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
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    
    public void ajouterCompte(Compte compte) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(compte);
            session.getTransaction().commit();
            System.out.println("COMPTE_________OK");
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
    
    public void ajouterEtudiant(Etudiant etudiant) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(etudiant);
            session.getTransaction().commit();
            System.out.println("ETUDIANT__________OK");
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
}
