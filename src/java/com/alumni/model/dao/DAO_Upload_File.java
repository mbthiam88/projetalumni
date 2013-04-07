/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.model.dao;

import org.apache.struts.upload.FormFile;

/**
 *
 * @author Housse
 */
public interface DAO_Upload_File {
    
    public boolean telechargerFichier(FormFile fileName,String filePath);
}