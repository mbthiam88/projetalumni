
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%-- 
    Document   : add
    Created on : 5 mars 2013, 13:01:00
    Author     : thiam
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Human Resources Portal - Adding Emloyee</title>
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
    </head>
    <body>
        <font size="+1">Human Resources Portal -Adding Emloyee</font> <br/>
        <hr width ="100%" noshade ="true">
        <html:errors/>
        <html:form action="/add">
        <bean:message key="label.add.name" />:
         <html:text property="name" />
        <bean:message key="label.add.ssNum" />
        <html:text property="ssNum" /> (xxx-xx-xxxx)
        <html:submit />
        </html:form>
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
