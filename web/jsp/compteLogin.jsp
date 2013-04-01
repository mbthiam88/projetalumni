<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

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

            </div><!-- #entete -->

            <div id="navigation">
                <ul>
                    <li><a href="index.html">Accueil</a></li>
                    <li><a href="liste.html">Tous les gabarits</a></li>
                    <li><a href="utiliser.html">Utilisation</a></li>
                    <li><a href="licence.html">Licence</a></li>
                    <li><a href="credits.html">Crédits</a></li>
                </ul>
            </div><!-- #navigation -->

            <div id="contenu">
                <font size="+1">Connectez vous</font> <br/>
                <div id="login" > 
                    <table>
                        <tr>
                            <td>
                                <html:form action="/CompteLoginAction">
                                    <bean:message key="error.login" /> : <html:text property="login" />
                                </td>
                                <td>
                                    <bean:message key="error.pass" /> : <html:text property="pass" />
                                </td>
                                <td>
                                    <html:submit />
                                </td>
                            </html:form>
                        </tr>
                    </table>
                </div>
                <hr width ="100%" noshade ="true">
                <p>
                    <html:errors/>
                </p>
                
                <table>
                        <tr>
                            <td>
                <html:form action="/CompteInscriptionEtudiantAction">
                    <bean:message key="label.nom" /> : <html:text property="nom" />
                    <bean:message key="label.prenom" /> : <html:text property="prenom" />
                    <bean:message key="label.mail" /> : <html:text property="mail" />
                    <bean:message key="label.pass" /> : <html:text property="pass" />
                                                      : <html:hidden property="statut" value="ETUDIANT"/>
                    <html:submit />
                </html:form>
            </div><!-- #contenu -->

        </div><!-- #global -->

    </body>
</html>
