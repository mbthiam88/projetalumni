/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

/**
 *
 * @author compte utilisateur
 */
public class Etudiant_Modification_Action extends Action{
     @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
         System.out.println("entre 0");
        DynaActionForm modificationEtudiant = (DynaActionForm) form;
         System.out.println("aaa ="+modificationEtudiant.get("nom"));
        if (modificationEtudiant.get("bouton1") != null && !modificationEtudiant.get("nom").equals("")) {
            return mapping.findForward("CompteLoginSuccess"); 
        } else if (modificationEtudiant.get("bouton2") != null && !modificationEtudiant.get("prenom").equals("")) {
           return mapping.findForward("erreur"); 
        } else if (modificationEtudiant.get("bouton3") != null && !modificationEtudiant.get("adresse").equals("")) {
                return mapping.findForward("PageAcceuil"); 
        } else if (modificationEtudiant.get("bouton4") != null && !modificationEtudiant.get("mail").equals("")) {
            
        } else if (modificationEtudiant.get("bouton5") != null && !modificationEtudiant.get("telephone").equals("")) {;
            
        }else {
            return mapping.findForward("erreur");
        }
        return mapping.findForward("erreur"); 
         
     }
}
