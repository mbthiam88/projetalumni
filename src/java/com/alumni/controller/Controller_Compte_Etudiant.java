/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.controller;

import com.alumni.model.dao.DAO_CompteInscriptionEtudiantService;
import com.alumni.model.dao.DAO_EtudiantAjoutAmi;
import com.alumni.model.dao.DAO_EtudiantModificationCompteService;
import com.alumni.model.dao.EtudiantModificationCompteService;
import com.alumni.model.dao.DAO_Etudiant_Search_Service;
import com.alumni.model.entities.Compte;
import com.alumni.model.entities.Etudiant;
import com.alumni.model.entities.RelationEtudiant;
import com.alumni.model.entities.RelationEtudiantId;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
 * @author compte utilisateur
 */
public class Controller_Compte_Etudiant extends DispatchAction {

    private HttpSession session;
    private ActionErrors erreurs;

    public ActionForward createEtudiant(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("==> Début methode createEtudiant()[CONTROLLER_COMPTE_ETUDIANT]");
        // Initialisation ActionErrors
        erreurs = new ActionErrors();
        // Service pour l'inscription d'un Etudiant
        DAO_CompteInscriptionEtudiantService service_InscriptionEtudiant =
                (DAO_CompteInscriptionEtudiantService) ServiceFactory.instantiate("com.alumni.model.dao.CompteInscriptionEtudiantService");
        // Récupération infos formulaire
        DynaActionForm inscriptioEtudiant = (DynaActionForm) form;
        String nom = (String) inscriptioEtudiant.get("nom");
        String prenom = (String) inscriptioEtudiant.get("prenom");
        String mail = (String) inscriptioEtudiant.get("mail");
        String mailVerif = (String) inscriptioEtudiant.get("mailVerif");
        String pass = (String) inscriptioEtudiant.get("pass");
        String statut = (String) inscriptioEtudiant.get("statut");
        String dateNaissance = (String) inscriptioEtudiant.get("dateNaissance");
        String genre = (String) inscriptioEtudiant.get("genre");
        // Validation des champs remplis
        if (!validateNom(nom)) {
            saveErrors(request, erreurs);
            return (new ActionForward(mapping.findForward("PageAcceuil")));
        }
        if (!validatePrenom(prenom)) {
            saveErrors(request, erreurs);
            return (new ActionForward(mapping.findForward("PageAcceuil")));
        }
        if (!validateMail(mail)) {
            saveErrors(request, erreurs);
            return (new ActionForward(mapping.findForward("PageAcceuil")));
        }
        if (!mail.equals(mailVerif)) {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.inscription.etudiant.mail.verifInvalid"));
            saveErrors(request, erreurs);
            return (new ActionForward(mapping.findForward("PageAcceuil")));
        }
        if (!validatePass(pass)) {
            saveErrors(request, erreurs);
            return (new ActionForward(mapping.findForward("PageAcceuil")));
        }
        if (dateNaissance == null) {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.inscription.etudiant.pass.naissance"));
            saveErrors(request, erreurs);
            return (new ActionForward(mapping.findForward("PageAcceuil")));
        } else {
            java.sql.Date date = castToDate(dateNaissance);
            // Création de l'objet Compte
            Compte compte = new Compte();
            compte.setLogin(mail);
            compte.setPass(pass);
            compte.setStatut(statut);
            compte.setEtat("ACTIF");
            // Insértion de l'objet Compte dans la BDD
            service_InscriptionEtudiant.ajouterCompte(compte);
            // Création de l'objet Etudiant
            Etudiant etudiant = new Etudiant();
            etudiant.setNom(nom);
            etudiant.setPrenom(prenom);
            etudiant.setMail(mail);
            etudiant.setGenre(genre);
            etudiant.setDatedenaissance(date);
            int idCompte = compte.getIdcompte();
            etudiant.setIdcompte(idCompte);
            // Insértion de l'objet Etudiant dans la BDD
            service_InscriptionEtudiant.ajouterEtudiant(etudiant);
            System.out.println("==> Fin methode createEtudiant()[CONTROLLER_COMPTE_ETUDIANT]");
            return (new ActionForward(mapping.findForward("PageAcceuil")));
        }
    }

