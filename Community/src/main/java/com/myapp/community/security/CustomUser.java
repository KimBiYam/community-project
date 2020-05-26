package com.myapp.community.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.myapp.community.vo.MemberVO;

import lombok.Getter;

@Getter
public class CustomUser extends User {
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	private MemberVO member;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}
	

	public CustomUser(MemberVO member) {
		super(member.getName(),member.getPassword(),new ArrayList<String>(Arrays.asList(member.getAuth().split(""))).stream()
				.map(auth -> new SimpleGrantedAuthority(auth)).collect(Collectors.toList()));
		this.member = member;
	}
	
	public MemberVO getUser() {
		return member;
	}
	
	public void setUser(MemberVO member) {
		this.member = member;
	}

}
