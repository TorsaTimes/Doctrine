import java.util.ArrayList;

public class ConcreteSubject implements Subject{

	
	ArrayList<Observer> observerList = new ArrayList<Observer>();
	
	public double accountBalance = 20;
	private String name;
	
	public void setState(int x) {
		this.accountBalance = x;
		messageAllObserver();
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
	
	@Override
	public void attach(Observer observer) {
		observerList.add(observer);
		
	}

	@Override
	public void detach(Observer observer) {
		observerList.remove(observer);
		
	}

	@Override
	public void messageAllObserver() {
		for (Observer observer : observerList) {
			observer.update();
		}
		
	}
	
	public ConcreteSubject(String name) {
		this.name = name;
		System.out.println(this.name);
	}
	
	
}
