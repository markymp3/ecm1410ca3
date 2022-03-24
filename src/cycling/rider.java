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
	
	public static ArrayList <rider> riderList = new ArrayList<>();
	
	public rider(int riderID, int yearOfBirth, String name, int teamID, LocalTime time) {
		this.riderID = riderID;
		this.yearOfBirth = yearOfBirth;
		this.name = name;
		this.teamID = teamID;
		this.time = time;
	}
	
	public int getRiderID() {return riderID;}
	public int getYearOfBirth() {return yearOfBirth;}
	public String getName() {return name;}
	public int getteamID() {return teamID;}
	public LocalTime getLocalTime() {return time;}
	
	public String toString() {
		return this.yearOfBirth + "," + this.riderID + "," + this.name + "," + this.teamID + "," + this.time;
	}
}
