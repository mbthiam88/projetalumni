/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rh.model.dao;

/**
 *
 * @author compte utilisateur
 */
public interface EtudiantLoginServiceDAO {
    public boolean authentificate(String nom, String mdp);
}