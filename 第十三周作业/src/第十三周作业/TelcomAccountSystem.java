package 第十三周作业;

public class TelcomAccountSystem {
	public static void main(String[] args) {
		TelcomUser telcomUser = new TelcomUser("15515158296");
		telcomUser.generateCommunicateRecord();
		telcomUser.printDetails();
		telcomUser.printCallToDetails();
	}
}