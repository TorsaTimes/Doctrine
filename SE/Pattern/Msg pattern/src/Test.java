public class Test {
	
	
	
	
	public static void main(String[] args) {
	
		
		NachrichtenDienst nachrichtenDienst = new NachrichtenDienst();
		
		Sender Ricksender = new Sender();
	
		Empfaenger sam = new Empfaenger("samu");
		Empfaenger oli = new Empfaenger("oli");
		Empfaenger peter = new Empfaenger("peter");
		Empfaenger uwe = new Empfaenger("uwe");
		
		//-----------------------------------------------------------------------------
		
		nachrichtenDienst.anmelden("samu", sam);
		nachrichtenDienst.anmelden("oli", oli);
		nachrichtenDienst.anmelden("uwe", uwe);
		nachrichtenDienst.anmelden("peter", peter);
		
		sam.druckePostfach();
		
		Ricksender.nachrichtSchreiben("hallo sam");
		nachrichtenDienst.send(Ricksender.getNachrichten(), "samu");
		nachrichtenDienst.send(Ricksender.getNachrichten());
		
		sam.druckePostfach();
		
		
		
}
	
}