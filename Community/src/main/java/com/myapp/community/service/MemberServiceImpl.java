package com.myapp.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myapp.community.mapper.MemberMapper;
import com.myapp.community.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void memberJoin(MemberVO member) {
		// TODO Auto-generated method stub
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		memberMapper.memberJoin(member);		
	}

	@Override
	public MemberVO memberGet(String id) {
		// TODO Auto-generated method stub
		return memberMapper.memberGet(id);
	}

}
