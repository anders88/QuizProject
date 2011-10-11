<jsp:include page="header.jsp" />

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2>
	<spring:message code="people.list" />
</h2>

<c:if test="${empty people}">
	<spring:message code="application.empty.list" />
</c:if>
<table>
	<c:forEach items="${people}" var="person" varStatus="index">
		<tr>
			<td><c:out value="${person.name}" /></td>
			<td><a href="show?id=${person.id}"> <spring:message
						code="application.show.link" /></a></td>
			<td><a href="update?id=${person.id}"><spring:message
						code="application.edit.link" /></a></td>
			<td><a href="delete?id=${person.id}"> <spring:message
						code="application.delete.link" />
			</a></td>
		</tr>
	</c:forEach>
</table>
<p></p>

<a href="create"><spring:message code="application.new.link" /></a>

<jsp:include page="footer.jsp" />

