package biz;

import dao.*;
import entity.*;
import view.MainUI;

public class CourseBiz {
         CourseDao courseDao;
         private Course course;
		public void register(String CourseNo,
				String CourseName,
				int CourseGrade) throws Exception {
			
				course = new Course();
				course.setCourseNo(CourseNo);
				course.setCourseName(CourseName);
				course.setCourseGrade(CourseGrade);
				courseDao = CourseDao.getInstance();
				courseDao.insert(course);
				System.out.println("×¢²á³É¹¦!");
				MainUI.show();
		}
		public void modifyPassword() throws Exception{	 
   		 course = new Course();
   		 courseDao = CourseDao.getInstance();
   		 courseDao.update();
   		 MainUI.show();
}
}
