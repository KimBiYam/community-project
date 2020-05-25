package com.myapp.community.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.myapp.community.vo.MemberVO;

@Mapper
public interface MemberMapper {
	
	public void memberJoin(MemberVO member);
	public MemberVO memberGet(String id);
	public MemberVO authGet(String id);

}

