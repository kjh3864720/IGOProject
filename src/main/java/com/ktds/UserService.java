package com.ktds;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.ktds.member.biz.MemberBiz;
import com.ktds.member.vo.MemberVO;

@Component("userService")
public class UserService implements AuthenticationProvider{

	@Autowired
	public MemberBiz memberBiz;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String email = authentication.getPrincipal().toString();
		String userPassword = authentication.getCredentials().toString();
		MemberVO memberVO = new MemberVO();
		memberVO.setEmail(email);
		memberVO.setPassword(userPassword);
		
		boolean isBlockAccount = memberBiz.isBlockUser(memberVO.getEmail());
		MemberVO isLoginSuccess = new MemberVO();
		
		if ( !isBlockAccount ){
			isLoginSuccess = memberBiz.readOneMember(memberVO);
			
			if ( isLoginSuccess == null ){
				memberBiz.increaseLoginFailCount(memberVO.getEmail());
			}
			else {
				memberBiz.unblockUser(memberVO.getEmail());
			}
		}
		else {
			isLoginSuccess = null;
		}
		
		// 로그인 횟수 제한 방어코드 작성
		
		UsernamePasswordAuthenticationToken result = null;
				
		if ( isLoginSuccess != null ) {
			String token = UUID.randomUUID().toString();
			String grade;
			if ( isLoginSuccess.getAdminYN().equalsIgnoreCase("Y") ) {
				grade = "ROLE_ADMIN";
			}
			else {
				grade = "ROLE_USER";
			}
			List<GrantedAuthority> roles = new ArrayList<>();
			roles.add(new SimpleGrantedAuthority(grade));
			if (grade.equals("ROLE_ADMIN")) {
				roles.add(new SimpleGrantedAuthority("ROLE_USER"));
			}
			result = new UsernamePasswordAuthenticationToken(email, userPassword, roles);
			User user = new User(email, userPassword, grade, isBlockAccount, token);
			result.setDetails(user);
		}
		else {
			throw new BadCredentialsException("잘못된 인증");
		}
		return result;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	
	
}
