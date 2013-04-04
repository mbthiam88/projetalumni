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
                            <html:form action="/Controller_Compte_Etudiant_Redirection"> 
                                <html:hidden property="var_choice_method" value="dispatchLinkMenu"  />
                                <html:hidden property="redirectionName" value="form_4"  />
                                <html:submit value="acceuil compte" />
                            </html:form>
                        </th>
                        <th>
                            <html:form action="/Controller_Compte_Etudiant_Redirection"> 
                                <html:hidden property="var_choice_method" value="dispatchLinkMenu"  />
                                <html:hidden property="redirectionName" value="form_1"  />
                                <html:submit value="relations personnelles" />
                            </html:form>
                        </th>
                        <th>
                            <html:form action="/Controller_Compte_Etudiant_Redirection"> 
                                <html:hidden property="var_choice_method" value="dispatchLinkMenu"  />
                                <html:hidden property="redirectionName" value="form_2"  />
                                <html:submit value="Relation entreprises" />
                            </html:form>
                        </th>
                        <th>
                            <html:form action="/Controller_Compte_Etudiant_Redirection"> 
                                <html:hidden property="var_choice_method" value="dispatchLinkMenu"  />
                                <html:hidden property="redirectionName" value="form_3"  />
                                <html:submit value="Administration compte" />
                            </html:form>
                        </th> 
                        <th>
                            <html:form action="/Controller_Compte_Etudiant_Redirection"> 
                                <html:hidden property="var_choice_method" value="dispatchLinkMenu"  />
                                <html:hidden property="redirectionName" value="form_3"  />
                                <html:submit value="déposer un cv" />
                            </html:form>
                        </th> 
                        <th>
                            <html:form action="/Controller_Compte_Etudiant_Redirection"> 
                                <html:hidden property="var_choice_method" value="dispatchLinkMenu"  />
                                <html:hidden property="redirectionName" value="form_5"  />
                                <html:submit value="se déconnecter" />
                            </html:form>
                        </th> 
                    </tr>
                </table>
                <br/>
                
                <logic:present name="mail" scope="session">
                    Bienvenue <bean:write name="nom" scope="session"/>! 
                </logic:present> 
                <logic:notPresent name="mail" scope="session">
                    il n'y a pas de session test
                    <logic:forward name="PageAcceuil"/>
                </logic:notPresent>
            </div>

            <div id="contenu">
                <h1>Ceci est une erreur</h1>
            </div>
    </body>
</html>
