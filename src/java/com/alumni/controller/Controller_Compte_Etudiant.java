/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.controller;

import com.alumni.model.dao.DAO_CompteInscriptionEtudiantService;
import com.alumni.model.dao.DAO_EtudiantAjoutAmi;
import com.alumni.model.dao.DAO_EtudiantModificationCompteService;
import com.alumni.model.dao.DAO_Etudiant_Search_Service;
import com.alumni.model.dao.DAO_Upload_File;
import com.alumni.model.entities.Compte;
import com.alumni.model.entities.Etudiant;
import com.alumni.model.entities.HistoriqueEtudiantPoste;
import com.alumni.model.entities.HistoriqueEtudiantPosteId;
import com.alumni.model.entities.Poste;
import com.alumni.model.entities.RelationEtudiant;
import com.alumni.model.entities.RelationEtudiantId;
import java.sql.Date;
import java.util.ArrayList;
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
import org.apache.struts.upload.FormFile;

/**
 *
 * @author compte utilisateur
 */
public class Controller_Compte_Etudiant extends Super_Action {

//    private HttpSession session;
//    private ActionErrors erreurs;
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
        System.out.println("Lahoucine --> " + nom);
        String prenom = (String) inscriptioEtudiant.get("prenom");
        String mail = (String) inscriptioEtudiant.get("mail");
        String mailVerif = (String) inscriptioEtudiant.get("mailVerif");
        String pass = (String) inscriptioEtudiant.get("pass");
        String statut = (String) inscriptioEtudiant.get("statut");
        String dateNaissance = (String) inscriptioEtudiant.get("dateNaissance");
        String genre = (String) inscriptioEtudiant.get("genre");
        // Validation des champs remplis
        if (!isValidNom(nom)) {
            saveErrors(request, erreurs);
            return (new ActionForward(mapping.findForward("PageAcceuil")));
        }
        if (!isValidPrenom(prenom)) {
            saveErrors(request, erreurs);
            return (new ActionForward(mapping.findForward("PageAcceuil")));
        }
        if (!isValidMail(mail)) {
            saveErrors(request, erreurs);
            return (new ActionForward(mapping.findForward("PageAcceuil")));
        }
        if (!mail.equals(mailVerif)) {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.inscription.etudiant.mail.verifInvalid"));
            saveErrors(request, erreurs);
            return (new ActionForward(mapping.findForward("PageAcceuil")));
        }
        if (!isValidPass(pass)) {
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
            if (genre.equals("HOMME")) {
                etudiant.setPhotoprofil("homme.jpg");
            } else if (genre.equals("FEMME")) {
                etudiant.setPhotoprofil("femme.jpg");
            }
            int idCompte = compte.getIdcompte();
            etudiant.setIdcompte(idCompte);
            // Insértion de l'objet Etudiant dans la BDD
            service_InscriptionEtudiant.ajouterEtudiant(etudiant);
            System.out.println("==> Fin methode createEtudiant()[CONTROLLER_COMPTE_ETUDIANT]");
            return (new ActionForward(mapping.findForward("PageAcceuil")));
        }
    }

    /**
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception Cette méthode permet de modifier le compte de
     * l'etudiant et son poste
     */
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
        DAO_Upload_File service_telecharger =
                (DAO_Upload_File) ServiceFactory.instantiate("com.alumni.model.dao.Upload_File_Service");
        // Récupération de la Session courrante
        session = request.getSession();
        // Récupération infos formulaire
        DynaActionForm modificationEtudiant = (DynaActionForm) form;
        String nom = (String) modificationEtudiant.get("nom");
        String prenom = (String) modificationEtudiant.get("prenom");
        String adresse = (String) modificationEtudiant.get("adresse");
        String telephone = (String) modificationEtudiant.get("telephone");
        String dateNaissance = (String) modificationEtudiant.get("dateNaissance");
        FormFile photoProfil = (FormFile) modificationEtudiant.get("photoProfil");
        FormFile cv = (FormFile) modificationEtudiant.get("cv");
        String mailSession = (String) session.getValue("mail");

        System.out.println("dateNaissance --> " + dateNaissance);
        System.out.println("photoProfil --> " + photoProfil);
        System.out.println("dateNaissance --> " + dateNaissance);
        System.out.println("CV --> " + cv);
        System.out.println("mailSession --> " + mailSession);

        // Récupération de l'étudiant dans la BDD
