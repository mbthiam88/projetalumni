<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<h1>administration de votre compte</h1>

Voici vos informations, n'hésitez surtout pas à les mettre à jours
<table>
    <html:form action="/Controller_Compte_Etudiant" enctype="multipart/form-data"> 
        <html:hidden property="var_choice_method" value="updateEtudiant" />
        <tr>
            <td>
                <html:img src="<%=(String) session.getAttribute("photoProfil")%>" styleId="photoProfil" width="150" height="180" />
            </td>
        </tr>
        <tr>
            <td>nom :</td>
            <td>
                <html:text property="nom" value="<%=(String) session.getAttribute("nom")%>" size="30" />
            </td>
        </tr> 
        <tr>
            <td>prenom :</td>
            <td><html:text property="prenom" value="<%=(String) session.getAttribute("prenom")%>" size="30"/></td>
        </tr> 
        <tr>
            <td>Adresse :</td>
            <td><html:text property="adresse" value="<%=(String) session.getAttribute("adresse")%>" size="30"/></td>
        </tr> 
        <tr>
            <td>Telephone :</td>
            <td>
                <html:text property="telephone" value="<%=(String) session.getAttribute("telephone")%>" size="30"/>
            </td> 
        </tr> 
        <tr>
            <td>date naissance :</td>
            <td>
                <html:text property="dateNaissance" value="" styleId="mydate2" size="30"/>
            </td>
        </tr>
        <tr>
            <td>nouvelle photo :</td>
            <td>
                <html:file property="photoProfil" size="30"/>
            </td> 
        </tr> 
        <tr>
            <td>Poste occupé :</td>
            <td>
                <html:textarea property="intitule" value="<%=(String) session.getAttribute("intitule")%>" />
            </td>
        </tr>
        <tr>
            <td>Description du poste :</td>
            <td>
                <html:textarea property="description" value="<%=(String) session.getAttribute("description")%>" />
            </td>
        </tr>
        <tr>
            <td>Lieu de travail :</td>
            <td> 
                <html:select property="localisation" >
                    <html:option value="FRANCE" />
                    <html:option value="AUTRES" />
                </html:select>
            </td>
        </tr>
        <tr>
            <td>Date d'embauche :</td>
            <td>
                <html:text property="dateDebut" value="" size="30" styleId="mydate"/>
            </td>
        </tr>
        <tr>
            <td>Salaire :</td>
            <td>
                <html:text property="salaire" value="<%=(String) session.getAttribute("salaire")%>" size="30"/>
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