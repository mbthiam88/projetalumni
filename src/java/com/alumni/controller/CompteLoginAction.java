/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.controller;

import com.alumni.model.dao.CompteLoginService;
import com.alumni.model.dao.Compte_Search_Service;
import com.alumni.model.dao.Etudiant_Search_Service;
import com.alumni.model.entities.Compte;
import com.alumni.model.entities.Etudiant;
import com.alumni.view.CompteLoginForm;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.validator.EmailValidator;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Housse
 */
public class CompteLoginAction extends Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private HttpSession session;
    private ActionErrors erreurs;
    
    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // Service pour l'authentification d'un compte
        CompteLoginService compteLoginService = new CompteLoginService();
        // Service pour la recherche d'un compte
        Compte_Search_Service compteSearchService = new Compte_Search_Service();
        // Service pour la recherche d'un Etudiant
        Etudiant_Search_Service etudiantSearchService = new Etudiant_Search_Service();
        // Récupération infos formulaire
        CompteLoginForm compteLoginForm = (CompteLoginForm) form;
        String login = compteLoginForm.getLogin();
        String pass = compteLoginForm.getPass();
        // Récupération de la Session courrante
        session = request.getSession();
        // Initialisation ActionErrors
        erreurs = new ActionErrors();
        // Validation des champs remplis
        if (!validateMail(login)) {
            saveErrors(request, erreurs);
            return mapping.getInputForward();
        } 
        if (!validatePass(pass)) {
            saveErrors(request, erreurs);
            return mapping.getInputForward();
        }
        // Authentification
        if (compteLoginService.authentificate(login, pass).equals("Un Compte trouve et c'est le bon Pass")) {
            session.setAttribute("mail", login);
            Compte compte = compteSearchService.searchCompteByLogin(login).get(0);
//            if(compte.getStatut().equals("ETUDIANT")){
            ArrayList<Etudiant> etudiant = etudiantSearchService.searchByMail(login);
            session.setAttribute("nom", etudiant.get(0).getNom());
            session.setAttribute("prenom", etudiant.get(0).getPrenom());
            if(etudiant.get(0).getAdresse() != null){
                session.setAttribute("adresse", etudiant.get(0).getAdresse());
            }
            if(etudiant.get(0).getTel() != null){
                session.setAttribute("telephone", etudiant.get(0).getTel());
            }
            if(etudiant.get(0).getDatedenaissance() != null){
                session.setAttribute("dateNaissance", etudiant.get(0).getDatedenaissance());
            }
            System.out.println("Session Mail: "+session.getAttribute("mail"));
            return mapping.findForward("CompteLoginSuccess");
//            }
        } 
        else if (compteLoginService.authentificate(login, pass).equals("Aucun Compte trouvé")) {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.account.manyfinds"));
        } //impossible normalement (bdd)
        else if (compteLoginService.authentificate(login, pass).equals("Plusieurs Comptes trouvés")) {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.account.manyfinds"));
        } 
        else {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.account"));
        }
        if (!erreurs.isEmpty()) {
            session.invalidate(); 
            saveErrors(request, erreurs);
        }
        return (new ActionForward(mapping.getInput()));
    }
    
    private boolean validateMail(String mail){
        if(mail == null || mail.length() == 0){
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.inscription.etudiant.mail.manquant"));
            return false;
        }
        if(mail.length() > 30){
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.inscription.etudiant.mail.tropLong"));
            return false;
        }
        else{
            EmailValidator emailValidator = EmailValidator.getInstance();
            if(!emailValidator.isValid(mail)){
                erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.inscription.etudiant.mail.invalide"));
                return false;
            }
        }
        return true;
    }
    
    private boolean validatePass(String pass){
        if(pass == null || pass.length() == 0){
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.inscription.etudiant.pass.manquant"));
            return false;
        }
        if(pass.length() != 8){
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.inscription.etudiant.pass.huitChars"));
            return false;
        }
        for (int i = 0; i < pass.length(); i++) {
            if(!Character.isAlphabetic(pass.charAt(i)) && !Character.isDigit(pass.charAt(i))){
                erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.inscription.etudiant.pass.invalid"));
                return false;
            }
        }
        return true;
    }

}
