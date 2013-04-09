/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.model.dao;

import com.alumni.model.entities.Compte;
import com.alumni.model.entities.Etudiant;
import com.alumni.model.entities.Poste;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author compte utilisateur
 */
public interface DAO_Compte_Search_Service{

    public ArrayList<Compte> searchCompteByLogin(String login);
    
    public ArrayList<Poste> searchPosteByIdPoste(Integer idCompte);
    
}
