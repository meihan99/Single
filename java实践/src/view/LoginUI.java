package view;

import java.util.Scanner;
import biz.StudentBiz;
//登录
public class LoginUI {	

	public static void show() throws Exception {
		Scanner scanner;
		String studentNo;
		String studentPassword;
		StudentBiz studentBiz;
		System.out.println("请输入账号：");
		scanner = new Scanner(System.in);
		studentNo = scanner.nextLine();
		System.out.println("请输入密码：");
		studentPassword = scanner.nextLine();
		if(studentNo.equals("1001")&&studentPassword.equals("571249")) {
   		 System.out.println("欢迎你，管理员");
   		 GuanLi.show();
   	 }else {
   		StudentBiz student = new StudentBiz();
   		if(student.login(studentNo, studentPassword)==1){
   		 StudentUI.show(studentNo, studentPassword);
		}else{
			System.out.println("找不到此用户！");
			MainUI.show();
		}
	}
	}
}
