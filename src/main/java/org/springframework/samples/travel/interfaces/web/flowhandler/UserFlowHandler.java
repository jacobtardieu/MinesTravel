package org.springframework.samples.travel.interfaces.web.flowhandler;

import org.springframework.webflow.core.FlowException;
import org.springframework.webflow.execution.FlowExecutionOutcome;
import org.springframework.webflow.execution.repository.NoSuchFlowExecutionException;
import org.springframework.webflow.mvc.portlet.AbstractFlowHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by calixtebonsart on 04/02/14.
 */
public class UserFlowHandler extends AbstractFlowHandler {

    private static final String REDIRECT_URL = "contextRelative:/users/create";

}
