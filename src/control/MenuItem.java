package control;
import java.util.ArrayList;
import entity.Item;

/**
 * MenuItem class performs method on Item entity class, such as updating, removing, adding and checking for duplicate or if its empty
 * @author Jeremy U Keat, Jordan Yuen Jia Jun, Lim Wee Tat Noel, Lin Run Yu
 * @version 1.0
 * @since 2021-11-13
 */
public class MenuItem{

	/**
	 * Name of meal type
	 */
	private String mealType;
	/**
	 * Item array list for Main course
	 */
	private ArrayList<Item> mainCourse = new ArrayList<Item>();
	/**
	 * Item array list for Drinks
	 */
	private ArrayList<Item> drinks = new ArrayList<Item>();
	/**
	 * Item array list for Sides
	 */
	private ArrayList<Item> sides = new ArrayList<Item>();
	/**
	 * Item array list for Dessert
	 */
	private ArrayList<Item> dessert = new ArrayList<Item>();
	/**
	 * Item array list for Set Meal
	 */
	private ArrayList<Item> setMeal = new ArrayList<Item>();

	/**
	 * Constructor for MenuItem
	 */
	public MenuItem(){
		
	}
	/**
	 * Check for the amount of item in a meal type
	 * @param mealType Selected meal type
	 * @return The amount of item inside the meal type
	 */
	public int checkMenuSize(String mealType){
		if (mealType.equalsIgnoreCase("maincourse"))
			return mainCourse.size();
		if (mealType.equalsIgnoreCase("drinks"))
			return drinks.size();
		if (mealType.equalsIgnoreCase("sides"))
			return sides.size();
		if (mealType.equalsIgnoreCase("dessert"))
			return dessert.size();
		if (mealType.equalsIgnoreCase("setmeal"))
			return setMeal.size();
		return 0;

	}

	/**
	 * Checks if there's a duplicate ID when trying to add item to menu
	 * @param mealType Meal type name
	 * @param itemID Item ID
	 * @return Result if there contains a duplicate id inside the class
	 */
	public boolean duplicateID(String mealType, String itemID){
		if (mealType.equalsIgnoreCase("maincourse")){
			for (int i = 0; i<mainCourse.size(); i++){
				if (itemID.equalsIgnoreCase(mainCourse.get(i).getItemID()))
					return true;
			}
		}

		if (mealType.equalsIgnoreCase("drinks")){
			for (int i = 0; i<drinks.size(); i++){
				if (itemID.equalsIgnoreCase(drinks.get(i).getItemID()))
					return true;
			}
		}

		if (mealType.equalsIgnoreCase("sides")){
			for (int i = 0; i<sides.size(); i++){
				if (itemID.equalsIgnoreCase(sides.get(i).getItemID()))
					return true;
			}
		}

		if (mealType.equalsIgnoreCase("dessert")){
			for (int i = 0; i<dessert.size(); i++){
				if (itemID.equalsIgnoreCase(dessert.get(i).getItemID()))
					return true;
			}
		}

		if (mealType.equalsIgnoreCase("setmeal")){
			for (int i = 0; i<setMeal.size(); i++){
				if (itemID.equalsIgnoreCase(setMeal.get(i).getItemID()))
					return true;
			}
		}

		return false;
	}

