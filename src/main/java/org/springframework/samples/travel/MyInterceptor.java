package org.springframework.samples.travel;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.samples.travel.infrastructure.persistence.mongo.booking.MongoStatsRepository;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor extends HandlerInterceptorAdapter {

	
	private MongoStatsRepository mongostate;

	@Inject
	public MyInterceptor(MongoStatsRepository mongostate) {
		this.mongostate = mongostate;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		request.getSession().setAttribute("finished", "" + mongostate.getFinishedBookings());
		request.getSession().setAttribute("cancelled", "" + mongostate.getCancelledBookings());
		super.postHandle(request, response, handler, modelAndView);
	}
}
