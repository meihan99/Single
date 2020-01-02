package view;

import java.util.HashMap;

import biz.*;
import dao.*;
import entity.*;

//Ñ¡¿Î
public class CourseSelection {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MainUI.show();
	}
	
	public static void show(String studentNo,String studentPassword) throws Exception{
	    HashMap<String, IEntity> map = new HashMap<String,IEntity>();
		StudentDao studentDao = StudentDao.getInstance();
	    map=studentDao.getAllEntities();
	    if(map.containsKey(studentNo)==true&&(((Student)map.get(studentNo)).getStudentPassword().equals(studentPassword))){
			SCBiz sb=new SCBiz();
		sb.xuanke(studentNo,studentPassword);
		}
	}
	public static void show2(String studentNo,String studentPassword) throws Exception{
	    HashMap<String, IEntity> map = new HashMap<String,IEntity>();
		StudentDao studentDao = StudentDao.getInstance();
		map=studentDao.getAllEntities();
		if(map.containsKey(studentNo)==true&&(((Student)map.get(studentNo)).getStudentPassword().equals(studentPassword))){
			SCDao sDao = SCDao.getInstance();
			sDao.delete();
		}
	}
}
