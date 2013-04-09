<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insert definition="main_definition" >
	<tiles:put name="entete"  value="/jsp/entete.jsp" />
	<tiles:put name="contenu" value="/jsp/erreur_contenu.jsp" />
</tiles:insert>
