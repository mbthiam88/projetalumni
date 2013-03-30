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
public class EtudiantLoginService implements EtudiantLoginServiceDAO {

    Transaction transaction;
    Session session;

    public EtudiantLoginService() {
        session=HibernateUtil.getSessionFactory().getCurrentSession();
        System.out.println("EtudiantLoginService's constructeur");
    }
    
    @Override
    @SuppressWarnings("IncompatibleEquals")
    public boolean authentificate(String nom, String mdp) {
        transaction = session.beginTransaction();
        @SuppressWarnings("UnusedAssignment")
        ArrayList<Etudiant> arraylist = new ArrayList<Etudiant>();
        arraylist = (ArrayList<Etudiant>) session.createQuery("from Etudiant where name like '"+nom+"'").list();
        System.out.println("arrayliste taille : "+arraylist.size());
        System.out.println("arrayliste emt : "+arraylist.get(0).getName());
        System.out.println();
        if(!arraylist.isEmpty() && mdp.equals(arraylist.get(0).getMotDePasse())){
        return true;
        }else{
            return false;
        }
    }
    
}
