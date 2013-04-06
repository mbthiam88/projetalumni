/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.controller;

import com.alumni.model.dao.DAO_CompteInscriptionEtudiantService;
import com.alumni.model.entities.Compte;
import com.alumni.model.entities.Entreprise;
import com.alumni.model.entities.Etudiant;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author compte utilisateur
 */
public class Controller_Compte_Entreprise extends DispatchAction {

    private HttpSession session;

    public ActionForward createEntreprise(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAO_CompteInscriptionEtudiantService service =
                (DAO_CompteInscriptionEtudiantService) ServiceFactory.instantiate("com.alumni.model.dao.CompteInscriptionEtudiantService");

        DynaActionForm inscireEntreprise = (DynaActionForm) form;

        String nomEntreprise = (String) inscireEntreprise.get("nomEntreprise");
        String mailEntreprise = (String) inscireEntreprise.get("mailEntreprise");
        String mailEntreprise2 = (String) inscireEntreprise.get("mailEntreprise2");
        String siteWebEntreprise = (String) inscireEntreprise.get("siteWebEntreprise");
        String statut = (String) inscireEntreprise.get("statut");
        String motDePasse = (String) inscireEntreprise.get("motDePasse");

        System.out.println("Nom"+nomEntreprise);
        System.out.println("Mail"+mailEntreprise);
        System.out.println("Mail2"+mailEntreprise2);
        System.out.println("Site Web"+siteWebEntreprise);
        System.out.println("Satut"+statut);
        System.out.println("Mot de passe"+motDePasse);

        ActionErrors errors = new ActionErrors();

        if (nomEntreprise == null || nomEntreprise.equals("")) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.nomEntreprise.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.findForward("inscriptionEntreprise")));
        } else if (siteWebEntreprise == null || siteWebEntreprise.equals("")) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.siteWebEntreprise.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.findForward("inscriptionEntreprise")));
        } else if (mailEntreprise == null || mailEntreprise.equals("")) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.mailEntreprise.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.findForward("inscriptionEntreprise")));
        } else if (service.validateEmailAddress(mailEntreprise) != true) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.invalidMail.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.findForward("inscriptionEntreprise")));
        } else if (mailEntreprise2 == null || mailEntreprise2.equals("")) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.mailEntreprise2.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.findForward("inscriptionEntreprise")));
        } else if (!mailEntreprise2.equals(mailEntreprise)) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.mailNonIdemtique.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.findForward("inscriptionEntreprise")));
        } else if (motDePasse.equals("")) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.motDePasse.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.findForward("inscriptionEntreprise")));
        }
        //Set du compte
        Compte compte = new Compte();
        compte.setLogin(mailEntreprise);
        compte.setPass(motDePasse);
        compte.setStatut(statut);
        service.ajouterCompte(compte);

        //set de l'étudiant
        Entreprise entreprise = new Entreprise();
        entreprise.setNomentreprise(nomEntreprise);
        entreprise.setMail(mailEntreprise);
        entreprise.setSiteweb(siteWebEntreprise);


        System.out.println("ffffffffffff" + compte.getIdcompte());
        int idCompte = compte.getIdcompte();
        entreprise.setIdcompte(idCompte);
        service.ajouterEntreprise(entreprise);
        
        return (new ActionForward(mapping.findForward("inscriptionEntreprise")));

    }
}
