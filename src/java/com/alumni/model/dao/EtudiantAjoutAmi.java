/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.model.dao;

import com.alumni.model.entities.RelationEtudiant;
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
    public void ajoutAmiEtudiant(RelationEtudiant relationEtudiant) {
        System.out.println("methode ajoutAmiEtudiant ="+relationEtudiant.getId().getIdetudiant1());
        System.out.println("methode ajoutAmiEtudiant ="+relationEtudiant.getId().getIdetudiant2());
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(relationEtudiant);
            System.out.println("transaction Ajout Ami Etudiant: " + session);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
