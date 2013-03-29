/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rh.view;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Housse
 */
public class CompteLoginForm extends org.apache.struts.action.ActionForm {
    private String login;
    private String pass;
    private String error;

    /**
     *
     */
    public CompteLoginForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    /**
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param string
     */
    public void setLogin(String string) {
        login = string;
    }

    /**
     * @return
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param i
     */
    public void setPass(String i) {
        pass = i;
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getLogin() == null || getLogin().length() < 1) {
            errors.add("login", new ActionMessage("error.login.required", new ActionMessage("error.login")));
            // TODO: add 'error.login.required' key to your resources
        }
        if (getPass() == null || getPass().length() < 1) {
            errors.add("pass", new ActionMessage("error.pass.required", new ActionMessage("error.pass")));
            // TODO: add 'error.login.required' key to your resources
        }
        return errors;
    }

}
