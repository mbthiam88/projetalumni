/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rh.controller;

import com.rh.model.SearchService;
import com.rh.view.AddForm2;
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
public class AddAction2 extends Action{
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        SearchService service = new SearchService();
        AddForm2 addForm = (AddForm2) form;
        String nom = addForm.getNom();
        String prenom = addForm.getPrenom();
        String mail = addForm.getNom();
        String mdp = addForm.getNom();
        if (!nom.isEmpty()) {
            service.addEmploye(nom, prenom);
        }
        return mapping.findForward("succes_ide");
    }
}
