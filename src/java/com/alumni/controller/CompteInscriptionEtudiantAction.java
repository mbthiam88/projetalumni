/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.controller;

import com.alumni.model.dao.CompteInscriptionEtudiantService;
import com.alumni.model.entities.Compte;
import com.alumni.model.entities.Etudiant;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.validator.EmailValidator;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author thiam
 */
public class CompteInscriptionEtudiantAction extends DispatchAction {

    CompteInscriptionEtudiantService service = new CompteInscriptionEtudiantService();


    public ActionForward ajouter(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm inscriptioEtudiant = (DynaActionForm) form;
        
        String nom = (String) inscriptioEtudiant.get("nom");
        String prenom = (String) inscriptioEtudiant.get("prenom");
        String mail = (String) inscriptioEtudiant.get("mail");
        String mail2 = (String) inscriptioEtudiant.get("mail2");
        String pass = (String) inscriptioEtudiant.get("pass");
        String statut = (String) inscriptioEtudiant.get("statut");
        
        java.sql.Date date = (java.sql.Date) inscriptioEtudiant.get("dateNaissance");
        
        String genre = (String) inscriptioEtudiant.get("genre");
        
        System.out.println("L: "+date);
        
        java.sql.Date dateNaissance = new java.sql.Date(date.getTime());
        java.sql.Date aujourdhui = new java.sql.Date(new Date().getTime());
        System.out.println("L: "+dateNaissance);
        System.out.println("L: "+aujourdhui);
        
        
//        System.out.println(nom);
//        System.out.println(prenom);
//        System.out.println(mail);
//        System.out.println(mail2);
//        System.out.println(pass);
//        System.out.println(statut);
//        System.out.println(dateNaissance);
//        System.out.println(aujourdhui);
//        System.out.println(date);
//        System.out.println(genre);

        ActionErrors errors = new ActionErrors();
        if (nom == null || nom.equals("")) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.nomEtudiant.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.getInput()));
        } else if (prenom == null || prenom.equals("")) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.prenomEtudiant.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.getInput()));
        }  else if (mail == null || mail.equals("")) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.mailEtudiant.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.getInput()));
        } else if (CompteInscriptionEtudiantAction.validateEmailAddress(mail) != true) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.invalidMail.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.getInput()));
        } else if (!mail.equals(mail2)) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.mailNonIdemtique.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.getInput()));
        }else if (pass == null || pass.equals("")) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.passEtudiant.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.getInput()));
        }else if (String.valueOf(dateNaissance).equals(String.valueOf(aujourdhui))) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.dateNaissance.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.getInput()));
        }
        //Set du compte
        Compte compte = new Compte();
        compte.setLogin(mail);
        compte.setPass(pass);
        compte.setStatut(statut);
        service.ajouterCompte(compte);

        //set de l'étudiant
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setMail(mail);
        etudiant.setGenre(genre);
        etudiant.setDatedenaissance(dateNaissance);



        System.out.println("ffffffffffff" + compte.getIdcompte());
        int idCompte = compte.getIdcompte();
        etudiant.setIdcompte(idCompte);
        service.ajouterEtudiant(etudiant);
        System.out.println("_______________________________");

        return mapping.findForward("CompteAcceuil");

    }

    public static boolean validateEmailAddress(String votreEmail) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        return emailValidator.isValid(votreEmail);
    }
}
