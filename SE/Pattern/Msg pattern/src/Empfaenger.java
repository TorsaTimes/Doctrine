import java.util.LinkedList;

public class Empfaenger {

	private String name;

	private LinkedList<Nachricht> postfach = new LinkedList<Nachricht>();
	
	
	public LinkedList<Nachricht> getPostfach() {
		return postfach;
	}


	public void setPostfach(LinkedList<Nachricht> postfach) {
		this.postfach = postfach;
	}


	public Empfaenger(String name) {
		this.name = name;
	}
	
	public Empfaenger() {
		
	}
	
	public Empfaenger gib(String name) {
		return this;
	}
	
	public void druckePostfach() {
		System.out.println("Postfach vom Benutzer: " + this.name);
		int zaehler = 0; 
		if(!(this.postfach.isEmpty())) {
		for(Nachricht n : this.postfach) {
			System.out.println("Nachricht " + zaehler + " : " + n.getText());
			zaehler++;
		}
		}
		else {
			System.out.println("Das Postfach des Benutzers: " + this.name + " ist Leer!");
		}
	
	}

}