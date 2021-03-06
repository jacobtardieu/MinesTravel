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
                <script type="text/javascript">
                    Spring.addDecoration(new Spring.ElementDecoration({
                        elementId : "name",
                        widgetType : "dijit.form.ValidationTextBox",
                        widgetAttrs : { required : true}
                    }));
                </script>
            </p>
            <p>
                <label for="username">Username:</label>
                <br />
                <form:input path="username"/>
                <script type="text/javascript">
                    Spring.addDecoration(new Spring.ElementDecoration({
                        elementId : "username",
                        widgetType : "dijit.form.ValidationTextBox",
                        widgetAttrs : { required : true, invalidMessage : "2 characters required.",
                        regExp : "[A-Za-z0-9][A-Za-z0-9]+"}}));
                </script>
            </p>
            <p>
                <label for="password">Password:</label>
                <br />
                <form:password path="password"/>
                <script type="text/javascript">
                    Spring.addDecoration(new Spring.ElementDecoration({
                        elementId : "password",
                        widgetType : "dijit.form.ValidationTextBox",
                        widgetAttrs : { required : true, invalidMessage : "6 characters required and at least a letter and a number.",
                            regExp : "(?=.*[0-9]+)(?=.*[a-zA-Z])[0-9a-zA-Z!@#$%]{6,}"}}));
                </script>
            </p>
            <p>
                <button id="proceed" type="submit" name="_eventId_proceed">Sign up</button>
                <button id="cancel" name="_eventId_cancel">Cancel</button>
            </p>
            <script type="text/javascript">
                Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'proceed', event:'onclick'}));
            </script>
        </fieldset>
    </form:form>
</div>