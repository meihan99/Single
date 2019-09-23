public class BMW320 {
	public BMW320(){
		System.out.println("制造-->BMW320");
	}
}
 
public class BMW523 {
	public BMW523(){
		System.out.println("制造-->BMW523");
	}
}
 
public class Customer {
	public static void main(String[] args) {
		BMW320 bmw320 = new BMW320();
		BMW523 bmw523 = new BMW523();
	}
}
