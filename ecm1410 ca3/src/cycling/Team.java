package cycling;
import java.io.Serializable;
import java.util.*;

public class Team implements Serializable{
	
	String teamName;
	String teamDescription;
	int teamId;
	
	
	public Team(String name, String description, int teamId ) {
		this.teamName = name;
		this.teamDescription = description;
		this.teamId = teamId;
		
	}
	
	//Team Name
	public String getTeamName() {
		return teamName;
	}
		
		
	//Description
	public String getTeamDescription() {
		return teamDescription;
	}
	
	//team id
	public int getTeamID() {
		return teamId;
	}
	
	// Prints all the rider information in a single string
		public String toString() {
			return this.teamName + "," + this.teamId + "," + this.teamDescription;
		}
}