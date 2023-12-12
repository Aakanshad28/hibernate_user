package hibernate_user.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_user.dto.User;

public class UserDao {

	public EntityManager entityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("aakansha");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void signUp(User user) {
		EntityManager entityManager = entityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();

	}

	public User loginUser(String email,String password) {
		EntityManager entityManager = entityManager();
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email=?1 AND u.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		try {
			User user = (User) query.getSingleResult();
		    return user;

		} catch (Exception e) {
			return null;
		}
		
	}
	public void displayPassword() {
		EntityManager entityManager = entityManager();
		List<User> list=entityManager.createQuery("SELECT u FROM User u",User.class).getResultList();
		System.out.println("All Passwords:");
		for (User user : list) {
			System.out.println("ID:"+user.getId()+",Password:"+user.getPassword());
		}
	}

}
