/**
 * @author Kilian Wehde - kewehde
 * CIS175 - Fall 2022
 * Oct 11, 2022
 */
package model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game {
	//Variables
	@Id
	@GeneratedValue
	private int id;
	@Column
	private LocalDate date;
	@Column
	private LocalTime time;
	@JoinColumn
	@ManyToOne (cascade= {CascadeType.MERGE})
	private Team home;
	@JoinColumn
	@ManyToOne (cascade= {CascadeType.MERGE})
	private Team away;
	
	//Getters and Setters
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
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	/**
	 * @return the time
	 */
	public LocalTime getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(LocalTime time) {
		this.time = time;
	}
	/**
	 * @return the home
	 */
	public Team getHome() {
		return home;
	}
	/**
	 * @param home the home to set
	 */
	public void setHome(Team home) {
		this.home = home;
	}
	/**
	 * @return the away
	 */
	public Team getAway() {
		return away;
	}
	/**
	 * @param away the away to set
	 */
	public void setAway(Team away) {
		this.away = away;
	}
	
	
	/**
	 * Default no-arg constructor
	 */
	public Game() {
		super();
	}
	/**
	 * @param gameTime
	 * @param home
	 * @param away
	 */
	public Game(LocalDate date, LocalTime time, Team home, Team away) {
		super();
		this.date = date;
		this.time = time;
		this.home = home;
		this.away = away;
	}
	/**
	 * @param id
	 * @param gameTime
	 * @param home
	 * @param away
	 */
	public Game(int id, LocalDate date, LocalTime time, Team home, Team away) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.home = home;
		this.away = away;
	}	
}
