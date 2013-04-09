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
public class Upload_File_Service implements DAO_Upload_File {

    @Override
    public void telechargerFichier(FormFile file) {//, String filePath
        System.out.println("CONTROLEUR ENTTRE DANS LA FONCTION TELECHARGER FICHIER");
        
        String avatarName = file.getFileName();
        //String filePath = getServlet().getServletContext().getRealPath("/") + "uploadAvatar";
        File folder = new File("C:/Users/thiam/Documents/NetBeansProjects/ProjetAlumni_git/web/img");
        if (!folder.exists()) {
            folder.mkdir();
        }
        File avatarFile = new File("C:/Users/thiam/Documents/NetBeansProjects/ProjetAlumni_git/web/img", avatarName);
        if (!avatarFile.exists()) {
            try {
                FileOutputStream fos = new FileOutputStream(avatarFile);
                fos.write(file.getFileData());
                fos.flush();
                fos.close();
                System.out.println("LE FICHIER A ETE TELECHARGER");
            } catch (IOException ex) {
                Logger.getLogger(Upload_File_Service.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
