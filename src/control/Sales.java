package control;

import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;

import entity.Item;
/**
 * Sales class is where the sales revenue report will be generated based on the orders that has been stored inside the 
 * invoice array list which was declared in Invoice class
 * @author Jeremy U Keat, Jordan Yuen Jia Jun, Lim Wee Tat Noel, Lin Run Yu
 * @version 1.0
 * @since 2021-11-13
 */
public class Sales {
	/**
	 * The total revenue of the sales report
	 */
	private double Revenue;
	/**
	 * An item array list which filters out each other to find the quantity of each item
	 */
	private ArrayList<Item> filter = new ArrayList<Item>();
	
	/**
	 * Convert the date and time into a Calendar format so that comparison functions can be used 
	 * @param date Date and time that was entered
	 * @return Into Calendar format
	 */
	public static Calendar convertCal(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		return cal;
	}
	/**
	 * Print the sales revenue of the selected format 
	 */
	public void printSales() {
		System.out.println("Sales Report");
		System.out.println("==========================================================================");
		System.out.println("Item sold:  \t  Qty:\tPrice:");
		for(int i=0; i< filter.size();i++)
		{
			System.out.printf("%-20s %-2d  $%.2f%n",filter.get(i).getName(),filter.get(i).getQuantity(),filter.get(i).getPrice());
			Revenue +=(filter.get(i).getPrice() * filter.get(i).getQuantity());
		}
		System.out.println("==========================================================================");
		System.out.printf("Revenue before taxes: $" +"%.2f \n",Revenue);
		System.out.println("==========================================================================");
		Revenue =0;
		filter = new ArrayList<Item>();

	}
	/**
	 * By using the stored invoice array list which was created, filter out each item and store it into the item array list
	 * if each an item already exist in the array list increase quantity instead
	 * @param sortedInvoice Invoice array list which contains all the order
	 */
	public void countSales(ArrayList<Invoice> sortedInvoice) {
		
		for(int i=0;i<sortedInvoice.size();i++)
		{
			for(int j=0;j<sortedInvoice.get(i).singleOrder.orderItems.size();j++)
			{
				int k = inArray(sortedInvoice.get(i).singleOrder.orderItems.get(j).getName());

				if(k== -1)
				{
					filter.add(sortedInvoice.get(i).singleOrder.orderItems.get(j));
				}
				else
				{
					int increase = sortedInvoice.get(i).singleOrder.orderItems.get(j).getQuantity();
					filter.get(k).increaseQuantity(increase);
				}
			}
		}
		printSales();
	}
	/**
	 * Checks if an item already exist inside an item array
	 * @param name Item name 
	 * @return Returns the item index
	 */
	public int inArray(String name) {
		for(int i =0; i < filter.size();i++)
		{
			if(filter.get(i).getName() == name)
			{
				return i;
			}
		}
		return -1;
	}
}