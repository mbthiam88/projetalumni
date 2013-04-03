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
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.hibernate.Session;

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
        
        HttpSession session = request.getSession(); 
        DynaActionForm modificationEtudiant = (DynaActionForm) form;
        // faire test if mail = null
        String mail = (String) request.getSession().getValue("mail");
        ArrayList<Etudiant> etu = serviceRecherche.searchByMail(mail);
        if (!etu.isEmpty()) {
            if (!modificationEtudiant.get("nom").equals("")) {
                etu.get(0).setNom(modificationEtudiant.get("nom").toString());
                session.setAttribute("nom", modificationEtudiant.get("nom").toString());
            }
            if (!modificationEtudiant.get("prenom").equals("")) {
                etu.get(0).setPrenom(modificationEtudiant.get("prenom").toString());
                session.setAttribute("prenom", modificationEtudiant.get("prenom").toString());
            }
            if (!modificationEtudiant.get("adresse").equals("")) {
//                System.out.println("bouton3 = " + modificationEtudiant.get("adresse").toString());
                etu.get(0).setAdresse(modificationEtudiant.get("adresse").toString());
                session.setAttribute("adresse", modificationEtudiant.get("adresse").toString());
            }
            if (!modificationEtudiant.get("telephone").equals("")) {
//                System.out.println("bouton4 = " + modificationEtudiant.get("telephone").toString());
                etu.get(0).setTel(modificationEtudiant.get("telephone").toString());
                session.setAttribute("telephone", modificationEtudiant.get("telephone").toString());
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
            service.modificationEtudiant(etu.get(0));
            return (new ActionForward(mapping.getInputForward()));
        }
        return mapping.findForward("erreur");
    }
}
