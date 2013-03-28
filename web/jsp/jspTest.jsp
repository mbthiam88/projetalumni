<%-- 
    Document   : jspTest
    Created on : 28 mars 2013, 17:47:32
    Author     : compte utilisateur
--%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <html:form action="/test">
            <bean:message key="label.add.identifiant" />:
            <html:text property="name" /> 
            <br>
            <bean:message key="label.add.mail" />
            <html:text property="mdp" /> (xx@xx.xx)  
            <html:submit />
        </html:form>
    </body>
</html>
