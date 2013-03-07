/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rh.controller;

import com.rh.model.SearchService;
import com.rh.view.AddForm;
import java.util.ArrayList;
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
        AddForm addForm = (AddForm) form;
        String name = addForm.getName();
        String ssNum = addForm.getSsNum();
        if (AddForm.isValidSsNum(ssNum) && !name.isEmpty()) {
            service.addEmploye(name, ssNum);
        }
        return mapping.getInputForward();
    }
}
