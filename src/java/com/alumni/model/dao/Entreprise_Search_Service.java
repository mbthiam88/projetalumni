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
public class Entreprise_Search_Service implements DAO_Entreprise_Search_Service {

    Transaction transaction;
    Session session;
    
    public Entreprise_Search_Service(){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @Override
    public Entreprise searchCompteByMail(String mail) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Entreprise compte =
                    (Entreprise) session.createQuery("from Entreprise as e where e.mail like '" + mail + "'").uniqueResult();
            return compte;
        } catch (Exception e) {
            System.out.println("Etudiant_Search_Service searchByMail: entre dans l'exception = " + e);
            return null;
        }
        
    }
}
