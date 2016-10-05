package appointmentApp;

import appointmentApp.*;
import java.util.Scanner;
/**
 * 
 * @author aditya
 *
 */
public class CappointmentApp {
	
	/**
	 * <b><i>main</i></b><br><br>
	 * 
	 * <code>public static void main(String args[])</code><br><br>
	 * 
	 * Display menu to the user. Get the input from user.<br> 
	 * Perform:<br>
	 * User input: 1 <br> Do: Create new appointment.<br>
	 * User input: 2 <br> Do: Display all appointment.<br>
	 * User input: 3 <br> Do: Delete an appointment.<br>
	 * User input: 4 <br> Do: Exit.<br>  
	 * @param args
	 */
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);
		Cappointment c=new Cappointment();
		Cschedule sch=new Cschedule();
		int choice;								//Stores user given choice.
		while(true){
			System.out.println("** My Appointment book application **");
			
			System.out.println("1. Create new appointment");
			System.out.println("2. Display all appointments");
			System.out.println("3. Delete an appointment");
			System.out.println("4. Exit");
			System.out.println(">>");
			choice=scan.nextInt();
			
			switch(choice){
			case 1: System.out.println("Creating new appointment...");
					c.createAppointment();
					break;
			case 2: System.out.println("Your appointments are:");
					sch.viewSchedule();
					break;
			case 3: sch.deleteSchedule();
					break;
			case 4: System.out.println("Good bye!");
					System.exit(0);
			default:System.out.println("Invalid choice."); 
					break;
			}
		}
	}
}
