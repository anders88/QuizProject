<jsp:include page="header.jsp" />

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2>
	<spring:message code="people.list" />
</h2>

<c:if test="${empty people}">
	<spring:message code="applikation.empty.list" />
</c:if>
<table>
	<c:forEach items="${people}" var="person" varStatus="index">
		<tr>
			<td><c:out value="${person.name}" /></td>
			<td><spring:message code="application.show.link" /></td>
			<td><spring:message code="application.edit.link" /></td>
		</tr>
	</c:forEach>
</table>
<p></p>

<a href="create"> <spring:message code="application.new.link" />
</a>
&nbsp;|&nbsp;
<a href="search_person"> <spring:message
		code="application.search.link" />
</a>

<jsp:include page="footer.jsp" />

