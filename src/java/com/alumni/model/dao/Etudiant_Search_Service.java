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
public class Etudiant_Search_Service {

    Transaction transaction;
    Session session;

    public Etudiant_Search_Service() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public ArrayList<Etudiant> searchByMail(String mail) {
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            System.out.println("entre dans chercheByMail");
            ArrayList<Etudiant> results = 
               (ArrayList<Etudiant>)  session.createQuery("from Etudiant as e where e.mail like '"+mail+"'").list();
            System.out.println("result = "+results);
            return results;
        }catch (Exception e){
            System.out.println("entre dans l'exception = "+e);
            return null;
        }
    }
}
