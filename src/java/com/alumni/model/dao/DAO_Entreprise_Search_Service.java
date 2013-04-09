/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.model.dao;

import com.alumni.model.entities.Entreprise;

/**
 *
 * @author compte utilisateur
 */
public interface DAO_Entreprise_Search_Service {
    
    public Entreprise searchCompteByMail(String mail);
    
}
