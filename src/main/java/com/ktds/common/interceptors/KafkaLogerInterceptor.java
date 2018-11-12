package com.ktds.common.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ktds.member.vo.MemberVO;

public class KafkaLogerInterceptor extends HandlerInterceptorAdapter {

	/*private KafkaLogger qosLogger = new KafkaLogger();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if ( session.getAttribute("_USER_") != null ) {
			MemberVO member = (MemberVO) session.getAttribute("_USER_");
			qosLogger.info("#"+request.getRemoteAddr() + "#" + member.getEmail() + "#" + request.getRequestURI() + "#" + request.getMethod() );
		}
		else {
			qosLogger.info("#"+request.getRemoteAddr() + "##" + request.getRequestURI() + "#" + request.getMethod() );
		}
		
		
		return true;
	}*/
	
}
