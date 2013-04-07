<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<h1>administration de votre compte</h1>

Voici vos informations, n'hésitez surtout pas à les mettre à jours
<table>
    <html:form action="/Controller_Compte_Etudiant"> 
        <html:hidden property="var_choice_method" value="updateEtudiant" />
        <tr>
            <td>nom :</td>
            
            <td>
                <html:text property="nom" value="<%=(String) session.getAttribute("nom")%>"  />
            </td>
        </tr> 
        <tr>
            <td>prenom :</td>
            <td><html:text property="prenom" value="<%=(String) session.getAttribute("prenom")%>" /></td>
        </tr> 
        <tr>
            <td>Adresse :</td>
            <td><html:text property="adresse" value="<%=(String) session.getAttribute("adresse")%>"/></td>
        </tr> 
        <tr>
            <td>Telephone :</td>
            <td>
                <html:text property="telephone" value="<%=(String) session.getAttribute("telephone")%>"/>
            </td> 
        </tr> 
        <tr>
            <td>Date naissance :</td>
            <td><html:text property="dateNaissance" styleId="mydate" size="30"/></td>
        </tr> 
        <tr>
            <td>Poste :</td>
            <td>
                <html:text property="poste" value=""/>
            </td>
        </tr> 
        <tr>
            <td>Nouvelle photo :</td>
            <td>
                <html:text property="photoProfil" value=""/>
            </td> 
        </tr> 
        <tr>
            <td>
                SEXE:
            </td>
            <td>
                <html:radio property="genre" value="HOMME" /> 
                <bean:message key="label.homme" />
                <html:radio property="genre" value="FEMME" /> 
                <bean:message key="label.femme" />
            </td>
        </tr>
        <tr>
            <td><html:submit /></td>
        </tr>
    </html:form>
</table>