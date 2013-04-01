<%-- 
    Document   : administration_CompteEtudiant
    Created on : 28 mars 2013, 14:02:26
    Author     : compte utilisateur
--%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>
            Alumni
        </title>
        <!-- La feuille de styles "base.css" doit être appelée en premier. -->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/base.css" media="all" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/modele05.css" media="screen" />
    </head>

    <body>

        <div id="global">

            <div id="entete">
                <table>
                    <!--Partie CV-->
                    <tr>
                        <th>
                            <html:form action="/etudiant_redirection"> 
                                <html:hidden property="name_var" value="form_4"  />
                                <html:submit value="acceuil compte" />
                            </html:form>
                        </th>
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
                <br/>
                <% String loginSession = (String) session.getAttribute("nom");%>
                <% if (loginSession != null) {%> 
                Bienvenue <%= session.getAttribute("nom")%> ! 
                <% } else {%> 
                La session ne marche pas! 
                <logic:redirect page="/jsp/compteLogin.jsp" />
                <% }%> 
            </div>

            <div id="contenu">
                <h1>administration de votre compte</h1>
            </div><!-- #contenu -->

        </div><!-- #global -->

    </body>
</html>