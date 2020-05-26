package com.myapp.community.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String password;
	private String name;
	private Date regdate;
	private String auth;
}
 