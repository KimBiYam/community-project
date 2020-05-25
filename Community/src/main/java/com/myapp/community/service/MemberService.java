package com.myapp.community.service;

import com.myapp.community.vo.MemberVO;

public interface MemberService {
	
	public void memberJoin(MemberVO member); 
	public MemberVO memberGet(String id);
	

}
