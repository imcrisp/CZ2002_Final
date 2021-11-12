package control;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import init.RestaurantMgr;
import entity.Item;
import entity.Staff;
import entity.Table;
import java.util.ArrayList;

public class Invoice implements RestaurantMgr{
	private double total;
	private double taxes;
	private Calendar cal = Calendar.getInstance();
    private final static double GST = 1.07;
    private final static double SERVICE_CHARGE = 1.1; 
	ArrayList<Invoice> sOrder = new ArrayList<Invoice>();
    SimpleDateFormat sdf = new SimpleDateFormat();
    ArrayList<Table> cloneTable = new ArrayList<Table>();
    Order singleOrder;
    Item ordereditem;
    public Invoice() {

    }
	
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
	public void setCal(Calendar cal) {
		this.cal = cal;
	}
	public void setOrder(Order order)
	{
		this.singleOrder = order;
	}
	public void setItem(Item item)
	{
		this.ordereditem = item;
	}
	public void setTotal(double total)
	{
		this.total = total;
	}
	public void createInvoice(Calendar cal, Order order,double total){
		Invoice invoice = new Invoice();
		invoice.setCal(cal);
		invoice.setOrder(order);
		invoice.setTotal(total);
		inv.sOrder.add(invoice);
	}
	public Calendar getCal() {
		return this.cal;
	}
	public Order getOrder() {
		return this.singleOrder;
	}
	
}
