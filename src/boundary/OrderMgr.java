package boundary;
import java.util.Scanner;

import init.RestaurantMgr;

public class OrderMgr implements RestaurantMgr {

    private String mealType;
    private String itemID;
    private int index;
    private int quantity;
    Scanner scan = new Scanner(System.in);

    public void addToOrder(int tableID){
        System.out.println("Enter StaffID: ");
        int staffID = scan.nextInt();
        res.tablelist.get(tableID).order.s.setStaffId(staffID);
        scan.nextLine();
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

    public void viewOrder(int tableID){
        if (tableID > res.tablelist.size())
            System.out.println("Table does not exist");
        else 
            res.tablelist.get(tableID).order.printOrder(tableID);
    }
    
}
