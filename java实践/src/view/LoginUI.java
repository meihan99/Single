package view;

import java.util.Scanner;
import biz.StudentBiz;
//��¼
public class LoginUI {	

	public static void show() throws Exception {
		Scanner scanner;
		String studentNo;
		String studentPassword;
		StudentBiz studentBiz;
		System.out.println("�������˺ţ�");
		scanner = new Scanner(System.in);
		studentNo = scanner.nextLine();
		System.out.println("���������룺");
		studentPassword = scanner.nextLine();
		if(studentNo.equals("1001")&&studentPassword.equals("571249")) {
   		 System.out.println("��ӭ�㣬����Ա");
   		 GuanLi.show();
   	 }else {
   		StudentBiz student = new StudentBiz();
   		if(student.login(studentNo, studentPassword)==1){
   		 StudentUI.show(studentNo, studentPassword);
		}else{
			System.out.println("�Ҳ������û���");
			MainUI.show();
		}
	}
	}
}
