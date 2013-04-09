/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.model.dao;

import com.alumni.model.entities.Etudiant;
import com.alumni.model.entities.HistoriqueEtudiantPoste;
import com.alumni.model.entities.Poste;

/**
 *
 * @author compte utilisateur
 */
public interface DAO_EtudiantModificationCompteService {

    public void modificationEtudiant(Etudiant etudiant);
    
    public void createPoste(Poste poste);
    
    public void updatePoste(Poste poste);
    
    public void createHistoriqueEtudiantPoste(HistoriqueEtudiantPoste hist_etudiant_poste);
}
