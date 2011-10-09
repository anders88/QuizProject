<jsp:include page="header.jsp" />

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2>
	<spring:message code="person.heading" />
</h2>
<table>
	<tr>
		<td><b><spring:message code="person.name" />:</b></td>
		<td><c:out value="${person.name}"></c:out></td>
	</tr>
</table>
<p />
<a href="update?id=${person.id}"><spring:message
		code="application.edit.link" /></a>
&nbsp;|&nbsp;
<a href="delete?id=${person.id}"> <spring:message
		code="application.delete.link" />
		
<jsp:include page="footer.jsp" />