    public ActionForward updateEtudiant(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("Début methode updateEtudiant()[Class = CONTROLLER_COMPTE_ETUDIANT]");
        // Initialisation ActionErrors
        erreurs = new ActionErrors();
        // Service pour la recherche d'un Etudiant
        DAO_Etudiant_Search_Service service_RechercheEtudiant =
                (DAO_Etudiant_Search_Service) ServiceFactory.instantiate("com.alumni.model.dao.Etudiant_Search_Service");
        // Service pour la modification d'un Etudiant
        DAO_EtudiantModificationCompteService service_ModificationEtudiant =
                (DAO_EtudiantModificationCompteService) ServiceFactory.instantiate("com.alumni.model.dao.EtudiantModificationCompteService");
        // Récupération de la Session courrante
        session = request.getSession();
        // Récupération infos formulaire
        DynaActionForm modificationEtudiant = (DynaActionForm) form;
        String nom = (String) modificationEtudiant.get("nom");
        String prenom = (String) modificationEtudiant.get("prenom");
//        String mail          = (String) modificationEtudiant.get("mail");
        String poste = (String) modificationEtudiant.get("poste");
        String photoProfil = (String) modificationEtudiant.get("photoProfil");
//        String mail2         = (String) modificationEtudiant.get("mail2");
        String telephone = (String) modificationEtudiant.get("telephone");
//        String pass          = (String) modificationEtudiant.get("pass");
        String adresse = (String) modificationEtudiant.get("adresse");
//        String statut        = (String) modificationEtudiant.get("statut");
        String dateNaissance = (String) modificationEtudiant.get("dateNaissance");
//        String genre         = (String) modificationEtudiant.get("genre");
        String mailSession = (String) session.getValue("mail");
        // Récupération de l'étudiant dans la BDD
//        System.out.println("mail = "+mail);
        System.out.println("mail =" + mailSession);
        ArrayList<Etudiant> listeEtudiant = service_RechercheEtudiant.searchByMail(mailSession);
        // Modification de l'Etudiant
        if (!listeEtudiant.isEmpty()) {
            Etudiant etudiant = listeEtudiant.get(0);
            if (!nom.equals("")) {
                etudiant.setNom(nom);
                session.setAttribute("nom", nom);
            }
            if (!prenom.equals("")) {
                System.out.println("entre dans prenom");
                etudiant.setPrenom(prenom);
                session.setAttribute("prenom", prenom);
            }
            if (!adresse.equals("")) {
                etudiant.setAdresse(adresse);
                session.setAttribute("adresse", adresse);
            }
            if (!telephone.equals("")) {
                etudiant.setTel(telephone);
                session.setAttribute("telephone", telephone);
            }
            if (dateNaissance.equals("")) {
                //datenaissance ATTENTION A CHANGER RISQUE !!!
//                return mapping.findForward("erreur");
            }
            if (poste.equals("")) {
//                return mapping.findForward("erreur");
            }
            if (photoProfil.equals("")) {
//                return mapping.findForward("erreur");
            }
            // Modification de l'Etudiant dans la BDD
            service_ModificationEtudiant.modificationEtudiant(etudiant);
            System.out.println("Fin methode updateEtudiant()[Class = CONTROLLER_COMPTE_ETUDIANT]");
            return (new ActionForward(mapping.findForward("administration_CompteEtudiant")));
        }
        System.out.println("Fin methode updateEtudiant()[Class = CONTROLLER_COMPTE_ETUDIANT]");
        return mapping.findForward("erreur");
    }

    public ActionForward dispatchLinkMenu(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("Début methode dispatchLinkMenu()[Class = CONTROLLER_COMPTE_ETUDIANT]");
        // Récupération des infos du formulaire
        DynaActionForm redirigeForm = (DynaActionForm) form;
        String nom_var = redirigeForm.getString("redirectionName");
        if (nom_var.equals("relation_Etudiants")) {
            System.out.println("Fin methode dispatchLinkMenu()[Class = CONTROLLER_COMPTE_ETUDIANT]");
            return mapping.findForward("relation_Etudiants");
        } else if (nom_var.equals("relation_Entreprises")) {
            System.out.println("Fin methode dispatchLinkMenu()[Class = CONTROLLER_COMPTE_ETUDIANT]");
            return mapping.findForward("relation_Entreprises");
        } else if (nom_var.equals("administration_CompteEtudiant")) {
            System.out.println("Fin methode dispatchLinkMenu()[Class = CONTROLLER_COMPTE_ETUDIANT]");
            return mapping.findForward("administration_CompteEtudiant");
        } else if (nom_var.equals("CompteLoginSuccess")) {
            System.out.println("Fin methode dispatchLinkMenu()[Class = CONTROLLER_COMPTE_ETUDIANT]");
            return mapping.findForward("CompteLoginSuccess");
        } else if (nom_var.equals("PageAcceuil")) {
            session = request.getSession();
            session.invalidate();
            System.out.println("Fin methode dispatchLinkMenu()[Class = CONTROLLER_COMPTE_ETUDIANT]");
            return mapping.findForward("PageAcceuil");
        } else {
            System.out.println("Fin methode dispatchLinkMenu()[Class = CONTROLLER_COMPTE_ETUDIANT]");
            return mapping.findForward("erreur");
        }
    }

