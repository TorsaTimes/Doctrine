import java.util.ArrayList;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
	
		ArrayList<ConcreteSubject> subList = new ArrayList<ConcreteSubject>();
		
		Scanner scanner = new Scanner(System.in);
		
		String inter = scanner.nextLine();
		BankAccount bankaccount = new BankAccount();
		
		ProductFactory pf = new ProductFactory();
		
		Observer atm = pf.createProduct("ATM");
		Observer bankingApp = pf.createProduct("BankingApp");
		Observer onlineBanking = pf.createProduct("OnlineBanking");
		
		
			
		do {
		
			System.out.println("Beobachter-Muster");
			System.out.println("1 fuer Ressource anlegen");
			System.out.println("2 fuer Ressource regestrieren");
			System.out.println("3 fuer Zustand einer Ressource abfragen");
			System.out.println("4 fuer Zustand ändern");
			System.out.println("5 Beobachter abmelden");
			System.out.println("0 Programm beenden");
			inter = scanner.nextLine();
		
				
			
			if(inter.equals("1")) {
				System.out.println("Ressource Anlegen: ");
				String name = scanner.nextLine();
				
				ConcreteSubject test = new ConcreteSubject(name);
				
				subList.add(test);
				
				atm.setSubject(test);
				bankingApp.setSubject(test);
				onlineBanking.setSubject(test);
				
			}
			else if(inter.equals("2")) {
				System.out.println("Ressourcen name eingeben: ");
				String name = scanner.nextLine();
				for(ConcreteSubject cs: subList) {
					if(cs.getName().equals(name)) {
						System.out.println("Bitte geben sie den Observer ein: ");
						String name1 = scanner.nextLine();
						if(name1.equals("atm")) {
							cs.attach(atm);
						}
						else if(name1.equals("bankingApp")) {
							cs.attach(bankingApp);
						}
						else if(name1.equals("onlineBanking")) {
							cs.attach(onlineBanking);
						}
						
							
					}
				}
			
				
			}
			else if(inter.equals("3")) {
				System.out.println("Ressourcen name eingeben: ");
				String name = scanner.nextLine();
				for(ConcreteSubject cs: subList) {
					if(cs.getName().equals(name)) {
						cs.messageAllObserver();
			}
				}
			
			}
			else if(inter.equals("4")) {
				System.out.println("Ressourcen name eingeben: ");
				String name = scanner.nextLine();
				for(ConcreteSubject cs: subList) {
					if(cs.getName().equals(name)) {
						System.out.println("Neuer Zustand eingeben: ");
						Scanner zahl = new Scanner(System.in);
						int zustand = zahl.nextInt();
						
						cs.setState(zustand);
						
			}
				}
			}
			else if(inter.equals("5")) {
				System.out.println("Ressourcen name eingeben: ");
				String name = scanner.nextLine();
				for(ConcreteSubject cs: subList) {
					if(cs.getName().equals(name)) {
						System.out.println("Bitte geben sie den Observer ein: ");
						String name1 = scanner.nextLine();
						if(name1.equals("atm")) {
							cs.detach(atm);
						}
						else if(name1.equals("bankingApp")) {
							cs.detach(bankingApp);
						}
						else if(name1.equals("onlineBanking")) {
							cs.detach(onlineBanking);
						}
			}
				}
			}
			
			


		
			
//			bankaccount.attach(atm);
//			bankaccount.attach(bankingApp);
//			bankaccount.attach(onlineBanking);
			
//			bankaccount.messageAllObserver();
//			
//			//bankaccount.detach(atm);9
//			
//			bankaccount.accountBalance = 5000;
//			
//
//			bankaccount.messageAllObserver();
			
		}
		while(!(inter.equals("0")));
		}
}
