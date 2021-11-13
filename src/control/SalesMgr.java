package control;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

import init.RestaurantMgr;

import java.util.InputMismatchException;
import java.text.ParseException;
import java.util.ArrayList;


/**
 * SalesMgr performs the request of the user which selects the format of sales report which will then use the Sales class to filter
 * out stored invoice
 * @author Jeremy U Keat, Jordan Yuen Jia Jun, Lim Wee Tat Noel, Lin Run Yu
 * @version 1.0
 * @since 2021-11-13
 */
public class SalesMgr implements RestaurantMgr{
	/**
	 * Assign a new invoice array list to the main invoice array list
	 */
	protected ArrayList<Invoice> invoiceOrder = inv.sOrder;
	/**
	 * Create a new invoice array list to store sorted data
	 */
	protected ArrayList<Invoice> sortedInvoice = new ArrayList<Invoice>();
	/**
	 * Initialize the invoice class to use the class methods to retrieve data
	 */
	private Invoice invoice = new Invoice();
	/**
	 * Initialize the sales class to use the sales class method to print sales revenue
	 */
	private Sales sale = new Sales();
	/**
	 * Format of the Sales report
	 */
	private reportFormat format;
	/**
	 * Format of the Sales report
	 */
	public enum reportFormat{
		/**
		 * Format in Day
		 */
		Day,
		/**
		 * Format in Month
		 */
		Month,
		/**
		 * Format in Year
		 */
		Year
	}
	/**
	 * Selecting the format of the report to be printed
	 * @param choice Format number
	 */
	public void printReport(int choice) {
	    SimpleDateFormat sdf = new SimpleDateFormat();
        Scanner sc = new Scanner(System.in);
        if (choice ==1 )
		{
			format = format.Day;
		}
		else if (choice == 2)
		{
			format = format.Month;
		}
		else if (choice ==3)
		{
			format = format.Year;
		}
		switch(format)
		{
			case Day:
				sdf.applyPattern("dd/MM/yyyy");
				sdf.setLenient(false);
				
				try {
				System.out.println("Sales for date:");
				System.out.print("Enter date (dd/mm/yyyy): ");
				String salesDate = sc.next();
				Date date = sdf.parse(salesDate);
				Calendar reqCal = Sales.convertCal(date);
			
				for(int i=0;i<invoiceOrder.size();i++)
				{
					if((reqCal.get(Calendar.YEAR)== invoiceOrder.get(i).getCal().get(Calendar.YEAR))&& reqCal.get(Calendar.MONTH)== invoiceOrder.get(i).getCal().get(Calendar.MONTH))
					{
						if(reqCal.get(Calendar.DAY_OF_MONTH)== invoiceOrder.get(i).getCal().get(Calendar.DAY_OF_MONTH))
						{
							sortedInvoice.add(invoiceOrder.get(i));

						}
					}
				}
				if(sortedInvoice.get(0).singleOrder.orderItems.size()<1)
				{
					System.out.println("No such order..");

				}
				else
				{
					System.out.println("Compling..");
					sale.countSales(sortedInvoice);
					sortedInvoice = new ArrayList<Invoice>();
				}	

				}catch (ParseException ex) {
					System.out.println("Error, please try again..");
				}
				catch (InputMismatchException ex) {
					System.out.println("Error, please try again..");
					return;
				}
				catch (Exception ex)
				{
					System.out.println("Error, please try again..");
				}
				break;
			case Month:
				sdf.applyPattern("MM/yyyy");
				sdf.setLenient(false);
				try {
				System.out.println("Sales for Month:");
				System.out.print("Enter month (mm/yyyy): ");
				String salesDate = sc.next();
				Date date = sdf.parse(salesDate);
				Calendar reqCal = Sales.convertCal(date);
				for(int i=0;i<invoiceOrder.size();i++)
				{
					if(invoiceOrder.get(i).getCal().get(Calendar.YEAR) == reqCal.get(Calendar.YEAR)&& invoiceOrder.get(i).getCal().get(Calendar.MONTH)== reqCal.get(Calendar.MONTH))
					{
						
						sortedInvoice.add(invoiceOrder.get(i));
					}
				}
				if(sortedInvoice.get(0).singleOrder.orderItems.size()<0)
				{
					System.out.println("No such order..");

				}
				else
				{
					System.out.println("Compling..");
					sale.countSales(sortedInvoice);
					sortedInvoice = new ArrayList<Invoice>();

				}			
				}
				catch (ParseException ex) {
					System.out.println("Error, please try again..");
				}
				catch (InputMismatchException ex) {
					System.out.println("Error, please try again..");
					return;
				}catch (Exception ex)
				{
					System.out.println("Error, please try again..");
				}
				
				break;
			case Year:
				sdf.applyPattern("yyyy");
				sdf.setLenient(false);
				try {
				System.out.println("Sales for Year:");
				System.out.print("Enter Year (yyyy): ");
				String salesDate = sc.next();
				Date date = sdf.parse(salesDate);
				Calendar reqCal = Sales.convertCal(date);
				
				for(int i=0;i<invoiceOrder.size();i++)
				{
					if(invoiceOrder.get(i).getCal().get(Calendar.YEAR) == reqCal.get(Calendar.YEAR))
					{
						
						sortedInvoice.add(invoiceOrder.get(i));
					}
				}
				if(sortedInvoice.get(0).singleOrder.orderItems.size()==0)
				{
					System.out.println("No such order..");

				}
				else
				{
					System.out.println("Compling..");
					sale.countSales(sortedInvoice);
					sortedInvoice = new ArrayList<Invoice>();
				}
				}catch (ParseException ex) {
					System.out.println("Error, please try again..");
				}
				catch (InputMismatchException ex) {
					System.out.println("Error, please try again..");
					break;
				}
				catch (Exception ex){
					System.out.println("Error, please try again..");
					break;
				}
				break;
			default: 
				System.out.println("5");
				break;
		}	
	}
}
