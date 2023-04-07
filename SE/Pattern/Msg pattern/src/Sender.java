public class Sender {

	
	
	NachrichtenDienst nachrichtenDienst = new NachrichtenDienst();
	
	private Nachricht nachrichten;
	
	
	
	public Nachricht getNachrichten() {
		return nachrichten;
	}



	public void setNachrichten(Nachricht nachrichten) {
		this.nachrichten = nachrichten;
	}



	public void nachrichtSchreiben(String na) {
		
		Textnachricht n = new Textnachricht(na);
		 nachrichten = n;
		

	}

	
	
	
}