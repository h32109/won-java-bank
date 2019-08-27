package com.bank.controllers;

import javax.swing.JOptionPane;

import com.bank.domains.AdminBean;
import com.bank.domains.CustomerBean;
import com.bank.domains.MemberBean;
import com.bank.serviceimpls.UserServiceImpl;
import com.bank.services.UserService;

public class UserController {

	public static void main(String[] args) {
		MemberBean member = null;
		CustomerBean customer = null;
		AdminBean admin = null;
		UserService service = new UserServiceImpl();
		String[] spec = null;
		String temp = "";
		
		while(true) {
			switch (JOptionPane.showInputDialog("0.종료\n1.고객회원가입\n2.사원회원가입\n3.고객리스트보기\n4.사원리스트보기\n5.이름으로찾기"
					+ "\n6.아이디로찾기\n7.로그인\n8.고객수보기\n9.사원수보기\n10.아이디중복확인\n11.비밀번호수정\n12.회원탈퇴")) {
			case "0":
				return;
				
			case "1":
				customer = new CustomerBean();
				spec = JOptionPane.showInputDialog("이름,아이디,비번,주민번호를 입력해주세요.\n"
						+ "주민번호 예 : xxxxxx-xxxxxxx").split(",");
				customer.setName(spec[0]);
				customer.setId(spec[1]);
				customer.setPass(spec[2]);
				customer.setSsn(spec[3]);
				service.join(customer);
				break;
				
			case "2":
				admin = new AdminBean();
				spec = JOptionPane.showInputDialog("이름,아이디,비번,주민번호를 입력해주세요.\n"
						+ "주민번호 예 : xxxxxx-xxxxxxx").split(",");
				admin.setName(spec[0]);
				admin.setId(spec[1]);
				admin.setPass(spec[2]);
				admin.setSsn(spec[3]);
				break;
				
				
			case "3":
				temp = "";
				CustomerBean[] customers = service.findCustomers();
				for(int i = 0;i<service.countCustomers();i++) {
					temp += customers[i].toString() + "\n\n";
				}
				JOptionPane.showMessageDialog(null, temp);
				break;
				
			case "4":
				temp = "";
				AdminBean[] admins = service.findAdmins();
				for(int i = 0;i<service.countAdmins();i++) {
					temp += admins[i].toString() + "\n\n";
				}
				JOptionPane.showMessageDialog(null, temp);
				break;
				
			case "5":
				String name = JOptionPane.showInputDialog("이름을 입력해 주세요.");
				JOptionPane.showMessageDialog(null, service.findByName(name).toString());
				break;
				
			case "6":
				String id = JOptionPane.showInputDialog("아이디를 입력해 주세요.");
				JOptionPane.showMessageDialog(null, service.findById(id).toString());
				break;
				
			case "7":
				member = new MemberBean();
				spec = JOptionPane.showInputDialog("아이디, 비밀번호를 입력해 주세요./n true면 로그인").split(",");
				member.setId(spec[0]);
				member.setPass(spec[1]);
				JOptionPane.showMessageDialog(null, service.login(member));
				break;
				
			case "8":
				JOptionPane.showMessageDialog(null, String.format("%d명", service.countCustomers()));
				break;
				
			case "9":
				JOptionPane.showMessageDialog(null, String.format("%d명", service.countAdmins()));
				break;
				
			case "10":
				String user = JOptionPane.showInputDialog("아이디를 입력해 주세요.\n 가입이 가능하면 false로 나옵니다.");
				JOptionPane.showMessageDialog(null, service.existId(user));
				break;
				
				
			case "11":
				member = new MemberBean();
				spec = JOptionPane.showInputDialog("아이디, 비밀번호, 신규비밀번호를 입력해 주세요.").split(",");
				member.setId(spec[0]);
				member.setPass(spec[1]+","+spec[2]);
				service.updatePass(member);
				break;
				
				
			case "12":
				member = new MemberBean();
				spec = JOptionPane.showInputDialog("아이디, 비밀번호를 입력해 주세요.").split(",");
				member.setId(spec[0]);
				member.setPass(spec[1]);
				service.deleteMember(member);
				break;

			default:
				break;
			}
		}

	}

}
