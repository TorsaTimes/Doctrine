
public class CounterTest {

	public static void main(String[] args) {
		
		
		
		Counter a= new Counter(); // Erzeugen eines Z¨ahlers a
		for(int i = 0;i<10;i++) {
		a.increment(); // Hochz¨ahlen von a
		

		System.out.println(a.get());
		}
		
		
		
		for(int j = 0;j<5;j++) {
		a.decrement();
		
		System.out.println(a.get());
		}
		
		 
		
		}
		

	}
