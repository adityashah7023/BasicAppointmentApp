package appointmentApp;

import java.text.DecimalFormat;

public class Ctime {
	int HH,hh,mm;
	
	/**
	 * <b><i>getHourHH</i></b><br><br>
	 * 
	 * <code>public int getHourHH(String time)</code><br><br>
	 * 
	 * Get hour from time.
	 * 
	 * @param time - String time
	 * @return hour 
	 */
	public int getHourHH(String time){
		return Integer.parseInt(time.substring(0,2));
	}
	
	/**
	 * <b><i>getMinute</i></b><br><br>
	 * 
	 * <code>public int getMinute(String time)</code><br><br>
	 * 
	 * Get minute from time.
	 * 
	 * @param time - String time
	 * @return minute
	 */
	public int getMinute(String time){
		return Integer.parseInt(time.substring(3));
	}

	/**
	 * <b><i>getTime</i></b><br><br>
	 * 
	 * <code>public String getTime(String time)</code><br><br>
	 * 
	 * Convert time from 24hr format to 12hr format
	 * 
	 * @param time - String time to be converted
	 * @return time in 12hr format
	 */
	public String getTime(String time){
		int HHhour=getHourHH(time);
		int minute=getMinute(time);
		DecimalFormat formatter = new DecimalFormat("00");
		if(HHhour<12){
			return formatter.format(HHhour) + ":" + formatter.format(minute) +"am" ;
		}
		else if(HHhour==12){
			return formatter.format(HHhour) + ":" + formatter.format(minute) +"pm" ;
		}
		else{
			return formatter.format(HHhour%12) + ":" + formatter.format(minute) +"pm" ;
		}
	}
	
	/**
	 * <b><i>compareTime</i></b><br><br>
	 * 
	 * <code>public int compareTime(String time1,String time2)</code><br><br>
	 * 
	 * compare two times.
	 * 
	 * @param time1 - String time1 
	 * @param time2 - String time2
	 * @return 2 - if time2 is smaller<br>
	 * 1 - if time1 is smaller
	 */
	public int compareTime(String time1,String time2){
		int hhtime1=getHourHH(time1);
		int hhtime2=getHourHH(time2);
		if(hhtime1==hhtime2){
			if(getMinute(time1)>getMinute(time2)){
				return 2;
			}
			else{
				return 1;
			}
		}
		else if(hhtime1>hhtime2){
			return 2;
		}
		else{
			return 1;
		}
	}
	
	/**
	 * <b><i>compateTime </i></b><br><br>
	 * 
	 * <code>public boolean compateTime(String r_time, String e_start_time, String e_end_time)</code><br><br>
	 * 
	 * compare given time(r_time) with existing start and end time.
	 * 
	 * @param r_time - time to be compared
	 * @param e_start_time - start time to be compared with
	 * @param e_end_time - end time to be compared with
	 * @return true or false
	 */
	public boolean compateTime(String r_time, String e_start_time, String e_end_time){
		int hh_r_time=getHourHH(r_time);
		int hh_e_start_time=getHourHH(e_start_time);
		int hh_e_end_time=getHourHH(e_end_time);
		if(hh_r_time>=hh_e_start_time && hh_r_time<=hh_e_end_time){
			if(getMinute(r_time)>=getMinute(e_start_time)){
				return true;
			}
			else{
				return false;
			}
			//return true;
		}
		return false;
	}

	/**
	 * <b><i>convertTimeToInt</i></b><br><br>
	 * 
	 * <code>public int convertTimeToInt(String time)</code><br><br>
	 * 
	 * Converts String time to Integer time.
	 * 
	 * @param time - String time to be converted 
	 * @return time in integer format
	 */
	public int convertTimeToInt(String time) {
		// TODO Auto-generated method stub
		return ((getHourHH(time))*100)+(getMinute(time));
	}
	
	/**
	 * <b><i>checkFormat</i></b><br><br>
	 * 
	 * <code>public boolean checkFormat(String time)</code><br><br>
	 * 
	 * Check that format of the time is HH:mm.
	 * @param time - time to be validated
	 * @return true if length is 5 and format is HH:mm else false
	 */
	public boolean checkFormat(String time){
		if(time.length()==5){
			if((time.substring(2, 3)).compareTo(":")==0){
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}
	
	/**
	 * <b><i>checkHour</i></b><br><br>
	 * 
	 * <code>public boolean checkHour(String time)</code><br><br>
	 * 
	 * Check validity of hour in time.
	 * @param time - time to be validated
	 * @return true if hour is between 00 to 23 else false
	 */
	public boolean checkHour(String time){
		int hour= getHourHH(time);
		if(hour>=0&&hour<24){
			return true;
		}
		return false;
	}
	
	/**
	 * <b><i>checkMinute</i></b><br><br>
	 * 
	 * <code>public boolean checkMinute(String time)</code><br><br>
	 * 
	 * Check validity of minute in time.
	 * @param time - time to be validated
	 * @return true if minute is between 00 to 59 else false
	 */
	public boolean checkMinute(String time){
		int minute=getMinute(time);
		if(minute>=0&&minute<60){
			return true;
		}
		return false;
	}

}
