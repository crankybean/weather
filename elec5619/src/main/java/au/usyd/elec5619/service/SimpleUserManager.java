package au.usyd.elec5619.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.DAO.UserDAO;
import au.usyd.elec5619.domain.User;


@Service(value="userManager")
@Transactional
public class SimpleUserManager{
	
	@Autowired
	public UserDAO userDAO;
	
	public void addUser(User user) {
		userDAO.addUser(user);
	}
	
	public User getUserById(int id) {
		return userDAO.getUserById(id);
	}
	
	public User getUserByUserName(String userName) {
		return userDAO.getUserByUserName(userName);
	}
	
	public int checkLogin(String userName, String password) {
		return userDAO.checkLogin(userName, password);
	}
	
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
}
