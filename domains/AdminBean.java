package com.bank.domains;

public class AdminBean extends MemberBean{
	private int sabun;
	
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	
	public int getSabun() {
		return sabun;
	}
	
	@Override
	public String toString() {
		return String.format("아이디 :%s\n"
				+ "비밀번호 :%s\n"
				+ "이름 :%s\n"
				+ "주민번호 :%s\n"
				+ "사번 : %d",  getId(), getPass(), getName(), getSsn(),sabun);
	}

}
