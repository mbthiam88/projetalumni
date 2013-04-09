<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insert definition="main_definition" >
	<tiles:put name="entete"  value="/jsp/entete.jsp" />
	<tiles:put name="contenu" value="/jsp/accueil_Etudiant_contenu.jsp" />
</tiles:insert>