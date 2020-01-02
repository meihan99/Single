package biz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import dao.*;
import entity.*;
import view.MainUI;
import view.StudentUI;

public class SCBiz {
	SCDao scDao;
	CourseDao courseDao;
	StudentDao studentDao;
	HashMap<String, IEntity> map = new HashMap<String,IEntity>();
    private SC sc;
	  public void xuanke(String studentNo,String studentPassword) throws Exception {
		    
		 studentDao = StudentDao.getInstance();
       	 Student student = (Student)studentDao.getEntity(studentNo);
		  if(student.getStudentNo().equals(studentNo)) {
	   		System.out.println("课程");
		    courseDao = CourseDao.getInstance();
		    map=courseDao.getAllEntities();
		    Set keySet=map.keySet();
	   	    Iterator in=keySet.iterator();
	   		while(in.hasNext()){
	   			Object key=in.next();
	   			Course cou=(Course)map.get(key);
	   		    System.out.println(cou.getCourseNo()+","+cou.getCourseName()+","+cou.getCourseGrade());	
	   		}	
	   		Scanner scanner = new Scanner(System.in);
	   		System.out.println("请输入课程号：");
			String courseNo = scanner.nextLine();
			
			
			if(map.containsKey(courseNo)==true) {
			System.out.println("请输入分数：");
			int grade = scanner.nextInt();
			   sc = new SC();
			   sc.setStudentNo(studentNo);
			   sc.setCourseNo(courseNo);
			   sc.setGrade(grade);
			   scDao =SCDao.getInstance();
			   scDao.insert(sc);
			   System.out.println("选课成功!");
		   }else{
			   System.err.println("选课失败!");
			}  
			}
		 StudentUI.show(studentNo,studentPassword);
	   }	   
	}
