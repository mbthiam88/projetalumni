/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.model.dao;

import com.alumni.model.entities.Etudiant;
import com.alumni.model.entities.HistoriqueEtudiantPoste;
import com.alumni.model.entities.HistoriqueEtudiantPosteId;
import com.alumni.model.entities.Poste;
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

    @Override
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
            System.out.println("LE COMPTE A ETE MODIFIE");
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } 
    }

    @Override
    public void createPoste(Poste poste) {
        System.out.println("session DEBUT --> "+session);
        session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("session FIN --> "+session);
        try {
            transaction = session.beginTransaction();
            System.out.println("transaction --> "+transaction);
            System.out.println("etudiant --> "+poste);
            session.save(poste);   
            System.out.println("transaction --> "+session);
            session.getTransaction().commit();
            System.out.println("LE POSTE A ETE MODIFIE");
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } 
    }
        @Override
    public void updatePoste(Poste poste) {
        System.out.println("session DEBUT --> "+session);
        session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("session FIN --> "+session);
        try {
            transaction = session.beginTransaction();
            System.out.println("transaction --> "+transaction);
            System.out.println("etudiant --> "+poste);
            session.update(poste);   
            System.out.println("transaction --> "+session);
            session.getTransaction().commit();
            System.out.println("LE POSTE A ETE MODIFIE");
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } 
    }

    @Override
    public void createHistoriqueEtudiantPoste(HistoriqueEtudiantPoste hist_etudiant_poste) {
        System.out.println("SESSION DEBUT --> "+session.toString());
        session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("SESSION FIN --> "+session.toString());
        try {
            transaction = session.beginTransaction();
            System.out.println("TRANSACTION DEBUT --> "+transaction.toString());
            System.out.println("HISTO_ETUDIANT_POSTE --> "+hist_etudiant_poste);
            session.save(hist_etudiant_poste);   
            System.out.println("TRANSACTION FIN --> "+transaction.toString());
            session.getTransaction().commit();
            System.out.println("L'HISTO_ETUDIANT_POSTE A ETE MODIFIE");
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } 
    }
        
        
}
