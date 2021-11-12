package control;

import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;

import entity.Item;

public class Sales {
	private double Revenue;
	ArrayList<Item> filter = new ArrayList<Item>();
	
	public static Calendar convertCal(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		return cal;
	}	
	public void printSales() {
		System.out.println("Sales Report");
		System.out.println("==========================================================================");
		System.out.println("Item sold: \t Qty: \t Price:");
		for(int i=0; i< filter.size();i++)
		{
			System.out.println(filter.get(i).getName()+ "\t \t"+filter.get(i).getQuantity()+"\t"+ filter.get(i).getPrice());
			Revenue +=(filter.get(i).getPrice() * filter.get(i).getQuantity());
		}
		System.out.println("==========================================================================");
		System.out.println("Revenue before taxes: $"+ Revenue);
		System.out.println("==========================================================================");

	}
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