    /**
     * méthode permettant d'afficher l'ensemble des étudiants qui sont sur le site alumni hormis l'étudiant 
     * qui fait la recherche et les étudiant avec qui il est déja en relation
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    public ActionForward afficherListEtudiant(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("==> Début methode afficherListEtudiant()[CONTROLLER_COMPTE_ETUDIANT]");
        // Initialisation ActionErrors et de la variable de session
        erreurs = new ActionErrors();
        session = request.getSession();
        // Service pour la recherche d'un Etudiant
        DAO_Etudiant_Search_Service serviceRecherche =
                (DAO_Etudiant_Search_Service) ServiceFactory.instantiate("com.alumni.model.dao.Etudiant_Search_Service");
        // Récupération des infos du formulaire, ici le nom
        DynaActionForm redirigeForm = (DynaActionForm) form;
        String name = (String) redirigeForm.get("name");
        // Vérification des infos du formulaire
        boolean verifFormulaire = this.validateNom(name);
        if (!verifFormulaire) {
            this.saveErrors(request, erreurs);
            return (new ActionForward(mapping.findForward("relation_Etudiants")));
        }
        // Récupération des Etudiants dans la BDD
        System.out.println("afficherListEtudiant == Récupération des étudiant dans la BDD");
        ArrayList<Etudiant> results = new ArrayList<Etudiant>();
         ArrayList<String> results2 = new ArrayList<String>();
        results = serviceRecherche.searchOtherByName(name, (String) session.getAttribute("mail"));
        results2 = serviceRecherche.searchRelation((Integer)session.getAttribute("id"));
        System.out.println("results ="+results);
        System.out.println("(String) session.getAttribute(\"mail\") ="+(String) session.getAttribute("mail"));
        redirigeForm.set("results", results);
        System.out.println("==> Fin methode afficherListEtudiant()[CONTROLLER_COMPTE_ETUDIANT]");
        return (new ActionForward(mapping.findForward("relation_Etudiants")));
    }

    public ActionForward compteEtudiantAjoutRelation(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("==> Début methode compteEtudiantAjoutRelation()[CONTROLLER_COMPTE_ETUDIANT]");
        // Initialisation ActionErrors
        erreurs = new ActionErrors();
        // Récupération Session courante
        session = request.getSession();
        // Service pour la recherche d'un Etudiant
        DAO_Etudiant_Search_Service serviceRecherche =
                (DAO_Etudiant_Search_Service) ServiceFactory.instantiate("com.alumni.model.dao.Etudiant_Search_Service");
        // Service pour l'Ajout d'un Etudiant
        DAO_EtudiantAjoutAmi serviceAjout =
                (DAO_EtudiantAjoutAmi) ServiceFactory.instantiate("com.alumni.model.dao.EtudiantAjoutAmi");
        // Récupération des infos du formulaire
        DynaActionForm redirigeForm = (DynaActionForm) form;
        String mail = (String) redirigeForm.get("mail");
        // Récupération d'un etudiant dans BDD gràce au mail
        ArrayList<Etudiant> list_etudiant = new ArrayList<Etudiant>();
        list_etudiant = serviceRecherche.searchByMail(mail);
        if (!list_etudiant.isEmpty()) {
            // On récupére les deux Etudiants concernés
            Etudiant etudiant = list_etudiant.get(0);
            Etudiant etudiant_effectuant_demande = serviceRecherche.searchByMail((String) session.getAttribute("mail")).get(0);
            // Liste contenant les deux Etudiants
            ArrayList<Etudiant> list_Return = new ArrayList<Etudiant>();
            list_Return.add(etudiant);
            list_Return.add(serviceRecherche.searchByMail((String) session.getAttribute("mail")).get(0));
            // Création 1 de la Relation entre les deux etuidants
            RelationEtudiantId relationEtudiantId = new RelationEtudiantId();
            relationEtudiantId.setIdetudiant1(etudiant.getIdetudiant());
            relationEtudiantId.setIdetudiant2(etudiant_effectuant_demande.getIdetudiant());
            
            //Creation Dd'une variable de test
            RelationEtudiantId relationEtudiantIdtest = new RelationEtudiantId(etudiant_effectuant_demande.getIdetudiant(),etudiant.getIdetudiant());
            // Création 2 de la Relation entre les deux etuidants
            RelationEtudiant relationEtudiant = new RelationEtudiant();
            relationEtudiant.setId(relationEtudiantId);
            relationEtudiant.setEtat("en cours");
            // Insértion de la relation dans la BDD
            serviceAjout.ajoutAmiEtudiant(relationEtudiant);
        } else {
            System.out.println("ERREUR quelque part");
            System.out.println("==> Fin methode compteEtudiantAjoutRelation()[CONTROLLER_COMPTE_ETUDIANT]");
            return (new ActionForward(mapping.findForward("relation_Etudiants")));
        }
        System.out.println("==> Fin methode compteEtudiantAjoutRelation()[CONTROLLER_COMPTE_ETUDIANT]");
        return (new ActionForward(mapping.findForward("relation_Etudiants")));
    }

    /**
     * méthode de validation quand l'utilisateur entre un nom
     *
     * @param nom
     * @return true si nom ok, false si nom ko.
     */
    private boolean validateNom(String nom) {
        boolean nameEntered = false;
        if (nom == null || nom.length() == 0) {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.inscription.etudiant.nom.manqant"));
            return false;
        }
        if (nom.length() > 30) {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.inscription.etudiant.nom.tropLong"));
            return false;
        }
        for (int i = 0; i < nom.length(); i++) {
            if (!Character.isAlphabetic(nom.charAt(i)) && nom.charAt(i) != '-') {
                erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.inscription.etudiant.nom.invalide"));
                return false;
            }
        }
        return true;
    }

