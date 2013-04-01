/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.controller;

import com.alumni.model.dao.CompteInscriptionEtudiantService;
import com.alumni.model.entities.Compte;
import com.alumni.model.entities.Compte;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.DynaActionForm;

/**
 *
 * @author thiam
 */
public class CompteInscriptionEtudiantAction extends Action {

    CompteInscriptionEtudiantService service = new CompteInscriptionEtudiantService();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm inscriptioEtudiant = (DynaActionForm) form;
        String nom = (String) inscriptioEtudiant.get("nom");
        String prenom = (String) inscriptioEtudiant.get("prenom");
        String mail = (String) inscriptioEtudiant.get("mail");
        String pass = (String) inscriptioEtudiant.get("pass");
        String statut = (String) inscriptioEtudiant.get("statut");

        ActionErrors errors = new ActionErrors();
        if (nom == null || nom.equals("")) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.nomEtudiant.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.getInput()));
        }  else if (prenom == null || prenom.equals("")) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.prenomEtudiant.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.getInput()));
        } else if (pass == null || pass.equals("")) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.passEtudiant.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.getInput()));
        } else if (mail == null || mail.equals("")) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.mailEtudiant.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.getInput()));
        } 
        Compte compte = new Compte();
        compte.setLogin(mail);
        compte.setPass(pass);
        compte.setStatut(statut);
        service.ajouterCompte(compte);
        System.out.println("_______________________________");
        
        return  mapping.findForward("CompteLoginSuccess");

    }
}