	/**
	 * Check if a given meal type is empty
	 * @param mealType Meal type name
	 * @return If meal type is empty
	 */
	public boolean isEmpty(String mealType){
		if (mealType.equalsIgnoreCase("maincourse")  && mainCourse.size() == 0)
			return true;
		if (mealType.equalsIgnoreCase("drinks") && drinks.size() == 0)
			return true;
		if (mealType.equalsIgnoreCase("sides") && sides.size() == 0)
			return true;
		if (mealType.equalsIgnoreCase("dessert") && dessert.size() == 0)
			return true;
		if (mealType.equalsIgnoreCase("setmeal") && setMeal.size() == 0)
			return true;
		
		return false;
	}
	/**
	 * Get the item inside the array list
	 * @param mealType Name of meal type
	 * @param index The index of the item
	 * @return Selected item
	 */
	public Item getItem(String mealType, int index){
		if (mealType.equalsIgnoreCase("maincourse"))
			return mainCourse.get(index-1);
		if (mealType.equalsIgnoreCase("drinks"))
			return drinks.get(index-1);
		if (mealType.equalsIgnoreCase("sides"))
			return sides.get(index-1);
		if (mealType.equalsIgnoreCase("dessert"))
			return dessert.get(index-1);;
		if (mealType.equalsIgnoreCase("setmeal"))
			return setMeal.get(index-1);
		
		return null;
	}
	/**
	 * Prints the menu of a given meal type
	 * @param mealType Name of meal type
	 */
	public void printMenu(String mealType) {
		// TODO - implement MenuItem.printMenu
			if (mealType.equalsIgnoreCase("maincourse")){
				System.out.printf("\t\t    Main Course\t\n");
				System.out.println("----------------------------------------------------------");
				System.out.printf("%-10s %-10s %-10s      %-10s    %-10s \n", "Item#", "ItemID", "Name", "Description", "Price");
				System.out.println("----------------------------------------------------------");
				if (mainCourse.size() == 0){
					System.out.println("\t\t    No items");
					System.out.println("----------------------------------------------------------");
					System.out.println();
				}	
				else{
					for (int i = 0; i<mainCourse.size(); i++){
						System.out.printf("%,4d        %-9s %-15s %-12s   " +"$"+"%.2f\n", (i+1), mainCourse.get(i).getItemID(), 
						mainCourse.get(i).getName(), mainCourse.get(i).getDescription(), mainCourse.get(i).getPrice());	
					}
					System.out.println("----------------------------------------------------------");
					System.out.println();
				}
				
			}
				
			if (mealType.equalsIgnoreCase("drinks")){
				System.out.printf("\t\t      Drinks\t\n");
				System.out.println("-----------------------------------------------------");
				System.out.printf("%-10s %-10s %-10s %-10s    %-10s \n", "Item#", "ItemID", "Name", "Description", "Price");
				System.out.println("-----------------------------------------------------");
				if (drinks.size() == 0){
					System.out.println("\t\t    No items");
					System.out.println("-----------------------------------------------------");
					System.out.println();
				}
				else{
					for (int i = 0; i<drinks.size(); i++){
						System.out.printf("%,4d        %-9s %-10s %-12s   " +"$"+"%.2f\n", (i+1), drinks.get(i).getItemID(), 
						drinks.get(i).getName(), drinks.get(i).getDescription(), drinks.get(i).getPrice());
						
					}
					System.out.println("-----------------------------------------------------");
					System.out.println();
			    }
		    }
			
			if (mealType.equalsIgnoreCase("sides")){
				System.out.printf("\t\t      Sides\t\n");
				System.out.println("-----------------------------------------------------");
				System.out.printf("%-10s %-10s %-10s %-10s    %-10s \n", "Item#", "ItemID", "Name", "Description", "Price");
				System.out.println("-----------------------------------------------------");
				if (sides.size() == 0){
					System.out.println("\t\t    No items");
					System.out.println("-----------------------------------------------------");
					System.out.println();
				}
				else{
					for (int i = 0; i<sides.size(); i++){
						System.out.printf("%,4d        %-9s %-10s %-12s   " +"$"+"%.2f\n", (i+1), sides.get(i).getItemID(), 
						sides.get(i).getName(), sides.get(i).getDescription(), sides.get(i).getPrice());
						
					}
					System.out.println("-----------------------------------------------------");
					System.out.println();
			    }
			}

			if (mealType.equalsIgnoreCase("dessert")){
				System.out.printf("\t\t       Dessert\t\n");
				System.out.println("-----------------------------------------------------");
				System.out.printf("%-10s %-10s %-10s %-10s    %-10s \n", "Item#", "ItemID", "Name", "Description", "Price");
				System.out.println("-----------------------------------------------------");
				if (dessert.size() == 0){
					System.out.println("\t\t    No items");
					System.out.println("-----------------------------------------------------");
					System.out.println();
				}
				else{
					for (int i = 0; i<dessert.size(); i++){
						System.out.printf("%,4d        %-9s %-10s %-12s   " +"$"+"%.2f\n", (i+1), dessert.get(i).getItemID(), 
						dessert.get(i).getName(), dessert.get(i).getDescription(), dessert.get(i).getPrice());
						
					}
					System.out.println("-----------------------------------------------------");
					System.out.println();
			    }
			}

			if (mealType.equalsIgnoreCase("setmeal")){
				System.out.printf("\t\t     Set Meal\t\n");
				System.out.println("-----------------------------------------------------");
				System.out.printf("%-10s %-10s %-10s %-10s    %-10s \n", "Item#", "ItemID", "Name", "Description", "Price");
				System.out.println("-----------------------------------------------------");
				if (setMeal.size() == 0){
					System.out.println("\t\t    No items");
					System.out.println("-----------------------------------------------------");
					System.out.println();
				}
				else{
					for (int i = 0; i<setMeal.size(); i++){
						System.out.printf("%,4d        %-9s %-10s %-12s   " +"$"+"%.2f\n", (i+1), setMeal.get(i).getItemID(), 
						setMeal.get(i).getName(), setMeal.get(i).getDescription(), setMeal.get(i).getPrice());
						
					}
					System.out.println("-----------------------------------------------------");
					System.out.println();
			    }
			}
	}
	/**
	 * Update an item's price, name, description, of selected item in a meal type
	 * @param itemNumber Choice of item
	 * @param price New price
	 * @param name New name
	 * @param description New description
	 * @param mealType Choice of meal type
	 */
	public void updateMenu(int itemNumber, double price, String name, String description, String mealType){
		if (mealType.equalsIgnoreCase("maincourse")){
			mainCourse.get(itemNumber-1).setPrice(price);
			mainCourse.get(itemNumber-1).setName(name);
			mainCourse.get(itemNumber-1).setDescription(description);
		}
		if (mealType.equalsIgnoreCase("drinks")){
			drinks.get(itemNumber-1).setPrice(price);
			drinks.get(itemNumber-1).setName(name);
			drinks.get(itemNumber-1).setDescription(description);
		}
		if (mealType.equalsIgnoreCase("sides")){
			sides.get(itemNumber-1).setPrice(price);
			sides.get(itemNumber-1).setName(name);
			sides.get(itemNumber-1).setDescription(description);
		}
		if (mealType.equalsIgnoreCase("dessert")){
			dessert.get(itemNumber-1).setPrice(price);
			dessert.get(itemNumber-1).setName(name);
			dessert.get(itemNumber-1).setDescription(description);
		}
		if (mealType.equalsIgnoreCase("setmeal")){
			setMeal.get(itemNumber-1).setPrice(price);
			setMeal.get(itemNumber-1).setName(name);
			setMeal.get(itemNumber-1).setDescription(description);	
		}
		
	}
	/**
	 * Add item into item array list of selected meal type
	 * @param Item Item data
	 */
	public void addToMenu(Item Item) {
		// TODO - implement MenuItem.addToMenu
		mealType = Item.getMealType();

		if (mealType.equalsIgnoreCase("maincourse"))
			mainCourse.add(Item);
		if (mealType.equalsIgnoreCase("drinks"))
			drinks.add(Item);
		if (mealType.equalsIgnoreCase("sides"))
			sides.add(Item);
		if (mealType.equalsIgnoreCase("dessert"))
			dessert.add(Item);
		if (mealType.equalsIgnoreCase("setmeal"))
			setMeal.add(Item);
	}

	/**
	 * Remove item from menu of a given meal type and index
	 * @param mealType Meal type name
	 * @param index Item index
	 */
	public void removeFromMenu(String mealType, int index) {
		// TODO - implement MenuItem.removeFromMenu
		if (mealType.equalsIgnoreCase("maincourse")) {
			if(index ==0 || index > mainCourse.size())
			{
				return;
			}
			else{
				mainCourse.remove(index-1);

				}
			}
		if (mealType.equalsIgnoreCase("drinks")){
			if(index ==0 || index > drinks.size())
			{
				return;
			}
			else {
			drinks.remove(index-1);

				}
			}
		if (mealType.equalsIgnoreCase("sides")) {
			if(index ==0 || index > sides.size())
			{
				return;
			}
			else {
			sides.remove(index-1);

			}
		}
		if (mealType.equalsIgnoreCase("dessert")) {
			if(index ==0 || index > dessert.size())
			{
				return;
			}
			else {
			dessert.remove(index-1);

			}
		}
		if (mealType.equalsIgnoreCase("setmeal")) {
			if(index ==0 || index > setMeal.size())
			{
				return;
			}
			else {
			setMeal.remove(index-1);
			}
		}
	}

}
