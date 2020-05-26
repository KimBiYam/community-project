package com.myapp.community.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myapp.community.mapper.MemberMapper;
import com.myapp.community.vo.MemberVO;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private MemberMapper mapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		MemberVO member = mapper.memberGet(username);
		
		if (member == null) { 
			throw new InternalAuthenticationServiceException(username);
		}
		
		
		return new CustomUser(member);
	}

}
