package au.usyd.elec5619.domain;

import junit.framework.TestCase;

public class AdminTest extends TestCase{
	private Admin admin;
	
	protected void setup() throws Exception{
		admin = new Admin();
	}
	
	public void testSetAndGetDescription() {
		String testUserName = "test";
		assertNull(admin.getUserName());
		admin.setUserName(testUserName);
		assertEquals(testUserName,admin.getUserName());
	}

	public void testSetAndGetId() {
		int testId = 5;
		assertEquals(0,0,0);
		admin.setId(testId);
		assertEquals(testId,admin.getId(),0);
	}
}
