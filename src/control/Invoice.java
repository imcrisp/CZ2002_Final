package control;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import init.RestaurantMgr;
import entity.Item;
import entity.Staff;
import entity.Table;
import java.util.ArrayList;
/**
 * Invoice control class that handles the printing of the invoice and tagging a time to each order which will be stored into an array list,
 * the class also performs the printing of each invoice which frees up the table and clears the order on each table.
 * @author Jeremy U Keat, Jordan Yuen Jia Jun, Lim Wee Tat Noel, Lin Run Yu
 * @version 1.0
 * @since 2021-11-13
 */
public class Invoice implements RestaurantMgr{
	/**
	 * The total of a single order
	 */
	private double total;
	/**
	 * The total of tax
	 */
	private double taxes;
	/**
	 * Instance of the current time
	 */
	private Calendar cal = Calendar.getInstance();
	/**
	 * Default Singapore GST 
	 */
    private final static double GST = 1.07;
    /**
     * Default Service charge
     */
    private final static double SERVICE_CHARGE = 1.1; 
    /**
     * Invoice array list to store order and time for each order which will be filtered for sales revenue later
     */
	public ArrayList<Invoice> sOrder = new ArrayList<Invoice>();
	/**
	 * Date and time formatter
	 */
    private SimpleDateFormat sdf = new SimpleDateFormat();
    /**
     * Storing each order to access the class method 
     */
    protected Order singleOrder;
    /**
     * Storing each item to access the class method
     */
    protected Item ordereditem;
    
    /**
     * Constructor for the class
     */
    public Invoice() {

    }
	
    /**
     * Class that prints the invoice of a given table which check if they are a member which decides if they are able to receive discount or not,
     * after printing the invoice it stores the order detail and timing into an invoice array list, after storing the details it frees up the table,
     * clears the table orders and set the status to vacant.
     * @param tableNo This is the table number of the invoice to print for
     * @param member This is the status of weather they are a member or not
     */
	public void printInvoice(int tableNo, boolean member)
	{   
		ArrayList<Table> curTable = (ArrayList<Table>)res.tablelist.clone();
		String time = String.valueOf(cal.get(Calendar.DAY_OF_MONTH)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR)+" "+cal.get(Calendar.HOUR_OF_DAY))+":"+String.valueOf(cal.get(Calendar.MINUTE))+":"+String.valueOf(cal.get(Calendar.SECOND));

		if(curTable.get(tableNo-1).order.orderItems.size() == 0)
		{
			System.out.println("There are no orders found in the table");
			return;
		}
		else {
		
		System.out.println("======================================");
		System.out.println("Table ID: "+ tableNo);
		System.out.println(time);
        //System.out.println(curTable.size());
        for(int i=0;i< curTable.size();i++)
        {
        	for(int j=0;j<curTable.get(i).order.orderItems.size();j++)
        	{
        		if(((curTable.get(i).gettableID()+1)== tableNo)){
        			System.out.println("Name: "+curTable.get(i).order.orderItems.get(j).getName()+"\t Qty: "+curTable.get(i).order.orderItems.get(j).getQuantity() +"\t Price"+ curTable.get(i).order.orderItems.get(j).getPrice());
        		}
        	}
        }
        for(int i=0; i< curTable.size();i++)
        {
        	double subTotal=0;
        	for(int j=0;j<curTable.get(i).order.orderItems.size();j++)
        	{
        		if((curTable.get(i).gettableID()+1)== tableNo) {
        			if(member == true)
        			{
        			subTotal += (curTable.get(i).order.orderItems.get(j).getPrice())*(curTable.get(i).order.orderItems.get(j).getQuantity())*0.9;
        			}
        			else
        			{
            			subTotal += (curTable.get(i).order.orderItems.get(j).getPrice())*(curTable.get(i).order.orderItems.get(j).getQuantity());

        			}
        	        total = subTotal*GST * SERVICE_CHARGE;
        	        taxes = total-subTotal;
        		}
        	}       	
        }
        if(member == true) {
        	System.out.println("Membership applied");
        }
		System.out.println("-------------------------------------");
        System.out.printf("Taxes: "+ "%.2f \n", taxes );
        System.out.printf("Grand Total: "+ "%.2f \n", total);
		System.out.println("=====================================");
		createInvoice(cal,curTable.get(tableNo-1).order, total);
		res.tablelist.get(tableNo-1).order = new Order();
		res.tablelist.get(tableNo-1).order.staff = new Staff();
		res.tablelist.get(tableNo-1).order.orderItems = new ArrayList<Item>();
		res.removeRes(tableNo-1);
		res.tablelist.get(tableNo-1).setStatus(false);
		}
	}
	
	/**
	 * Sets the current date and time
	 * @param cal New date and time
	 */
	public void setCal(Calendar cal) {
		this.cal = cal;
	}
	/**
	 * Assign the order 
	 * @param order New Order class
	 */
	public void setOrder(Order order)
	{
		this.singleOrder = order;
	}
	/**
	 * Assign the item
	 * @param item New Item class
	 */
	public void setItem(Item item)
	{
		this.ordereditem = item;
	}
	/**
	 * Assign the total 
	 * @param total New total 
	 */
	public void setTotal(double total)
	{
		this.total = total;
	}
	/**
	 * Adds the current order into the invoice array list using the date, time, order and total stored into the RestaurantMgr class
	 * @param cal Using the date and time to store into the array list
	 * @param order Using the items ordered to store into the array list
	 * @param total Using the total to store 
	 */
	public void createInvoice(Calendar cal, Order order,double total){
		Invoice invoice = new Invoice();
		invoice.setCal(cal);
		invoice.setOrder(order);
		invoice.setTotal(total);
		inv.sOrder.add(invoice);
	}
	/**
	 * Gets the date and time of the invoice
	 * @return this invoice date and time
	 */
	public Calendar getCal() {
		return this.cal;
	}
	/**
	 * Gets the order of the selected invoice
	 * @return this order
	 */
	public Order getOrder() {
		return this.singleOrder;
	}
	
}
