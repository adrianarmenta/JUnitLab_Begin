package csc131.junit;

import static org.junit.Assert.*;
import org.junit.Test;


public class GiftCardTest {

	@Test 
	public void getIssuingStore(){
		double 		balance;
		GiftCard 	card;
		int 		issuingStore;
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		assertEquals("getIssuingStore()",
		issuingStore, card.getIssuingStore());
		assertEquals("getBalance()",
		issuingStore, card.getIssuingStore());
	}
	@Test 
	public void getBalance(){
		double 		balance;
		GiftCard 	card;
		int 		issuingStore;
		double		tolerance;
		
		tolerance	 = 0.001;
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		assertEquals("getBalance()",
		balance, card.getBalance(), tolerance);
	}
	@Test
	public void deduct_RemainingBalance(){
		String		result;
		GiftCard	card;
		double 		balance;
		int			issuingStore;
		double		amount;
		
		amount = 50;
		balance = 100;
		issuingStore = 1337;
		card = new GiftCard(issuingStore, balance);
        for(amount = -50; amount < 100; amount++)
        {
	        if (amount < 0.0)
	        {
	            result = "Invalid Transaction";
	        }
	        else
	        {
	            balance -= amount;
	            
	            if (balance < 0.0)
	            {
	                result = "Amount Due: " + String.format("%6.2f",
	                                                        Math.abs(balance));
	                balance = 0.0;
	            }
	            else
	            {
	                result = "Remaining Balance: " + String.format("%6.2f",
	                                                         Math.abs(balance));
	            }
	        }
			
			assertEquals("deduct_RemainingBalance()", result, card.deduct(amount));
        }
	}
	@Test
	public void annotatedMethod(){
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});	
		
	}
	@Test
	public void constructor_IncorrectID_Low() {
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-1,100.00);});
		
	
	}
	@Test
	public void constructor_IncorrectID_High() {
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(10000,100.00);});
	
	}
	
}
