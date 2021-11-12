package control;
import java.util.ArrayList;

import entity.Item;
import entity.Staff;
import init.RestaurantMgr;

public class Order implements RestaurantMgr{
	private String itemID;
	private int tableID;
	private int staffID;
    private Item newItem;
    Staff staff = new Staff();
    public ArrayList<Item> orderItems;
    public Order(int tableID){
        this.tableID = tableID;
        this.orderItems = new ArrayList<Item>();
        this.staff = staff;
        }

    public Order(){

    }


    public double getPrice(int i){
        return orderItems.get(i).getPrice();
    }

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

    public void printOrder(int tableNo){
    	System.out.println("=======================================================================================");
    	System.out.println("Table No:"+ (tableNo+1) + "\t Created By: "+ s.getStaffName());
    	System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("No. \t"+ "Item Name. \t "+" Price."+"\t Qty.");
        for (int i = 0; i<orderItems.size(); i++){

            System.out.println((i+1)+"\t"+ orderItems.get(i).getName()+"\t \t"+ orderItems.get(i).getPrice()+"\t\t"+ orderItems.get(i).getQuantity());

        }
    	System.out.println("=======================================================================================");
    	res.tablelist.get(tableNo).setStatus(true);
    }

    public void removeItem(int index, int quantity){
    	if (orderItems.get(index-1).getQuantity() == quantity)
            orderItems.remove(index-1);
        else {
            orderItems.get(index-1).decreaseQuantity(quantity);
        }
    }
}