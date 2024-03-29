/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.controller;

import com.alumni.model.dao.CompteLoginService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.DynaActionForm;

/**
 *
 * @author thiam
 */
public class CompteInscriptionAction extends Action{
     @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("Je rentre dans la classe CompteLoginAction.");
        CompteLoginService compteLoginService = new CompteLoginService();
        DynaActionForm redirigeForm = (DynaActionForm) form;
        String login = redirigeForm.getString("login");
        String pass = redirigeForm.getString("pass");
        ActionErrors errors = new ActionErrors();

        if (compteLoginService.authentificate(login, pass).equals("Un Compte trouve et c'est le bon Pass")) {
            return mapping.findForward("CompteLoginSuccess");
        } else if (compteLoginService.authentificate(login, pass).equals("Aucun Compte trouvé")) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.account.manyfinds"));
        } //impossible normalement (bdd)
        else if (compteLoginService.authentificate(login, pass).equals("Plusieurs Comptes trouvés")) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.account.manyfinds"));
        } else {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.account"));
        }
        if (!errors.isEmpty()) {
            saveErrors(request, errors);
        }
        return (new ActionForward(mapping.getInput()));
    }
}
