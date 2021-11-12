package entity;
public class Item{

    private int quantity;
    private String itemID;
    private double price;
	private String name;
	private String description;
	private String mealType;

    public Item(String itemID, int quantity, double price, String name,  String description, String mealType){
        this.mealType = mealType;
        this.quantity = 1;
        this.name = name;
        this.description = description;
        this.price = price;
        this.itemID = itemID;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void increaseQuantity(int quantity) {
        this.quantity += quantity;        
    }
    public void decreaseQuantity(int quantity) {
        this.quantity -= quantity;        
    }
    public void setMealType(String mealType) {
        this.mealType = mealType;        
    }
    public void setItemID(String itemID){
        this.itemID = itemID;
    }

    public int getQuantity(){
        return this.quantity;
    }
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public String getDescription(){
        return this.description;
    }
    public String getMealType() {
		return this.mealType;
	}
    public String getItemID(){
        return this.itemID;
    }

    public Item clone(){
        return new Item(itemID, quantity, price, name, description, mealType);
    }
}
