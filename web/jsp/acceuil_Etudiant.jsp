<%-- 
    Document   : acceuil_Etudiant
    Created on : 27 mars 2013, 19:55:41
    Author     : compte utilisateur
--%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page étudiant</title>
        <link rel="stylesheet" type="text/css" href="/projetalumni/css/stylesheet.css">
    </head>
    <body>
        <div>
            <h1>Coucou Nouvelle étudiant!</h1>
            <table>
                <!--Partie CV-->
                <tr>
                    <th>
                        <html:form action="/etudiant_redirection"> 
                            <html:hidden property="name_var" value="form_1"  />
                            <html:submit value="relations personnelles" />
                        </html:form>
                    </th>
                    <th>
                        <html:form action="/etudiant_redirection"> 
                            <html:hidden property="name_var" value="form_2"  />
                            <html:submit value="Relation entreprises" />
                        </html:form>
                    </th>
                    <th>
                        <html:form action="/etudiant_redirection"> 
                            <html:hidden property="name_var" value="form_3"  />
                            <html:submit value="Administration compte" />
                        </html:form>
                    </th> 
                    <th>
                        <html:form action="/etudiant_redirection"> 
                            <html:hidden property="name_var" value="form_3"  />
                            <html:submit value="déposer un cv" />
                        </html:form>
                    </th> 
<!--                    <th>
                        <%--<html:link forward="relation_Etudiants">Search for Employees</html:link>--%>
                    </th>-->

                </tr>
            </table>
        </div>
        <!--Partie Actualité-->
        <!--Partie social-->
        <div>

            --Ecrire un commentaire*
            <html:errors />
            <html:form action="/ajouterActualite"> 
                <bean:message key="label.search.name" />:
                <html:text property="name" /> 
                <br>
            </html:form>
            --

            fil d'actualité

            -- <br>
            --
            -- <br>
            --
            -- <br>
            --
            -- <br>
            --
            -- <br>
            --
            -- <br>
            --
            -- <br>
            --
            -- <br>
            --
            -- <br>
            --
            fin fil actualité
        </div>   
        <!--partie administration-->


        <!--Partie CV-->

        <!--Partie Actualité-->
        <!--Partie social-->

        <!--partie administration-->


    </body>

</html>
