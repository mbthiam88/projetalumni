<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <img src="images/header.png" width="425" height="106" alt="header"/>
        <font size="+1">Human Resources Portal - Emloyee Search</font> <br/>
        <hr width ="100%" noshade ="true">
        <p style="color:red">
<!--            <logic:present name="CompteLoginForm" property="error">
                <%--<bean:write name="CompteLoginForm" property="error" />--%>
            </logic:present>-->
        </p>
        <p>
            <html:errors/>
        </p>
        <html:form action="/CompteLoginAction">
            <bean:message key="error.login" /> : <html:text property="login" />
            <bean:message key="error.pass" /> : <html:text property="pass" />
            <html:submit />
        </html:form>
    </body>
</html>
