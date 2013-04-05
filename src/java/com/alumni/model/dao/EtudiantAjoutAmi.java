/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.model.dao;

import com.alumni.model.entities.RelationEtudiantId;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author compte utilisateur
 */
public class EtudiantAjoutAmi implements DAO_EtudiantAjoutAmi {

    Transaction transaction;
    Session session;

    public EtudiantAjoutAmi() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @Override
    public void ajoutAmiEtudiant(RelationEtudiantId relationEtudiantId) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(relationEtudiantId);
            System.out.println("transaction : " + session);

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
