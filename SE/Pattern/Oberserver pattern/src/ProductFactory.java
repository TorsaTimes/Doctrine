
public class ProductFactory {

	
	public Observer createProduct(String p){
		
		
		
		if(p.equals("ATM")) {
			return new ATM();
		}
		
		else if(p.equals("BankingApp")) {
			return new BankingApp();
		}
		else if(p.equals("OnlineBanking")) { 
			Observer ob = new OnlineBanking();
			return ob;
		}
		return null;
		
	}
	
	
}
