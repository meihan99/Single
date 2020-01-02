package view;

import java.util.Scanner;

import biz.*;

//注册
public class RegisterUI {
	public static void show() throws Exception {
		System.out.println("1-注册学生信息；2-注册课程信息；0-退出");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		switch (option) {
		//注册
		case "1":{
		System.out.println("请输入学号：");
		String studentNo = scanner.nextLine();
		System.out.println("请输入姓名：");
		String studentName = scanner.nextLine();
		System.out.println("请输入性别：");
		String studentGender = scanner.nextLine();
		System.out.println("请输入年龄：");
		int studentAge = Integer.parseInt(scanner.nextLine());		
		System.out.println("请输入院系：");
		String studentDepartment = scanner.nextLine();
		System.out.println("请输入密码：");
		String firstPassword = scanner.nextLine();
		System.out.println("请再次输入密码：");
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
			System.out.println("请输入管理员账号");
			String studentNo = scanner.nextLine();
			if(studentNo.equals("1001")){
				System.out.println("请输入学课程号：");
			String courseNo = scanner.nextLine();
			System.out.println("请输入课程名：");
			String courseName = scanner.nextLine();
			System.out.println("请输入课程分数：");
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
		