/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.controller;

import com.alumni.model.dao.CompteLoginService;
import com.alumni.view.CompteLoginForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        System.out.println("Je rentre dans la classe CompteLoginAction.");
        CompteLoginService compteLoginService = new CompteLoginService();
        CompteLoginForm compteLoginForm = (CompteLoginForm) form;
        String login = compteLoginForm.getLogin();
        String pass = compteLoginForm.getPass();
        HttpSession session = request.getSession(); 
        
        ActionErrors errors = new ActionErrors();
        if (compteLoginService.authentificate(login, pass).equals("Un Compte trouve et c'est le bon Pass")) {
            session.setAttribute("mail", login);
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
            session.invalidate(); 
            saveErrors(request, errors);
        }
        return (new ActionForward(mapping.getInput()));
    }
}
