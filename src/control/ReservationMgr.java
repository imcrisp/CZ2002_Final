package control;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import init.RestaurantMgr;
import entity.Reservation;
import entity.Table;
/**
 * The control class that handles the creation, removal and checking of reservations
 * @author Jeremy U Keat, Jordan Yuen Jia Jun, Lim Wee Tat Noel, Lin Run Yu
 * @version 1.0
 * @since 2021-11-13
 */
public class ReservationMgr implements RestaurantMgr{
	/**
	 * The number of reservations that have been made in the current session
	 */
	private int counterID;
	/**
	 * The array list that contains all reservations in the restaurant 
	 * Stored in RestaurantMgr
	 */
	protected ArrayList<Reservation> reservationlist = new ArrayList<Reservation>();
	/**
	 * The array list that contains all tables in the restaurant
	 * Stored in RestaurantMgr
	 */
	public ArrayList<Table> tablelist = new ArrayList<Table>();
	
	/**
	 * Constructor for the reservation manager class
	 * Creates empty array for reservations and tables
	 * Sets ID of reservations to start at 1.
	 */
	public ReservationMgr() {
		this.reservationlist=new ArrayList<Reservation>();
		this.tablelist=new ArrayList<Table>();
		this.counterID=1;
	}
	/**
	 * creates the tables in the restaurant given a capacity and number of tables
	 * @param total		total number of tables to be created 
	 * @param capacity	initial capacity of the first table
	 * 					this should be an even number which will increment by 2 till total is reached
	 */
	public void createTables(int total, int capacity) {
		for (int i=0;i<total;i++) {
			Table tabcreate= new Table(tablelist.size(),capacity, new Order(i));
			tablelist.add(tabcreate);
			capacity+=2;	
		}
	}
	
	
	/**
	 * Checks if there is a table that is open and has a high enough capacityfor the given pax
	 *  If no tables are available, returns null
	 * @param pax The number of customers to be seated at the table
	 * @return	the table that is found to be available, or
	 * 			null if no table can be found that can host the pax given
	 */
	
	public Table checkAvailability(int pax) {
		refreshReservations();
		for (int i=0; i<tablelist.size();i++) {
			if (!tablelist.get(i).isReserved() && tablelist.get(i).getCapacity()>=pax) {
				return tablelist.get(i);
			}
			
		}
		return null;
	}
	/**
	 * Checks if a given table ID is out of bounds of the table array list
	 * @param tableID the index of the table to be checked
	 * @return true if the table is within the array list, or
	 * 			false if the table is found to be out of bounds
	 */
	public boolean checkValid(int tableID){
		if (tableID < 0 || tableID > tablelist.size() -1)
			return false;
			
		return true;
	}
	/**
	 * Displays the id, capacity and vacancy of all individual tables in the restaurant 
	 */
	public void printTables() {
		refreshReservations();
		if (tablelist.size()==0) {
			System.out.println("There are no tables yet!");
			return;
		}
		String s;
		System.out.println("The current list of Tables and their vacancy: ");
		for(int i=0;i<tablelist.size();i++) {
			if (tablelist.get(i).isReserved()){
				s="Reserved";
			}
			else {
				s="Vacant";
			}
			System.out.println("Table ID "+(tablelist.get(i).gettableID()+1)+
					"Capacity: "+tablelist.get(i).getCapacity()+
					" Status: "+ s );
		}
	}
	/**
	 * Displays the details of a reservation that was made given the customer contact
	 * If no reservation can match the contact, displays to user that no reservation has been made for this contact
	 * @param contact	The contact of the customer who made the reservation
	 */
	public void checkReservation(int contact) {
		refreshReservations();
		for (int i=0; i<reservationlist.size();i++) {
			if (reservationlist.get(i).getcontact()==contact) {
				System.out.println("A reservation under "+reservationlist.get(i).getname()+
						" for "+reservationlist.get(i).getpax()+
						" people on table " + (reservationlist.get(i).getTableID()+1)+
						" has been made for "+reservationlist.get(i).gettiming().toLocalDate()+
						" at "+reservationlist.get(i).gettiming().toLocalTime()+" hours.");
				return;
				
			}
		}
		System.out.println("There is no reservation made under this contact!");
	}
	/**
	 * Allocates the reservation to a table given pax, contact, name, date and time
	 * @param pax The amount of person seating at the table
	 * @param contact The contact of the customer making this reservation
	 * @param name The name of customer for this reservation
	 * @param date The date of the reservation
	 * @param time The time of the reservation
	 * @return total number of reservations made at the current time if reservation was successfully allocated,
	 * 			or -1 if the date and time of the reservation is in the past
	 */
	public int tableAllocate(int pax, int contact, String name, LocalDate date, LocalTime time){
		//booking in the past
		if (Duration.between(LocalDateTime.of(date,time), LocalDateTime.now()).toMinutes()>=0) {
			return -1;
		}

		Reservation newres = new Reservation();
		
		newres.setname(name);
		
		newres.setcontact(contact);
		
		newres.setpax(pax);
		
		newres.setdate(date);
		
		newres.settime(time);
		int num=this.counterID++;
		//newres.setreservationID(num);
		newres.settable(checkAvailability(pax));
		reservationlist.add(newres);
		
		newres.getTable().setStatus(true);
		return num;
		
	}
	/**
	 * Removes a reservation given the customer's contact
	 * @param contact	The contact of the customer's reservation
	 * @return   1 if the removal of the reservation was successful, or
	 * 			-1 if no reservations matching the contact could be found
	 */
	public int removeReservation(int contact) {
		refreshReservations();
		for(int i=0;i<reservationlist.size();i++) {
			if (reservationlist.get(i).getcontact()==contact) {
				tablelist.get(reservationlist.get(i).getTableID()).setStatus(false);
				reservationlist.remove(i);
				return 1;
			}
		}
		return -1;
	}
	/**
	 * Removes a reservation given the table ID number
	 * @param	tableID	the table ID number of the reservation
	 * @return   1 if the reservation was successfully removed
	 * 			-1 if no reservations matching the table ID could be found
	 */
	public int removeRes(int tableID)
	{
		refreshReservations();
		for(int i=0;i<reservationlist.size();i++) {
			if (reservationlist.get(i).getTable().gettableID()== tableID) {
				tablelist.get(reservationlist.get(i).getTableID()).setStatus(false);
				reservationlist.remove(i);
				return 1;
			}
		}
		return -1;
	}
	/**
	 * Refreshes all the reservations in the restaurant by scanning through the reservation array,
	 * checking if any reservations are already past 15 minutes of its booking time and removes them
	 */
	public void refreshReservations() {
		//Check if there are any reservations that are already past the date and time
		for(int i=0;i<reservationlist.size();i++) {
			Reservation curr=reservationlist.get(i);
			if (Duration.between(curr.gettiming(), LocalDateTime.now()).toMinutes()>=15) {
						
						tablelist.get(curr.getTableID()).setStatus(false);
						reservationlist.remove(i);
					}
				}
			}
		

	
	
}
