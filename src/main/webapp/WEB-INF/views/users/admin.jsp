<%@page import="org.springframework.security.web.WebAttributes"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page import="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter" %>
<%@ page import="org.springframework.security.core.AuthenticationException" %>

<h1>Liste des utilisateurs</h1>

<table>
	<tr>
		<th>Utilisateur</th>
		<th>Nom</th>
		<th>Prénom</th>
	</tr>
	<c:forEach var="user" items="${userList}">
		<tr>
			<td>${user.username}</td>
			<td>${user.name}</td>
			<td></td>
		</tr>
	</c:forEach>
</table>