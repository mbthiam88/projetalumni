/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.model.dao;

import com.alumni.model.entities.Etudiant;
import com.alumni.model.entities.RelationEtudiant;
import com.alumni.model.entities.RelationEtudiantId;
import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.Query;
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
     * Les mail sont unique, donc on recherche juste ici un étudiant
     *
     * @param mail, données normalement unique.
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

    /**
     * cherche tous les étudiants en fonction d'une chaine de caractère
     *
     * @param name
     * @return une arrayliste d'étudiant contenant au moins la chaine name
     */
    @Override
    public ArrayList<Etudiant> searchByName(String name) {
        System.out.println("DAO searchByName");
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            System.out.println("Etudiant_Search_Service searchByNAME: entre dans chercheByMail name =" + name);
            ArrayList<Etudiant> results =
                    (ArrayList<Etudiant>) session.createQuery("from Etudiant as e where LOWER(e.nom) like"
                    + " '%" + name.toLowerCase() + "%'").list();
            return results;
        } catch (Exception e) {
            System.out.println("Etudiant_Search_Service searchByName: entre dans l'exception = " + e);
            return null;
        }
    }

    /**
     * cherche les autres étudiant (hormis sois même)
     *
     * @param name nom que l'étudiant cherche
     * @param mail mail représentant l'utilisateur effectuant la recherche
     * @return
     */
    @Override
    public ArrayList<Etudiant> searchOtherByName(String name, String mail) {
        System.out.println("DAO searchOtherByName");
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            System.out.println("Etudiant_Search_Service searchByNAME: entre dans chercheByMail name =" + name);
            System.out.println("Etudiant_Search_Service searchByNAME: entre dans chercheByMail mail =" + mail);
            ArrayList<Etudiant> results =
                    (ArrayList<Etudiant>) session.createQuery("from Etudiant as e where LOWER(e.nom) like"
                    + " '%" + name.toLowerCase() + "%' and e.mail not like '" + mail + "'").list();
            return results;
        } catch (Exception e) {
            System.out.println("Etudiant_Search_Service searchByName: entre dans l'exception = " + e);
            return null;
        }
    }

    /**
     * renvoi l'arraylist des id avec qui notre étudiant est déja en contact //
     * vérifie si l'autre étudiant lui a envoyé une demande d'ajout // vérifie
     * si il a envoyé à l'autre étudiant une demande d'ajout
     *
     * @param id
     * @return arrayList de identifiant des personnes avec qui il est connecté.
     */
    public ArrayList<Etudiant> searchRelation(Integer id) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {


            transaction = session.beginTransaction();
            ArrayList<Integer> results = new ArrayList<Integer>();
            ArrayList<Integer> query1 =
                    (ArrayList<Integer>) session.createSQLQuery("Select e.idetudiant2 from ALUMNI.Relation_Etudiant as e where e.idetudiant1 = " + id).list();
            for (int i = 0; i < query1.size(); i = i + 1) {
                results.add(query1.get(i));
            }
            ArrayList<Integer> query2 =
                    (ArrayList<Integer>) session.createSQLQuery("Select e.idetudiant1 from ALUMNI.Relation_Etudiant as e where e.idetudiant2 = " + id).list();
            for (int i = 0; i < query2.size(); i = i + 1) {
                results.add(query2.get(i));
            }

            return searchEtudiantsWithIdCollection(results);
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<Etudiant> searchEtudiantsWithIdCollection(ArrayList<Integer> listId) {
        ArrayList<Etudiant> results = new ArrayList<Etudiant>();
        for (int i = 0; i < listId.size(); i++) {
            Etudiant etudiant = (Etudiant) session.createQuery("from Etudiant as e where e.idetudiant =" + listId.get(i)).uniqueResult();
            results.add(etudiant);
        }
        System.out.println("TAILLE = " + results.size());
        if (results.size() > 0) {
            System.out.println("idEtudiant = " + results.get(0).getIdetudiant());
        }
        return results;
    }
}
