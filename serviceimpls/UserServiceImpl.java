package com.bank.serviceimpls;

import com.bank.domains.AdminBean;
import com.bank.domains.CustomerBean;
import com.bank.domains.MemberBean;
import com.bank.services.UserService;

/**
*1.고객회원가입
*2.사원회원가입
*3.고객리스트보기		
*4.사원리스트보기
*5.이름으로찾기
*6.아이디로찾기
*7.로그인
*8.고객수보기
*9.사원수보기
*10.아이디중복확인
*11.비밀번호수정
*12.회원탈퇴
*/

public class UserServiceImpl implements UserService{
	private CustomerBean[] customers;
	private AdminBean[] admins;
	
	private int countAdm, countCus;
	public UserServiceImpl() {
		customers = new CustomerBean[100];
		admins = new AdminBean[100];
		countAdm = 0;
		countCus = 0;
	}
	
	/*
	 * 1.고객회원가입
	 */
	@Override
	public void join(CustomerBean param) {
		customers[countCus] = param;
		countCus++;
	}
	/*
	 * 2.사원회원가입
	 */
	@Override
	public void register(AdminBean param) {
		admins[countAdm] = param;
		countAdm++;
	}
	/*
	 * 3. 고객리스트보기
	 */
	@Override
	public CustomerBean[] findCustomers() {
		return customers;
		
	}
	
	/*
	 * 4.사원리스트보기
	 */
	@Override
	public AdminBean[] findAdmins() {
		return admins;
	}
	/*
	 * 5.이름으로찾기
	 */
	@Override
	public MemberBean[] findByName(String name) {
		int num1= 0, num2 = 0, num3 = 0;
		for (int i = 0;i<countCus;i++) {
			if(name.equals(customers[i].getName())) {
				num1++;
				break;
			}
		}
		for(int i = 0;i<countAdm;i++) {
			if(name.equals(admins[i].getName())) {
				num2++;
				break;
			}
		}
		num3 = num1 + num2;
		MemberBean[] members = new MemberBean[num3];
		int j = 0, k = 0;
		for(int i = 0;i<countCus;i++) {
			if(name.equals(customers[i].getName())) {
				members[j] = customers[i];
				j++;
				if(num1 ==j) {
					break;
				}		
			}
		}
		for(int i = 0;i<countAdm;i++) {
			if(name.equals(admins[i].getName())) {
				members[j] = admins[i];
				k++;
				j++;
				if(num2 ==k) {
					break;
				}		
			}
		}
		return members;
	}
	/*
	 * 6.아이디로찾기
	 */
	@Override
	public MemberBean findById(String id) {
		MemberBean c = new MemberBean();
		for(int i = 0;i<countCus;i++) {
			if(id.equals(customers[i].getId())) {
				c = customers[i];
				break;
			}
		}
		for(int i = 0;i<countAdm;i++) {
			if(id.equals(admins[i].getId())) {
				c = admins[i];
				break;
			}
		}
		return c;
	}
	/*
	 * 7.로그인
	 */
	@Override
	public boolean login(MemberBean param) {
		return param
				.getPass()
				.equals(findById(param.getId()).getPass());
	}
	/*
	 * 8.고객수보기
	 */
	@Override
	public int countCustomers() {
		return countCus;
	}
	/*
	 * 9.사원수보기
	 */
	@Override
	public int countAdmins() {
		return countAdm;
	}
	/*
	 * 10.아이디중복확인
	 */
	@Override
	public boolean existId(String id) {
		boolean result = false;
		for(int i = 0;i<countCus;i++) {
			if(id.equals(customers[i].getId())) {
				result = true;
				break;
			}
		}
		for(int i = 0;i<countAdm;i++) {
			if(id.equals(admins[i].getId())) {
				result = true;
				break;
			}
		}
		return result;
	}
	/*
	 * 11.비밀번호수정
	 */
	@Override
	public void updatePass(MemberBean param) {
		String[] arr = param.getPass().split(",");
		param.setPass(arr[1]);
			if(login(param)) {
				for(int i = 0;i<countCus;i++) {
					if(param.getId().equals(customers[i].getId())) {
						customers[i].setPass(arr[2]);
						break;
					}
				}
				for(int i = 0;i<countAdm;i++) {
					if(param.getId().equals(admins[i].getId())) {
						admins[i].setPass(arr[2]);;
						break;
					}
				}
			}
		}

	/*
	 * 12.회원탈퇴
	 */
	@Override
	public void deleteMember(MemberBean param) {
		if(login(param)) {
			for(int i = 0;i<countCus;i++) {
				if(param.getId().equals(customers[i].getId())) {
					customers[i] = customers[countCus-1];
					countCus--;
					break;
				}
			}
			for(int i = 0;i<countAdm;i++) {
				if(param.getId().equals(admins[i].getId())) {
					admins[i] = admins[countAdm-1];
					countAdm--;
					break;
				}
			}
		}
	}
}	

	

