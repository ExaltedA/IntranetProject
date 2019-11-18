
public class EntryClass {

	public static void main(String[] args) {
		Course AdvCalculus = new Course("AdvancedCalculus 1","CSC1111"); 
		Course Calculus1 = new Course("Calculus 1","CSC1101"); 
		Course Calculus2 = new Course("Calculus 2","CSC1102");
		Course Calculus3 = new Course("Calculus 3","CSC1103"); 
		AdvCalculus.addPrereq(Calculus1);
		AdvCalculus.addPrereq(Calculus1);
		AdvCalculus.addPrereq(Calculus3);
		AdvCalculus.addPrereq(Calculus2);
		
		AdvCalculus.showPrereq();
	}

}
