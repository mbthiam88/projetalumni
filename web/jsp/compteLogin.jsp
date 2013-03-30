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
        <link rel="stylesheet" type="text/css" href="../css/base.css" media="all" />
        <link rel="stylesheet" type="text/css" href="../css/modele05.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="../css/modele05.css">
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
                <font size="+1">Entré vos Login</font> <br/>
                <hr width ="100%" noshade ="true">
                <p style="color:red">
                </p>
                <p>
                    <html:errors/>
                </p>
                <html:form action="/CompteLoginAction">
                    <bean:message key="error.login" /> : <html:text property="login" />
                    <bean:message key="error.pass" /> : <html:text property="pass" />
                    <html:submit />
                </html:form>
            </div><!-- #contenu -->

        </div><!-- #global -->

    </body>
</html>
