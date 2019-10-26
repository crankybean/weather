package au.usyd.elec5619.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import au.usyd.elec5619.domain.Outfit;

@Repository
public class OutfitDAO {
	@Resource
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public void addOutfit(Outfit outfit) {
		this.sessionFactory.getCurrentSession().save(outfit);
	}

	public Outfit getOutfitById(int id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Outfit outfit = (Outfit) currentSession.get(Outfit.class, id);
		return outfit;
	}

	public void updateOutfit(Outfit outfit) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(outfit);
	}

}