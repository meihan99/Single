package view;

import java.util.Scanner;
import biz.*;

//�޸�����
public class ModifyPasswordUI {
	
	public static void show() throws Exception {
		
			StudentBiz sc = new StudentBiz();
		    sc.modifyPassword();
		    MainUI.show();
	}
}
