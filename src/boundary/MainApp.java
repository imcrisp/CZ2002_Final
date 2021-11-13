package boundary;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import control.Invoice;
import control.SalesMgr;
import init.InitRes;
import init.RestaurantMgr;
/**
 * Main body of the application
 * @author Jeremy U Keat, Jordan Yuen Jia Jun, Lim Wee Tat Noel, Lin Run Yu
 * @version 1.0
 * @since 2021-11-13
 */
public class MainApp implements RestaurantMgr {
	/**
	 * Request for users input and perform what has been request
	 * @param args Main UI
	 */
    public static void main(String[] args){
        
        try{
            FileOutputStream writeData = new FileOutputStream(".\\src\\boundary\\menuitem.txt"); //enter file path here
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            InitRes init = new InitRes();
            writeStream.writeObject(init);
            writeStream.flush();
            writeStream.close();
  
        }catch (IOException e) {
            e.printStackTrace();
        }

        try{
            FileInputStream readData = new FileInputStream(".\\src\\boundary\\menuitem.txt"); //enter file path here
            ObjectInputStream readStream = new ObjectInputStream(readData);
  
            InitRes initRes = (InitRes) readStream.readObject();
            initRes.start();
            readStream.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
      
    	//InitRes init = new InitRes();
    	//init.start();
        Scanner scan = new Scanner(System.in);
        boolean key = false;
        boolean target = false;
        while (!key){
            displayAppMenu();
            MenuItemMgr menuItemUI = new MenuItemMgr();
            OrderMgr orderUI = new OrderMgr();
            Invoice invoiceUI = new Invoice();
            SalesMgr salesUI = new SalesMgr();
            System.out.print("Select choice 1-13: ");
            char choice;
            int option = scan.nextInt();
            scan.nextLine();
            switch(option){
                case 1:
                    caseOne();
                    System.out.println("Select choice ");
                    choice = scan.nextLine().charAt(0);
                    switch (choice){
                        case '1': 
                            menuItemUI.addItemToMenu(target);
                            break;
                        case '2':
                            menuItemUI.updateItemInMenu(target);
                            break;
                        case '3':
                            menuItemUI.removeItemFromMenu(target);
                            break;
                    }
                    break; //end case 1
                
                case 2: 
                    caseTwo();
                    target = true;
                    System.out.println("Select choice ");
                    choice = scan.nextLine().charAt(0);
                    switch (choice){
                        case '1': 
                            menuItemUI.addItemToMenu(target);
                            break;
                        case '2':
                            menuItemUI.updateItemInMenu(target);
                            break;
                        case '3':
                            menuItemUI.removeItemFromMenu(target);
                            break;
                    }
                    break; //end case 2
                case 3:
                    System.out.println("Creating order...");
                    System.out.println("Enter your table ID");
                    int tableID = scan.nextInt();
                    scan.nextLine(); 
                    if (!res.checkValid(tableID-1)){
                        System.out.println("Invalid table entered, try again");
                    }
                    else 
                        orderUI.addToOrder(tableID-1);
                    
                    break; // end case 3
                case 4: 
                    System.out.println("Enter your table ID");
                    tableID = scan.nextInt();
                    scan.nextLine();
                    if (!res.checkValid(tableID-1)){
                        System.out.println("Invalid table entered, try again");
                    }
                    else{
                        System.out.println("Printing order...");
                        orderUI.viewOrder(tableID-1);
                    }  
                    break; // end case 4
                
                case 5:
                    System.out.println("Enter your table ID");
                    tableID = scan.nextInt();
                    scan.nextLine();
                    if (!res.checkValid(tableID-1)){
                        System.out.println("Invalid table entered, try again");
                    }
                    else {
                        System.out.println("Enter option, 1 to add, 2 to remove to/from order");
                        choice = scan.nextLine().charAt(0);
                        switch (choice){
                        case '1':
                            orderUI.addToOrder(tableID-1);
                            break;
                        case '2':
                            orderUI.removeFromOrder(tableID-1);
                            break;
                        }
                    } 
                    break; // end case 5
                case 6:
                
                res.refreshReservations();
    			System.out.println("Enter the name of the Customer: ");
    			String name=scan.next();
    			
    			System.out.println("Enter the contact of the Customer: ");
    			int contact;
    			
    			try {
    				contact=scan.nextInt();
    			}
    			catch(Exception e){
    				System.out.println("The input given is incorrect!");
    				e.printStackTrace();
    				continue;
    			}
    			System.out.println(contact);
    			
    			
    			System.out.println("How many customers will be dining? (Max number is 10!)");
    			int pax=scan.nextInt();
    			while (pax>10 || pax<2) { System.out.println("Invalid number of customers! Reenter number of people dining: ");
    			pax=scan.nextInt();
    			}
    			if (res.checkAvailability(pax)==null) {
    				System.out.println("There are no tables that can host that capacity!");
    				break;
    			}

    			System.out.println("Enter the date and time of the reservation in the format YYYY-MM-DD: ");
    			
    			DateTimeFormatter format1=DateTimeFormatter.ofPattern("YYYY-MM-DD");
    			String datein=scan.next();
    			try {
    				format1.parse(datein);
    			}
    			catch (Exception e) {
    				System.out.println("The entered date is in the incorrect format!");
    				e.printStackTrace();
    				continue;
    				
    			}
    			LocalDate date=LocalDate.parse(datein);
    			
    			System.out.println("Enter the time of the reservation in the format HH:MM: ");
    			DateTimeFormatter format2=DateTimeFormatter.ofPattern("HH:mm");
    			String timein=scan.next();
    			try {
    				format2.parse(timein);
    			}
    			catch (Exception e) {
    				System.out.println("The entered time is in the incorrect format!");
    				e.printStackTrace();
    				
    				continue;
    				
    			}
    			LocalTime time=LocalTime.parse(timein);
    			
    			
    			
    			int reservationID=res.tableAllocate(pax, contact, name, date, time);
    			if (reservationID==-1) {
    				System.out.println("Error: Timing Given is in the past!");
    				break;
    			}
    			else {
    				System.out.println("A new reservation is created with ID: " + reservationID + "!");
    			}
    			
    			break;
                case 7:	System.out.println("Please enter the contact the reservation was made under: ");
    			int rescontact=scan.nextInt();
    			res.refreshReservations();
    			res.checkReservation(rescontact);
    			break;
                case 8:
        			System.out.println("Enter the contact of the reservation you would like to remove: ");
        			int removecontact=scan.nextInt();
        			int result;
        			result= res.removeReservation(removecontact);
        			if(result==-1) {
        				System.out.println("There is no reservation made under that contact!");
        			}
        			else {
        				System.out.println("Removal of reservation for contact number "+ removecontact+ " has been completed.");
        			}
        			break;
                case 9:
                	res.printTables();
        			break;
                case 10:
        			System.out.println("Enter the Table ID that you wish to check the availability of: ");
    				int tableIDcheck =scan.nextInt();
    				if(res.tablelist.get(tableIDcheck-1).isReserved()) {
    					System.out.println("The table is Reserved!");
    				}
    				else {
    					System.out.println("The table is Vacant!");
    				}
    				break;
                case 11:
                	boolean member;
                	System.out.println("Select Table to print order invoice");
                	System.out.println("Select Table 1-5");
                    tableID = scan.nextInt();
                    if(!res.checkValid(tableID))
                    {
                    	System.out.println("Out of range");
                    	break;
                    }
                    System.out.println("Are is customer a member? (Y/N)");
                	choice = scan.next().charAt(0);
                	if(choice == 'Y')
                	{
                		member = true;
                	}
                	else
                	{
                		member = false;
                	}

                    switch(tableID) {
                    case 1:
                    	invoiceUI.printInvoice(tableID,member);
                    	break;
                    case 2:
                    	invoiceUI.printInvoice(tableID,member);
                    	break;
                    case 3:
                    	invoiceUI.printInvoice(tableID,member);
                    	break;
                    case 4:
                    	invoiceUI.printInvoice(tableID,member);
                    	break;
                    case 5:
                    	invoiceUI.printInvoice(tableID,member);
                    	break;
                    	}
                    break;
                	

                case 12:
                	do {
                		System.out.println("Choose one of the following format(1-3) 0 to exit: ");
                		System.out.println("1. Day");
                		System.out.println("2. Month");
                		System.out.println("3. Year");
                		option =scan.nextInt();
                	switch(option)
                	{
                	case 1:
                		salesUI.printReport(option);
                		break;
                	case 2:
                		salesUI.printReport(option);
                		break;
                	case 3:
                		salesUI.printReport(option);
                		break;
                	default:
                		System.out.println("Select (1-3)");
                		break;
                	}
                	}while(option != 0);{
                		break;
                	}
                    
                case 13:
                    key = true;
                    break; 
                default:
                    System.out.println("Invalid choice, try again");
                    break;
            }
            if (key)
                break;
        }
    }

    /**
     * The main menu of the application
     */
    public static void displayAppMenu(){
        System.out.println("----------------------------------------------------------");
        System.out.println("1. Create/Update/Remove menu item");
        System.out.println("2. Create/Update/Remove promotion");
        System.out.println("3. Create order");
        System.out.println("4. View order");
        System.out.println("5. Add/Remove order item/s to/from order");
        System.out.println("6. Create reservation booking");
        System.out.println("7. Check reservation booking");
        System.out.println("8. Remove reservation booking");
        System.out.println("9. Check All Tables and their Vacancies");
        System.out.println("10. Check specific table availability");
        System.out.println("11. Print order invoice");
        System.out.println("12. Print sale revenue report by period (eg day or month)");
        System.out.println("13. Quit");
        System.out.println("----------------------------------------------------------");
    }

    /**
     * Prints option when user selects option 1
     */
    public static void caseOne(){
        System.out.println("------------------------------");
        System.out.println("1. Create menu item");
        System.out.println("2. Update menu item");
        System.out.println("3. Remove menu item");
        System.out.println("------------------------------");
    }
    /**
     * Prints option when user selects option 2
     */
    public static void caseTwo(){
        System.out.println("------------------------------");
        System.out.println("1. Create promotion");
        System.out.println("2. Update promotion");
        System.out.println("3. Remove promotion");
        System.out.println("------------------------------");
    }
}
