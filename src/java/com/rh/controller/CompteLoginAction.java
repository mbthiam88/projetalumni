/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rh.controller;

import com.rh.model.dao.CompteLoginService;
import com.rh.view.CompteLoginForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
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
        CompteLoginForm compteLoginForm = (CompteLoginForm)form;
        String login = compteLoginForm.getLogin();
        String pass  = compteLoginForm.getPass();
       
        if(compteLoginService.authentificate(login, pass).equals("Un Compte trouve et c'est le bon Pass")){
            return mapping.findForward("CompteLoginSuccess");
        } 
        else if (compteLoginService.authentificate(login, pass).equals("Aucun Compte trouvé")) {
            request.setAttribute("error", new ActionMessage("error.account.nofind"));
            return mapping.getInputForward();
        }
        //impossible normalement (bdd)
        else if (compteLoginService.authentificate(login, pass).equals("Plusieurs Comptes trouvés")) {
            request.setAttribute("error", new ActionMessage("error.account.manyfinds"));
            return mapping.getInputForward();
        }
        else {
            request.setAttribute("error", new ActionMessage("error.account"));
            return mapping.getInputForward();
        }
        
    }
}
