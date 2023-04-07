package src;

public class Prozess {

	
	private double quantum = 0;
	private double wartezeit = 0;
	private double gesamtzeit = 0;
	private double rechenzeit = 0;
	private double erg = 0;
	private int counter = 0;
	
	//-------------------------------------
	

	public Prozess(int quantum, int wartezeit) {
		this.quantum = quantum;
		this.wartezeit = wartezeit;
		this.rechenzeit= 0;
		this.gesamtzeit = 0;
		this.erg = 0;
	}
	

	public double getQuantum() {
		return this.quantum;
	}
	public void setQuantum(double quantum) {
		this.quantum = quantum;
	}
	public double getWartezeit() {
		return wartezeit;
	}
	public void setWartezeit(double wartezeit) {
		this.wartezeit = wartezeit;
	}
	
	public double getGesamtzeit() {
		return gesamtzeit;
	}



	public void setGesamtzeit(double gesamtzeit) {
		this.gesamtzeit = gesamtzeit;
	}



	public double getRechenzeit() {
		return rechenzeit;
	}



	public void setRechenzeit(double rechenzeit) {
		this.rechenzeit = rechenzeit;
	}



	public double getErg() {
		return erg;
	}



	public void setErg(double erg) {
		this.erg = erg;
	}
	
public void prozessDurchlaufen(double durchlaufQuantum, int s) {
		
		while(this.getQuantum() != 0) {
			
			System.out.println("Prozess" + this.getQuantum());
			this.setQuantum(this.getQuantum() - durchlaufQuantum);
			this.setRechenzeit(this.getRechenzeit() + durchlaufQuantum);
			System.out.println("Rechenzeit = " + this.getRechenzeit());
			this.setGesamtzeit(this.getGesamtzeit() + s);
			System.out.println("Gesamtlaufzeit" + this.getGesamtzeit());
			System.out.println("s = " + s);
			counter++;
			
		}
		
		this.setGesamtzeit(this.getGesamtzeit() + this.getRechenzeit());
		System.out.println("Rechenzeit / Gesamtlaufzeit = " + this.getRechenzeit()/this.getGesamtzeit());
		System.out.println(counter);
	}
		
		
	}

