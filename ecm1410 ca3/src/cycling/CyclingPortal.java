package cycling;
import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
/**
 * the main class that has all the functionalities for the portal
 * @authors Marcus Connolly, Aneeka Soni
 *
 */
public class CyclingPortal implements Serializable, CyclingPortalInterface {

	ArrayList<Rider> riderArray = new ArrayList<>();
	ArrayList<Stage> stageArray = new ArrayList<>();
	ArrayList<Race> raceArray = new ArrayList<>();
	ArrayList<Team> teamArray = new ArrayList<>();
	ArrayList<Segment> segmentArray = new ArrayList<>();
	
	

	
	public int [] getRaceIDs() {
		/*
		 * Creates a new race which is added to the raceArray,
		 * returns a list of race ids.
		 * @author marcus connolly
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
			
	}
	
	public int createRace(String name, String description) throws IllegalNameException, InvalidNameException{
		
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

	
	public String viewRaceDetais(int raceId) throws IDNotRecognisedException{
		
		for(int a = 0; a < raceArray.size(); a++) {
			Race race = raceArray.get(a);
			if(race == null) {
				throw new IDNotRecognisedException("ID does not match any in the system");
				}
			}
		double totalLength = 0;
		int stagecount = 0;
		for (int a = 0; a < stageArray.size(); a++) {
			Stage stage = stageArray.get(a);
			if(stage.getRaceID() == raceId) {
				stagecount++;
			}
		}
				
				String formattedsum = "\n<pre>\nID: " + Race.getName() + "\nDescription: " + Race.getDescription() + "\nNumber of stages: " + stagecount + "\nTotal Length: " + Stage.getStageName();
				return formattedsum;
			}			
				
	public void removeRaceByID(int raceId) throws IDNotRecognisedException{
		for(int a =0; a<raceArray.size(); a++) {
			Race races = raceArray.get(a);
			if(races.getRaceId() == raceId){
				raceArray.remove(a);
			}
			else {
				throw new IDNotRecognisedException("Account Id not recognised to remove");
			}
		}
	}
	
	public int getNumberOfStages(int raceId) throws IDNotRecognisedException{
		/**
		 * this method will return the amount of stages in a race
		 * authour marcus connolly
		 */
		
		for(int a = 0; a < stageArray.size(); a++) {
			Stage stage = stageArray.get(a);
			if(stage.equals(null)){
			throw new IDNotRecognisedException ("Race ID does not match any race in the system");
		}
		}	
		return stageArray.size();
		
		
		
		
	}
	
	public int addStageToRace(int raceId, String stageName, String description, double length, LocalDateTime startTime, StageType type) throws IDNotRecognisedException, IllegalNameException, InvalidNameException, InvalidLengthException {
		for(int a = 0; a < raceArray.size(); a++) {
			Race races = raceArray.get(a);
			if(races.equals(null)){
			throw new IDNotRecognisedException ("Race ID does not match any race in the system");
		}
		if(stageName.isBlank() || stageName.length() < 30) {
			throw new InvalidNameException("name is null, empty or is longer than 30 characters ");
		}
		for(int b = 0; a < raceArray.size(); b++){
			if(raceArray.get(b).getName() == stageName) {
				throw new IllegalNameException("Name already exists in the platform");
			}
		}}
		if(length < 5) {
			throw new InvalidLengthException("Length is less than 5km");
		}
		Stage stage = new Stage(raceId, stageName, description, length, startTime, type);
		stageArray.add(stage);
		return stage.getStageID();
		}
		
	public int[] getRaceStages(int raceId) throws IDNotRecognisedException{
			
		for(int i = 0; i < raceArray.size(); i++) {
			Race races = raceArray.get(i);
			if(races.equals(null)) {
				throw new IDNotRecognisedException("race ID does not exist");
			}}
			
			int [] raceStages = new int[stageArray.size()];
			for(int a = 0; a< stageArray.size(); a++ ) {
				if(stageArray.get(a).getStageID() == raceId) {
					raceStages[a] = stageArray.get(a).getStageID();
					}
				}
				return raceStages;
			
		
		}
	
