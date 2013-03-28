/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rh.controller;

import com.rh.model.dao.EtudiantLoginService;
import com.rh.view.TestForm;
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
public class LoginActionTest extends Action{
    @Override
    public ActionForward execute(ActionMapping mapping,ActionForm form, 
    HttpServletRequest request,HttpServletResponse response)throws Exception{
       EtudiantLoginService service = new EtudiantLoginService();
       TestForm searchForm = (TestForm) form;
       String name = searchForm.getName();
       String ssNum = searchForm.getMdp();
       
       if(service.authentificate(name, ssNum)){
           return mapping.findForward("succes_ide");
       } else {
            return mapping.findForward("erreur");
       }
    }
}
