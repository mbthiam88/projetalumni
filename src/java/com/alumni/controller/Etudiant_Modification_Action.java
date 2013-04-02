/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.controller;

import com.alumni.model.dao.EtudiantModificationCompteService;
import com.alumni.model.dao.Etudiant_Search_Service;
import com.alumni.model.entities.Etudiant;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

/**
 *
 * @author compte utilisateur
 */
public class Etudiant_Modification_Action extends Action {

    EtudiantModificationCompteService service = new EtudiantModificationCompteService();
    Etudiant_Search_Service serviceRecherche = new Etudiant_Search_Service();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        DynaActionForm modificationEtudiant = (DynaActionForm) form;
        String mail = (String) request.getSession().getValue("mail");
        ArrayList<Etudiant> etu = serviceRecherche.searchByMail(mail);
        if (!etu.isEmpty()) {
            if (!modificationEtudiant.get("nom").equals("")) {
                System.out.println("bouton1 = " + modificationEtudiant.get("nom").toString());
                etu.get(0).setNom(modificationEtudiant.get("nom").toString());
            }
            if (!modificationEtudiant.get("prenom").equals("")) {
                System.out.println("bouton2 = " + modificationEtudiant.get("prenom").toString());
                etu.get(0).setPrenom(modificationEtudiant.get("prenom").toString());
            }
            if (!modificationEtudiant.get("adresse").equals("")) {
                System.out.println("bouton3 = " + modificationEtudiant.get("adresse").toString());
                etu.get(0).setAdresse(modificationEtudiant.get("adresse").toString());
            }
            if (!modificationEtudiant.get("telephone").equals("")) {
                System.out.println("bouton4 = " + modificationEtudiant.get("telephone").toString());
                etu.get(0).setTel(modificationEtudiant.get("telephone").toString());
//                service.modificationEtudiant(etu.get(0));
            }
            if (!modificationEtudiant.get("dateNaissance").equals("")) {
                //datenaissance ATTENTION A CHANGER RISQUE !!!
                return mapping.findForward("erreur");
            }
            if (!modificationEtudiant.get("poste").equals("")) {
                //poste actuel
                return mapping.findForward("erreur");
            }
            if (!modificationEtudiant.get("photoProfil").equals("")) {
                //photo profil
                return mapping.findForward("erreur");
            }
            System.out.println("entre dans modification ---------");
            service.modificationEtudiant(etu.get(0));
            System.out.println("finis dans modification ---------");
            return (new ActionForward(mapping.getInputForward()));
        }
        return mapping.findForward("erreur");
    }
}