    private boolean validatePrenom(String prenom) {
        boolean nameEntered = false;
        if (prenom == null || prenom.length() == 0) {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.inscription.etudiant.prenom.manqant"));
            return false;
        }
        if (prenom.length() > 30) {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.inscription.etudiant.prenom.tropLong"));
            return false;
        }
        for (int i = 0; i < prenom.length(); i++) {
            if (!Character.isAlphabetic(prenom.charAt(i)) && prenom.charAt(i) != '-') {
                erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.inscription.etudiant.prenom.invalide"));
                return false;
            }
        }
        return true;
    }

    private Date castToDate(String date) {
        if (!date.equals("")) {
            String[] xx = date.split("/");
            int year = Integer.valueOf(xx[2]);
            int month = Integer.valueOf(xx[0]);
            int day = Integer.valueOf(xx[1]);
            return new java.sql.Date(year - 1900, month - 1, day);
        } else {
            return null;
        }
    }

    private boolean validateMail(String mail) {
        if (mail == null || mail.length() == 0) {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.inscription.etudiant.mail.manquant"));
            return false;
        }
        if (mail.length() > 30) {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.inscription.etudiant.mail.tropLong"));
            return false;
        } else {
            EmailValidator emailValidator = EmailValidator.getInstance();
            if (!emailValidator.isValid(mail)) {
                erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.inscription.etudiant.mail.invalide"));
                return false;
            }
        }
        return true;
    }

    private boolean validatePass(String pass) {
        if (pass == null || pass.length() == 0) {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.inscription.etudiant.pass.manquant"));
            return false;
        }
        if (pass.length() != 8) {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.inscription.etudiant.pass.huitChars"));
            return false;
        }
        for (int i = 0; i < pass.length(); i++) {
            if (!Character.isAlphabetic(pass.charAt(i)) && !Character.isDigit(pass.charAt(i))) {
                erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.inscription.etudiant.pass.invalid"));
                return false;
            }
        }
        return true;
    }
}
