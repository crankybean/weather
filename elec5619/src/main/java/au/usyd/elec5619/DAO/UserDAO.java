package au.usyd.elec5619.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import au.usyd.elec5619.domain.User;

@Repository
public class UserDAO {
	@Resource
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public void addUser(User user) {
		this.sessionFactory.getCurrentSession().save(user);
	}

	public User getUserById(int id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		User user = (User) currentSession.get(User.class, id);
		return user;
	}
	
	public User getUserByUserName(String userName) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		User user = (User) currentSession.get(User.class, userName);
		return user;
	}

	public void updateUser(User user) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(user);
	}
	
	public int checkLogin(String userName, String password) {
		int suc = 0;
		User user = this.getUserByUserName(userName);
		if(user == null) {
			return 1;
		}
		else {
			if(password.equals(user.getPassword())) {
				suc = 0;
			}
			else {
				suc = 1;
			}
		}
		
		return suc;
	}

}