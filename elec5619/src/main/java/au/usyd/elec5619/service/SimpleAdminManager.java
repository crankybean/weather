package au.usyd.elec5619.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.DAO.AdminDAO;
import au.usyd.elec5619.domain.Admin;


@Service(value="adminManager")
@Transactional
public class SimpleAdminManager{
	
	@Autowired
	public AdminDAO adminDAO;
	
	public void addAdmin(Admin admin) {
		adminDAO.addAdmin(admin);
	}
	
	public Admin getAdminById(int id) {
		return adminDAO.getAdminById(id);
	}
	
	public void updateAdmin(Admin admin) {
		adminDAO.updateAdmin(admin);
	}
}