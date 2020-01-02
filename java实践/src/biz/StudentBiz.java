package biz;

import dao.StudentDao;
import entity.Student;
import view.GuanLi;
import view.MainUI;

public class StudentBiz {
         StudentDao studentDao;
         private Student student;
  //登录
         public int login(String studentNo,String  studentPassword) throws Exception {
        	 
        	 studentDao = StudentDao.getInstance();
        	 student = (Student)studentDao.getEntity(studentNo);
        	 if(student == null) {
        		 System.out.println("用户不存在");	 
        		 return 0;
        	 }else if (student.getStudentPassword().equals(studentPassword)) {
        		 System.out.println("登陆成功");
        		 return 1;
        	 }else {
        		 System.out.println("密码不正确");
        		 return 0;
        	  }	 
         }
  //注册
         public void register(String studentNo,
        		               String studentName,
        		               String studentGender,
        		               int studentAge,
        		               String studentDepartment,
        		               String firstPassword,
        		               String secondPassword) throws Exception {
        	 if(firstPassword.contentEquals(secondPassword)) {
        		 student = new Student();
        		 student.setStudentNo(studentNo);
        		 student.setStudentName(studentName);
        		 student.setStudentAge(studentAge);
        		 student.setStudentGender(studentGender);
        		 student.setStudentDepartment(studentDepartment);
        		 student.setStudentPassword(firstPassword);
        		 studentDao = StudentDao.getInstance();
        		 studentDao.insert(student);
        		 System.out.println("注册成功!");
        	 }else {
        		 System.err.println("注册失败!");
        		} 
        	 MainUI.show();
         }
      //修改密码
         public void modifyPassword() throws Exception{	 
        		 student = new Student();
        		 studentDao = StudentDao.getInstance();
        		 studentDao.update();
        		 MainUI.show();
}
         
}
