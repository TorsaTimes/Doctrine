
public class ATM implements Observer {

	private Subject subject;
	
	public void setBankBalance(double accountBalance) {
		System.out.println("---ATM---");
		System.out.println("Your current account balance is " + accountBalance+ " $");
	}
	
	@Override
	public void update() {
		this.setBankBalance(((ConcreteSubject) subject).getAccountBalance());
		
	}

//	public ATM(Subject subject) {
//		this.subject = subject;
//		
//	}
	

	@Override
	public void setSubject(ConcreteSubject test) {
		this.subject = test;
		
	}

	
	
	
}
