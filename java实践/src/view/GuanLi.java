package view;

import java.util.Scanner;

import dao.*;

public class GuanLi {
        //ע���˻�
	public static void show() throws Exception {
		System.out.println("1-ע��ѧ���˻���2-ע���γ���Ϣ��3-ע��ѡ����Ϣ��"
				+"4-�޸Ŀγ���Ϣ��5-�޸�ѡ����Ϣ��0-�˳�");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		switch (option) {
		//ע��ѧ���˻�
		case "1":{
			StudentDao studentDao = StudentDao.getInstance();
			studentDao.delete();
			break;
		}		
		//ע���γ���Ϣ	
		case "2":{
			CourseDao courseDao = CourseDao.getInstance();
			courseDao.delete();
			break;
		}
		//ע��ѡ����Ϣ	
		case "3":{
			SCDao scDao = SCDao.getInstance();
			scDao.delete();
			break;
		}	
		//�޸Ŀγ���Ϣ
		case "4":{
			CourseDao courseDao = CourseDao.getInstance();
			courseDao.update();
			break;
		}
		//�޸�ѡ����Ϣ
		case "5":{
			SCDao scDao = SCDao.getInstance();
			scDao.update();
			break;
		}
		}
		MainUI.show();
	}
}
