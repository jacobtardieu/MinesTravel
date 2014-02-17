<%@page import="org.springframework.security.web.WebAttributes"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page import="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter" %>
<%@ page import="org.springframework.security.core.AuthenticationException" %>

<h1>Liste des utilisateurs</h1>

<table class="summary">
	<thead>
		<tr>
			<th>Utilisateur</th>
			<th>Nom</th>
			<th>Pr�nom</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user" items="${userList}">
			<tr>
				<td>${user.username}</td>
				<td>${user.name}</td>
				<td>
					<c:if test="${user.firstname != null}">
						${user.firstname}
					</c:if>
				</td>
				<td>
					<button>Delete</button>
                    <button onclick="window.location.href='<c:url value="/hotels/bookings/${user.username}" />'">View bookings</button>
					<button onClick="location.href='<c:url value="/users/admin/delete/${user.username}" />'">Delete</button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>