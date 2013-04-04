/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alumni.controller;

import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;

/**
 *
 * @author compte utilisateur
 */

public class ServiceFactory {
    public static Object instantiate(String nomClasse) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        Class cls = Class.forName(nomClasse);
        Object obj = cls.newInstance();
        return obj;
    }
}
