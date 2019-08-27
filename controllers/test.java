package com.bank.controllers;

import com.bank.services.AdminService;
import com.bank.serviceimpls.AdminServiceImpl;

public class test {

	public static void main(String[] args) {
		AdminService service = new AdminServiceImpl();
		System.out.println(service.createAccountNum());
	}

}
