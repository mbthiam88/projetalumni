<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

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
            <td><bean:message key="label.siteWebEntreprise.Entreprise" /></td>
        </tr>
        <tr>
            <td> <html:text property="siteWebEntreprise" /></td>
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
            <td><bean:message key="label.motDePasse.Entreprise" /></td>
        </tr>
        <tr>
            <td><html:text property="motDePasse" /></td>
        </tr>
        <tr>
            <td><html:hidden property="statut" value="ENTREPRISE"/> <html:submit /></td>
        </tr>
    </html:form>
</table>