package entity;
import java.time.*; 
import java.util.Calendar;

public class Reservation {
	private LocalDate date;
	private LocalTime time;
	private int pax;
	//name of person who made the reservation;
	private String name;
	private int contact;
	private Table tab;
	
	public Reservation() {
		this.date=null;
		this.time=null;
		this.tab=null;
		this.contact=0;
		this.pax=0;
		this.name=null;		
	}
	/*
	public Reservation( LocalDate date, LocalTime time, int pax, String name, int contact, int reservationID,Table tab) {
		this.date=date;
		this.time=time;
		this.pax=pax;
		this.name=name;
		this.contact=contact;
		this.reservationID=reservationID;
		this.tab=tab;
	}
	*/

	public int getTableID() {
		return this.tab.gettableID();
	}
	public Table getTable() {
		return this.tab;
	}
	
	public int getcontact() {
		return this.contact;
	}
	public LocalDateTime gettiming() {

		LocalDateTime result= LocalDateTime.of(this.date, this.time);
		return result;
	}
	public int getpax() {
		return this.pax;
	}
	public String getname() {
		return this.name;
	}

	public void setname(String name) {
		this.name=name;
	}
	public void setpax(int pax) {
		this.pax=pax;
	}
	public void setcontact(int contact) {
		this.contact=contact;
	}

	public void settable(Table tab) {
		this.tab=tab;
	}
	public void setdate(LocalDate d) {
		this.date=d;
	}
	public void settime(LocalTime t) {
		//formatted in HH:MM
		this.time=t;
	}
}
