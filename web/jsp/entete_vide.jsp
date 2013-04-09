<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean"  prefix="bean" %>

<logic:present name="mail" scope="session">
    Bienvenue <bean:write name="nom" scope="session"/>! 
</logic:present> 

<logic:notPresent name="mail" scope="session">
    il n'y a pas de session test
    <%--<logic:forward name="PageAcceuil"/>--%>
</logic:notPresent>
