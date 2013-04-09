/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.model.dao;

import com.alumni.model.entities.Compte;
import com.alumni.model.entities.Etudiant;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author compte utilisateur
 */
public class Compte_Search_Service implements DAO_Compte_Search_Service {

    Transaction transaction;
    Session session;

    public Compte_Search_Service() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    /**
     *
     * @param mail, données normalement unique.
     * @return un étudiant par rapport à un mail
     */
    @Override
    public ArrayList<Compte> searchCompteByLogin(String login) {
        System.out.println("DAO searchByMail");
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            ArrayList<Compte> results =
                    (ArrayList<Compte>) session.createQuery("from Compte as e where e.login like '" + login + "'").list();
            System.out.println("searchByMail result = " + results);
            return results;
        } catch (Exception e) {
            System.out.println("Etudiant_Search_Service searchByMail: entre dans l'exception = " + e);
            return null;
        }
    }
}