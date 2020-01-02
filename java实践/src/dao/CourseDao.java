package dao;

import java.io.*;

import java.util.*;
import entity.*;
import view.GuanLi;
import view.MainUI;

public class CourseDao implements IDao{
	   private static  String filepath="D:\\JAVAʵ��\\inter.txt";
       private HashMap<String,Course> courses;
       private  Course course;
       private static CourseDao instance = null;
       private CourseDao() throws Exception {
    	   
    	   courses=read(filepath);
    	   System.out.println(courses.size());
    	  
       }
       public static HashMap<String,Course>  read(String file) throws Exception{
   		FileInputStream fis=new FileInputStream(file);
   		InputStreamReader ir=new InputStreamReader(fis);
   		BufferedReader br=new BufferedReader(ir);
   		HashMap<String,Course> list=new HashMap<String,Course>();
   		String str=null;
   		while((str=br.readLine())!=null){
   			String[] strs=str.split(",");
   			Course stu=new Course();
   			stu.setCourseNo(strs[0]);
   			stu.setCourseName(strs[1]);
   			stu.setCourseGrade(Integer.parseInt(strs[2]));
   			list.put(strs[0],stu);
   		}
   		br.close();
   		return list;
   		
   	}
    	   
       public static void writer(String file,HashMap<String,Course> courses) throws Exception{
   		FileOutputStream fos=new FileOutputStream(file,true);
   		OutputStreamWriter osw=new OutputStreamWriter(fos);
   		PrintWriter pw=new PrintWriter(osw,true);
   		Set keySet=courses.keySet();
   		Iterator it=keySet.iterator();
   		while(it.hasNext()) {
   			Object key=it.next();
   			Course cou=(Course)courses.get(key);
   		    pw.println(cou.getCourseNo()+","+cou.getCourseName()+","+cou.getCourseGrade());	
   		}	
   		pw.close();
   	}
       public static CourseDao getInstance() throws Exception {
    	   if(instance == null) {
    		   synchronized(CourseDao.class) {
    			   if(instance == null) {
    				   instance = new CourseDao();
    				   return instance;
    			   }
    		   }
    	   }
    	   return instance;
       }
       public void insert(IEntity entity) throws Exception {
    	   Course st = (Course)entity;
    	   courses.put(st.getCourseNo(),st);
    	   FileOutputStream fs = new FileOutputStream(new File("D:\\JAVAʵ��\\inter.txt"));
			writer(filepath, courses);
       }
       public void delete() throws Exception {
    	   Scanner scanner = new Scanner(System.in);
    	   System.out.println("������ƻ�ע���Ŀγ̺ţ�");
    	    String courseNo = scanner.nextLine();
    	    if(courses.containsKey(courseNo)==true) {
    	    	 courses.remove(courseNo);
   		   FileOutputStream fs = new FileOutputStream(new File("D:\\JAVAʵ��\\inter.txt"));
		   writer(filepath, courses);
		   System.out.println("ע���ɹ���");
    	    }else {
    	    	System.out.println("�޴˿γ̣�");
    	    }
   		  
       }
       //�޸�����
       public void update() throws Exception {
    	   Scanner scanner = new Scanner(System.in);
    	   System.out.println("������ƻ��޸ĵĿγ̺ţ�");
    	   String courseNo = scanner.nextLine();
           if(courses.containsKey(courseNo)==true) {
        	   Course course=new Course();
   			System.out.println("1-�޸Ŀγ̺ţ�2-�޸Ŀγ�����3-�޸Ŀγ̷�����0-�˳�");
   			String option = scanner.nextLine();
   			switch (option) {
   			//�޸Ŀγ̺�
   			case "1":{
   			System.out.println("�������¿γ̺ţ�");
   			String courseNo1= scanner.nextLine();
   			course=courses.get(courseNo);
   			course.setCourseNo(courseNo1);
   			courses.put(courseNo1, course);
   			FileOutputStream fs = new FileOutputStream(new File("D:\\JAVAʵ��\\inter.txt"));
			writer(filepath, courses);
			  System.out.println("�޸ĳɹ�!");
   			break;
   			}
   			//�޸Ŀγ���	
   			case "2":{
   				System.out.println("�������¿�����");
   	   			String courseName= scanner.nextLine();
   	   		    course=courses.get(courseNo);
   	   		    course.setCourseName(courseName);
   	   		    courses.put(courseNo, course);
   	   		    FileOutputStream fs = new FileOutputStream(new File("D:\\JAVAʵ��\\inter.txt"));
			    writer(filepath, courses);
			    System.out.println("�޸ĳɹ�!");
   				break;
   			}//�޸Ŀγ̷���
   			case "3":{
   				System.out.println("�������·�����");
   	   			int courseGrade= scanner.nextInt();
   	   		    course=courses.get(courseNo);
   	   		    course.setCourseGrade(courseGrade);
   	   		    courses.put(courseNo, course);
   	   		    FileOutputStream fs = new FileOutputStream(new File("D:\\JAVAʵ��\\inter.txt"));
			    writer(filepath, courses);
			    System.out.println("�޸ĳɹ�!");
   				break;
   			}
   			}
           }else {
        	   System.out.println("û�д˿γ̣�");
           }
       	   GuanLi.show();
   		   } 
       public HashMap<String,IEntity> getAllEntities() throws Exception{
    	   HashMap map = new HashMap<String,IEntity>();
    	   map=read(filepath);
    	   return map;
       }
       public IEntity getEntity(String Id) {
    	   return courses.get(Id);
       }
}
