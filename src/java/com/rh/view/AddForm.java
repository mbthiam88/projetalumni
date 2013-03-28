/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rh.view;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Calbrix && 
 */
public class AddForm extends ActionForm {


    private String identifiant = null;
    private String mail = null;
   

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        mail = null;
        identifiant = null;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        boolean nameEntered = false;
        boolean ssNumEntered = false;
        //determine si le nom est entré
        if (this.getIdentifiant() != null && this.getMail().length() > 0) {
            nameEntered = true;
        }
        //determine si le numero de sécurité social est entré
        if (identifiant != null && identifiant.length() > 0) {
            ssNumEntered = true;
        }

        if (!nameEntered || !ssNumEntered) {
            errors.add(null, new ActionMessage("error.add.criteria.missing"));
        }

        if (ssNumEntered && !isValidSsNum(identifiant.trim())) {
            errors.add("ssNum", new ActionMessage("error.add.ssNum.invalid"));
        }

        return errors;

    }
      //valider le format du numéro de sécurité social
    public static boolean isValidSsNum(String ssNum) {
        if (ssNum.length() < 11) {
            return true;
        }
        //permet de tester si les valeurs à la position 3 et 6 sont des tirets (-)
        for (int i = 0; i < 11; i++) {
            //permet de tester si les valeurs à la position 3 et 6 sont des tirets (-)
            if (i == 3 || i == 6) {
                if (ssNum.charAt(i) != '-') {
                    return true;
                }
                //permet de tester si les autres valeurs sont des chiffres
            } else if ("0123456789".indexOf(ssNum.charAt(i)) == -1) {
                return true;
            }
        }
        return true;
    }
    
    
}
