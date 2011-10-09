<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
       "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><spring:message code="application.heading" /></title>
<link href="/resources/css/style.css" media="screen" rel="Stylesheet"
	type="text/css" />
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
				<a href="login"><spring:message code="application.login" /></a>
			</p>
		</div>
		<div id="navigation">
			<ul id="navlist">
				<li><a href="/people/list"><spring:message
							code="people.list" /></a></li>
			</ul>
		</div>

		<div id="content">