public class WortImpl implements Wort {

	private String s;

	public WortImpl(String wort) {

		s = wort;
	}

	public String toString() {

		return s;
	}

	public char position(int k) {

		if (!(k >= s.length())) {
			return s.charAt(k);
		} else {
			return 0;
		}
	}

	public int laenge() {

		return s.length();
	}

	public Wort extrahiere(int k, int m) {

		String speicher = "";

		for (int i = k; i <= m; i++) {

			speicher += s.charAt(i);

		}

		Wort w1 = new WortImpl(speicher); // Objekt des Interfaces erzeueg für
											// den return

		return w1;
	}

	public Wort kontrahiere(int k, int m) {

		String speicher = "";

		for (int i = 0; i < s.length(); i++) {

			if (!((i >= k) && (i <= k + m-1))) {

				speicher += s.charAt(i);

			}
		}

		Wort w2 = new WortImpl(speicher);

		return w2;

	}

	public Wort konkateniere(Wort w) {

		String speicher = s + w;

		Wort w3 = new WortImpl(speicher);

		return w3;

	}

	public Wort einschmelzen(Wort w, int m) {

		String speicher = "";

		for (int i = 0; i <= s.length(); i++) {

			if ((i < m)) {

				speicher = speicher + s.charAt(i);

			} else if (i == m) {

				for (int x = 0; x <= w.laenge() - 1; x++) {

					speicher += w.position(x);

				}

			}

			else
				speicher += s.charAt(i - 1);

		}

		Wort w4 = new WortImpl(speicher);

		return w4;

	}

	public Wort tausche(char c1, char c2) {

		String speicher = "";

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == c1) {

				speicher += c2;
			} else {

				speicher += s.charAt(i);

			}

		}

		Wort w5 = new WortImpl(speicher);

		return w5;
	}

	public int istTeilwortVon(Wort w) {

		int pos = 0;
		int counter = 1;

		if(!s.contains(w.toString())) {
			
			return 0;
		}
		
		if (s.length() < w.laenge()) {

			return 0;
		}
		int e = 0;

	
			for (int i = 0; i < s.length(); i++) {
				
				if(e != w.laenge()) {
				if (w.position(e) == s.charAt(i)) {
					pos = i;
					e++;

				}else if(w.position(0) == s.charAt(counter)) {
						i = counter;
						pos = i;
						e = 1;
						counter++;
				}
				else {
					
					e = 0;
				}
					

			}

		}
			
		
			
		return pos-(w.laenge()-1) + 1;

	}

	public int anzahl(char c) {

		int anz = 0;

		for (int i = 0; i <= s.length() - 1; i++) {

			if (s.charAt(i) == c) {

				anz++;
			}
		}

		return anz;

	}

	public Wort ersetze(Wort w1, Wort w2) {

		Wort speicher = new WortImpl(s);
		
		int sp = speicher.istTeilwortVon(w1);
		
		
		if(sp != 0) {
			System.out.println(speicher);
		speicher =	speicher.kontrahiere(sp-1, w1.laenge());
			System.out.println(speicher);
		speicher =	speicher.einschmelzen(w2, sp-1);
			
		}
		
		
		return speicher;

	}

}
