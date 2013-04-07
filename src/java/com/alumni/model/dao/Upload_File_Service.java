/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumni.model.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author thiam
 */
public class Upload_File_Service implements DAO_Upload_File{

    @Override
    public boolean telechargerFichier(FormFile file,String filePath) {
 	    //create the upload folder if not exists
	    File folder = new File(filePath);
	    if(!folder.exists()){
	    	folder.mkdir();
	    }
 
	    String fileName = file.getFileName();
 
	    if(!("").equals(fileName)){  
 
	        System.out.println("Server path:" +filePath);
	        File newFile = new File(filePath, fileName);
 
	        if(!newFile.exists()){
                    FileOutputStream fos = null;
                    try {
                        fos = new FileOutputStream(newFile);
                        fos.write(file.getFileData());
                        fos.flush();
                        fos.close();
                    } catch (IOException ex) {
                        System.out.println("fichier non trouvé");
                    } finally {
                        try {
                            fos.close();
                        } catch (IOException ex) {
                        System.out.println("finally fichier non trouvé");
                        }
                    }
	        }
    }
        return false;
    
    }
}
