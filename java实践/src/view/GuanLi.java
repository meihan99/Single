package view;

import java.util.Scanner;

import dao.*;

public class GuanLi {
        //注销账户
	public static void show() throws Exception {
		System.out.println("1-注销学生账户；2-注销课程信息；3-注销选课信息；"
				+"4-修改课程信息；5-修改选课信息；0-退出");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		switch (option) {
		//注销学生账户
		case "1":{
			StudentDao studentDao = StudentDao.getInstance();
			studentDao.delete();
			break;
		}		
		//注销课程信息	
		case "2":{
			CourseDao courseDao = CourseDao.getInstance();
			courseDao.delete();
			break;
		}
		//注销选课信息	
		case "3":{
			SCDao scDao = SCDao.getInstance();
			scDao.delete();
			break;
		}	
		//修改课程信息
		case "4":{
			CourseDao courseDao = CourseDao.getInstance();
			courseDao.update();
			break;
		}
		//修改选课信息
		case "5":{
			SCDao scDao = SCDao.getInstance();
			scDao.update();
			break;
		}
		}
		MainUI.show();
	}
}
