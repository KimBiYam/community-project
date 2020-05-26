package com.myapp.community.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
public class LoginFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String errormsg = null;

		if (exception instanceof BadCredentialsException) {
			errormsg = "패스워드가 일치하지 않습니다.";
			request.setAttribute("loginid", request.getParameter("username"));
		} else if (exception instanceof InternalAuthenticationServiceException) {
			errormsg = "존재하지 않는 아이디입니다.";
		}

		request.setAttribute("errormsg", errormsg);
		request.getRequestDispatcher("/member/login?error=true").forward(request, response);

	}

}
