import javax.swing.JComboBox;



public class FortbildungAuswaehlenK {
	
	Wrapper wrapper = new Wrapper();
	String[] fortbildungen;
 
	public FortbildungAuswaehlenK() {
		// TODO Auto-generated constructor stub
		fortbildungen = wrapper.alleFortbildungen;
	
	}
	
	public void befuellen(JComboBox combo) {
		
		String[] alleFortbildungen = Fortbildung.gibAlleFortbildungen();
		combo.addItem(alleFortbildungen);
		
		
		
		
	}
	
	class Wrapper{
		
		String[] alleFortbildungen;
	
		
		Wrapper(){
			alleFortbildungen = Fortbildung.gibAlleFortbildungen();
		}
		
		
	}
}
