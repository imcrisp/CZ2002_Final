package control;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

import init.RestaurantMgr;

import java.util.InputMismatchException;
import java.text.ParseException;
import java.util.ArrayList;



public class SalesMgr implements RestaurantMgr{
	ArrayList<Invoice> invoiceOrder = inv.sOrder;
	ArrayList<Invoice> sortedInvoice = new ArrayList<Invoice>();
	Invoice invoice = new Invoice();
	Sales sale = new Sales();
	private reportFormat format;
	public enum reportFormat{
		Day,
		Month,
		Year
	}
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
