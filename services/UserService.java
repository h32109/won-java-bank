package com.bank.services;

import com.bank.domains.AdminBean;
import com.bank.domains.CustomerBean;
import com.bank.domains.MemberBean;

public interface UserService {

	public void join(CustomerBean param);
	public void register(AdminBean param);
	public CustomerBean[] findCustomers(); 
	public AdminBean[] findAdmins();
	public MemberBean[] findByName(String name);// 고객 사원 공용
	public MemberBean findById(String id);
	public boolean login(MemberBean param);
	public int countCustomers(); //고객수
	public int countAdmins(); // 직원수
	public boolean existId(String id);
	public void updatePass(MemberBean param);
	public void deleteMember(MemberBean param);
	
}
