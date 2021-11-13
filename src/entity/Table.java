package entity;
import control.Order;
/**
 * Represents a table in the restaurant
 * @author Jeremy U Keat, Jordan Yuen Jia Jun, Lim Wee Tat Noel, Lin Run Yu
 * @version 1.0
 * @since 2021-11-13
 */
public class Table {
	/**
	 * The ID number of this table
	 */
	private int tableID;
	/**
	 * The total number of customers this table can accommodate
	 */
	private int capacity;
	/**
	 * The status of the table
	 * When true, the table is occupied
	 * When false, table is vacant
	 */
	private boolean status;
	/**
	 * The order of this table
	 */
	public Order order;
	/**
	 * Constructor 	for the table class with given table ID, capacity and order
	 * @param TableID	This table's ID number
	 * @param capacity	This table's capacity
	 * 					This capacity should be an even number less than 10 and greater than 2.
	 * @param order		This table's order
	 */
	public Table(int TableID, int capacity, Order order) {
		this.capacity=capacity;
		this.tableID=TableID;
		this.status=false;
		this.order = new Order(tableID);
	}
	/**
	 * Gets the ID number of this table
	 * @return	this table's ID number
	 */
	public int gettableID() {
		return this.tableID;
	}
	/**
	 * Changes the status of this table to either true or false
	 * @param occupied	status as a boolean value of this table
	 * 					true means the table is occupied
	 * 					false means the table is vacant
	 */
	public void setStatus(boolean occupied){
		this.status=occupied;
	}
	/**
	 * Checks the status of this table as a boolean value
	 * @return	this table's status
	 */
	public boolean isReserved() {
		return this.status;
	}
	/**
	 * Gets the capacity of this table
	 * @return This table's capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}
}
