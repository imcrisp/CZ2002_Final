package entity;
import java.util.ArrayList;
import java.util.Scanner;

public class Staff {

	private  int staffID;
	private String staffGender;
	private  String staffName;
	private String staffRole;
	
	/*static ArrayList<Integer> staffIDList = new ArrayList<Integer>();
    	static ArrayList<String> staffNameList = new ArrayList<String>();
    	static ArrayList<String> staffGenderList = new ArrayList<String>();
    	static ArrayList<String> staffRoleList = new ArrayList<String>();
    	*/
	
	public ArrayList<Staff> staff = new ArrayList<Staff>();
    	
    
	public Staff(int staffID, String staffGender, String staffName, String staffRole) 
	{
		this.staffID = staffID;
		this.staffGender = staffGender;
		this.staffName = staffName;
		this.staffRole = staffRole;
	}
	public Staff()
	{
		
	}
	
	public int getStaffID() 
	{
		return this.staffID;
	}
	
	public String getStaffName() 
	{
		return this.staffName;
	}
	
	public String getStaffGender()
	{
		return this.staffGender;
	}
	
	public String getStaffRole()
	{
		return this.staffRole;
	}

	public void setStaffId(int staffID) 
	{
		this.staffID = staffID;
	}
	
	public void setStaffName(String staffName)
	{
		this.staffName = staffName;
	}
	
	public void setStaffGender(String staffGender)
	{
		this.staffGender = staffGender;
	}

	public void setstaffRole(String staffRole) 
	{
		this.staffRole = staffRole;
	}
}