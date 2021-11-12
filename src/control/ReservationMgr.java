package control;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import init.RestaurantMgr;
import entity.Reservation;
import entity.Table;

public class ReservationMgr implements RestaurantMgr{
	
	private int counterID;
	protected ArrayList<Reservation> reservationlist = new ArrayList<Reservation>();
	public ArrayList<Table> tablelist = new ArrayList<Table>();
	Order order;
	
	public ReservationMgr() {
		this.reservationlist=new ArrayList<Reservation>();
		this.tablelist=new ArrayList<Table>();
		this.counterID=1;
	}
	
	public void createTables(int total, int capacity) {
		for (int i=0;i<total;i++) {
			Table tabcreate= new Table(tablelist.size(),capacity, new Order(i));
			tablelist.add(tabcreate);
			capacity+=2;	
		}
	}
	
	
	/**
	 * Checks if there is a table open. If none are, return null
	 * @return
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
	
	public boolean checkValid(int tableID){
		if (tableID < 0 || tableID > tablelist.size() -1)
			return false;
			
		return true;
	}
	
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
	 * Requires contact of the person who reserved the spot.
	 * @param contact
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
	 * Conditions for table to be released:
	 * 1. Order has been paid for
	 * 2. Past 15 minutes of reservation
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
	 * This function will be used when listing all vacant tables that can be reserved
	 * Listing is necessary when:
	 * 1. Display all tables and their status
	 * 2. Making a reservation
	 * 3. Cancelling any reservations
	 * 4. Checking reservations
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
