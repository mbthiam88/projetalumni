/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rh.view;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Calbrix && Ikerchalene
 */
public class SearchForm extends ActionForm {

    private String name = null;
    private String ssNum = null;
    private List results = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsNum() {
        return ssNum;
    }

    public void setSsNum(String ssNum) {
        this.ssNum = ssNum;
    }

    public List getResults() {
        return results;
    }

    public void setResults(List results) {
        this.results = results;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        name = null;
        ssNum = null;
        results = null;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        boolean nameEntered = false;
        boolean ssNumEntered = false;
        //determine si le nom est entré
        if (this.getName() != null && this.getName().length() > 0) {
            nameEntered = true;
        }
        //determine si le numero de sécurité social est entré
        if (ssNum != null && ssNum.length() > 0) {
            ssNumEntered = true;
        }

        if (!nameEntered && !ssNumEntered) {
            errors.add(null, new ActionMessage("error.search.criteria.missing"));
        }

        if (ssNumEntered && !isValidSsNum(ssNum.trim())) {
            errors.add("ssNum", new ActionMessage("error.search.ssNum.invalid"));
        }

        return errors;

    }

    //valider le format du numéro de sécurité social
    public static boolean isValidSsNum(String ssNum) {
        if (ssNum.length() < 11) {
            return false;
        }
        //permet de tester si les valeurs à la position 3 et 6 sont des tirets (-)
        for (int i = 0; i < 11; i++) {
            //permet de tester si les valeurs à la position 3 et 6 sont des tirets (-)
            if (i == 3 || i == 6) {
                if (ssNum.charAt(i) != '-') {
                    return false;
                }
                //permet de tester si les autres valeurs sont des chiffres
            } else if ("0123456789".indexOf(ssNum.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }
}
