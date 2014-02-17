package org.springframework.samples.travel.infrastructure.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationListener implements AuthenticationSuccessHandler, AuthenticationFailureHandler{

    int successes = 0;
    int failures = 0;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        successes++;
        request.getSession().setAttribute("successes", ""+successes);
        response.sendRedirect("/hotels/search");
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        failures++;
        request.getSession().setAttribute("failures", ""+failures);
        response.sendRedirect("/users/login?login_error=1");
    }
}
