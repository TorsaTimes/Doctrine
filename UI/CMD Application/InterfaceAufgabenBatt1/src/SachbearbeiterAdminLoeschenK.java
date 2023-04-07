import java.util.Iterator;
import java.util.Scanner;
import java.util.*;

public class SachbearbeiterAdminLoeschenK {

	
	
	
	
	public void loeschen(String name) {
		
		
		if(SachbearbeiterEK.gib(name) != null) {
			
			SachbearbeiterEK.gib(name).remove(SachbearbeiterEK.gib(name));
			SachbearbeiterEK.druckAlleNamen();
			AdminAS.menue();
			
		}
		
		else{
			
			System.out.println("Der Benutzername exsistiert nicht oder wurde falsch eingegeben!");
			AdminAS.menue();
			
		}
	
		
		
		
	}

}