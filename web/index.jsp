<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html>
    <head>
        <title>Page de recherche des employ�s</title>
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
    </head>
    <body>
        <table>
            <tr>    
                <td><html:link forward="search" >Search for Employees</html:link></td> 
                <td> rechercher un employ�</td>
            </tr>
            <tr>
                <td><html:link forward="add" >Add an Employees</html:link></td>
                <td>Ajouter un employ�</td>
            </tr>
        </table>
    </body>
</html>