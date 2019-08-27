package com.bank.domains;
/**
 * 계좌번호, 거래일, 돈 accountNum, today, money
 */

public class AccountBean {
	private String today,accountNum, money;
	
	public void setToday(String today) {
		this.today = today;
	}
	
	public String getToday() {
		return today;
	}
	
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	public String getAccountNum() {
		return accountNum;
	}
	
	public void setMoney(String money) {
		this.money = money;
	}
	
	public String getMoney() {
		return money;
	}

	@Override
	public String toString() {
		return "계좌정보 [날짜=" + today + "\n"
				+ " 계좌번호=" + accountNum + "\n 잔액=" + money + "]";
	}
	

	

}
