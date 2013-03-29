/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rh.controller;

import com.rh.model.SearchService;
import com.rh.view.AddForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Calbrix && Ikerchalene
 */
public class AddAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        SearchService service = new SearchService();
        String resultat = null;
        AddForm addForm = (AddForm) form;
        String identifiant = addForm.getIdentifiant();
        String mail = addForm.getMail();
        if (AddForm.isValidSsNum(mail) && !identifiant.isEmpty()) {
            service.addEmploye(identifiant, mail);
            resultat = "succes_ide";
        } else{
            resultat = "erreur";
        }
        return mapping.findForward(resultat);
    }
}
