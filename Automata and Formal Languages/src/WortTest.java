import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class WortTest{



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WortImpl k = new WortImpl("Baumhaus");
		WortImpl d = new WortImpl("Hochschule");
		WortImpl w = new WortImpl("Wohn");
		WortImpl b = new WortImpl("Baum");
		WortImpl f = new WortImpl("Fahrbahnenverkehrsstauwendenampelblitzableiterschilderproduziergerät");
		WortImpl bsp = new WortImpl("001111010111");
		WortImpl bsp1 = new WortImpl("0");
		WortImpl bsp2 = new WortImpl("00");
		
		System.out.println("Postiton von k an der Stelle 4");
		System.out.println(k.position(3));
		System.out.println("Position von d an der Stelle 10");
		System.out.println(d.position(9));
		System.out.println("Die Laenge von k");
		System.out.println(k.laenge());
		System.out.println("Das Wort f wird extrahiert von der position 64 bis 68");
		System.out.println(f.extrahiere(63, 67));
		System.out.println("Das Wort f wird kontrahiert von der Position 55 bis 68");
		System.out.println(bsp.kontrahiere(0, 1));
		System.out.println("Wort w wird mit b konkateniert");
		System.out.println(w.konkateniere(b));
		System.out.println("Das Wort k bis stelle 4 mit engeschmolzenem Wort d");
		System.out.println(k.einschmelzen(d, 4));
		System.out.println("Tausche im wort k buchstabe m mit buchstabe b");
		System.out.println(k.tausche('m', 'b'));
		System.out.println("TeilwortVon");
		System.out.println(bsp.istTeilwortVon(bsp1));
		System.out.println("die anzahl des buchstabens a kommt in k 2 mal vor");
		System.out.println(k.anzahl('a'));
		System.out.println("Wort ersetzten");
		System.out.println(bsp.ersetze(bsp2, bsp1));
		
		WortImpl2 test = new WortImpl2(); 
		
		WortImpl binär = new WortImpl("001111010111");
		WortImpl binär2 = new WortImpl("010101");
		
		WortImpl2 regel1 = new WortImpl2(new WortImpl("00"), new WortImpl("0"));
		WortImpl2 regel2 = new WortImpl2(new WortImpl("11"), new WortImpl("1"));
		
		
		
		LinkedList<Wortsetzungsregel> regeln = new LinkedList<Wortsetzungsregel>();
		
		regeln.add(regel1);
		regeln.add(regel2);
		
		System.out.println(test.ableitbar(regeln, binär, binär2));
		
		System.out.println("______________________________________");
		System.out.println("Aufgabe 5.");
		

		WortImpl alphabet1 = new WortImpl("ababcab");
		WortImpl alphabet2 = new WortImpl("aaabbbc");
		
		WortImpl2 atest = new WortImpl2(); 

		WortImpl2 aregel4 = new WortImpl2(new WortImpl("aba"), new WortImpl("aab"));
		WortImpl2 aregel5 = new WortImpl2(new WortImpl("bab"), new WortImpl("abb"));
		WortImpl2 aregel6 = new WortImpl2(new WortImpl("aca"), new WortImpl("aac"));
		WortImpl2 aregel7 = new WortImpl2(new WortImpl("bca"), new WortImpl("abc"));
		WortImpl2 aregel8 = new WortImpl2(new WortImpl("cab"), new WortImpl("abc"));
		WortImpl2 aregel9 = new WortImpl2(new WortImpl("bcb"), new WortImpl("bbc"));
		WortImpl2 aregel10 = new WortImpl2(new WortImpl("cbc"), new WortImpl("bcc"));
		
		
		LinkedList<Wortsetzungsregel> aregeln = new LinkedList<Wortsetzungsregel>();
		
		aregeln.add(aregel4);
		aregeln.add(aregel5);
		aregeln.add(aregel6);
		aregeln.add(aregel7);
		aregeln.add(aregel8);
		aregeln.add(aregel9);
		aregeln.add(aregel10);
		
		
		System.out.println(atest.ableitbar(aregeln, alphabet1, alphabet2));

	
	}

}