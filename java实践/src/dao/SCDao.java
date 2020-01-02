package dao;

import java.io.*;
import java.util.*;
import entity.*;
import view.GuanLi;
import view.MainUI;

public class SCDao implements IDao{
	private static  String filepath="D:\\JAVA实践\\sc.txt";
    private HashMap<String,SC> scs;
    private  SC sc;
    private static SCDao instance = null;
    private SCDao() throws Exception {
 	   
 	   scs=read(filepath);
 	   System.out.println(scs.size());
 	  
    }
    public static HashMap<String,SC>  read(String file) throws Exception{
		FileInputStream fis=new FileInputStream(file);
		InputStreamReader ir=new InputStreamReader(fis);
		BufferedReader br=new BufferedReader(ir);
		HashMap<String,SC> list=new HashMap<String,SC>();
		String str=null;
		while((str=br.readLine())!=null){
			String[] strs=str.split(",");
			SC stu=new SC();
			stu.setStudentNo(strs[0]);
			stu.setCourseNo(strs[1]);
			stu.setGrade(Integer.parseInt(strs[2]));
			list.put(strs[0],stu);
		}
		br.close();
		return list;
		
	}
 	   
    public static void writer(String file,HashMap<String,SC> scs) throws Exception{
		FileOutputStream fos=new FileOutputStream(file,true);
		OutputStreamWriter osw=new OutputStreamWriter(fos);
		PrintWriter pw=new PrintWriter(osw,true);
		Set keySet=scs.keySet();
		Iterator it=keySet.iterator();
		while(it.hasNext()) {
			Object key=it.next();
			SC sc=(SC)scs.get(key);
		    pw.println(sc.getStudentNo()+","+sc.getCourseNo()+","+sc.getGrade());	
		}	
		pw.close();
	}
    public static SCDao getInstance() throws Exception {
 	   if(instance == null) {
 		   synchronized(SCDao.class) {
 			   if(instance == null) {
 				   instance = new SCDao();
 				   return instance;
 			   }
 		   }
 	   }
 	   return instance;
    }
    public void insert(IEntity entity) throws Exception {
 	   SC st = (SC)entity;
 	   scs.put(st.getStudentNo(),st);
 	   FileOutputStream fs = new FileOutputStream(new File("D:\\JAVA实践\\sc.txt"));
		writer(filepath, scs);
    }
    public void delete() throws Exception {
 	   Scanner scanner = new Scanner(System.in);
 	   System.out.println("请输入删除学号：");
 	    String studentNo = scanner.nextLine();
 	    if(scs.containsKey(studentNo)==true) {
 	    	scs.remove(studentNo);
		   FileOutputStream fs = new FileOutputStream(new File("D:\\JAVA实践\\sc.txt"));
		   writer(filepath, scs);
		   System.out.println("注销成功！");
 	    }else {
 	    	System.out.println("无此信息！");
 	    }
		   
    }
    //修改数据
    public void update() throws Exception {
 	   Scanner scanner = new Scanner(System.in);
 	   System.out.println("请输入修改学生学号：");
 	   String studentNo = scanner.nextLine();
           if(scs.containsKey(studentNo)==true) {
        	   SC sc=new SC();
			System.out.println("1-修改课程号；2-修改课程分数；0-退出");
			String option = scanner.nextLine();
			switch (option) {
			//修改课程号
			case "1":{
			System.out.println("请输入新课程号：");
			String courseNo= scanner.nextLine();
			sc=scs.get(studentNo);
			sc.setCourseNo(courseNo);
			scs.put(courseNo, sc);
			FileOutputStream fs = new FileOutputStream(new File("D:\\JAVA实践\\sc.txt"));
			writer(filepath, scs);
			System.out.println("修改成功!");
			break;
			}
			//修改课程分数	
			case "2":{
				System.out.println("请输入应新课程分数：");
	   			int Grade= scanner.nextInt();
	   		    sc=scs.get(studentNo);
	   		    sc.setGrade(Grade);
	   		    scs.put(studentNo, sc);
	   		    FileOutputStream fs = new FileOutputStream(new File("D:\\JAVA实践\\sc.txt"));
			    writer(filepath, scs);
			    System.out.println("修改成功!");
				break;
			}	
			}
           }else {
        	   System.out.println("未有此学生的选课信息!");
           }
         	GuanLi.show();
		   } 
    public HashMap<String,IEntity> getAllEntities() throws Exception{
 	   HashMap map = new HashMap<String,IEntity>();
 	   map=read(filepath);
 	   return map;
    }
    public IEntity getEntity(String Id) {
 	   return scs.get(Id);
    }
}
