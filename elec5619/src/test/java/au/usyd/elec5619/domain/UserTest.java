package au.usyd.elec5619.domain;

import junit.framework.TestCase;

public class UserTest extends TestCase{
	private User user;
	
	protected void setup() throws Exception{
		user = new User();
	}
	
	public void testSetAndGetDescription() {
		String testEmail = "email";
		assertNull(user.getEmail());
		user.setEmail(testEmail);
		assertEquals(testEmail,user.getEmail());
	}

	public void testSetAndGetId() {
		int testId = 5;
		assertEquals(0,0,0);
		user.setId(testId);
		assertEquals(testId,user.getId(),0);
	}
}
