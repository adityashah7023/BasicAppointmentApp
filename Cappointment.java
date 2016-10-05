package appointmentApp;

import appointmentApp.Cschedule;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.lang.String;
/**
 * 
 * Stores the start time, end time, and the string description of the appointment. 
 * Ensures the the appointment is valid, meaning a start time is always before an end time, and the description is not empty.
 * 
 * @author aditya
 *
 */
public class Cappointment {
	/**
	 * Stores start time of appointment.
	 */
	public String start_time=null;
	/**
	 * Stores end time of appointment.
	 */
	public String end_time=null;
	/**
	 * Stores description of appointment.
	 */
	public String description=null;
		
	Scanner scan=new Scanner(System.in);
	Ctime timeobj=new Ctime();
	
		
	/**
	 * <b><i>getStartTime</i></b><br><br>
	 * 
	 * <code>public String getStartTime()</code><br><br>
	 * 
	 * Ask user to enter start time.<br>
	 * Perform:<br>
	 * 1. Time format validation<br>
	 * 2. Ensure that hour is valid<br>
	 * 3. Ensure that minute is valid<br>
	 * 
	 * @return scanned time
	 */
	public String getStartTime(){
		while(start_time==null){
			System.out.println("Please enter start time (HH:mm): ");
			start_time=scan.nextLine();
			if(timeobj.checkFormat(start_time)){
				if(!timeobj.checkHour(start_time)){
					System.out.println("Invalid time, hour must be between 0 and 23");
					start_time=null;
				}
				else if(!timeobj.checkMinute(start_time)){
					System.out.println("Invalid time, minute must be between 0 and 59");
					start_time=null;
				}
				else{
					return	start_time;
				}
			}
			else{
				System.out.println("Invalid time, must be in HH:mm format");
				start_time=null;
			}
		}
		return null;
	}
	
	/**
	 * <b><i>checkValidity</i></b><br><br>
	 * 
	 * <code>private boolean checkValidity(String end_time, String start_time)</code><br><br>
	 * 
	 * Compare start time and end time to make sure that end time is not less than start time.<br>
	 * 
	 * @param end_time - String end time given by user
	 * @param start_time - String start time given by user
	 * @return true - start time is smaller than end time else false
	 */
	private boolean checkValidity(String end_time,String start_time){
		int st_hour=timeobj.getHourHH(start_time);
		int st_minute=timeobj.getMinute(start_time);
		int et_hour=timeobj.getHourHH(end_time);
		int et_minute=timeobj.getMinute(end_time);
		
		if(st_hour==et_hour){
			if(st_minute<et_minute){
				return true;
			}
			else{
				System.out.println("Invalid appointment, check start/end times.");
				return false;
			}
		}
		else if(st_hour>et_hour){
			System.out.println("Invalid appointment, check start/end times.");
			return false;
		}
		else{
			return true;
		}
	}
	
	/**
	 * <b><i>getEndTime</i></b><br><br>
	 * 
	 * <code>private String getEndTime(String start_time)</code><br><br>
	 * 
	 * Ask user to enter end time.<br>
	 * Perform:<br>
	 * 1. Time format validation<br>
	 * 2. Ensure that hour is valid<br>
	 * 3. Ensure that minute is valid<br>
	 * 4. Ensure end time is greater than start time.
	 * 
	 * @param start_time - String start time given by user
	 * @return scanned time
	 */
	private String getEndTime(String start_time) {
		while(end_time==null){	
			System.out.println("Please enter end time (HH:mm): ");
			end_time=scan.nextLine();
			if(timeobj.checkFormat(end_time)){
				if(!timeobj.checkHour(end_time)){
					System.out.println("Invalid time, hour must be between 0 and 23");
					return null;
				}
				else if(!timeobj.checkMinute(end_time)){
					System.out.println("Invalid time, minute must be between 0 and 59");
					return null;
				}
				else if(checkValidity(this.end_time,this.start_time)){
					return end_time;
				}
				else{
					break;
				}
			}
			else{
				System.out.println("Invalid time, must be in HH:mm format");
				return null;
			}
		}
		return null;
	}
	
	/**
	 * <b><i>createAppointment</i></b><br><br>
	 * 
	 * <code>public void createAppointment()</code><br><br>
	 * 
	 * Stores description, start time and end time temporarily. 
	 * If all of them are not null than pass them to <i>Cschedule.addSchedule()<i>.
	 */
	public void createAppointment(){
		
		Cappointment c=new Cappointment();
		System.out.println("Please enter description: ");
		c.description=scan.nextLine();
		start_time=null;
		c.start_time=getStartTime();
		end_time=null;
		c.end_time=getEndTime(c.start_time);
		if(c.description!=null && c.start_time!=null && c.end_time!=null){
			Cschedule sch=new Cschedule();
			sch.addSchedule(c);
		}
	}
	
	
}
