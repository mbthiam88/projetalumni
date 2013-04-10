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
                <html:img src="<%=(String) session.getAttribute("")%>" styleId="photoProfil" width="150" height="180" />
            </td>
        </tr>
        <tr>
            <td>Nom Entreprise :</td>
            <td>
                <html:text property="nomEntreprise" value="<%=(String) session.getAttribute("")%>" size="30" />
            </td>
        </tr> 
        <tr>
            <td>Site Web:</td>
            <td><html:text property="siteWeb" value="<%=(String) session.getAttribute("")%>" size="30"/></td>
        </tr> 
        <tr>
            <td>Adresse Siége:</td>
            <td><html:text property="adresseSiege" value="<%=(String) session.getAttribute("")%>" size="30"/></td>
        </tr> 
        <tr>
            <td>Telephone :</td>
            <td>
                <html:text property="telephone" value="<%=(String) session.getAttribute("")%>" size="30"/>
            </td> 
        </tr> 
        <tr>
            <td>Nom Responsable RH :</td>
            <td>
                <html:text property="responsable" value="<%=(String) session.getAttribute("")%>" size="30"/>
            </td> 
        </tr> 
        <tr>
            <td>Adresse email :</td>
            <td>
                <html:text property="adresseEmail" value="<%=(String) session.getAttribute("")%>" size="30"/>
            </td> 
        </tr> 
        <tr>
            <td><html:submit /></td>
        </tr>
    </html:form>
</table>
