package ctr2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestUnmodifiableList {
	
	public static void main(String[] args) {
		
		List<String> arrayList1 = new ArrayList<String>();
		
		arrayList1.add("First");
		arrayList1.add("Second");
		arrayList1.add("Third");
		arrayList1.add("Fourth");
		arrayList1.add("Fifth");
		
        List<String> arrayList2 = Collections.unmodifiableList(arrayList1);
        System.out.println("Unmodifiable List: " + arrayList2);
        arrayList1.add("First");
        
        //System.out.print("Unmodifiable List after adding element to the list:");
        //System.out.println(arrayList2);
        
        //list2.add("Second");//Dies bewirkt das Werfen der Exception da diese Liste inveränderbar ist!
        
        System.out.println(arrayList2.get(0));// Gibt das Element der unveränderbaren List ander stelle des Index zurück
        
        //System.out.println(arrayList2.set(0, "Second"));//wirft eine Exception Liste darf nicht verändert werden
       
        System.out.println(arrayList2.indexOf(arrayList1.get(2)));// wirft den Index an der Stelle des Strings (Third)
        System.out.println(arrayList2.listIterator());
        System.out.println(arrayList2.hashCode());
        System.out.println(arrayList2);
        arrayList1.add("First");
        System.out.println(arrayList2);
	}
}

