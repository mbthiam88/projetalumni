
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%-- 
    Document   : add
    Created on : 5 mars 2013, 13:01:00
    Author     : pierre
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page Acceuil</title>
        <link rel="stylesheet" type="text/css" href="/projetalumni/css/stylesheet.css">
    </head>
    
    
    <body>
        <font size="+1">Alumni, Page d'acceuil</font> <br/>
        
        
        <hr width ="100%" noshade ="true">
        <html:errors />
        <html:form action="/add">
            <bean:message key="label.add.identifiant" />:
            <html:text property="identifiant" /> 
            <br>
            <bean:message key="label.add.mail" />
            <html:text property="mail" /> (xx@xx.xx)  
            <html:submit />
        </html:form>
        
        <%--<html:form action="/add2">
            <bean:message key="label.add.nom" />:
            <html:text property="nom" />
            <br>
            <bean:message key="label.add.prenom" />
            <html:text property="prenom" /> 
            <br>
            <bean:message key="label.add.mail" />
            <html:text property="mail2" />
            <br>
            <bean:message key="label.add.motdepasse" />
            <html:text property="mdp" />
            <html:submit />
        </html:form>--%> 
        
<!-- ceci est un commentaire de ouffff -->
        <logic:present name="searchForm" property="results">
        <hr width ="100%" size="1" noshade ="true">
        <bean:size id="size" name="searchForm" property="results" />
        <logic:equal name="size" value="0">
        <center><bold><font color="red" >The employee is added</font></bold></center>    
            </logic:equal>
            <logic:greaterThan name="size" value="0">     
            <table border="1">
                <tr>
                    <th>Name</th>
                    <th>Social Security Number</th>
                </tr>
                <logic:iterate id="result" name="searchForm" property="results">
                    <tr>
                        <td><bean:write name="result" property="name" /></td>
                        <td><bean:write name="result" property="ssNum" /></td>
                    </tr>
                </logic:iterate>
            </table>
        </logic:greaterThan>
    </logic:present>
</body>
</html>
