
public class RestrictedCounter extends Counter {

	private int n;
	
	public RestrictedCounter(int n) {this.n = n;}
	public void increment() {
		
		if(x<n) {
			++x;
		}
	
	else {
		System.out.println("Fehlermeldung");
	}
	
	}	
		
	public int freeCapacity() {
		return n-x;
	}
	
}