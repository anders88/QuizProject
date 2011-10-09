<jsp:include page="header.jsp" />

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2>
	<spring:message code="application.welcome.header" />
</h2>

<spring:message code="application.welcome.message" />

<jsp:include page="footer.jsp" />
