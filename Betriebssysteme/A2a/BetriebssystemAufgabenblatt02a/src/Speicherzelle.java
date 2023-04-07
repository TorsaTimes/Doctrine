public class Speicherzelle {

	private int wert;

	static Speicherzelle s1 = new Speicherzelle(10);
	static Speicherzelle s2 = new Speicherzelle(20);

	Speicherzelle(int i) {
		wert = i;
	}

	public synchronized void setWert(int w) {
	
		wert = w;
	}

	public synchronized int getWert() {
		
		return wert;
	}

	public synchronized void swapWert(Speicherzelle s) {
		
		int h = s.getWert();
		
		
		try {
			System.out.println("Sleep");
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		s.setWert(this.wert);
		setWert(h);

	}

}
