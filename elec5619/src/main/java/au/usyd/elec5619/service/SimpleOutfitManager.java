package au.usyd.elec5619.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.DAO.OutfitDAO;
import au.usyd.elec5619.domain.Outfit;


@Service(value="outfitManager")
@Transactional
public class SimpleOutfitManager{
	
	@Autowired
	public OutfitDAO outfitDAO;
	
	public void addOutfit(Outfit outfit) {
		outfitDAO.addOutfit(outfit);
	}
	
	public Outfit getOutfitById(int id) {
		return outfitDAO.getOutfitById(id);
	}
	
	public void updateOutfit(Outfit outfit) {
		outfitDAO.updateOutfit(outfit);
	}
}