package com.projectmanager.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.projectmanager.dao.SessionDao;
import com.projectmanager.entity.SessionEntry;

public class SessionValidatorInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	SessionDao sessionDao;
	// before the actual handler will be executed

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		boolean isSessionvalid = false;
		// Get Seesion_Id from HTTPSession or Cookie
		HttpSession session = request.getSession();

		String sessionId = String.valueOf(session.getAttribute("sessionId"));
		String userName = (String) session.getAttribute("userName");

		if(null==userName)
		{
			return false;
		}
		// Call sessionDao to check if the sesssion exists in DB or not
		SessionEntry sessionEntry = new SessionEntry();
		sessionEntry.setSessionId(sessionId);
		sessionEntry.setUserName(userName);

		isSessionvalid = sessionDao.isSessionIdPresent(sessionEntry);
		if (isSessionvalid) {
			// response.sendRedirect("home");
			isSessionvalid = true;
		} else {
			response.sendRedirect("login");
			isSessionvalid = false;
		}
		return isSessionvalid;

	}
}