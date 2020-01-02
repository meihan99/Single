package view;

import java.util.HashMap;
import java.util.Scanner;

import biz.*;
import dao.CourseDao;
import dao.StudentDao;
import entity.IEntity;
import entity.Student;

public class StudentUI {
	public static void show(String studentNo,String studentPassword) throws Exception{
		HashMap<String, IEntity> map = new HashMap<String,IEntity>();
		StudentDao studentDao = StudentDao.getInstance();
	    map=studentDao.getAllEntities();
		String option;
		System.out.println("1-ѡ�Σ�2-�˿Σ�0-�˳�");
		Scanner scanner = new Scanner(System.in);
		 option = scanner.nextLine();
		switch (option) {
		//ѡ��
		case "1":
			CourseSelection.show(studentNo, studentPassword);
			break;
		//
		case "2":{
			CourseSelection.show2(studentNo, studentPassword);
			break;
		}	
		}
		MainUI.show();
	}
}
