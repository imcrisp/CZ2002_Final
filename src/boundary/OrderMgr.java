package boundary;
import java.util.Scanner;

import init.RestaurantMgr;

/**
 * This boundary class manages an order by a customer.
 * This class implements the 'RestaurantMgr' interface.
 * It will utilize some methods from the 'Order' class.
 * @author Jeremy U Keat, Jordan Yuen Jia Jun, Lim Wee Tat Noel, Lin Run Yu
 * @version 1.0
 * @since 2021-11-13
 */
public class OrderMgr implements RestaurantMgr {
	/**
	 * The type of item the customer wants to order
	 */
    private String mealType;
    /**
     * The identification number of the item
     */
    private String itemID;
    /**
     * The index of the ArrayList
     */
    private int index;
    /**
     * The quantity of the ordered items
     */
    private int quantity;
    /**
     * The scanner to scan inputs
     */
    Scanner scan = new Scanner(System.in);

    /**
     * This method adds the customer's order.
     * It will first get the ID of the staff.
     * It will then ask the staff to key in the type of meal the customer wants to order.
     * The staff can input in capital letters or small letters.
     * Once they input the meal type, it will print out the menu items associated with that meal type.
     * The staff will order the item through it's index.
     * If the index is invalid, it will prompt the staff to enter the index again.
     * If the index is valid, it will prompt the staff to enter the item quantity.
     * The staff can continue ordering until he/she inputs 0.
     * @param tableID The identification number of the table.
     */
    public void addToOrder(int tableID){
        System.out.println("Enter StaffID: ");
        int staffID = scan.nextInt();
        scan.nextLine();
        res.tablelist.get(tableID).order.staff = s.staff.get(staffID-1);
        System.out.println("Enter mealType you want to order, q/Q to stop ordering");
        System.out.println("Meal types: MainCourse, Drinks, Sides, Dessert, SetMeal");
        mealType = scan.nextLine();

        while (!mealType.equalsIgnoreCase("q")){
            menu.printMenu(mealType);
            if (!(menu.isEmpty(mealType))){
                System.out.println("Enter index and quantity of order, 0 to stop order");
                index = scan.nextInt();
                while (index > menu.checkMenuSize(mealType)){
                    System.out.println("Invalid index, try again");
                    index = scan.nextInt();
                }
                while (index !=0){
                    System.out.println("Enter quantity to order");
                    quantity = scan.nextInt();
                    res.tablelist.get(tableID).order.addItem(menu.getItem(mealType, index), quantity);
                    System.out.println("Continue entering, enter 0 to stop");
                    index = scan.nextInt();
                } 
                scan.nextLine();
                System.out.println("Enter mealType you want to order, q/Q to stop ordering");
                System.out.println("Meal types: MainCourse, Drinks, Sides, Dessert, SetMeal");
                mealType = scan.nextLine();
            }
            else{
                System.out.println("Current mealType menu empty, unable to order");
            } 
        }
        //System.out.println("Printing total order");
        res.tablelist.get(tableID).order.printOrder(tableID);
        
    }

    /**
     * This method removes the customer's order.
     * It will first print out the customer's order.
     * The staff will then select the item to remove through its index.
     * If the index is invalid, it will prompt the staff to try again.
     * If the index is valid, it will ask the staff how many to remove.
     * If the staff input a number that is more than the quantity the customer ordered, it will prompt the staff to try again.
     * The staff can continue removing until he/she inputs 0.
     * @param tableID The identification number of the table.
     */
    public void removeFromOrder(int tableID){
        System.out.println("Printing current order");
        res.tablelist.get(tableID).order.printOrder(tableID);
        System.out.println("Select index to remove, 0 to stop"); 
        index = scan.nextInt();
        //check for invalid index
        while (index > res.tablelist.get(tableID).order.orderItems.size()){
            System.out.println("Invalid index, try again");
            index = scan.nextInt();
        }
        while (index !=0){
            System.out.println("How many to remove?");
            quantity = scan.nextInt();
            while (quantity > res.tablelist.get(tableID).order.orderItems.get(index-1).getQuantity()){
                System.out.println("Removing too many items, choose quantity to remove again");
                quantity = scan.nextInt();
            }
        res.tablelist.get(tableID).order.removeItem(index, quantity);
        System.out.println("Continue removing, enter 0 to stop");
        index = scan.nextInt();
        }  
        scan.nextLine(); 
    }
    /**
     * This method will print out the customer order.
     * It will print out the items and it's price and quantity.
     * If the table does not have any customer, it will print out that the table does not exist.
     * @param tableID The identification number of the table.
     */
    public void viewOrder(int tableID){
        if (tableID > res.tablelist.size())
            System.out.println("Table does not exist");
        else 
            res.tablelist.get(tableID).order.printOrder(tableID);
    }
    
}
