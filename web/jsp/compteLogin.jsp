<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
        <script src="<%=request.getContextPath()%>/javaScript/js/jquery-1.9.1.js"></script>
        <script src="<%=request.getContextPath()%>/javaScript/js/jquery-ui-1.10.2.custom.js"></script>
        <script src="<%=request.getContextPath()%>/javaScript/js/jquery-ui-1.10.2.custom.min.js"></script>
        <title>
            Alumni
        </title>
        <!-- La feuille de styles "base.css" doit être appelée en premier. -->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/base.css" media="all" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/modele05.css" media="screen" /> 
        <link  rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/javaScript/styles/glDatePicker.default.css">
        <script type="text/javascript">
            $(window).load(function()
            {
                $('#mydate').datepicker();
            });
        </script>

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
                                    <bean:message key="error.pass" /> : <html:password property="pass" />
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

                <html:form action="/Controller_Compte_Etudiant_Inscription">
                    <html:hidden property="var_choice_method" value="createEtudiant"/>
                    <table>
                        <tr>
                            <td><bean:message key="label.nom" /></td><td><bean:message key="label.prenom" /></td>
                        </tr>
                        <tr>
                            <td> <html:text property="nom" /></td><td><html:text property="prenom" /></td>
                        </tr>
                        <tr>
                            <td><bean:message key="label.mail" /></td>
                        </tr>
                        <tr>
                            <td><html:text property="mail" /></td>
                        </tr>
                        <tr>
                            <td><bean:message key="label.mail2" /></td>
                        </tr>
                        <tr>
                            <td><html:text property="mail2" /></td>
                        </tr>
                        <tr>
                            <td><bean:message key="label.pass" /></td>
                        </tr>
                        <tr>
                            <td><html:password property="pass" /></td>
                        </tr>
                        <tr>
                            <td><bean:message key="label.dateNaissance" /></td>
                        </tr>
                        <tr>
                            <td><html:text property="dateNaissance" styleId="mydate" size="30"/></td>
                        </tr>
                        <tr>
                            <td><html:radio property="genre" value="HOMME" /> 
                                <bean:message key="label.homme" />

                                <html:radio property="genre" value="FEMME" /> 
                                <bean:message key="label.femme" /></td>
                        </tr>
                        <tr>
                            <td><html:hidden property="statut" value="ETUDIANT"/> <html:submit /></td>
                        </tr>
                    </html:form>
                </table>
                <html:link forward="inscriptionEntreprise" action="">Vous êtes une entreprise</html:link>
            </div><!-- #contenu -->
 
        </div><!-- #global -->
    </body>
</html>