//        System.out.println("mail = "+mail);
        System.out.println("mail =" + mailSession);
        ArrayList<Etudiant> listeEtudiant = service_RechercheEtudiant.searchByMail(mailSession);
        // Modification de l'Etudiant
        if (!listeEtudiant.isEmpty()) {
            Etudiant etudiant = listeEtudiant.get(0);
            if (!isValidNom(nom)) {
                saveErrors(request, erreurs);
                return (new ActionForward(mapping.findForward("administration_CompteEtudiant")));
            }
            if (!isValidPrenom(prenom)) {
                saveErrors(request, erreurs);
                return (new ActionForward(mapping.findForward("administration_CompteEtudiant")));

            }
            if (!isValidateAdresse(adresse)) {
                saveErrors(request, erreurs);
                return (new ActionForward(mapping.findForward("administration_CompteEtudiant")));

            }
            if (!isValidTelephone(telephone)) {
                saveErrors(request, erreurs);
                return (new ActionForward(mapping.findForward("administration_CompteEtudiant")));
            }
            if (!isValidDate(dateNaissance)) {
                saveErrors(request, erreurs);
                return (new ActionForward(mapping.findForward("administration_CompteEtudiant")));
            }
            //Si l'utilisateur choisie une photo on le télécharge
            if (photoProfil != null) {
                service_telecharger.telechargerFichier(photoProfil);//, getServlet().getServletContext().getRealPath("/") + "img"
                etudiant.setPhotoprofil(photoProfil.getFileName());
                System.out.println("FILENAME --> " + photoProfil.getFileName());
                session.setAttribute("photoProfil", "./img/" + photoProfil.getFileName());
            }
            if (cv != null) {
                service_telecharger.telechargerFichier(cv);//, getServlet().getServletContext().getRealPath("/") + "img"
                etudiant.setCv(cv.getFileName());
                System.out.println("FILENAME --> " + cv.getFileName());
                session.setAttribute("cv", "./img/" + cv.getFileName());
            }
            etudiant.setNom(nom);
            session.setAttribute("nom", nom);
            etudiant.setPrenom(prenom);
            session.setAttribute("prenom", prenom);
            etudiant.setAdresse(adresse);
            session.setAttribute("adresse", adresse);
            etudiant.setTel(telephone);
            session.setAttribute("telephone", telephone);
            Date dateAnniversaire = this.castToDate(dateNaissance);
            etudiant.setDatedenaissance(dateAnniversaire);
            // Modification de l'Etudiant dans la BDD
            service_ModificationEtudiant.modificationEtudiant(etudiant);
            System.out.println("Fin methode updateEtudiant()[Class = CONTROLLER_COMPTE_ETUDIANT]");
            return (new ActionForward(mapping.findForward("administration_CompteEtudiant")));
        }
        System.out.println("Fin methode updateEtudiant()[Class = CONTROLLER_COMPTE_ETUDIANT]");
        return mapping.findForward("erreur");
    }

    public ActionForward updatePoste(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("Début methode updatePoste()[Class = CONTROLLER_COMPTE_ETUDIANT]");
        // Initialisation ActionErrors
        erreurs = new ActionErrors();
        // Service pour la recherche d'un Etudiant
        DAO_Etudiant_Search_Service service_RechercheEtudiant =
                (DAO_Etudiant_Search_Service) ServiceFactory.instantiate("com.alumni.model.dao.Etudiant_Search_Service");
        // Service pour la recherche d'un Etudiant
        //DAO_Compte_Search_Service service_Poste =
        //      (DAO_Compte_Search_Service) ServiceFactory.instantiate("com.alumni.model.dao.Compte_Search_Service");
        // Service pour la modification d'un Etudiant
        DAO_EtudiantModificationCompteService service_ModificationEtudiant =
                (DAO_EtudiantModificationCompteService) ServiceFactory.instantiate("com.alumni.model.dao.EtudiantModificationCompteService");
        // Récupération de la Session courrante
        session = request.getSession();
        // Récupération infos formulaire
        DynaActionForm modificationEtudiant = (DynaActionForm) form;
        String intitulePoste = (String) modificationEtudiant.get("intitule");
        String descriptionPoste = (String) modificationEtudiant.get("description");
        String localisationPoste = (String) modificationEtudiant.get("localisation");
        String dateDebutEmbauche = (String) modificationEtudiant.get("dateDebut");
        String salaire = (String) modificationEtudiant.get("salaire");
        String mailSession = (String) session.getValue("mail");

        System.out.println("intitulePoste --> " + intitulePoste);
        System.out.println("descriptionPoste --> " + descriptionPoste);
        System.out.println("localisationPoste --> " + localisationPoste);
        System.out.println("dateDebutEmbauche --> " + dateDebutEmbauche);
        System.out.println("salaire --> " + salaire);
        System.out.println("mailSession --> " + mailSession);

        // Récupération de l'étudiant dans la BDD
        System.out.println("mail =" + mailSession);
        ArrayList<Etudiant> listeEtudiant = service_RechercheEtudiant.searchByMail(mailSession);
        if (!listeEtudiant.isEmpty()) {
            Etudiant etudiant = listeEtudiant.get(0);
            Poste poste = new Poste();
            if (!isValidateIntitulePoste(intitulePoste)) {
                saveErrors(request, erreurs);
                session.setAttribute("intitule", "");
                session.setAttribute("salaire", "");
                session.setAttribute("description", "");
                return (new ActionForward(mapping.findForward("administration_CompteEtudiant")));
            }
            session.setAttribute("intitule", intitulePoste);

            if (!isValidDescriptionPoste(descriptionPoste)) {
                saveErrors(request, erreurs);
                return (new ActionForward(mapping.findForward("administration_CompteEtudiant")));
            }
            session.setAttribute("description", descriptionPoste);

            if (!isValidDate(dateDebutEmbauche)) {
                System.out.println("ENTRE DANS ISVALIDEDATE");
                saveErrors(request, erreurs);
                return (new ActionForward(mapping.findForward("administration_CompteEtudiant")));
            }

            if (!isValidSalaire(salaire)) {
                saveErrors(request, erreurs);
                return (new ActionForward(mapping.findForward("administration_CompteEtudiant")));
            }
            Double salaireEnDouble = Double.valueOf(salaire);
            session.setAttribute("salaire", salaireEnDouble.toString());

            if (localisationPoste != null) {
                poste.setLocalisation(localisationPoste);
                session.setAttribute("localisation", dateDebutEmbauche);
            }
            poste.setIntitule(intitulePoste);
            poste.setDescription(descriptionPoste);
            poste.setSalaire(salaireEnDouble);
            Date dateEmbauche = this.castToDate(dateDebutEmbauche);
            poste.setDatedebut(dateEmbauche);
            session.setAttribute("dateDebut", dateDebutEmbauche);
            //Création du nouveau poste
            service_ModificationEtudiant.createPoste(poste);
            //modification de l'IdPoste dans la table etudiant
            System.out.println("IDPOSTE du NOUVEAU POSTE -->" + poste.getIdposte());
            etudiant.setIdposte(poste.getIdposte());

            //Enregistrement de l'historique du poste dans la BDD
            HistoriqueEtudiantPoste hist_Etud_Poste = new HistoriqueEtudiantPoste();
            HistoriqueEtudiantPosteId hist_Etud_Post_Id = new HistoriqueEtudiantPosteId(etudiant.getIdetudiant(), poste.getIdposte());
            hist_Etud_Poste.setId(hist_Etud_Post_Id);
            service_ModificationEtudiant.createHistoriqueEtudiantPoste(hist_Etud_Poste);

            System.out.println("Fin methode updatePoste()[Class = CONTROLLER_COMPTE_ETUDIANT]");
            return (new ActionForward(mapping.findForward("administration_CompteEtudiant")));
        }
        System.out.println("Fin methode updatePoste()[Class = CONTROLLER_COMPTE_ETUDIANT]");
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

    public ActionForward afficherListEtudiant(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("==> Début methode afficherListEtudiant()[CONTROLLER_COMPTE_ETUDIANT]");
        // Initialisation ActionErrors
        erreurs = new ActionErrors();
        session = request.getSession();
        // Service pour la recherche d'un Etudiant
        DAO_Etudiant_Search_Service serviceRecherche =
                (DAO_Etudiant_Search_Service) ServiceFactory.instantiate("com.alumni.model.dao.Etudiant_Search_Service");
        // Récupération des infos du formulaire
        DynaActionForm redirigeForm = (DynaActionForm) form;
        String name = (String) redirigeForm.get("name");
        // Vérification des infos du formulaire
        boolean verifFormulaire = this.isValidNom(name);
        if (!verifFormulaire) {
            this.saveErrors(request, erreurs);
            return (new ActionForward(mapping.findForward("relation_Etudiants")));
        }
        // Récupération des Etudiants dans la BDD
        ArrayList<Etudiant> results = new ArrayList<Etudiant>();
        results = serviceRecherche.searchOtherByName(name, (String) session.getAttribute("mail"));
        System.out.println("results =" + results);
        System.out.println("(String) session.getAttribute(\"mail\") =" + (String) session.getAttribute("mail"));
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
            relationEtudiantId.setIdetudiant1(etudiant.getIdcompte());
            relationEtudiantId.setIdetudiant2(etudiant_effectuant_demande.getIdcompte());
            // Création 2 de la Relation entre les deux etuidants
            RelationEtudiant relationEtudiant = new RelationEtudiant();
            relationEtudiant.setId(relationEtudiantId);
            relationEtudiant.setEtat("en cours");
            System.out.println("relationEtudiant.getId=" + relationEtudiant.getId());
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
}
