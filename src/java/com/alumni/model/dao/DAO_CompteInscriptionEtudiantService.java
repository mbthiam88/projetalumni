/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.model.dao;

import com.alumni.model.entities.Compte;
import com.alumni.model.entities.Etudiant;
import org.apache.commons.validator.EmailValidator;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author compte utilisateur
 */
public interface DAO_CompteInscriptionEtudiantService {
    
    public void ajouterCompte(Compte compte);
    
    public void ajouterEtudiant(Etudiant etudiant);
    
    public boolean validateEmailAddress(String votreEmail);
}
