package com.bank.serviceimpls;
/**
 *1.계좌생성
 *2.계좌번호생성
 *3.모든계좌보기
 *4.계좌번호로찾기
 *5.계좌개수보기
 *6.계좌번호중복확인
 *7.날짜보기
 *8.입금
 *9.인출
 *10.계좌삭제
 */

import com.bank.domains.AccountBean;
import com.bank.services.AdminService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class AdminServiceImpl implements AdminService {

	private AccountBean[] accounts;
	private int count;

	
	public AdminServiceImpl() {
		accounts = new AccountBean[100];
		count = 0;
	}
/**
 * 1.계좌생성
 */
	
	
	@Override
	public void createAccount(String money) {
		AccountBean account = new AccountBean();
		account.setAccountNum(createAccountNum());
		account.setMoney(money+"");
		account.setToday(findDate());
		accounts[count] = account;
		count++;
	}

	/**
	 *2.계좌번호생성
	 */
	
	@Override
	public String createAccountNum() {
		String result = "";
		Random ran = new Random();
		for(int i =0;i<9;i++) {
			result += (i==4)?"-":ran.nextInt(10);
		}
		return result;
	}
	
	/**
	 * 3.모든계좌보기
	 */
	
	
	@Override
	public AccountBean[] findAll() {
		return accounts;
	}
	
	/**
	 *4.계좌번호로찾기
	 */

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean acc = new AccountBean();
		for(int i =0;i<count;i++) {
			if(findAll()[i].getAccountNum().equals(accountNum)) {
				acc = findAll()[i];
			}
		}
		return acc;
	}

	/**
	 *5.계좌개수보기
	 */
	
	@Override
	public int countAccount() {
		return count;
	}

	/**
	 *6.계좌번호중복확인
	 */
	
	@Override
	public boolean existAccountNum(String accountNum) {
		boolean a = false;
		for(int i =0;i<count;i++) {
			if(findAll()[i].getAccountNum().equals(accountNum)) {
				a = true;
			}
		}
		return a;
	}

	/**
	 *7.날짜보기
	 */
	
	@Override
	public String findDate() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date());
	}

	/**
	 *8.입금
	 */
	
	@Override
	public void depositMoney(AccountBean param) {
		for(int i = 0;i<count;i++) {
			if(param.getAccountNum().equals(accounts[i].getAccountNum())) {
				int val = Integer.parseInt(param.getMoney())
				+Integer.parseInt(accounts[i].getMoney());
				accounts[i].setMoney(String.valueOf(val));
			}
		}
	}

	/**
	 *9.인출
	 */
	
	@Override
	public void withdrawMoney(AccountBean param) {
		for(int i = 0;i<count;i++) {
			if(param.getAccountNum().equals(accounts[i].getAccountNum())) {
				int val = Integer.parseInt(param.getMoney())
				-Integer.parseInt(accounts[i].getMoney());
				accounts[i].setMoney(String.valueOf(val));
			}
		}
	}

	/**
	 *10.계좌삭제
	 */
	
	@Override
	public void deleteAccountNum(String accountNum) {
		for(int i = 0;i<count;i++) {
			if(accountNum.equals(accounts[i].getAccountNum())) {
				accounts[i] = accounts[count-1];
				count--;
			}
		}
	}


}
