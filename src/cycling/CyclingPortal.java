package cycling;
import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
/**
 * the main class that has all the functionalities for the portal
 * @author marcusconnolly
 *
 */
public interface CyclingPortal {

	ArrayList<rider> riderArray = new ArrayList<>();
	ArrayList<stage> stageArray = new ArrayList<>();
	ArrayList<race> raceArray = new ArrayList<>();
	ArrayList<race> teamArray = new ArrayList<>();

	public default int [] getRaceIDs() {
		/*
		 * returns array of race ids
		 */
		
		int [] raceIds = new int[raceArray.size()];
		for(int a = 0; a<raceArray.size(); a++) {
			// if there are no races available print a message saying so
			if(raceArray.size() == 0) {
				System.out.print("No raceIds");
				return null;
			}
			// populate the race array with ids for each race
			raceIds[a] = raceArray.get(a).getRaceId();
		}
		return raceIds;
	
	public default int createRace(String name, String description) throws IllegalNameException, InvalidNameException{
		
		/*Iterates through the accounts array to check if handle already exists
		 Then checks to see if given handle is within the guidelines
		 If it passes those two checks then account is created with a unique id*/
		for(int a = 0; a < raceArray.size(); a++) {
			if(raceArray.get(a).getName()==name) {
				throw new IllegalNameException("name already taken");	
			}
			}
		for(int a= 0; a < raceArray.size(); a++) {
			if (name.isBlank() || name.length() > 30) {
				throw new InvalidNameException("Name cannot have more than 30 characters, be null or contain white spaces");
			}
		}
		// create the race 
		Race newRace = new Race(name, description);
		raceArray.add(newRace);
		return newRace.getRaceId();		
	}

				
					
				
	public static void removeRaceByID(int raceId) throws IDNotRecognisedException{
		for(int a =0; a<raceArray.size(); a++) {
			race races = raceArray.get(a);
			if(races.getRaceId() == raceId){
				raceArray.remove(a);
			}
			else {
				throw new IDNotRecognisedException("Account Id not recognised to remove");
			}
		}
	}
	
	public default int getNumberOfStages(int raceId) throws IDNotRecognisedException{
		int noStage = 0;
		
		for (int i = 0; i < raceArray.size(); i++) {
			if(raceArray.get(i).getRaceId()==raceId) {
				noStage = raceArray.get(a).getNu
			}
		}
	}
	
	public static int addStageToRace(int raceId, String stageName, String description, double length, LocalDateTime startTime, StageType type) throws IDNotRecognisedException, IllegalNameException, InvalidNameException, InvalidLengthException {
		int lol =0;
		if(raceId == 0) {
			throw new IDNotRecognisedException ("Race ID does not match any race in the system");
		}
		if(stageName.isBlank() || stageName.length() < 30) {
			throw new InvalidNameException("name is null, empty or is longer than 30 characters ");
		}
		if(int i = 0; i < raceArray.size(); i++) {
			if(raceArray.get(i).getStageName() == stageName) {
				throw new IllegalNameException("Name already exists in the platform");
			}
		}
		if(length < 5) {
			throw new InvalidLengthException("Length is less than 5km");
		}
		stage stage = new Stage(race, stageName, description, lebgth, startTime, type);
		race.addStage(stage);
		return getStageId();
	}
		
	public default int[] getRaceStages(int raceId) throws IDNotRecognisedException{
			
		for(int i = 0; i < raceArray.size(); i++) {
			race races = raceArray.get(i);
			if(races.equals(null)) {
				throw new IDNotRecognisedException("race ID does not exist");
			}
			else {
				int [] raceStages = new int[stageArray.size()];
				for(int a = 0; a< stageArray.size(); a++ ) {
					if(stageArray.get(a).getStageID() == raceId) {
						raceStages[a] = stageArray.get(a).getStageID();
					}
				}
				return raceStages;
			}
			}
		
		}
	
	public default int addCategorizedClimbToStage(int stageId, Double location, segmentType type, Double averageGradient, Double length) throws IDNotRecognisedException, InvalidLocationException, InvalidStageStateException,InvalidStageTypeException{
		
		for(int a = 0; a < stageArray.size(); a++) {
			stage stages  = stageArray.get(a);
			if(stages.equals(null)) {
				throw new IDNotRecognisedException("ID does not match any stage in the system"); 
			}
		}
		if(length > location) {
			throw new InvalidLocationException("Location is out of bounds of the stage length");
		}
	}
	
public default void createRider(int teamID, String name, int yearOfBirth) throws IDNotRecognisedException, IllegalArgumentException{
		
		if(name == null) {
			throw new IllegalArgumentException("Name cannot be null");}
		if(yearOfBirth < 1900) {
			throw new IllegalArgumentexception("Year of birth cannot be before 1900");}
		rider Rider = new rider(name, yearOfBirth);
		getTeamById(teamID).addRider(Rider);
		return rider.getRiderID();
		
	}
public default void removeRider(int riderID) throws IDNotRecognisedException {
		for(int a = 0; a < riderArray.size(); a++) {
			Rider riders = riderArray.get(a);
			if(riders.getRiderID() == riderID){
				riderArray.remove(riders);
			}
			else {
				throw new IDNotRecognisedException("the ID does not match to any rider in the system.");
			}
		}
	}
	public default void registerRiderResultsInStage(int stageId, int riderId, LocalDateTime checkpoints) throws IDNotRecognisedException, DuplicatedResultException, InvalidCheckpointsException, InvalidStageStateException{
		for(int a = 0; a < riderArray.size(); a++) {
			rider riders = riderArray.get(a);
			if(riders.equals(null)) {
				throw new IDNotRecognisedException("Id does not match any in the rider system");
			}
		}
		return;
		
	public LocalTime[ ] getRiderResultsInStage(int stageId, int riderId) throws IDNotRecognisedException{
		
		for(int a = 0; a < stageArray.size(); a++) {
			stage stages = stageArray.get(a);
			if(stages != null) {
				throw new IDNotRecognisedException("ID does not match any in the stage system");
			}
		}
		for(int a = 0; a < riderArray.size(); a++) {
			rider riders = riderArray.get(a);
			if(rider != null) {
				throw new IDNotRecognisedException("ID does not match any in the rider system");
			}
		}
		return null;
	}
	}
		
	
	
}
	

