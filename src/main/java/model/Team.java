package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**  
* @author Alex Waters - Awaters6
* CIS175 - Fall 2021
* Oct 10, 2022  
*/

@Entity
@Table(name="team")
public class Team {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="NUMOFPLAYERS")
	private int numOfPlayers;
	/**
	 * 
	 */
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param name
	 * @param numOfPlayers
	 */
	public Team(String name, int numOfPlayers) {
		super();
		this.name = name;
		this.numOfPlayers = numOfPlayers;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the numOfPlayers
	 */
	public int getNumOfPlayers() {
		return numOfPlayers;
	}
	/**
	 * @param numOfPlayers the numOfPlayers to set
	 */
	public void setNumOfPlayers(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}
	
	public String returnTeamDetails() {
		return "Team [name=" + name + ", numOfPlayers=" + numOfPlayers + "]";
	}
	
	
	
	
	

}
