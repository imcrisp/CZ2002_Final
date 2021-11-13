package boundary;
import java.util.Scanner;
import init.RestaurantMgr;
import entity.Item;

/**
 * MenuItemMgr boundary class takes in user input to input item 
 * @author Jeremy U Keat, Jordan Yuen Jia Jun, Lim Wee Tat Noel, Lin Run Yu
 * @version 1.0
 * @since 2021-11-13
 */
public class MenuItemMgr implements RestaurantMgr {

	/**
	 * To scan user input
	 */
    private Scanner scan = new Scanner(System.in);
    /**
     * Quantity of item
     */
    private int quantity;
    /**
     * Price of item
     */
    private double price;
    /**
     * Name of item
     */
    private String name;
    /**
     * Description of item
     */
    private String description;
    /**
     * Meal type of item
     */
    private String mealType;
    /**
     * ID of item
     */
    private String itemID;

    /**
     * Add item into the item array list of the menu
     * @param target Determine if set meal or ala carte. If its true its a set meal else its ala carte.
     */
    public void addItemToMenu(boolean target){

        if (target){
            System.out.println("Enter price, itemID, name, description of set meal");
            price = scan.nextDouble();
            scan.nextLine();
            itemID = scan.nextLine();
            name = scan.nextLine();                       
            description = scan.nextLine();
            mealType = "setmeal";
        } 
        else{
            System.out.println("Enter price, itemID, name, description and meal type of item");
            System.out.println("Meal types: MainCourse, Drinks, Sides, Dessert");
            price = scan.nextDouble();
            scan.nextLine();
            itemID = scan.nextLine();
            name = scan.nextLine();                       
            description = scan.nextLine();
            mealType = scan.nextLine(); 
        }
        Item item = new Item(itemID, quantity, price, name,  description, mealType);     
        //check for duplicate itemID
        if (menu.duplicateID(mealType, itemID)){
            System.out.println("Item ID already exist, try again");
        }
        else{
            menu.addToMenu(item);
            System.out.println("Item added!");
            menu.printMenu(mealType);
        }    
    }

    /**
     * Update item inside the item array list of the menu
     * @param target Determine if set meal or ala carte. If its true its a set meal else its ala carte.
     */
    public void updateItemInMenu(boolean target){
        if (target){
            mealType = "setmeal";
            menu.printMenu(mealType);
            System.out.println("Choose item number to update along with the changes (price, name, description)");
            int i = scan.nextInt();
            while (i<=0 || i > menu.checkMenuSize(mealType)){
                System.out.println("Invalid index selected, try again");
                i = scan.nextInt();
                if (i>0 || i <= menu.checkMenuSize(mealType))
                    System.out.println("Continue entering the changes to price, name and description");
            }
            price = scan.nextDouble();
            scan.nextLine();
            name = scan.nextLine();
            description = scan.nextLine();
            menu.updateMenu(i, price, name, description, mealType);
            System.out.println("Menu Updated!");
            menu.printMenu(mealType);
        }
        else{
            System.out.print("Choose mealType to update: ");
            System.out.println("Meal types: MainCourse, Drinks, Sides, Dessert");
            mealType = scan.nextLine();
            menu.printMenu(mealType);
            System.out.println("Choose item number to update along with the changes (price, name, description)");
            int i = scan.nextInt();
            while (i<=0 || i > menu.checkMenuSize(mealType)){
                System.out.println("Invalid index selected, try again");
                i = scan.nextInt();
            }
            price = scan.nextDouble();
            scan.nextLine();
            name = scan.nextLine();
            description = scan.nextLine();
            menu.updateMenu(i, price, name, description, mealType);
            System.out.println("Menu Updated!");
            menu.printMenu(mealType);
        }    
    }
    /**
     * Remove item from item array list of the menu
     * @param target Determine if set meal or ala carte. If its true its a set meal else its ala carte.
     */
    public void removeItemFromMenu(boolean target){
        if (target){
            mealType = "setmeal";
            menu.printMenu(mealType);
            System.out.println("Choose item number you want to remove");
            int i = scan.nextInt();
            while (i<=0 || i > menu.checkMenuSize(mealType)){
                System.out.println("Invalid index selected, try again");
                i = scan.nextInt();
            }
            scan.nextLine();
            menu.removeFromMenu(mealType, i);
            System.out.println("Item removed!");
            menu.printMenu(mealType);
        }
        
        else{
            System.out.println("Choose mealType you want to remove from");
            System.out.println("Meal types: MainCourse, Drinks, Sides, Dessert, SetMeal");
            mealType = scan.nextLine();
            menu.printMenu(mealType);
            System.out.println("Choose item number you want to remove");
            int i = scan.nextInt();
            while (i<=0 || i > menu.checkMenuSize(mealType)){
                System.out.println("Invalid index selected, try again");
                i = scan.nextInt();
            }
            scan.nextLine();
            menu.removeFromMenu(mealType, i);
            System.out.println("Item removed!");
            menu.printMenu(mealType);
        }          
    }
}
