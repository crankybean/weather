package au.usyd.elec5619.service;

import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;
import au.usyd.elec5619.domain.Admin;

public class SimpleAdminManagerTest extends TestCase{
	private SimpleAdminManager adminManager;
	private List<Admin> admins;
	
	private static int admin_COUNT = 2;
	
	private static String adminNAME_A = "Hello";
	private static String PASS_A = "abc";
	
	private static String adminNAME_B = "Hi";
	private static String PASS_B = "cba";
	
	
	protected void setUp() throws Exception{
		adminManager = new SimpleAdminManager();
		admins = new ArrayList<Admin>();
		
		Admin admina = new Admin();
		admina.setUserName(adminNAME_A);
		admina.setPassword(PASS_A);
		admins.add(admina);
		
		Admin adminb = new Admin();
		adminb.setUserName(adminNAME_B);
		adminb.setPassword(PASS_B);
		admins.add(adminb);
	}
	
	public void testadminWithNoPassword() {
		assertNull(new Admin().getPassword());
	}
	
}
