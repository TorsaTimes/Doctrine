package de.hfu;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
 
public class QueueTest {

	Queue qObjekt = new Queue(3);//array length 3 

	
	@Test
	public void testdequeue() {
		
		try {
		qObjekt.enqueue(1);
		qObjekt.enqueue(2);
		qObjekt.enqueue(3);
		qObjekt.enqueue(4);
		int speicher = qObjekt.dequeue();
		assertEquals(1,speicher);
		}
		catch(Exception e) {
			
		}
		
		
		}
	
	
}
