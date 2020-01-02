package biz;

import dao.StudentDao;
import entity.Student;
import view.GuanLi;
import view.MainUI;

public class StudentBiz {
         StudentDao studentDao;
         private Student student;
  //��¼
         public int login(String studentNo,String  studentPassword) throws Exception {
        	 
        	 studentDao = StudentDao.getInstance();
        	 student = (Student)studentDao.getEntity(studentNo);
        	 if(student == null) {
        		 System.out.println("�û�������");	 
        		 return 0;
        	 }else if (student.getStudentPassword().equals(studentPassword)) {
        		 System.out.println("��½�ɹ�");
        		 return 1;
        	 }else {
        		 System.out.println("���벻��ȷ");
        		 return 0;
        	  }	 
         }
  //ע��
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
        		 System.out.println("ע��ɹ�!");
        	 }else {
        		 System.err.println("ע��ʧ��!");
        		} 
        	 MainUI.show();
         }
      //�޸�����
         public void modifyPassword() throws Exception{	 
        		 student = new Student();
        		 studentDao = StudentDao.getInstance();
        		 studentDao.update();
        		 MainUI.show();
}
         
}
