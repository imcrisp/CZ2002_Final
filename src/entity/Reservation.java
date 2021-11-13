package entity;
import java.time.*; 
import java.util.Calendar;
/**
 * Represents a reservation made at the restaurant
 * @author Jeremy U Keat, Jordan Yuen Jia Jun, Lim Wee Tat Noel, Lin Run Yu
 * @version 1.0
 * @since 2021-11-13
 */
public class Reservation {
	/**
	 * The date of this reservation 
	 */
	private LocalDate date;
	/**
	 * The time of this reservation
	 */
	private LocalTime time;
	/**
	 * The number of customers dining for this reservation
	 */
	private int pax;
	/**
	 * Name of the customer making this reservation
	 */
	private String name;
	/**
	 * contact of the customer making this reservation
	 */
	private int contact;
	/**
	 * The table object that this reservation is made under
	 */
	private Table tab;
	
	/**
	 * Constructor for the reservation class
	 */
	public Reservation() {
		this.date=null;
		this.time=null;
		this.tab=null;
		this.contact=0;
		this.pax=0;
		this.name=null;
		
	}
	/**
	 * Gets the ID of the table of this reservation
	 * @return	Reservation's Table ID
	 */
	public int getTableID() {
		return this.tab.gettableID();
	}
	/**
	 * Gets the table of the reservation
	 * @return	Reservation's Table
	 */
	public Table getTable() {
		return this.tab;
	}
	
	/**
	 * Gets the contact number of the customer who made the reservation
	 * @return	This Reservation's customer contact
	 */
	public int getcontact() {
		return this.contact;
	}
	/**
	 * Gets the date and time of this reservation 
	 * This is done by combining the date and time of the reservation.
	 * @return Combined Date and Time of the reservation
	 */
	public LocalDateTime gettiming() {

		LocalDateTime result= LocalDateTime.of(this.date, this.time);
		return result;
	}
	/**
	 * Gets the number of customers dining for this reservation
	 * @return	The number of customers
	 */
	public int getpax() {
		return this.pax;
	}
	/**
	 * Gets the name of the customer who made the reservation
	 * @return	The customer's name
	 */
	public String getname() {
		return this.name;
	}
	/**
	 * Changes the name of the customer who made this reservation
	 * @param name This reservation's customer name
	 */
	public void setname(String name) {
		this.name=name;
	}
	/**
	 * Changes the number of customers dining for this reservation
	 * @param pax	This reservation's new number of customers
	 */
	public void setpax(int pax) {
		this.pax=pax;
	}
	/**
	 * Changes the contact of the customer who made this reservation
	 * @param contact	This reservation's new customer contact
	 */
	public void setcontact(int contact) {
		this.contact=contact;
	}
	/**
	 * Changes the table of this reservation
	 * @param tab	This reservation's new table 
	 */
	public void settable(Table tab) {
		this.tab=tab;
	}
	/**
	 * Changes the date of this reservation
	 * @param d	This reservation's new date
	 */
	public void setdate(LocalDate d) {
		this.date=d;
	}
	/**
	 * Changes the time of this reservation
	 * @param t	This reservation's new time
	 */
	public void settime(LocalTime t) {
		//formatted in HH:MM
		this.time=t;
	}
}
