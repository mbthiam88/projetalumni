/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.model.dao;

import com.alumni.model.entities.Etudiant;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author compte utilisateur
 */
public class EtudiantModificationCompteService implements DAO_EtudiantModificationCompteService{

    Transaction transaction;
    Session session;

    public EtudiantModificationCompteService() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public void modificationEtudiant(Etudiant etudiant) {
        System.out.println("session : "+session);
        session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("session : "+session);
        try {
            transaction = session.beginTransaction();
            System.out.println("transaction : "+transaction);
            System.out.println("etudiant : "+etudiant);
            session.update(etudiant);   
            System.out.println("transaction : "+session);

            session.getTransaction().commit();
            System.out.println("Lahoucine");
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } 
    }
}
