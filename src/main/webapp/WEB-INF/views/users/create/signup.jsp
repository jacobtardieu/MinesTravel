<%@page import="org.springframework.security.web.WebAttributes"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="span-10 append-2 last">
    <form:form modelAttribute="user">
        <fieldset>
            <legend>User Information</legend>
            <p>
                <label for="name">Name:</label>
                <br />
                <form:input path="name"/>
            </p>
            <p>
                <label for="username">Username:</label>
                <br />
                <form:input path="username"/>
            </p>
            <p>
                <label for="password">Password:</label>
                <br />
                <form:password path="password"/>
            </p>
            <p>
                <button id="proceed" type="submit">Sign up</button>
                <button id="cancel">Cancel</button>
            </p>
        </fieldset>
    </form:form>
</div>