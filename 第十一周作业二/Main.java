import user.*;
import production.*;
import utility.*;
public class Main {

	public static void main(String[] args) {
		User us;
		Produce pr;
		pr=(Produce)XMLUtility.getBean();
		us=pr.produceUser();
		us.generateCommucationRecord();
		us.printDetails();
	}

}
