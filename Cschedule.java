package appointmentApp;

import java.util.Scanner;

import appointmentApp.*;

public class Cschedule {
	Scanner scan=new Scanner(System.in);
	/**
	 * Array to store appointments.
	 */
	static String schedule[][]=new String[100][3];
	/**
	 * Count of appointments.
	 */
	static int sch_count=0;
	Ctime timeobj=new Ctime();
	
	/**
	 * <b><i>checkStartConflict</i></b><br><br>
	 * 
	 * <code>private boolean checkStartConflict(Cappointment c)</code><br><br>
	 * 
	 * Checks whether the entered start time is conflicting with any existing time.
	 * 
	 * @param c - Object of Cappointment containing description, start time and end time
	 * @return true - conflict occurred<br> false - no conflict
	 */
	private boolean checkStartConflict(Cappointment c){
		
		Ctime t=new Ctime();
		int sn=t.convertTimeToInt(c.start_time) ;
		int en=t.convertTimeToInt(c.end_time);
		int s,e;
		boolean conflict=false;
		if(sch_count==0){
			return conflict;
		}
		for(int i= 0; i<sch_count;i++){
			s=t.convertTimeToInt(schedule[i][1]);
			if(sn<s){
				if(en<s){
					continue;
				}
			}
			else if(sn==s){
				conflict=true;
				break;
			}
			else{
				e=t.convertTimeToInt(schedule[i][2]);
				if(sn>=e){
					continue;
				}
				else{
					conflict=true;
					break;
				}
			}
		}
		return conflict;
	}
	
	/**
	 * <b><i>checkEndConflict</i></b><br><br>
	 * 
	 * <code>private boolean checkEndConflict(Cappointment c)</code><br><br>
	 * 
	 * Checks whether the entered start time is conflicting with any existing time.
	 * 
	 * @param c - Object of Cappointment containing description, start time and end time
	 * @return true - conflict occurred<br> false - no conflict
	 */
	private boolean checkEndConflict(Cappointment c){		
		boolean conflict=false;
		Ctime t=new Ctime();
		int en=t.convertTimeToInt(c.end_time);
		int s,e;
		if(sch_count==0){
			return conflict;
		}
		for(int i= 0; i<sch_count;i++){
			s=t.convertTimeToInt(schedule[i][1]);
			e=t.convertTimeToInt(schedule[i][2]);
			if(s<en && en<e){
				conflict=true;
				break;
			}
		}
		return conflict;
	}
	
	/**
	 * <b><i>addSchedule</i></b><br><br>
	 * 
	 * <code>public void addSchedule(Cappointment c)</code><br><br>
	 * 
	 * Adds appointment in schedule if it is not conflicting with any other appointment.
	 * 
	 * @param c - Object of Cappointment containing description, start time and end time
	 */
	public void addSchedule(Cappointment c){
		/*
		 * Compare recently added start time  with existing start and end time.
		 * if start time is in between, than return true.
		 * else repeat same for end time.
		 */
		if(checkStartConflict(c)){
			System.out.println("Invalid appointment, conflict detected.");
		}
		else if(checkEndConflict(c)){
			System.out.println("Invalid appointment, conflict detected.");
		}
		else{
			schedule[sch_count][0]=c.description;
			schedule[sch_count][1]=c.start_time;
			schedule[sch_count][2]=c.end_time;
			System.out.println("New appointment created.");
			sortSchedule();
			sch_count++;
		}
	}
	
	/**
	 * <b><i>sortSchedule</i></b><br><br>
	 * 
	 * <code>private void sortSchedule()</code><br><br>
	 * 
	 * Sort the schedule according to start time in ascending order.
	 */
	private void sortSchedule(){
		String temp = null;
		for(int i=0;i<sch_count;i++){
			for(int j=0;j<sch_count; j++){
				if((timeobj.compareTime(schedule[j][1],schedule[j+1][1]))==2){
					temp=schedule[j][0];
					schedule[j][0]=schedule[j+1][0];
					schedule[j+1][0]=temp;
					temp=schedule[j][1];
					schedule[j][1]=schedule[j+1][1];
					schedule[j+1][1]=temp;
					temp=schedule[j][2];
					schedule[j][2]=schedule[j+1][2];
					schedule[j+1][2]=temp;
				}
			}
		}
	}
	
	/**
	 * <b><i>viewSchedule</i></b><br><br>
	 * 
	 * <code>public void viewSchedule()</code><br><br>
	 * 
	 * Displays Schedule to user.
	 */
	public void viewSchedule(){
		for(int i=0;i<sch_count;i++){
			System.out.println((i+1) + ". " +schedule[i][0] + " from " + timeobj.getTime(schedule[i][1]) + " to " + timeobj.getTime(schedule[i][2]));
		}
		System.out.println();
	}
	
	/**
	 * <b><i>deleteSchedule</i></b><br><br>
	 * 
	 * <code>public void deleteSchedule()</code><br><br>
	 * 
	 * Deletes the appointment specified by the user.
	 */
	public void deleteSchedule(){
		System.out.println("Enter appointment number to delete:");
		viewSchedule();
		int loc=scan.nextInt();
		if(loc>sch_count){
			System.out.println("No such appointment");
		}
		else{
			for(int i=loc-1;i<sch_count;i++){
				schedule[i][0]=schedule[i+1][0];
				schedule[i][1]=schedule[i+1][1];
				schedule[i][2]=schedule[i+1][2];
			}
			sch_count--;
			System.out.println("Appointmnet "+ loc +" deleted.");
		}
	}
}