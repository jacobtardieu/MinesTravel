<%@ page import="org.springframework.security.web.WebAttributes" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page import="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter" %>
<%@ page import="org.springframework.security.core.AuthenticationException" %>

<h1>Mon profil</h1>

<form:form modelAttribute="user">
    <fieldset>
        <legend>User Information</legend>
        <p>
            <label for="name">Name:</label>
            <br />
            <form:input path="name"/>
        </p>
        <p>
            <label for="firstname">Firstname:</label>
            <br />
            <form:input path="firstname"/>
        </p>
        <p>
            <label for="age">Age:</label>
            <br />
            <form:input path="age"/>
        </p>
        <p>
            <button id="proceed" type="submit" name="_eventId_proceed">Save</button>
        </p>
        <script type="text/javascript">
            Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'proceed', event:'onclick'}));
        </script>
    </fieldset>
</form:form>