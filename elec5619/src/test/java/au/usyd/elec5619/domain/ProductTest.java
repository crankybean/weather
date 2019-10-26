package au.usyd.elec5619.domain;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import junit.framework.TestCase;

public class ProductTest extends TestCase{
	private Product product;
	
	protected void setup() throws Exception{
		product = new Product();
	}
	@Test
	public void testSetAndGetDescription() {
		String testDescription = "aDescription";
		assertNull(product.getDescription());
		product.setDescription(testDescription);
		assertEquals(testDescription,product.getDescription());
	}
	@Test
	public void testSetAndGetPrice() {
		double testPrice = 100.00;
		assertEquals(0,0,0);
		product.setPrice(testPrice);
		assertEquals(testPrice,product.getPrice(),0);
	}
}
