<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
        <title>
            Alumni
        </title>
        <!-- La feuille de styles "base.css" doit être appelée en premier. -->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/base.css" media="all" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/modele05.css" media="screen" /> 
        <link  rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/javaScript/styles/glDatePicker.default.css">
    </head>

    <body>

        <div id="global">

            <div id="entete">

            </div><!-- #entete -->

            <div id="navigation">
                
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

                <html:form action="/Controller_Compte_Entreprise_Inscription">
                    <html:hidden property="var_choice_method" value="createEntreprise"/>
                    <table>
                        <tr>
                            <td><bean:message key="label.nom.Entreprise" /></td>
                        </tr>
                        <tr>
                            <td> <html:text property="nomEntreprise" /></td>
                        </tr>
                        <tr>
                            <td><bean:message key="label.mail.Entreprise" /></td>
                        </tr>
                        <tr>
                            <td><html:text property="mailEntreprise" /></td>
                        </tr>
                        <tr>
                            <td><bean:message key="label.mail.Entreprise2" /></td>
                        </tr>
                        <tr>
                            <td><html:text property="mailEntreprise2" /></td>
                        </tr>
                        <tr>
                            <td><bean:message key="label.pass.Entreprise" /></td>
                        </tr>
                        <tr>
                            <td><html:password property="motDePasseEntreprise" /></td>
                        </tr>
                        <tr>
                            <td><html:hidden property="statut" value="ENTREPRISE"/> <html:submit /></td>
                        </tr>
                    </html:form>
                </table>
            </div><!-- #contenu -->

        </div><!-- #global -->
    </body>
</html>
