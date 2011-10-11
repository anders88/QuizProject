<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>

<html>
<head>
<title><spring:message code="application.heading" /></title>
<link href="/resources/css/style.css" media="screen" rel="Stylesheet" type="text/css" />
<script src="/resources/js/jquery-1.4.4.min.js"></script>
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>
				<spring:message code="application.heading" />
			</h1>
			<p class="slogan">
				<spring:message code="application.slogan" />
			</p>
			<p class="userinfo">
				<script type="text/javascript">$('p.userinfo').load('/resources/jsp/credentials.jsp')</script>
			</p>
		</div>
		<div id="navigation">
			<ul id="navlist">
				<li><a href="/people/list"><spring:message
							code="people.list" /></a></li>
			</ul>
		</div>

		<div id="content">