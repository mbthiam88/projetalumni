/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.model.dao;

import com.alumni.model.entities.Entreprise;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author compte utilisateur
 */
public class EntrepriseModificationCompteService implements DAO_EntrepriseModificationCompteService{

    Transaction transaction;
    Session session;

    public EntrepriseModificationCompteService() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @Override
    public void updateEntreprise(Entreprise entreprise) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(entreprise);   
            session.getTransaction().commit();
            System.out.println("L'ENTREPRISE A ETE MODIFIE");
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } 
    }        
}
