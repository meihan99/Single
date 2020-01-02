package view;

import java.util.Scanner;

public class MainUI {
	public static void show() throws Exception {
		String option;
		System.out.println("1-×¢²áĞÅÏ¢£»2-ĞŞ¸ÄÃÜÂë£»3-µÇÂ¼;0-ÍË³ö");
		Scanner scanner = new Scanner(System.in);
		 option = scanner.nextLine();
		switch (option) {
		//×¢²á
		case "1":
			RegisterUI.show();
			break;
		//ĞŞ¸ÄÃÜÂë	
		case "2":
			ModifyPasswordUI.show();
			break;
		//µÇÂ¼	
		case "3":
			LoginUI.show(); 
			break;
		}
		MainUI.show();
	}
}
