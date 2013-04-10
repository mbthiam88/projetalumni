/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.model.dao;

import com.alumni.model.entities.Compte;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Housse
 */
public class CompteLoginService implements DAO_CompteLoginService {

    Transaction transaction;
    Session session;

    public CompteLoginService() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @Override
    public String authentificate(String login, String pass) {
        System.out.println("Je rentre la méthode authentificate de la classe CompteLoginService()");
        transaction = session.beginTransaction();
        Compte compte = (Compte) session.createQuery("from Compte where login like '" + login + "'").uniqueResult();
//        System.out.println("Taille du tableau de résultat dela réquête: "+results.size());
        if (compte == null) {
            System.out.println("Je retourne \"Aucun Compte trouvé\" dans la méthode authentificate()");
            return "Aucun Compte trouvé";
        } else if (pass.equals(compte.getPass())) {
            System.out.println("ok");
            return "Un Compte trouve et c'est le bon Pass";
        } else {
            System.out.println("Je retourne \"Erreur\" dans la méthode authentificate()");
            return "Erreur";
        }
    }
}
