package cycling;
import java.io.Serializable;
import java.util.ArrayList;
import java.lang.Exception;
import java.time.LocalTime;

/**
 * This class will create the ids and information for riders and teams 
 * @author marcusconnolly
 *
 */

public class rider implements Serializable{
	private int riderID;
	private int yearOfBirth;
	private String name;
	private int teamID;
	private LocalTime time;
	
	
	public rider(int riderID, int yearOfBirth, String name, int teamID, LocalTime time) {
		this.riderID = riderID;
		this.yearOfBirth = yearOfBirth;
		this.name = name;
		this.teamID = teamID;
		this.time = time;
	}
	
	//getter for rider ID
	public int getRiderID() {return riderID;}
	
	//getter for the rider's year of birth
	public int getYearOfBirth() {return yearOfBirth;}
	
	//getter for the rider name
	public String getName() {return name;}
	
	//getter for rider's team ID
	public int getteamID() {return teamID;}
	
	//getter for the local time 
	public LocalTime getLocalTime() {return time;}
	
	
	// Prints all the rider information in a single string
	public String toString() {
		return this.yearOfBirth + "," + this.riderID + "," + this.name + "," + this.teamID + "," + this.time;
	}
}
