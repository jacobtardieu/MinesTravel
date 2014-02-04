<%@page import="org.springframework.security.web.WebAttributes"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page import="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter" %>
<%@ page import="org.springframework.security.core.AuthenticationException" %>

<div class="span-10 append-2 last">
    <form  action="<c:url value="/users/add" />" method="post">
        <fieldset>
            <legend>User Information</legend>
            <p>
                <label for="login">User:</label>
                <br />
                <input type="text" name="login" id="login" required />
            </p>
            <p>
                <label for="password">Password:</label>
                <br />
                <input type="password" name="password" id="password" required />
            </p>
            <p>
                <button id="submit" type="submit">Sign up</button>
            </p>
        </fieldset>
    </form>
</div>