public class Deadlock {

	public static void main(String[] args) {

		
		Speicherzelle A = new Speicherzelle(10);
		Speicherzelle B = new Speicherzelle(20);
		
		Thread1 t1 = new Thread1(A ,B);
		Thread2 t2 = new Thread2(A ,B);

		  System.out.println ("In main(): starte Thread1");
	      t1.start();
	      System.out.println ("In main(): starte Thread2");
	      t2.start();

	}

}
