package com.bank.domains;
/**
 * 고객: 신용도 (1등급) credit
 */

public class CustomerBean extends MemberBean{
	private int credit;
	
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public int getCredit() {
		return credit;
	}
	
	@Override
		public String toString() {
			return String.format("아이디 :%s\n"
					+ "비밀번호 :%s\n"
					+ "이름 :%s\n"
					+ "주민번호 :%s\n"
					+ "신용등급 : %d" , getId(), getPass(), getName(), getSsn(), credit);
		}
	
}
