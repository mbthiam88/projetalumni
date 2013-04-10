/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.controller;

import java.sql.Date;
import javax.servlet.http.HttpSession;
import org.apache.commons.validator.EmailValidator;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author thiam
 */
public abstract class Super_Action extends DispatchAction {

    protected ActionErrors erreurs;
    protected HttpSession session;

    protected boolean isValidNom(String nom) {
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
            if (!Character.isAlphabetic(nom.charAt(i))
                    && nom.charAt(i) != '-'
                    && !Character.isSpaceChar(nom.charAt(i))) {
                erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.inscription.etudiant.nom.invalide"));
                return false;
            }
        }
        return true;
    }

    protected boolean isValidPrenom(String prenom) {
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

    protected Date castToDate(String date) {
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

    protected boolean isValidMail(String mail) {
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

    protected boolean isValidPass(String pass) {
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

    protected boolean isValidateIntitulePoste(String intitule) {
        if (intitule == null || intitule.length() == 0) {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.modification.poste.intitule.manqant"));
            return false;
        }
        return true;
    }

    protected boolean isValidDescriptionPoste(String description) {
        boolean nameEntered = false;
        if (description == null || description.length() == 0) {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.modification.poste.description.manqant"));
            return false;
        }
        return true;
    }

    protected boolean isValidSalaire(String salary) {
        if (salary.equals("") || salary == null) {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.modification.poste.salaire.manqant"));
            return false;
        }
        // Test 1 validité des caractéres
        for (int i = 0; i < salary.length(); i++) {
            if (!Character.isDigit(salary.charAt(i))
                    && salary.charAt(i) != '.') {
                erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.modification.poste.salaire.invalid1"));
                return false;
            }
        }
        // Test 2 validité des caractéres
        int countPoint = 0;
        for (int i = 0; i < salary.length(); i++) {
            if (salary.charAt(i) == '.') {
                countPoint++;
                if (countPoint > 1) {
                    erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.modification.poste.salaire.2points"));
                    return false;
                }
            }
        }
        // Test IsDecial
        boolean isDecimal = false;
        if (countPoint == 1) {
            isDecimal = true;
        }
        // Test Taille
        if (isDecimal && salary.length() > 9) {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.modification.poste.salaire.invalid2"));
            return false;
        }
        if (!isDecimal && salary.length() > 6) {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.modification.poste.salaire.invalid2"));
            return false;
        }
        return true;
    }

    protected String castToValidTextArea(String texteDuChampTextArea) {
        for (int i = 0; i < texteDuChampTextArea.length(); i++) {
            if (texteDuChampTextArea.charAt(i) == '"') {
                texteDuChampTextArea.replaceAll("", "");
            }
        }
        return texteDuChampTextArea;

    }

    protected boolean isValidDate(String date) {
        if (date.equals("") || date == null) {

            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.modification.poste.dateEmbauche.manqant"));
            return false;
        }
        if (date.length() != 10) {
            System.out.println("dsfdfg");
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.modification.poste.dateEmbauche.incorrect"));
            return false;
        }
        if (date.charAt(2) != '/' || date.charAt(5) != '/') {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.modification.poste.dateEmbauche.incorrect"));
            return false;
        }
        for (int i = 0; i < 10; i++) {
            if (i != 2 && i != 5) {
                if ("0123456789".indexOf(date.charAt(i)) == -1) {
                    erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.modification.poste.dateEmbauche.incorrect"));
                    return false;
                }
            }
        }

        String anneeString = String.valueOf(date.charAt(6)) + String.valueOf(date.charAt(7))
                + String.valueOf(date.charAt(8)) + String.valueOf(date.charAt(9));
        String moisString = String.valueOf(date.charAt(0)) + String.valueOf(date.charAt(1));
        String jourString = String.valueOf(date.charAt(3)) + String.valueOf(date.charAt(4));


        int jour = Integer.parseInt(jourString);
        int mois = Integer.parseInt(moisString);
        int annee = Integer.parseInt(anneeString);

        if (annee < 0 || annee > 2013 || mois > 12 || mois < 0 || jour < 0 || jour > 31) {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.modification.poste.dateEmbauche.incorrect"));
            return false;
        }
        return true;
    }

    protected boolean isValidateAdresse(String adresse) {
        boolean nameEntered = false;
        if (adresse == null || adresse.length() == 0) {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.modification.etudiant.adresse.manqant"));
            return false;
        }
        if (adresse.length() < 40) {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.modification.etudiant.adresse.tropCourt"));
            return false;
        }
        return true;
    }

    protected boolean isValidTelephone(String date) {
        if (date.length() != 10) {
            erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.modification.etudiant.telephone.toLong"));
            return false;
        }
        for (int i = 0; i < 10; i++) {
            if ("0123456789".indexOf(date.charAt(i)) == -1) {
                erreurs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.modification.etudiant.telephone.incorrect"));
                return false;
            }
        }
        return false;
    }
}
