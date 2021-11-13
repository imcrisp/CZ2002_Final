package entity;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This is the staff class where a staff will be tagged onto a order to determine which staff created each order
 * @author Jeremy U Keat, Jordan Yuen Jia Jun, Lim Wee Tat Noel, Lin Run Yu
 * @version 1.0
 * @since 2021-11-13
 */
public class Staff {

	/**
	 * The ID of the staff
	 */
	private  int staffID;
	/**
	 * The gender of the staff
	 */
	private String staffGender;
	/**
	 * The name of the staff
	 */
	private  String staffName;
	/**
	 * The role of the staff
	 */
	private String staffRole;
	/**
	 * Generates an array list of Staff
	 */
	public ArrayList<Staff> staff = new ArrayList<Staff>();
	/*static ArrayList<Integer> staffIDList = new ArrayList<Integer>();
    	static ArrayList<String> staffNameList = new ArrayList<String>();
    	static ArrayList<String> staffGenderList = new ArrayList<String>();
    	static ArrayList<String> staffRoleList = new ArrayList<String>();
    	*/
    	
    /**
     * Creates a new staff by taking in ID, gender, name and role
     * @param staffID The staff's ID
     * @param staffGender The staff's gender
     * @param staffName The Staff's name
     * @param staffRole The Staff's role
     */
	public Staff(int staffID, String staffGender, String staffName, String staffRole) 
	{
		this.staffID = staffID;
		this.staffGender = staffGender;
		this.staffName = staffName;
		this.staffRole = staffRole;
	}
	
	/**
	 * Another way of initializing the class apart from the original way this way other class are able to access this class methods
	 */
	public Staff()
	{
		
	}
	/**
	 * Gets the staff's ID 
	 * @return this staff's ID
	 */
	public int getStaffID() 
	{
		return this.staffID;
	}
	/**
	 * Gets the staff's name
	 * @return this staff's ID
	 */
	public String getStaffName() 
	{
		return this.staffName;
	}
	/**
	 * Gets the staff's gender
	 * @return this staff's gender
	 */
	public String getStaffGender()
	{
		return this.staffGender;
	}
	/**
	 * Gets the staff's role
	 * @return this staff's role
	 */
	public String getStaffRole()
	{
		return this.staffRole;
	}
	/**
	 * Changes the staff ID 
	 * @param staffID new staff ID 
	 */
	public void setStaffId(int staffID) 
	{
		this.staffID = staffID;
	}
	/**
	 * Changes staff name
	 * @param staffName new staff name
	 */
	public void setStaffName(String staffName)
	{
		this.staffName = staffName;
	}
	/**
	 * Changes staff gender
	 * @param staffGender new staff gender
	 */
	public void setStaffGender(String staffGender)
	{
		this.staffGender = staffGender;
	}
	/**
	 * Changes staff role
	 * @param staffRole new staff role
	 */
	public void setstaffRole(String staffRole) 
	{
		this.staffRole = staffRole;
	}
}