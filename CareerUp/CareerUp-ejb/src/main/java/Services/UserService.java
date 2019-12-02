package Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.AppUser;
import Interfaces.IUserService;

@Stateless
@LocalBean
public class UserService implements IUserService {

	@PersistenceContext
	EntityManager em;

	@Override
	public int ajouterUser(AppUser user) {
		em.persist(user);
		return user.getIdUser();
	}

	@Override
	public List<AppUser> getAllUsers() {
		List<AppUser> emp = em.createQuery("Select e from AppUser e", AppUser.class).getResultList();
		return emp;
	}

	@Override
	public void deleteUser(int idUser) {
		AppUser o = em.find(AppUser.class, idUser);
		em.remove(o);
	}

	@Override
	public void updateUser(AppUser user) {
		AppUser us = em.find(AppUser.class, user.getIdUser());
		us.setEmail(user.getEmail());
		us.setPassword(user.getPassword());
		us.setFirstName(user.getFirstName());
		us.setLastName(user.getLastName());
		us.setUserName(user.getUserName());
		us.setRole(user.getRole());

	}
	
	@Override
	public AppUser getUserByEmailAndPassword(String email, String password) {
		TypedQuery<AppUser> query=
				em.createQuery("SELECT e FROM AppUser e WHERE e.email=:email AND e.password=:password ", AppUser.class);
				query.setParameter("email", email);
				query.setParameter("password", password);
				AppUser user= null;
				try{ user= query.getSingleResult(); }
				catch(Exception e) { System.out.println("Erreur : "+ e); }
				return user;
	}

}