	public int addCategorizedClimbToStage(int stageId, Double location, SegmentType type, Double averageGradient, Double length) throws IDNotRecognisedException, InvalidLocationException, InvalidStageStateException,InvalidStageTypeException{
		/*
		 * Method to add a climb to a stage in the race
		 */
		for(int a = 0; a < stageArray.size(); a++) {
			Stage stages  = stageArray.get(a);
			if(stages.equals(null)) {
				throw new IDNotRecognisedException("ID does not match any stage in the system"); 
			}
		}
		if(length > location) {
			throw new InvalidLocationException("Location is out of bounds of the stage length");
		}
		return stageId;
		
	}
	
public int createRider(int teamID, String name, int yearOfBirth) throws IDNotRecognisedException, IllegalArgumentException{
		
		if(name == null) {
			throw new IllegalArgumentException("Name cannot be null");}
		if(yearOfBirth < 1900) {
			throw new IllegalArgumentException("Year of birth cannot be before 1900");}
		Rider newRider = new Rider(teamID, yearOfBirth, name, yearOfBirth, null);
		riderArray.add(newRider);
		return newRider.getRiderID();
		
	}
	public void removeRider(int riderID) throws IDNotRecognisedException {
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
	public void registerRiderResultsInStage(int stageId, int riderId, LocalDateTime checkpoints) throws IDNotRecognisedException, DuplicatedResultException, InvalidCheckpointsException, InvalidStageStateException{
		for(int a = 0; a < riderArray.size(); a++) {
			Rider riders = riderArray.get(a);
			if(riders.equals(null)) {
				throw new IDNotRecognisedException("Id does not match any in the rider system");
			}
		}
	}
		
	public LocalTime[ ] getRiderResultsInStage(int stageId, int riderId) throws IDNotRecognisedException{
		
		for(int a = 0; a < stageArray.size(); a++) {
			Stage stages = stageArray.get(a);
			if(stages != null) {
				throw new IDNotRecognisedException("ID does not match any in the stage system");
			}
		}
		for(int a = 0; a < riderArray.size(); a++) {
			Rider riders = riderArray.get(a);
			if(riders != null) {
				throw new IDNotRecognisedException("ID does not match any in the rider system");
			}
		}
		return null;
	}
	
	public void removeRaceByName(String name) throws NameNotRecognisedException{
		for(int a = 0; a < raceArray.size(); a++) {
			if(raceArray.get(a).getName() == name) {
				raceArray.remove(a);
			}
		}
	}
	
	public LocalTime[] getGeneralClassificationTimesInRace(int raceId) throws IDNotRecognisedException{
		for(int a = 0; a < raceArray.size(); a++) {
			Race races = raceArray.get(a);
			if(races.equals(null)) {
				throw new IDNotRecognisedException("ID not found in system");
			}
		}
		return null;
	}

	
	public void eraseCyclingPortal() {
		/*
		 * erases the platform by clearing all the arrays
		 */
		riderArray.clear();
		stageArray.clear();
		raceArray.clear();
		teamArray.clear();
	}
	
	public void saveCyclingPortal(String filename) throws IOException {
		/*
		 * Method saves the contents into a serialised file, with the filename given in the argument.
		 */
		for(int a = 0; a < riderArray.size(); a++) {
			FileOutputStream fileOutput = new FileOutputStream(filename + "rider.ser");
			ObjectOutputStream output = new ObjectOutputStream(fileOutput);
            output.writeObject(riderArray.get(a));
		}
		for(int a = 0; a < stageArray.size(); a++) {
			FileOutputStream fileOutput = new FileOutputStream(filename + "stage.ser");
			ObjectOutputStream output = new ObjectOutputStream(fileOutput);
            output.writeObject(stageArray.get(a));
		}
		for(int a = 0; a < raceArray.size(); a++) {
			FileOutputStream fileOutput = new FileOutputStream(filename + "race.ser");
			ObjectOutputStream output = new ObjectOutputStream(fileOutput);
            output.writeObject(raceArray.get(a));
		}
		for(int a = 0; a < teamArray.size(); a++) {
			FileOutputStream fileOutput = new FileOutputStream(filename + "team.ser");
			ObjectOutputStream output = new ObjectOutputStream(fileOutput);
            output.writeObject(teamArray.get(a));
		}
	}


	public void concludeStagePreparation(int stageId) throws IDNotRecognisedException, InvalidStageStateException {
		// TODO Auto-generated method stub
		
	}
	public int[] getStageSegments(int stageId) throws IDNotRecognisedException {
		/*
		 * returns array of stage segments
		 */
		
		int [] segIds = new int[segmentArray.size()];
		for(int a = 0; a<segmentArray.size(); a++) {
			// if there are no races available print a message saying so
			if(segmentArray.size() == 0) {
				System.out.print("No raceIds");
				return null;
			}
			// populate the race array with ids for each race
			segIds[a] = segmentArray.get(a).getSegmentId();
		}
		return segIds;
	}


	@Override
	public LocalTime getRiderAdjustedElapsedTimeInStage(int stageId, int riderId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		for(int a = 0; a < riderArray.size(); a++) {
			Rider rider = riderArray.get(a);
			if(rider == null) {
				throw new IDNotRecognisedException("ID does not match to any rider or stage in the system");
			}
		}
		for(int b = 0; b < stageArray.size(); b++) {
			Stage stage = stageArray.get(b);
			if(stage == null) {
				throw new IDNotRecognisedException("ID does not match to any rider or stage in the system");
			}
		}
		return null;

	}	
	

	@Override
	public void deleteRiderResultsInStage(int stageId, int riderId) throws IDNotRecognisedException {
		
		for(int a = 0; a < riderArray.size(); a++) {
			Rider rider = riderArray.get(a);
			if(rider == null) {
				throw new IDNotRecognisedException("ID does not match to any rider or stage in the system");
			}
		}
	}	

		
	

	@Override
	public int[] getRidersRankInStage(int stageId) throws IDNotRecognisedException {
		for(int a = 0; a < riderArray.size(); a++) {
			Rider rider = riderArray.get(a);
			if(rider == null) {
				throw new IDNotRecognisedException("ID does not match to any rider or stage in the system");
			}
		}
		return null;

	}

	@Override
	public LocalTime[] getRankedAdjustedElapsedTimesInStage(int stageId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		
		for(int a = 0; a < riderArray.size(); a++) {
			Rider rider = riderArray.get(a);
			if(rider == null) {
				throw new IDNotRecognisedException("ID does not match to any rider or stage in the system");
			}
		}
		return null;
	}
		
	

	@Override
	public int[] getRidersPointsInStage(int stageId) throws IDNotRecognisedException {
		for(int a = 0; a < stageArray.size(); a++) {
			Stage stage = stageArray.get(a);
			if(stage ==null) {
				throw new IDNotRecognisedException("No match to stageID in the system");
			}
		}
		return null;
	}

	@Override
	public int[] getRidersMountainPointsInStage(int stageId) throws IDNotRecognisedException {
		//iterating through all the riders in the system 
		Stage stage = null;
		for(int a = 0; a < stageArray.size(); a++) {
			if(stageArray.get(a).getStageID() == stageId) {
				stage = stageArray.get(a);
			}
        if (stage == null){
            throw new IDNotRecognisedException("Stage ID doesn't exist.");}}
		return null;
      
		}

	@Override
	public void loadCyclingPortal(String filename) throws IOException, ClassNotFoundException {
		//ObjectInputStream can read object whether it is serialised or deserialised.

        ObjectInputStream obstr = new ObjectInputStream(new FileInputStream(filename));
        try
        {
            // While there are > 0 bytes to be read from file...
            Object obj = obstr.readObject();
            CyclingPortal portal = (CyclingPortal)obj;
            if (obj instanceof CyclingPortal){
            	
            
                for (Race race : portal.raceArray){
                   raceArray.add(race);}
                
                for (Stage stage : portal.stageArray){
                    stageArray.add(stage);}
                }
                for (Segment segment : portal.segmentArray){
                    segmentArray.add(segment);}
                
                for (Team team : portal.teamArray){
                    teamArray.add(team);}
                
                for (Rider rider : portal.riderArray){
 
                   riderArray.add(rider);}
        

            obstr.close();
        }
        catch (EOFException e)
        {
            // End of file
            obstr.close();
        }
		
	}

	@Override
	public int[] getRidersGeneralClassificationRank(int raceId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getRidersPointsInRace(int raceId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getRidersPointClassificationRank(int raceId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getRidersMountainPointClassificationRank(int raceId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getRaceIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String viewRaceDetails(int raceId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeRaceById(int raceId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getStageLength(int stageId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeStageById(int stageId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int addIntermediateSprintToStage(int stageId, double location) throws IDNotRecognisedException,
			InvalidLocationException, InvalidStageStateException, InvalidStageTypeException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeSegment(int segmentId) throws IDNotRecognisedException, InvalidStageStateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int createTeam(String name, String description) throws IllegalNameException, InvalidNameException {
		// TODO Auto-generated method stub
		if (name.length() >= 30) {
			throw new InvalidNameException("Team name is too long");
		} if (name.isEmpty()) {
			throw new InvalidNameException("Team name is empty");
		} if (name.trim().isEmpty()) {
			throw new InvalidNameException("Team name is empty");
		}  if (name.contains(" ")) {
			throw new InvalidNameException("Team name contains a white space");
		} 
		//if (teamArrayList.contains()) {
		//	throw new IllegalNameException();
		//} 
		Team team = new Team(name, description, 0);
		teamArray.add(team);
		return team.getTeamID();
	}

	@Override
	public void removeTeam(int teamId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		for(int i = 0; i < teamArray.size(); i++) {
			if(teamArray.get(i).getTeamID() == teamId){
				teamArray.remove(i);
				if(i == teamArray.size()){
					throw new IDNotRecognisedException("Team ID doesn't exist.");
				}
			}
		}
	}

	@Override
	public int[] getTeams() {
		// TODO Auto-generated method stub
		int j = teamArray.size();
		int[] teamIdsArray = new int[j];
		for (int i=0;i<teamArray.size();i++) {
			teamIdsArray[i] = teamArray.get(i).getTeamID();
		}				
		return teamIdsArray;
	}

	@Override
	public int[] getTeamRiders(int teamId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		int j = teamArray.size();
		int[] teamIdsArray = new int[j];
		for (int i=0;i<teamArray.size();i++) {
			teamIdsArray[i] = teamArray.get(i).getTeamID();
		}				
		return teamIdsArray;
	}

	@Override
	public int[] getRidersMountainPointsInRace(int raceId) throws IDNotRecognisedException {
		for(int a = 0; a < riderArray.size(); a++) {
			Rider riders = riderArray.get(a);
			if(riders.equals(null)) {
				throw new IDNotRecognisedException("Id does not match any in the rider system");
			}
		}
		return null;
	}

	@Override
	public void registerRiderResultsInStage(int stageId, int riderId, LocalTime... checkpoints)
			throws IDNotRecognisedException, DuplicatedResultException, InvalidCheckpointsException,
			InvalidStageStateException {
		// TODO Auto-generated method stub
		
	}
}
	
	

	

