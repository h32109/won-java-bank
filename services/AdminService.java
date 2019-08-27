package com.bank.services;

import com.bank.domains.AccountBean;

public interface AdminService {
	public void createAccount(String money);
	public String createAccountNum(); // 계좌번호 생성(1234-5678랜덤)
	public AccountBean[] findAll();
	public AccountBean findByAccountNum(String accountNum);
	public int countAccount();
	public boolean existAccountNum(String accountNum);
	String findDate(); // 오늘날짜,현재시간(분까지) 반환
	public void depositMoney(AccountBean param);
	public void withdrawMoney(AccountBean param);
	public void deleteAccountNum(String accountNum);

}
