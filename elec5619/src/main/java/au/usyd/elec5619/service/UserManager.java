package au.usyd.elec5619.service;

import java.io.Serializable;
import java.util.List;

import au.usyd.elec5619.domain.User;

public interface UserManager extends Serializable{
	public void addUser(User user);
	
	public User getUserById(int id);
	
	public void updateUser(User user);
}
