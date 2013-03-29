/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rh.controller;

import com.rh.view.Redirige_Etudiant_Form;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author compte utilisateur
 */
public class Redirige_Etudiant_Action extends Action{
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        Redirige_Etudiant_Form addForm = (Redirige_Etudiant_Form) form;
        String nom_var = addForm.getName_var();
        System.out.println("Lahoucine: "+nom_var);
        if(nom_var.equals("form_1")){
            return mapping.findForward("relation_Etudiants");
        } else if (nom_var.equals("form_2")) {
            return mapping.findForward("relation_Entreprises");
        } else if (nom_var.equals("form_3")){
            return mapping.findForward("administration_CompteEtudiant");
        } else {
            return mapping.findForward("erreur");
        }
    }
}
