package de.hfu;
import org.junit.Test;

public class UtilTest {
	
	@Test
	public void testistErstesHalbjahr() {
		
		
		try {
		assert(Util.istErstesHalbjahr(5));
		}
		catch(ArithmeticException e) {
			
		}
		
		
		}
	
	
}
