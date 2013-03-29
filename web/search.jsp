<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%-- 
    Document   : search
    Created on : 22 févr. 2013, 15:29:32
    Author     : thiam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Human Resources Portal - Emloyee Search</title>
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
    </head>
    <body>
        <font size="+1">Human Resources Portal - Emloyee Search</font> <br/>
        <hr width ="100%" noshade ="true">
        <html:errors/>
        
        <html:form action="/search">
            <bean:message key="label.search.name" />:
            <html:text property="name" />
             -- or --
            <bean:message key="label.search.ssNum" />
            <html:text property="ssNum" /> (xxx-xx-xxxx)
            <html:submit />
        </html:form>

        <logic:present name="searchForm" property="results">
            <hr width ="100%" size="1" noshade ="true">
            <bean:size id="size" name="searchForm" property="results" />
            <logic:equal name="size" value="0">
                <center>
                    <bold>
                        <font color="red" >No employees Found</font>
                    </bold>
                </center>    
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
