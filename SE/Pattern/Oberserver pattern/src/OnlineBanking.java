
public class OnlineBanking implements Observer {

	private Subject subject;
	
	public void setBankBalance(double accountBalance) {
		System.out.println("---OnlineBanking---");
		System.out.println("Your current account balance is " + accountBalance+ " $");
	}
	
	@Override
	public void update() {
		this.setBankBalance(((ConcreteSubject) subject).getAccountBalance());
		
	}

//	public OnlineBanking(Subject subject) {
//		this.subject = subject;
//		
//	}
	

	@Override
	public void setSubject(ConcreteSubject test) {
		this.subject = test;
		
	}

}
