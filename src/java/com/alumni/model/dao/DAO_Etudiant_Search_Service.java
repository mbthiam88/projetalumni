/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.model.dao;

import com.alumni.model.entities.Etudiant;
import java.util.ArrayList;
import org.hibernate.Transaction;

/**
 *
 * @author compte utilisateur
 */
public interface DAO_Etudiant_Search_Service {

    public ArrayList<Etudiant> searchByMail(String mail);

    public ArrayList<Etudiant> searchAllEtudiant();

    public ArrayList<Etudiant> searchByName(String name);

    public ArrayList<Etudiant> searchOtherByName(String name, String mail);

    public ArrayList<Etudiant> searchRelation(Integer id);
    
    public ArrayList<Etudiant> searchEtudiantsWithIdCollection(ArrayList<Integer> listId);
}
