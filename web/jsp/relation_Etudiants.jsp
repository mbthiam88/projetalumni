<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

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
            </div><!-- #entete -->

            <!--            <div id="navigation">
                            <ul>
                                <li><a href="index.html">Accueil</a></li>
                                <li><a href="liste.html">Tous les gabarits</a></li>
                                <li><a href="utiliser.html">Utilisation</a></li>
                                <li><a href="licence.html">Licence</a></li>
                                <li><a href="credits.html">Crédits</a></li>
                            </ul>
                        </div> #navigation -->

            <div id="contenu">

                <h1>Coucou, voici les relations disponnibles entre les étudiants</h1>

                <logic:present name="searchForm" property="results"> 
                    <bean:size id="size" name="searchForm" property="results"/>
                    <logic:equal name="size" value="0">
                        <center><font color="red"><cTypeface:Bold>No Employees Found</b>
                            </font></center>
                        </logic:equal>
                        <logic:greaterThan name="size" value="0">
                        <table border="1">
                            <tr>
                                <th>Name</th>
                                <th>Social Security Number</th>
                            </tr>
                            <logic:iterate id="result" name="searchForm" property="results">
                                <tr>
                                    <td><bean:write name="result" property="name"/></td>
                                    <td><bean:write name="result" property="ssnum"/></td>
                                </tr>
                            </logic:iterate>
                        </table>
                    </logic:greaterThan>
                </logic:present>
            </div><!-- #contenu -->

        </div><!-- #global -->

    </body>
</html>

</html>
