



public class Counter {

	
	protected int x; // Z¨ahlerstand
	private int y; //zweite zählervariable
	
	private boolean sicherung = false;
	
	public Counter() {x=0;} // Konstruktor
	
	
	public void decrement() {
		if(x>0) {
			--x;
		}
		
	}
	
	public void increment() {

			++x;
	}
	
	public int get(){return x;} // Auslesen
	
	public void reset(){x=0;} // Zur¨ucksetzen
	
	public void save() {
	
	x = y;
	sicherung = true;				
	
	}
	
	public void restore() {
		
	if(sicherung == true) {	
		
		y = x;
		System.out.println("Erfolg");
	}	
	else {
		System.out.println("Errormeldung");
	}
	}

	
	
}

	
