package com.devquiz.biz.model;

import java.util.Date;

public class MemberVO {
	public int memberIdx;
	public String id;
	public String pwd;
	public String name;
	public String nickname;
	public String email;
	public int phone;
	public int point;
	public Date joinDate;
	public int isDel;
	public int isAdmin;
	public String memberOri;
	public String memberFile;
	
	//검색조건 처리용
	//@JsonIgnore //JSON 데이터 변경 제외
	private String searchCondition;
	//@JsonIgnore
	private String searchKeyword;
	
	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public MemberVO() {
		System.out.println(">> MemberVO() 객체 생성");
	}
	
	public int getMemberIdx() {
		return memberIdx;
	}
	
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getMemberOri() {
		return memberOri;
	}
	public void setMemberOri(String memberOri) {
		this.memberOri = memberOri;
	}
	public String getMemberFile() {
		return memberFile;
	}
	public void setMemberFile(String memberFile) {
		this.memberFile = memberFile;
	}
	@Override
	public String toString() {
		return "MembersVO [memberIdx=" + memberIdx + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", nickname="
				+ nickname + ", email=" + email + ", phone=" + phone + ", point=" + point + ", joinDate=" + joinDate
				+ ", isDel=" + isDel + ", isAdmin=" + isAdmin + ", memberOri=" + memberOri + ", memberFile="
				+ memberFile + "]";
	}
	
	
}
