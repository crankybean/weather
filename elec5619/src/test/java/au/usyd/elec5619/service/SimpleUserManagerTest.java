package au.usyd.elec5619.service;

import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;
import au.usyd.elec5619.domain.User;

public class SimpleUserManagerTest extends TestCase{
	private SimpleUserManager userManager;
	private List<User> users;
	
	private static int user_COUNT = 2;
	
	private static String USERNAME_A = "Hello";
	private static String EMAIL_A = "a@b";
	
	private static String USERNAME_B = "Hi";
	private static String EMAIL_B = "b@a";
	
	
	protected void setUp() throws Exception{
		userManager = new SimpleUserManager();
		users = new ArrayList<User>();
		
		User usera = new User();
		usera.setUserName(USERNAME_A);
		usera.setEmail(EMAIL_A);
		users.add(usera);
		
		User userb = new User();
		userb.setUserName(USERNAME_B);
		userb.setEmail(EMAIL_B);
		users.add(userb);
	}
	
	public void testUserWithNoPassword() {
		assertNull(new User().getPassword());
	}
	
}
