package cycling;
import java.io.Serializable;

/**
 * 
 * @author marcusconnolly
 *
 */

public class Race {

	
	private int raceId;
	private int riderId;
	private static String name;
	private static String description;
	private String raceDetails;
	
	
	public Race(int raceId, String name, String description, String raceDetails, int riderId) {
		this.raceId = raceId;
		this.riderId = riderId;
		Race.name = name;
		Race.description = description;
	}
	public Race(String name, String description) {
		// TODO Auto-generated constructor stub
	}
	/**
	 * getter for the raceID
	 * @return raceID
	 */
	public int getRaceId() {return raceId;}
	/**
	 * getter for the name of the race
	 * @return raceName
	 */
	public static String getName() {return name;}
	/**
	 * getter for the description of the race
	 * @return raceDescription
	 */
	public static String getDescription() {return description;}
	
	/*
	 * getter for rider ID in the race 
	 * @return riderId
	 */
	public int getRiderID() {return riderId;}
	
	public String getRaceDetails() {return raceDetails;}
	
	
	public String toString() {
		return this.raceId + "," + this.name  + "," + this.description ;
	}
	
	
}
