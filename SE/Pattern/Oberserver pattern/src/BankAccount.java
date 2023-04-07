import java.util.ArrayList;

public class BankAccount implements Subject {

	ArrayList<Observer> observerList = new ArrayList<Observer>();
	
	public double accountBalance = 20;
	
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

	
	
}
