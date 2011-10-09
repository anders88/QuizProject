<jsp:include page="header.jsp" />

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2>
	<spring:message code="person.new.header" />
</h2>

<form:form modelAttribute="person" method="POST" action="/people/create">
	<table>
		<tr>
			<td><form:label path="name">
					<spring:message code="person.name" />
				</form:label></td>
			<td><form:input path="name" /></td>
		</tr>
	</table>
	<p>
		<input type="submit" value="Lagre" />
	</p>
</form:form>
<a href="/people/list"> <spring:message
		code="application.abort.link" /></a>
<jsp:include page="footer.jsp" />