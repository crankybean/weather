package au.usyd.elec5619.service;

import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;
import au.usyd.elec5619.domain.Outfit;
import au.usyd.elec5619.DAO.OutfitDAO;

public class SimpleOutfitManagerTest extends TestCase{
	private SimpleOutfitManager outfitManager;
	private List<Outfit> outfits;
	
	private static int OUTFIT_COUNT = 2;
	
	private static  double TEMP_A = 11.2;
	private static String DESC_A = "a@b";
	
	private static double TEMP_B = 13.1;
	private static String DESC_B = "b@a";
	
	
	protected void setUp() throws Exception{
		SimpleOutfitManager outfitManager = new SimpleOutfitManager();
		outfits = new ArrayList<Outfit>();
		
		Outfit outfita = new Outfit();
		outfita.setTemp(TEMP_A);
		outfita.setDescription(DESC_A);
		outfits.add(outfita);
		
		Outfit outfitb = new Outfit();
		outfitb.setTemp(TEMP_B);
		outfitb.setDescription(DESC_B);
		outfits.add(outfitb);
	}
	
	public void testoutfitWithNoPassword() {
		assertNull(new Outfit().getDescription());
	}
	
}
