package init;

import control.Invoice;
import control.MenuItem;
import control.ReservationMgr;
import entity.Staff;
/**
 * Interface class which stores all interaction in the control class
 * @author Jeremy U Keat, Jordan Yuen Jia Jun, Lim Wee Tat Noel, Lin Run Yu
 * @version 1.0
 * @since 2021-11-13
 */
public interface RestaurantMgr {

	/**
	 * Final class for MenuItem
	 */
    final MenuItem menu = new MenuItem();
    /**
     * Final class for ReservationMgr
     */
    final ReservationMgr res = new ReservationMgr();  
    /**
     * Final class for Invoice
     */
    final Invoice inv = new Invoice();
    /**
     * Final class for Staff
     */
    final Staff s = new Staff();
    
}