/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.model.dao;

import com.alumni.model.entities.Etudiant;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author compte utilisateur
 */
public class Etudiant_Search_Service implements DAO_Etudiant_Search_Service {

    Transaction transaction;
    Session session;

    public Etudiant_Search_Service() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    /**
     *
     * @param mail, donnée normalement unique.
     * @return un étudiant par rapport à un mail
     */
    @Override
    public ArrayList<Etudiant> searchByMail(String mail) {
        System.out.println("DAO searchByMail");
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            System.out.println("Etudiant_Search_Service searchByMail: entre dans chercheByMail mail =" + mail);
            ArrayList<Etudiant> results =
                    (ArrayList<Etudiant>) session.createQuery("from Etudiant as e where e.mail like '" + mail + "'").list();
            System.out.println("searchByMail result = " + results);
            return results;
        } catch (Exception e) {
            System.out.println("Etudiant_Search_Service searchByMail: entre dans l'exception = " + e);
            return null;
        }
    }

    /**
     *
     * @return l'ensemble des étudiants existants
     */
    @Override
    public ArrayList<Etudiant> searchAllEtudiant() {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            ArrayList<Etudiant> results =
                    (ArrayList<Etudiant>) session.createQuery("from Etudiant").list();
            System.out.println("searchAllEtudiant result = " + results);
            return results;
        } catch (Exception e) {
            System.out.println("Etudiant_Search_Service searchAllEtudiant: entre dans l'exception = " + e);
            return null;
        }
    }

    @Override
    public ArrayList<Etudiant> searchByName(String name) {
        System.out.println("DAO searchByName");
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            System.out.println("Etudiant_Search_Service searchByNAME: entre dans chercheByMail name =" + name);
            ArrayList<Etudiant> results =
                    (ArrayList<Etudiant>) session.createQuery("from Etudiant as e where e.nom like '%" + name + "%'").list();
            System.out.println("searchByMail result = " + results);
            return results;
        } catch (Exception e) {
            System.out.println("Etudiant_Search_Service searchByName: entre dans l'exception = " + e);
            return null;
        }
    }
}
