package view;

import java.util.Scanner;
import biz.*;

//ÐÞ¸ÄÃÜÂë
public class ModifyPasswordUI {
	
	public static void show() throws Exception {
		
			StudentBiz sc = new StudentBiz();
		    sc.modifyPassword();
		    MainUI.show();
	}
}
