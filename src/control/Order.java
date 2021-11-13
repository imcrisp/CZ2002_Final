package control;
import java.util.ArrayList;

import entity.Item;
import entity.Staff;
import init.RestaurantMgr;

/**
* This class add, prints and remove item ordered by a customer.
* It also get the price of the ordered items.
* @author Jeremy U Keat, Jordan Yuen Jia Jun, Lim Wee Tat Noel, Lin Run Yu
* @version 1.0
* @since 2021-11-13
*/
public class Order implements RestaurantMgr{
    /**
     * The identification number of the item.
     */
	private String itemID;
	/**
	 * The identification number of the table.
	 */
	private int tableID;
    /**
	 * The new item the customer wants to order.
	 */
    private Item newItem;
    /**
     * The staff that is taking the customer's order.
     */
    public Staff staff;
    /**
     * The ArrayList to store the items ordered by the customer.
     */
    public ArrayList<Item> orderItems;
    /**
     * Constructs an order with a specified table ID, ordered items and staff details.
     * @param tableID The identification number of the table.
     */
    public Order(int tableID){
        this.tableID = tableID;
        this.orderItems = new ArrayList<Item>();
        this.staff = staff;
        }

    /**
     * Constructor for the class.
     */
    public Order(){

    }

    /**
     * This returns the price of the ordered item.
     * @param i The index of the ordered item in the 'orderedItems' ArrayList. 
     * @return The price of the ordered item.
     */
    public double getPrice(int i){
        return orderItems.get(i).getPrice();
    }

    /**
     * This method adds the item the customer ordered into the 'orderItems' ArrayList.
     * It also adds the quantity of the items customer ordered.
     * The staff can input customer's order in capital letters or small letters.
     * @param item The item that the customer ordered.
     * @param quantity The quantity of that item the customer ordered.
     */
	public void addItem(Item item, int quantity){
        this.newItem = item.clone();
        itemID = newItem.getItemID();
        for (int i = 0; i<orderItems.size(); i++){
            if (orderItems.get(i).getItemID().equalsIgnoreCase(itemID)){
                orderItems.get(i).increaseQuantity(quantity);
                return;
            }
        }
        newItem.setQuantity(quantity);
        orderItems.add(newItem);
    }
	/**
	 * This method prints out the items ordered by the customer.
	 * It will print out the item name, the price and the quantity ordered.
	 * There is an index assigned with every items printed out.
	 * This index is different from the index of that item in the 'orderItems' ArrayList. 
	 * @param tableNo The identification number of the table. 
	 */
	public void printOrder(int tableNo){
	      System.out.println("=======================================================================================");
	      System.out.println("Table No:"+ (tableNo+1) + "\t Created By: "+ res.tablelist.get(tableNo).order.staff.getStaffName());
	      System.out.println("---------------------------------------------------------------------------------------");
	        System.out.println("No \t"+ "Item Name \t "+" Price"+"\t Qty");
	        for (int i = 0; i<orderItems.size(); i++){

	            //System.out.println((i+1)+"\t"+ orderItems.get(i).getName()+"\t \t"  + orderItems.get(i).getPrice()+"\t\t"   + orderItems.get(i).getQuantity());
	            System.out.printf("%d      %8s           %.2f           %d\n", (i+1), orderItems.get(i).getName(), orderItems.get(i).getPrice(), orderItems.get(i).getQuantity());

	        }
	      System.out.println("=======================================================================================");
	      res.tablelist.get(tableNo).setStatus(true);
	    }
    /**
     * This method removes the item from the 'orderItems' ArrayList.
     * Customer can either remove the items completely or reduce the items they have ordered.
     * If the customer wants to remove an item, that item will be removed from the 'orderItems' ArrayList.
     * If the customer wants to reduce the quantity of an item, only the quantity of that item will change.
     * That item will not be removed from the 'orderItems' ArrayList
     * @param index The index of the item that is printed out. 
     * 				It is not the same as the index of the item in the 'orderItems' ArrayList.
     * @param quantity The quantity of the items to be removed.
     */
    public void removeItem(int index, int quantity){
    	if (orderItems.get(index-1).getQuantity() == quantity)
            orderItems.remove(index-1);
        else {
            orderItems.get(index-1).decreaseQuantity(quantity);
        }
    }
}