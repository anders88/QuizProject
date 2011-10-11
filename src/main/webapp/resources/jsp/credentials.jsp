<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
       <a href="/logout">Logg ut</a>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
	<form id="loginform" action="../../j_spring_security_check" method="post">
		<table>
			<tr>
				<td><input type="text" id="j_username" name="j_username" placeholder="Brukernavn" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}" pattern="[a-zA-Z0-9]*"/></td>
				<td><input type="password" id="j_password" name="j_password" placeholder="Passord" /> </td>
				<td><input type="submit" value="Logg inn" class="button" /></td>
			</tr>
				<tr><td colspan="3" class="login-error-message">${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</td>
			</tr>
		</table>
	</form>
</sec:authorize>