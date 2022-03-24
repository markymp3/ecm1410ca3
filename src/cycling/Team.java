package cycling;
import java.io.Serializable;
import java.util.*;

public class Team implements Serializable{
	
	String teamName;
	String teamDescription;
	
	
	public Team(String name, String description) {
		teamName = name;
		teamDescription = description;
		
	}
	
	//Team Name
	public String getTeamName() {
		return teamName;
	}
		
		
	//Description
	public String getTeamDescription() {
		return teamDescription;
	}
	
	
	
}
