package init;

import control.Invoice;
import control.MenuItem;
import control.ReservationMgr;
import entity.Staff;

public interface RestaurantMgr {

    final MenuItem menu = new MenuItem();
    final ReservationMgr res = new ReservationMgr();  
    final Invoice inv = new Invoice();
    final Staff s = new Staff();
    
}