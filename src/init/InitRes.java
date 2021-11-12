package init;
import java.io.Serializable;

import entity.Item;
import entity.Staff;

public class InitRes implements RestaurantMgr, Serializable{

    public void start(){
        //init items
        Item item1 = new Item("M01", 1, 3.50, "Chicken", "desc", "maincourse");
        Item item2 = new Item("M02", 1, 4.50, "Pork", "desc", "maincourse");
        Item item3 = new Item("M03", 1, 5.50, "Steak", "desc", "maincourse");

        Item drinks1 = new Item("D01", 1, 1.50, "Coke", "desc", "drinks");
        Item drinks2 = new Item("D02", 1, 1.50, "Green Tea", "desc", "drinks");
        Item drinks3 = new Item("D03", 1, 1.50, "7-UP", "desc", "drinks");

        Item side1 = new Item("S01", 1, 3.10, "Fries", "desc", "sides");
        Item side2 = new Item("S02", 1, 4.00, "Takoyaki", "desc", "sides");
        Item side3 = new Item("S03", 1, 3.20, "Wedges", "desc", "sides");

        Item dessert1 = new Item("DS01", 1, 2.50, "Ice cream", "desc", "dessert");
        Item dessert2 = new Item("DS02", 1, 3.50, "Cake", "desc", "dessert");
        Item dessert3 = new Item("DS03", 1, 1.50, "Waffle", "desc", "dessert");

        Item setmeal1 = new Item("SM01", 1, 4.50, "Set A", "Chicken + Coke", "setmeal");
        Item setmeal2 = new Item("SM02", 1, 5.70, "Set B", "Pork + Green Tea", "setmeal");
        Item setmeal3 = new Item("SM03", 1, 6.50, "Set C", "Steak + 7-UP", "setmeal");

        // init staff
        Staff staff1 = new Staff(1, "M", "Name1", "Waiter");
        Staff staff2 = new Staff(2, "M", "Name2", "Manager");
        Staff staff3 = new Staff(3, "M", "Name3", "Cleaner");
        Staff staff4 = new Staff(4, "F", "Name4", "Waitress");
        Staff staff5 = new Staff(5, "F", "Name5", "Waitress");

        // add staff
        s.staff.add(staff1);
        s.staff.add(staff2);
        s.staff.add(staff3);
        s.staff.add(staff4);
        s.staff.add(staff5);

        //add menu items
        menu.addToMenu(item1);
        menu.addToMenu(item2);
        menu.addToMenu(item3);

        menu.addToMenu(drinks1);
        menu.addToMenu(drinks2);
        menu.addToMenu(drinks3);

        menu.addToMenu(side1);
        menu.addToMenu(side2);
        menu.addToMenu(side3);

        menu.addToMenu(dessert1);
        menu.addToMenu(dessert2);
        menu.addToMenu(dessert3);

        menu.addToMenu(setmeal1);
        menu.addToMenu(setmeal2);
        menu.addToMenu(setmeal3);

        //create 5 tables with capacity of 2, 4, 6, 8, 10
        res.createTables(5, 2);
    }

 
}
