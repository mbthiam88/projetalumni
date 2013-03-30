/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.model.dao;

import com.alumni.model.entities.CompteLogin;
import com.alumni.model.entities.Etudiant;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Housse
 */
public class CompteLoginService implements CompteLoginServiceDAO{
    Transaction transaction;
    Session session;

    public CompteLoginService() {
        session=HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    @Override
    public String authentificate(String login, String pass) {
        System.out.println("Je rentre la méthode authentificate de la classe CompteLoginService()");
        transaction = session.beginTransaction();
        ArrayList<CompteLogin> results = (ArrayList<CompteLogin>) session.createQuery("from CompteLogin where login like '"+login+"'").list();
        System.out.println("Taille du tableau de résultat dela réquête: "+results.size());
        if(!results.isEmpty()){
            CompteLogin compteLogin = results.get(0);
            System.out.println("CompteLogin trouvé dans la base: ");
            System.out.println("Login: "+compteLogin.getLogin());
        }
        if( results.size()==1 
         && pass.equals(results.get(0).getPass())
           ){
            System.out.println("Je retourne \"Un Compte trouvé et c'est le bon Pass\" dans la méthode authentificate()");
            
            System.out.println(results.get(0).getPass());
            return "Un Compte trouve et c'est le bon Pass";
        }
        else if(results.isEmpty()){
            System.out.println("Je retourne \"Aucun Compte trouvé\" dans la méthode authentificate()");
            return "Aucun Compte trouvé";
        }
        else if(results.size() > 1){
            System.out.println("Je retourne \"Plusieurs Comptes trouvés\" dans la méthode authentificate()");
            return "Plusieurs Comptes trouvés";
        }
        else{
            System.out.println("Je retourne \"Erreur\" dans la méthode authentificate()");
            return "Erreur";
        }
    }
    
}
