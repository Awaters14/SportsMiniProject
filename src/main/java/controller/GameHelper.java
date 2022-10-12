/**
 * @author Kilian Wehde - kewehde
 * CIS175 - Fall 2022
 * Oct 11, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Game;

public class GameHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week6Colors");
	
	public void insertGame(Game game) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(game);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Game> getAllGames() {
		EntityManager em = emfactory.createEntityManager();
		List<Game> allGames = em.createQuery("SELECT game FROM Game game ORDER BY game.date, game.time", Game.class).getResultList();
		em.close();
		return allGames;
	}
	
	public void deleteGame(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Game> typedQuery = em.createQuery("SELECT game FROM Game game WHERE game.id = :selectedGame", Game.class);
		
		typedQuery.setParameter("selectedGame", id);
		typedQuery.setMaxResults(1);
		Game result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
