/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.controller;

import com.alumni.model.dao.DAO_CompteInscriptionEtudiantService;
import com.alumni.model.dao.DAO_EtudiantModificationCompteService;
import com.alumni.model.dao.EtudiantModificationCompteService;
import com.alumni.model.dao.DAO_Etudiant_Search_Service;
import com.alumni.model.entities.Compte;
import com.alumni.model.entities.Etudiant;
import java.util.ArrayList;
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
public class Controller_Compte_Etudiant extends DispatchAction {
    private HttpSession session;

    public ActionForward createEtudiant(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAO_CompteInscriptionEtudiantService service = 
                (DAO_CompteInscriptionEtudiantService)ServiceFactory.instantiate("com.alumni.model.dao.CompteInscriptionEtudiantService");
            
        DynaActionForm inscriptioEtudiant = (DynaActionForm) form;

        String nom = (String) inscriptioEtudiant.get("nom");
        String prenom = (String) inscriptioEtudiant.get("prenom");
        String mail = (String) inscriptioEtudiant.get("mail");
        String mail2 = (String) inscriptioEtudiant.get("mail2");
        String pass = (String) inscriptioEtudiant.get("pass");
        String statut = (String) inscriptioEtudiant.get("statut");
        String dateNaissance = (String) inscriptioEtudiant.get("dateNaissance");
        String genre = (String) inscriptioEtudiant.get("genre");
        
                
        java.sql.Date date = null;
        if( !dateNaissance.equals("")){
        System.out.println("dateNaissance: " + dateNaissance);
        String[] xx = dateNaissance.split("/");
        System.out.println(xx[0]+"-"+xx[1]+"-"+xx[2]);
        int year = Integer.valueOf(xx[2]);
        int month = Integer.valueOf(xx[0]);
        int day = Integer.valueOf(xx[1]);
        System.out.println("year :" + year);
        System.out.println("month :" + month);
        System.out.println("day :" + day);
        date = new java.sql.Date(year-1900, month-1, day);
        }
        
        
        System.out.println("date :"+date);

        ActionErrors errors = new ActionErrors();
       
        if (nom == null || nom.equals("")) {
            
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.nomEtudiant.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.findForward("PageAcceuil")));
        } else if (prenom == null || prenom.equals("")) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.prenomEtudiant.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.findForward("PageAcceuil")));
        } else if (mail == null || mail.equals("")) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.mailEtudiant.required"));
            saveErrors(request, errors);
           return (new ActionForward(mapping.findForward("PageAcceuil")));
        } else if (service.validateEmailAddress(mail) != true) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.invalidMail.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.findForward("PageAcceuil")));
        } else if (!mail.equals(mail2)) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.mailNonIdemtique.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.findForward("PageAcceuil")));
        } else if (pass == null || pass.equals("")) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.passEtudiant.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.findForward("PageAcceuil")));
        } else if (dateNaissance.equals("")) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.dateNaissance.required"));
            saveErrors(request, errors);
            return (new ActionForward(mapping.findForward("PageAcceuil")));
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
        etudiant.setDatedenaissance(date);

        System.out.println("ffffffffffff" + compte.getIdcompte());
        int idCompte = compte.getIdcompte();
        etudiant.setIdcompte(idCompte);
        service.ajouterEtudiant(etudiant);
        
        return (new ActionForward(mapping.findForward("administration_CompteEtudiant")));

    }

    public ActionForward updateEtudiant(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("Classe_de_ouf: "+EtudiantModificationCompteService.class);
        
        DAO_Etudiant_Search_Service serviceRecherche = 
                (DAO_Etudiant_Search_Service) ServiceFactory.instantiate("com.alumni.model.dao.Etudiant_Search_Service");
        DAO_EtudiantModificationCompteService serviceModification = 
                (DAO_EtudiantModificationCompteService) ServiceFactory.instantiate("com.alumni.model.dao.EtudiantModificationCompteService");
        session = request.getSession();
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
            serviceModification.modificationEtudiant(etu.get(0));
            return (new ActionForward(mapping.findForward("administration_CompteEtudiant")));
        }
        return mapping.findForward("erreur");
    }

    public ActionForward dispatchLinkMenu(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
//        
        DynaActionForm redirigeForm = (DynaActionForm) form;
        String nom_var = redirigeForm.getString("redirectionName");
        if (nom_var.equals("form_1")) {
            return mapping.findForward("relation_Etudiants");
        } else if (nom_var.equals("form_2")) {
            return mapping.findForward("relation_Entreprises");
        } else if (nom_var.equals("form_3")) {
            return mapping.findForward("administration_CompteEtudiant");
        } else if (nom_var.equals("form_4")) {
            return mapping.findForward("CompteLoginSuccess");
        } else if (nom_var.equals("form_5")) {
            session = request.getSession();
            session.invalidate();
            return mapping.findForward("PageAcceuil");
        } else {
            return mapping.findForward("erreur");
        }
    }
}
