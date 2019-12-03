public class Main {
		public static void main(String[] args) {
			Customer person1=new Customer("AA");
			Movie movie1=new Movie("huaxia",1235);
			Rental rental1=new Rental(movie1,19999999);
			person1.addRental(rental1);
			System. out.print(person1. statement());
		}
}