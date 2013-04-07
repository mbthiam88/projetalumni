<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean"  prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<font size="+1">Connectez vous</font> <br/>
<div id="login" >
    <html:form action="/CompteLoginAction">
        <table>
            <tr>
                <td>
                    <bean:message key="error.login" /> : <html:text property="login" />
                </td>
                <td>
                    <bean:message key="error.pass" /> : <html:password property="pass" />
                </td>
                <td>
                    <html:submit />
                </td>
            </tr>
        </table>
    </html:form>
</div>
<hr width ="100%" noshade ="true">
<p>
    <html:errors/>
</p>

<html:form action="/Controller_Compte_Etudiant_Inscription">
    <html:hidden property="var_choice_method" value="createEtudiant"/>
    <table>
        <tr>
            <td><bean:message key="label.nom" /></td>
            <td><bean:message key="label.prenom" /></td>
        </tr>
        <tr>
            <td> <html:text property="nom" /></td>
            <td><html:text property="prenom" /></td>
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
            <td><html:text property="mailVerif" /></td>
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
            <td>SEXE:</td>
        </tr>
        <tr>
            <td><html:radio property="genre" value="HOMME" /> 
                <bean:message key="label.homme" />

                <html:radio property="genre" value="FEMME" /> 
                <bean:message key="label.femme" />
            </td>
        </tr>
        <tr>
            <td><html:hidden property="statut" value="ETUDIANT"/> <html:submit /></td>
        </tr>
    </html:form>
</table>
<html:link  forward="inscriptionEntreprise">Vous êtes une entreprise</html:link>
