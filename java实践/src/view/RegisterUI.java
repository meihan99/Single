package view;

import java.util.Scanner;

import biz.*;

//ע��
public class RegisterUI {
	public static void show() throws Exception {
		System.out.println("1-ע��ѧ����Ϣ��2-ע��γ���Ϣ��0-�˳�");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		switch (option) {
		//ע��
		case "1":{
		System.out.println("������ѧ�ţ�");
		String studentNo = scanner.nextLine();
		System.out.println("������������");
		String studentName = scanner.nextLine();
		System.out.println("�������Ա�");
		String studentGender = scanner.nextLine();
		System.out.println("���������䣺");
		int studentAge = Integer.parseInt(scanner.nextLine());		
		System.out.println("������Ժϵ��");
		String studentDepartment = scanner.nextLine();
		System.out.println("���������룺");
		String firstPassword = scanner.nextLine();
		System.out.println("���ٴ��������룺");
		String secondPassword = scanner.nextLine();
		StudentBiz sc = new StudentBiz();
		sc.register(studentNo, 
				studentName, 
				studentGender, 
				studentAge, 
				studentDepartment, 
				firstPassword, 
				secondPassword);
		break;
		}	
		case "2":{
			System.out.println("���������Ա�˺�");
			String studentNo = scanner.nextLine();
			if(studentNo.equals("1001")){
				System.out.println("������ѧ�γ̺ţ�");
			String courseNo = scanner.nextLine();
			System.out.println("������γ�����");
			String courseName = scanner.nextLine();
			System.out.println("������γ̷�����");
			int studentGrade = Integer.parseInt(scanner.nextLine());
			
			CourseBiz sc = new CourseBiz();
			sc.register(courseNo, 
					courseName, 
					studentGrade);
		            break;
			}else{
				MainUI.show();
			}
		}	
		}
	}
}
		