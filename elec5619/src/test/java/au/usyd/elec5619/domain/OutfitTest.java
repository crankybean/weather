package au.usyd.elec5619.domain;

import junit.framework.TestCase;

public class OutfitTest extends TestCase{
	private Outfit outfit;
	
	protected void setup() throws Exception{
		outfit = new Outfit();
	}
	
	public void testSetAndGetDescription() {
		String testDescription = "hha";
		assertNull(outfit.getDescription());
		outfit.setDescription(testDescription);
		assertEquals(testDescription,outfit.getDescription());
	}

	public void testSetAndGetId() {
		String testId = "elel";
		assertEquals(0,0,0);
		outfit.setId(testId);
		assertEquals(testId,outfit.getId(),0);
	}
}
