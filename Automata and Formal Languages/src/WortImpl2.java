import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class WortImpl2 implements Wortsetzungsregel, Wortersetzungssystem {

	private Wort lw2;
	private Wort rw2;

	public WortImpl2(Wort lw, Wort rw) {

		lw2 = lw;
		rw2 = rw;

	}

	public WortImpl2() {

	};

	public Wort linkeSeite() {

		return lw2;

	}

	public Wort rechteSeite() {

		return rw2;

	}

	public boolean ableitbar(Collection<Wortsetzungsregel> regeln, Wort start, Wort ziel) {

		Wort speicher = null;
		int i = 0;
		
		System.out.println("____________________________________________________________________");
		System.out.println("Startwert: " + start);
		System.out.println("Zielwert: " + ziel);
		
		while(!(start.toString().equals(ziel.toString())) || i == 10) {
		for (Iterator<Wortsetzungsregel> it = regeln.iterator(); it.hasNext();)
		{ 

			
			WortImpl2 regel = (WortImpl2) it.next();
			
			WortImpl ersetzen = (WortImpl) start;
			if(!(start.toString().equals(ziel.toString()))) {
				while(start.istTeilwortVon(regel.lw2) != 0){
					
					start = start.ersetze(regel.lw2, regel.rw2);
					System.out.println("Regeln "+regel.lw2+ " --> " + regel.rw2);
					System.out.println(start);
			}
		} if(start.toString().equals(ziel.toString())) { {

				return true;
		
		}
	}
		System.out.println(start);
		i++;
		}
		}
			return false;
	}

}

