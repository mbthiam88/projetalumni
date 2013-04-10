<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>



<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/javaScript/css/ui-lightness/jquery-ui.css" />
        <script src="<%=request.getContextPath()%>/javaScript/js/jquery-1.9.1.js"></script>
        <script src="<%=request.getContextPath()%>/javaScript/js/jquery-ui-1.10.2.custom.js"></script>
        <script src="<%=request.getContextPath()%>/javaScript/js/jquery-ui-1.10.2.custom.min.js"></script>
        <title>
            Alumni
        </title>
        <!-- La feuille de styles "base.css" doit être appelée en premier. -->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/base.css" media="all" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/modele05.css" media="screen" /> 
        <script type="text/javascript">
            $(window).load(function()
            {
                $('#mydate').datepicker();
            });
             $(window).load(function()
            {
                $('#mydate2').datepicker();
            });
        </script>
</head>

<body>

<div id="global">

	<div id="entete">
            <tiles:insert attribute="entete" />
	</div>

	<div id="navigation">
            <tiles:insert attribute="navigation" />
	</div>

	<div id="contenu">
            <tiles:insert attribute="contenu" />
	</div>

</div>

</body>
</html>
