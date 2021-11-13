package entity;
/**
 * Item class which stores all items that are in the menu 
 * @author Jeremy U Keat, Jordan Yuen Jia Jun, Lim Wee Tat Noel, Lin Run Yu
 * @version 1.0
 * @since 2021-11-13
 */
public class Item{
	/**
	 * Quantity of item
	 */
    private int quantity;
    /**
     * ID of item
     */
    private String itemID;
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
	 * Creates an item with a certain id, quantity, price, name, description, meal type
	 * @param itemID this item id
	 * @param quantity this item quantity
	 * @param price this item price
	 * @param name this item name
	 * @param description this item description
	 * @param mealType this item meal type
	 */
    public Item(String itemID, int quantity, double price, String name,  String description, String mealType){
        this.mealType = mealType;
        this.quantity = 1;
        this.name = name;
        this.description = description;
        this.price = price;
        this.itemID = itemID;
    }

    /**
     * Change new item name
     * @param name Item's new name
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Change new item description
     * @param description Item's new description
     */
    public void setDescription(String description){
        this.description = description;
    }
    /**
     * Change new item price
     * @param price Item's new price
     */
    public void setPrice(double price){
        this.price = price;
    }
    /**
     * Change new item quantity
     * @param quantity Item's new quantity
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    /**
     * Increase the quantity of an item
     * @param quantity Amount to increase
     */
    public void increaseQuantity(int quantity) {
        this.quantity += quantity;        
    }
    /**
     * Decrease the quantity of an item
     * @param quantity Amount to decrease
     */
    public void decreaseQuantity(int quantity) {
        this.quantity -= quantity;        
    }
    /**
     * Change new item meal type
     * @param mealType Item's new meal type
     */
    public void setMealType(String mealType) {
        this.mealType = mealType;        
    }
    /**
     * Change new item id
     * @param itemID Item's new id
     */
    public void setItemID(String itemID){
        this.itemID = itemID;
    }
    /**
     * Get item quantity of this item
     * @return this item quantity
     */
    public int getQuantity(){
        return this.quantity;
    }
    /**
     * Get name of this item
     * @return this item name
     */
    public String getName(){
        return this.name;
    }
    /**
     * Get price of this item
     * @return this item price
     */
    public double getPrice(){
        return this.price;
    }
    /**
     * Get description of this item
     * @return this item description
     */
    public String getDescription(){
        return this.description;
    }
    /**
     * Get meal type of this item
     * @return this item meal type
     */
    public String getMealType() {
		return this.mealType;
	}
    /**
     * Get id of this item
     * @return this item id
     */
    public String getItemID(){
        return this.itemID;
    }
    /**
     * Returns a new instance of an item
     */
    public Item clone(){
        return new Item(itemID, quantity, price, name, description, mealType);
    }
}
