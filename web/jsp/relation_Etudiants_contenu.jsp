<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<h1>Coucou, voici les relations disponnibles entre les étudiants</h1>
<html:form action="/rechercheEtudiant" method="post">
    <html:hidden property="var_choice_method" value="afficherListEtudiant"/>
    <table id="recherche">
        <tr>
            <td align="right"><bean:message key="label.search.nom"/>:</td>
            <td><html:text property="name"/></td>
        </tr>
    </table>   
    <html:submit/>
</html:form>
<table border="1">
    <logic:present name="listEtudiantForm" property="results">
        <bean:size id="size" name="listEtudiantForm" property="results" />
        <logic:equal name="size" value="0">
            <div class="error">Aucun étudiant avec ce nom n'est référencé sur notre site</div>
        </logic:equal>
        <logic:greaterThan name="size" value="0">

            <tr>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Demande d'ajout</th>
            </tr>
            <logic:iterate id="result" name="listEtudiantForm" property="results">
                <tr>
                    <html:form action="/Controller_Compte_Etudiant_Ajout_Relation"> 
                        <html:hidden  name="result" property="mail"/>
                        <html:hidden  property="var_choice_method" value="compteEtudiantAjoutRelation" />
                        <td> <bean:write name="result" property="nom"/></td>
                        <td> <bean:write name="result" property="prenom"/></td>
                        <td> <html:submit value="Ajouter dans vos relation"/></td>
                    </html:form>
                </tr>
            </logic:iterate>
        </logic:greaterThan>
    </logic:present>
</table>
