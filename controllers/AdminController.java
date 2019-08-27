package com.bank.controllers;

import javax.swing.JOptionPane;

import com.bank.domains.AccountBean;
import com.bank.serviceimpls.AdminServiceImpl;
import com.bank.services.AdminService;

public class AdminController {

	public static void main(String[] args) {
		AccountBean account = null;
		AdminService service = new AdminServiceImpl();
		String[] arr = null;
		String temp = "";
		
		while(true) {
			switch (JOptionPane.showInputDialog("0.종료\n1.계좌생성\n3.모든계좌보기"
					+ "\n4.계좌번호로찾기\n5.계좌개수보기\n6.계좌번호중복확인\n8.입금\n9.인출\n10.계좌삭제")) {
			case "0":
				return;
				
			case "1":
				String result = JOptionPane.showInputDialog("계좌를 만들으시려면 입금해 주세요.");
				service.createAccount(result);
				break;

			case "3":
				AccountBean[] accounts = service.findAll();
				for(int i = 0;i<service.countAccount();i++) {
					temp += accounts[i].toString() + "\n\n";
				}
				JOptionPane.showMessageDialog(null, temp);
				break;
				
			case "4":
				temp = "";
				temp = JOptionPane.showInputDialog("계좌번호를 입력해 주세요.");
				JOptionPane.showMessageDialog(null, service.findByAccountNum(temp).toString());
				break;
				
			case "5":
				JOptionPane.showMessageDialog(null, service.countAccount());
				break;
				
			case "6":
				temp = "";
				temp = JOptionPane.showInputDialog("계좌번호를 입력해 주세요.\n true면 계좌번호 생성이 불가합니다.");
				JOptionPane.showMessageDialog(null, service.existAccountNum(temp));
				break;
				
			case "7":
				JOptionPane.showMessageDialog(null, service.findDate());
				break;
				
			case "8":
				arr = JOptionPane.showInputDialog("계좌번호, 입금할 돈을 입력해 주세요.").split(",");
				account = new AccountBean();
				account.setAccountNum(arr[0]);
				account.setMoney(arr[1]);
				break;
				
			case "9":
				arr = JOptionPane.showInputDialog("계좌번호, 출금할 돈을 입력해 주세요.").split(",");
				account = new AccountBean();
				account.setAccountNum(arr[0]);
				account.setMoney(arr[1]);
				break;
				
			case "10":
				temp = JOptionPane.showInputDialog("계좌번호를 입력해 주세요.");
				service.deleteAccountNum(temp);
				break;

			default:
				break;
			}
		}

	}

}
