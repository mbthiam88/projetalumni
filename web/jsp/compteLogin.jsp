<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="/projetalumni/css/stylesheet.css">
    </head>
    <body>
        <font size="+1">Entré vos Login</font> <br/>
        <hr width ="100%" noshade ="true">
        <p>
            <html:errors/>
        </p>
        <p style="color:red">
<!--            <logic:present name="<%=org.apache.struts.Globals.ERROR_KEY%>" >
                Il y a une erreur<%--<bean:write name="CompteLoginForm" property="error" />--%>
            </logic:present>-->
        </p>
        <html:form action="/CompteLoginAction">
            <bean:message key="error.login" /> : <html:text property="login" />
            <bean:message key="error.pass" /> : <html:text property="pass" />
            <html:submit />
        </html:form>
    </body>
</html>
