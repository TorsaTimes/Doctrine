import javax.swing.JComboBox;

public class SachbearbeiterAuswaehlenK {
	
	Wrapper wrapper = new Wrapper();
	String[] namen;
 
	public SachbearbeiterAuswaehlenK() {
		// TODO Auto-generated constructor stub
		namen = wrapper.alleNamen;
	
	}
	
	public void befuellen(JComboBox combo) {
		
		String[] alleNamen = SachbearbeiterEK.gibAlleNamen();
		combo.addItem(alleNamen);
		
		
		
		
	}
	
	class Wrapper{
		
		String[] alleNamen;
	
		
		Wrapper(){
			alleNamen = SachbearbeiterEK.gibAlleNamen();
		}
		
		
	}
	
}
