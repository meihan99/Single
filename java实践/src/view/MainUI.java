package view;

import java.util.Scanner;

public class MainUI {
	public static void show() throws Exception {
		String option;
		System.out.println("1-ע����Ϣ��2-�޸����룻3-��¼;0-�˳�");
		Scanner scanner = new Scanner(System.in);
		 option = scanner.nextLine();
		switch (option) {
		//ע��
		case "1":
			RegisterUI.show();
			break;
		//�޸�����	
		case "2":
			ModifyPasswordUI.show();
			break;
		//��¼	
		case "3":
			LoginUI.show(); 
			break;
		}
		MainUI.show();
	}
}
