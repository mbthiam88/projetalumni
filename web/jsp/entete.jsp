<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean"  prefix="bean" %>

<table>
    <!--Partie CV-->
    <tr>
        <th>
            <html:form action="/Controller_Compte_Etudiant_Redirection"> 
                <html:hidden property="var_choice_method" value="dispatchLinkMenu"  />
                <html:hidden property="redirectionName" value="CompteLoginSuccess"  />
                <html:submit value="acceuil compte" />
            </html:form>
        </th>
        <th>
            <html:form action="/Controller_Compte_Etudiant_Redirection"> 
                <html:hidden property="var_choice_method" value="dispatchLinkMenu"  />
                <html:hidden property="redirectionName" value="relation_Etudiants"  />
                <html:submit value="relations personnelles" />
            </html:form>
        </th>
        <th>
            <html:form action="/Controller_Compte_Etudiant_Redirection"> 
                <html:hidden property="var_choice_method" value="dispatchLinkMenu"  />
                <html:hidden property="redirectionName" value="relation_Entreprises"  />
                <html:submit value="Relation entreprises" />
            </html:form>
        </th>
        <th>
            <html:form action="/Controller_Compte_Etudiant_Redirection"> 
                <html:hidden property="var_choice_method" value="dispatchLinkMenu"  />
                <html:hidden property="redirectionName" value="administration_CompteEtudiant"  />
                <html:submit value="Administration compte" />
            </html:form>
        </th> 
        <th>
            <html:form action="/Controller_Compte_Etudiant_Redirection"> 
                <html:hidden property="var_choice_method" value="dispatchLinkMenu"  />
                <html:hidden property="redirectionName" value="administration_CompteEtudiant"  />
                <html:submit value="déposer un cv" />
            </html:form>
        </th> 
        <th>
            <html:form action="/Controller_Compte_Etudiant_Redirection"> 
                <html:hidden property="var_choice_method" value="dispatchLinkMenu"  />
                <html:hidden property="redirectionName" value="PageAcceuil"  />
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
    <%--<logic:forward name="PageAcceuil"/>--%>
</logic:notPresent>
