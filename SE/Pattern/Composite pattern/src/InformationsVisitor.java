
public class InformationsVisitor implements GeraeteManagerVisitor {

	public static int tiefe = 1;
	public static int blattknotenAnzahl = 0;
	public static int blaetter = 0;
	public static int durchschnittsVerzweigungsgrad = 0;
	int depth;
	int depth2;
	boolean teilcounter = false;
	
	
	
	@Override
	public Object visit(Bauteil b) {
		if(b.liste.isEmpty()) {
			blaetter++;
			//System.out.println("");
			return "Keine Bauteile";
		}
		else {
			blattknotenAnzahl++;
		}
		
		this.depth(b);
		
		for (Component c : b.liste) {
			if (c instanceof Teil) {
				this.visit((Teil) c);
			} else if (c instanceof Bauteil) {
				this.visit((Bauteil) c);
			}
		}
		return "ende";
	}
	

	
	
	public int depth(Bauteil b) {
		
		for (Component c : b.liste) {
	
			if(c instanceof Bauteil) {
				depth2++;
				depth((Bauteil)c);
			}
			else {
				depth2((Teil)c);
			}
			
		}
//		System.out.println(depth2);
//		System.out.println(depth + "D1");
//		System.out.println(teilcounter + "    teilcounter");
		if(depth < depth2 ) {
			if(teilcounter == true) {
			depth = depth2 + 1;
			depth2 = 0;
			teilcounter = false;
			}
			else {
				depth = depth2;
				depth2 = 0;
			}
		}
		
		
		
		return tiefe = depth-1;
		
	}
	
	public boolean depth2(Teil t){
		teilcounter = true;
		return teilcounter;
	}
	
	
	
	
	
public void ergebnis() {
		

		durchschnittsVerzweigungsgrad = blaetter / tiefe;
		System.out.println("Blätter: " + blaetter);
		System.out.println("Tiefe: " + tiefe);
		System.out.println("Blattknoten: " + blattknotenAnzahl);
		System.out.println("durchschnittliche Verzweigungen: " + durchschnittsVerzweigungsgrad);
	}
	
	@Override
	public Object visit(Teil t) {
		blaetter++;
		return t;
	}
	
	
	
	
	
	
}
