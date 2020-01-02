package dao;

import java.io.*;

import java.util.*;
import entity.IEntity;
import entity.Student;
import view.MainUI;

public class StudentDao implements IDao{
	   private static  String filepath="D:\\JAVA实践\\dome.txt";
       private HashMap<String,Student> students;
       private  Student student;
       private static StudentDao instance = null;
       private StudentDao() throws Exception {
    	   
    	   students=read(filepath);
    	   System.out.println(students.size());
    	  
       }
       public static HashMap<String,Student>  read(String file) throws IOException{
   		FileInputStream fis=new FileInputStream(file);
   		InputStreamReader ir=new InputStreamReader(fis);
   		BufferedReader br=new BufferedReader(ir);
   		HashMap<String,Student> list=new HashMap<String,Student>();
   		String str=null;
   		while((str=br.readLine())!=null){
   			String[] strs=str.split(",");
   			Student stu=new Student();
   			stu.setStudentNo(strs[0]);
   			stu.setStudentName(strs[1]);
   			stu.setStudentAge(Integer.parseInt(strs[4]));
   			stu.setStudentGender(strs[2]);
   			stu.setStudentPassword(strs[3]);
   			stu.setStudentDepartment(strs[5]);
   			list.put(strs[0],stu);
   		}
   		br.close();
   		return list;
   		
   	}
       public static void writer(String file,HashMap<String,Student> students) throws IOException{
   		FileOutputStream fos=new FileOutputStream(file,true);
   		OutputStreamWriter osw=new OutputStreamWriter(fos);
   		PrintWriter pw=new PrintWriter(osw,true);
   		Set keySet=students.keySet();
   		Iterator it=keySet.iterator();
   		while(it.hasNext()) {
   			Object key=it.next();
   			Student stu=(Student)students.get(key);
   		    pw.println(stu.getStudentNo()+","+stu.getStudentName()+","+stu.getStudentGender()+","
   			+stu.getStudentPassword()+","+stu.getStudentAge()+","+stu.getStudentDepartment());	
   		}	
   		pw.close();
   	}
       public static StudentDao getInstance() throws Exception {
    	   if(instance == null) {
    		   synchronized(StudentDao.class) {
    			   if(instance == null) {
    				   instance = new StudentDao();
    				   return instance;
    			   }
    		   }
    	   }
    	   return instance;
       }
       public void insert(IEntity entity) throws Exception {
    	   Student st = (Student)entity;
    	   students.put(st.getStudentNo(),st);
    	   FileOutputStream fs = new FileOutputStream(new File("D:\\JAVA实践\\dome.txt"));
			writer(filepath, students);
       }
       public void delete() throws Exception {
    	   Scanner scanner = new Scanner(System.in);
    	   System.out.println("请输入学号：");
   		   String studentNo = scanner.nextLine();
   		   if(students.containsKey(studentNo)==true) {
   			   students.remove(studentNo);
   		   FileOutputStream fs = new FileOutputStream(new File("D:\\JAVA实践\\dome.txt"));
		   writer(filepath, students);
		   System.out.println("注销成功！");
   		   }else {
   			   System.out.println("无此用户！");
   		   }
   		   
       }
       //修改数据
       public void update() throws Exception {
    	   Scanner scanner = new Scanner(System.in);
    	   System.out.println("请输入你的学号：");
    	   String studentNo = scanner.nextLine();
    	   System.out.println("请输入你的账户密码：");
    	   String Password = scanner.nextLine();
   		   if(students.containsKey(studentNo)==true&&(students.get(studentNo).getStudentPassword().equals(Password))) {
   			//修改密码	
   			    Student student=new Student();
   				System.out.println("请输入新修改密码：");
   	   			String studentPassword= scanner.nextLine();
   	   			student=students.get(studentNo);
   	   			student.setStudentPassword(studentPassword);
   	   			students.put(studentNo, student);
   	   		    FileOutputStream fs = new FileOutputStream(new File("D:\\JAVA实践\\dome.txt"));
			    writer(filepath, students);
			    System.out.println("修改成功!");
   		   } else {
   			System.out.println("你的账号或密码错误!");
   		   }
   		   MainUI.show();
       }
       public HashMap<String,IEntity> getAllEntities() throws Exception{
    	   HashMap map = new HashMap<String,IEntity>();
    	   map=read(filepath);
    	   return map;
       }
       public IEntity getEntity(String Id) {
    	   return students.get(Id);
       }
}
