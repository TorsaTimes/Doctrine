import java.util.HashMap;

public class NachrichtenDienst {

	private HashMap<String, Empfaenger> empfaengerMap = new HashMap<String, Empfaenger>();
	
	public void send(Nachricht n, String e) {
		
		System.out.println("Die Nachricht: " + "[" + n.getText() + "]" + " wurde an folgenden Nutzer gesendet: ");
		for(String ename : empfaengerMap.keySet()) {
			if(ename.equals(e)) {
				empfaengerMap.get(ename).getPostfach().add(n);
				System.out.println("Nutzer: " + ename);
			}
		}
		
	}


	public void send(Nachricht n) {
		
		System.out.println("Die Nachricht: " + "[" + n.getText() + "]" + " wurde an folgende Nutzer gesendet: ");
		for(String ename : empfaengerMap.keySet()) {
			empfaengerMap.get(ename).getPostfach().add(n);
			System.out.println("Nutzer: " + ename);
		}
		
	}


	public void anmelden(String name, Empfaenger e) {
		
		if(!(empfaengerMap.containsKey(name))) {
		System.out.println("anmeldung erfolgreich Benutzer: " + name);
		empfaengerMap.put(name, e);
		}
		else {
			System.out.println("Benutzer: " + name + " ist schon angemeldet!");
		}
	}

	public void abmelden(String name, Empfaenger e) {
		empfaengerMap.replace(name, e);
		
	}


}