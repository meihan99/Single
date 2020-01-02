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
	   		System.out.println("�γ�");
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
	   		System.out.println("������γ̺ţ�");
			String courseNo = scanner.nextLine();
			
			
			if(map.containsKey(courseNo)==true) {
			System.out.println("�����������");
			int grade = scanner.nextInt();
			   sc = new SC();
			   sc.setStudentNo(studentNo);
			   sc.setCourseNo(courseNo);
			   sc.setGrade(grade);
			   scDao =SCDao.getInstance();
			   scDao.insert(sc);
			   System.out.println("ѡ�γɹ�!");
		   }else{
			   System.err.println("ѡ��ʧ��!");
			}  
			}
		 StudentUI.show(studentNo,studentPassword);
	   }	   
	}
