package entity;
import control.Order;

public class Table {
	private int tableID;
	private int capacity;
	//when true, means table is occupied
	private boolean status;
	//ArrayList<Item> specificOrder = new ArrayList<Item>(); 
	public Order order;
	
	public Table(int TableID, int capacity, Order order) {
		//capacity should always be even and less than 10, greater than 2
		this.capacity=capacity;
		this.tableID=TableID;
		//initialise table to be vacant
		this.status=false;
		//this.specificOrder = specificOrder;
		this.order = new Order(tableID);
	}
	
	public int gettableID() {
		return this.tableID;
	}
	public void setStatus(boolean occupied){
		if (occupied) {
			this.status= true;
		}
		else {
			this.status= false;
		}
	}
	public boolean isReserved() {
		return this.status;
	}
	public int getCapacity() {
		return this.capacity;
	}
}
