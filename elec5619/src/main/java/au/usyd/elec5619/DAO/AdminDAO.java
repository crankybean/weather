package au.usyd.elec5619.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import au.usyd.elec5619.domain.Admin;

@Repository
public class AdminDAO {
	@Resource
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public void addAdmin(Admin admin) {
		this.sessionFactory.getCurrentSession().save(admin);
	}

	public Admin getAdminById(int id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Admin admin = (Admin) currentSession.get(Admin.class, id);
		return admin;
	}

	public void updateAdmin(Admin admin) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(admin);
	}

}