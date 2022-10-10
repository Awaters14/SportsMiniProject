package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Team;

/**  
* @author Alex Waters - Awaters6
* CIS175 - Fall 2021
* Oct 10, 2022  
*/
public class TeamHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TeamList");
	
	public void insertItem(Team tm) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(tm);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteItem(Team toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Team> typedQuery = em.createQuery("select t from Team t where t.name = :selectedName and t.numOfPlayers = :selectedNumOfPlayers", Team.class);
		
		//Substitute parameter with actual data from the toDelete item 
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedNumOfPlayers", toDelete.getNumOfPlayers());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new Team
		Team result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Team> searchForTeamByName(String teamName) {
		
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Team> typedQuery = em.createQuery("select t from Team t where t.name = :selectedName", Team.class);
		typedQuery.setParameter("selectedName", teamName);
		
		List<Team> foundTeam = typedQuery.getResultList();
		
		em.close();
		return foundTeam;
	}

	public List<Team> searchForTeamByPlayers(int numPlayers) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		TypedQuery<Team> typedQuery = em.createQuery("select t from Team t where t.numOfPlayers = :selectedNumOfPlayers", Team.class);
		typedQuery.setParameter("selectedNumOfPlayers", numPlayers);
		
		List<Team> foundPlayers = typedQuery.getResultList();
		
		em.close();
		return foundPlayers;
	}
	
	public Team searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Team found = em.find(Team.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateItem(Team toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp(){
		emfactory.close();
		}
	
	public List<Team> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<Team> allItems = em.createQuery("SELECT i FROM Team i").getResultList();
		return allItems;
	}
}
