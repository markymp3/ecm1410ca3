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
	ArrayList<Race> teamArray = new ArrayList<>();
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
		int numStages = 0;
		double totalLength = 0.0;
		for(int a = 0; a < raceArray.size(); a++) {
			
			
		}
		return "raceID:" + raceId + "Race Name: " + getName + "Race Description: " + 
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
		int noStage = 0;
		
		for (int i = 0; i < raceArray.size(); i++) {
			if(raceArray.get(i).getRaceId()==raceId) {
				noStage = raceArray.get(a).getNu
			}
		}
	}
	
	public int addStageToRace(int raceId, String stageName, String description, double length, LocalDateTime startTime, StageType type) throws IDNotRecognisedException, IllegalNameException, InvalidNameException, InvalidLengthException {
		if(raceId == null) {
			throw new IDNotRecognisedException ("Race ID does not match any race in the system");
		}
		if(stageName.isBlank() || stageName.length() < 30) {
			throw new InvalidNameException("name is null, empty or is longer than 30 characters ");
		}
		for(int a = 0; a < raceArray.size(); a++){
			if(raceArray.get(a).getName() == stageName) {
				throw new IllegalNameException("Name already exists in the platform");
			}
		}
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
	
	public int addCategorizedClimbToStage(int stageId, Double location, SegmentType type, Double averageGradient, Double length) throws IDNotRecognisedException, InvalidLocationException, InvalidStageStateException,InvalidStageTypeException{
		
		for(int a = 0; a < stageArray.size(); a++) {
			stage stages  = stageArray.get(a);
			if(stages.equals(null)) {
				throw new IDNotRecognisedException("ID does not match any stage in the system"); 
			}
		}
		if(length > location) {
			throw new InvalidLocationException("Location is out of bounds of the stage length");
		}
		return ;
	}
	
public int createRider(int teamID, String name, int yearOfBirth) throws IDNotRecognisedException, IllegalArgumentException{
		
		if(name == null) {
			throw new IllegalArgumentException("Name cannot be null");}
		if(yearOfBirth < 1900) {
			throw new IllegalArgumentexception("Year of birth cannot be before 1900");}
		Rider newRider = new Rider(teamID, name, yearOfBirth);
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
	
	public int createTeam(String name, String description) throws IllegalNameException, InvalidNameException {
	
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
	Team team = new Team(name, description);
	teamArrayList.add(team);
	return team.getTeamId();
	}

	public void removeTeam(int teamId) throws IDNotRecognisedException {
		for(int i = 0; i < teamArrayList.size(); i++) {
			if(teamArrayList.get(i).getTeamId() == teamId){
				teamArrayList.remove(i);
				if(i == teamArrayList.size()){
					throw new IDNotRecognisedException("Team ID doesn't exist.");
				}
			}
		}
	}

	public int[] getTeams() {
		int j = teamArrayList.size();
		int[] teamIdsArray = new int[j];
		for (int i=0;i<teamArrayList.size();i++) {
			teamIdsArray[i] = teamArrayList.get(i).getTeamId();
		}				
		return teamIdsArray;
	}

	public int[] getTeamRiders(int teamId) throws IDNotRecognisedException {
		int j = teamArrayList.size();
		int[] teamIdsArray = new int[j];
		for (int i=0;i<teamArrayList.size();i++) {
			teamIdsArray[i] = teamArrayList.get(i).getTeamId();
		}				
		return teamIdsArray;
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
		return raceArray;
	}
	
	public int[] getRidersPointsInRace​(int raceId) throws IDNotRecognisedException{
		return null;
	}
	
	public int [] getRidersMountainPointsInRace(int raceId) throws IDNotRecognisedException{
		return null;
	}
	
	public int[] getRidersPointClassificationRank​(int raceId) throws IDNotRecognisedException{
		return null;
	}
	
	public int[] getRidersMountainPointClassificationRank​(int raceId) throws IDNotRecognisedException{
		return null;
	}
	
	
	
	
	
	
	
	public default void eraseCyclingPortal() {
		/*
		 * erases the platform by clearing all the arrays
		 */
		riderArray.clear();
		stageArray.clear();
		raceArray.clear();
		teamArray.clear();
	}
	
	public default void saveCyclingPortal(String filename) throws IOException {
		
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


	@Override
	public void concludeStagePreparation(int stageId) throws IDNotRecognisedException, InvalidStageStateException {
		// TODO Auto-generated method stub
		
	}
	public int[] getStageSegments(int stageId) throws IDNotRecognisedException {
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

	
	public void registerRiderResultsInStage(int stageId, int riderId, LocalTime... checkpoints)
			throws IDNotRecognisedException, DuplicatedResultException, InvalidCheckpointsException,
			InvalidStageStateException {
		Stage stage = this.getStage(stageId);

        if (stage == null)
        {
            throw new IDNotRecognisedException("Stage ID doesn't exist.");
        }
        else
        {
            if (stage.getRiderResults().containsKey(riderId))
            {
                throw new DuplicatedResultException("This stage result has already been registered");
            }

            LocalTime t_prev = checkpoints[0];
            for (LocalTime t : checkpoints)
            {
                if (t.isAfter(t_prev) || t.equals(t_prev))
                {
                    t_prev = t;
                    continue;
                }
                else
                {
                    throw new InvalidCheckpointsException("Invalid result: Checkpoint times are not consecutive");
                }
            }

            if (checkpoints.length != this.getStageSegments(stageId).length)
            {
                throw new InvalidCheckpointsException("Invalid result: too many checkpoints have been included");
            }

            if (stage.getState() == StageState.PREPARING)
            {
               
                throw new InvalidStageStateException("Stage isn't ready for results");
            }

            stage.addRiderResult(riderId, checkpoints);
        }

	}
		
	}

	public LocalTime getRiderAdjustedElapsedTimeInStage(int stageId, int riderId) throws IDNotRecognisedException {
		Stage stage = this.getStage(stageId);
        Rider rider = this.getRider(riderId);

        if (stage != null)
        {
            if (rider != null)
            {
                HashMap<Integer, ArrayList<LocalTime>> riderResults = stage.getRiderResults();
                ArrayList<LocalTime> results = riderResults.get(riderId);
                LocalTime[] resultsArray = new LocalTime[results.size()];
                for (int i=0; i<resultsArray.length; i++)
                {
                    resultsArray[i] = results.get(i);
                }

                LocalTime finishingTime = resultsArray[resultsArray.length - 1];

                for (ArrayList<LocalTime> riderResult : riderResults.values())
                {
                    LocalTime comparedFinishingTime = riderResult.get(riderResult.size()-1);
                    if (finishingTime.isAfter(comparedFinishingTime))
                    {
                        finishingTime = comparedFinishingTime;
                    }
                }

                return finishingTime;
            }
            throw new IDNotRecognisedException("Rider ID doesn't exist.");
        }
        throw new IDNotRecognisedException("Stage ID doesn't exist.");
	}

		
	}

	public void deleteRiderResultsInStage(int stageId, int riderId) throws IDNotRecognisedException {
		 Stage stage = this.getStage(stageId);
        Rider rider = this.getRider(riderId);

        if (stage != null)
        {
            if (rider != null)
            {
                HashMap<Integer, ArrayList<LocalTime>> riderResults = stage.getRiderResults();
                riderResults.remove(riderId);
                stage.setRiderResults(riderResults);
                return;
            }
            throw new IDNotRecognisedException("This Rider ID does not exist.");
        }
        throw new IDNotRecognisedException("This Stage ID does not exist.");
	}

		
	}

	public int[] getRidersRankInStage(int stageId) throws IDNotRecognisedException {
		Stage stage = this.getStage(stageId);

        if (stage != null)
        {
            HashMap<Integer, ArrayList<LocalTime>> riderResults = stage.getRiderResults();
            if (riderResults.keySet().size() > 0)
            {
                HashMap<Integer, LocalTime> riderFinishes = new HashMap<Integer, LocalTime>();
                // Populate with finish times
                for (int key : riderResults.keySet())
                {
                    ArrayList<LocalTime> riderCheckpoints = riderResults.get(key);
                    riderFinishes.put(key, riderCheckpoints.get(riderCheckpoints.size()-1));
                }

                // Make an ArrayList with all finish times
                ArrayList<LocalTime> sortedFinishes = new ArrayList<LocalTime>(riderFinishes.values());
                Collections.sort(sortedFinishes);

                int[] sortedRiders = new int[sortedFinishes.size()];
                int sortedRidersIndex = 0;

                for (LocalTime finish : sortedFinishes)
                {

                    for (int key : riderResults.keySet())
                    {
                        // Check if the rider has the same time as the sorted time
                        if (finish.equals(riderResults.get(key).get(riderResults.size()-1)) && sortedRidersIndex < sortedRiders.length)
                        {
                            // Assign the rider ID (key) to the correct index
                            sortedRiders[sortedRidersIndex] = key;
                            sortedRidersIndex++;
                        }
                    }
                }

                // Return the sorted array of rider IDs.
                return sortedRiders;
            }
            return new int[0];
        }
        // Stage is null; invalid.
        throw new IDNotRecognisedException("Stage ID doesn't exist.");
	}

	}


	public LocalTime[] getRankedAdjustedElapsedTimesInStage(int stageId) throws IDNotRecognisedException {
		Stage stage = this.getStage(stageId);
        if (stage != null)
        {
            // Finish Time
            HashMap<Integer, ArrayList<LocalTime>> riderResults = stage.getRiderResults();
            HashMap<Integer, LocalTime> riderFinishes = new HashMap<Integer, LocalTime>();

            // Populate with finishing times
            for (int key : riderResults.keySet())
            {
                ArrayList<LocalTime> riderCheckpoints = riderResults.get(key);
                riderFinishes.put(key, riderCheckpoints.get(riderCheckpoints.size()-1));
            }

            // Get adjusted elapsed times
            HashMap<Integer, LocalTime> adjustedRiderFinishes = new HashMap<Integer, LocalTime>();

            for (int riderId : riderFinishes.keySet())
            {
                adjustedRiderFinishes.put(riderId, this.getRiderAdjustedElapsedTimeInStage(stageId, riderId));
            }

            // Make an ArrayList with finish times
            ArrayList<LocalTime> sortedAdjustedFinishes = new ArrayList<LocalTime>(adjustedRiderFinishes.values());
            Collections.sort(sortedAdjustedFinishes);

            LocalTime[] sortedAdjustedFinishesArray = new LocalTime[sortedAdjustedFinishes.size()];
            for (int i=0; i<sortedAdjustedFinishesArray.length; i++)
            {
                sortedAdjustedFinishesArray[i] = sortedAdjustedFinishes.get(i);
            }
            return sortedAdjustedFinishesArray;
        }
        throw new IDNotRecognisedException("Stage ID doesn't exist.");
	}
	}

	public int[] getRidersPointsInStage(int stageId) throws IDNotRecognisedException {
		 Stage stage = this.getStage(stageId);

        if (stage == null)
        {
            throw new IDNotRecognisedException("Stage ID doesn't exist.");
        }
        else
        {
            int[] ranking = this.getRidersRankInStage(stageId);
            int[] points = new int[ranking.length];
            for (int i=0; i < ranking.length; i++)
            {
                // Set points value to finish points
                try {
                    int mapValue = stagePointsMap.get(stage.getType())[i];
                    points[i] = mapValue;
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    // The array found from stagePointsMap.get(stage.getType()) returned null;
                    // point scored is 0
                    points[i] = 0;
                }
            }
            return points;
        }
	}
	}

	public int[] getRidersMountainPointsInStage(int stageId) throws IDNotRecognisedException {
		Stage stage = this.getStage(stageId);

        if (stage == null)
        {
            throw new IDNotRecognisedException("Stage ID doesn't exist.");
        }
        else
        {
            int[] ranking = this.getRidersRankInStage(stageId);
            int[] points = new int[ranking.length];

            HashMap<Integer, ArrayList<LocalTime>> riderResults = stage.getRiderResults();
            int[] segments = this.getStageSegments(stageId);
            for (int i=0; i < segments.length; i++)
            {
                Segment segment = this.getSegment(segments[i]);
                if (segment != null)
                {
                    // Checkpoint Time
                    HashMap<Integer, LocalTime> riderSegmentFinishes = new HashMap<Integer, LocalTime>();

                    // Populate with finishing times
                    for (int key : riderResults.keySet())
                    {
                        ArrayList<LocalTime> riderCheckpoints = riderResults.get(key);
                        riderSegmentFinishes.put(key, riderCheckpoints.get(i));
                    }

                    // Make an ArrayList with finish times
                    ArrayList<LocalTime> sortedSegmentFinishes = new ArrayList<LocalTime>(riderSegmentFinishes.values());
                    Collections.sort(sortedSegmentFinishes);

                    // Create a variable to track the position in the array
                    int[] sortedRiders = new int[sortedSegmentFinishes.size()];
                    int sortedRidersIndex = 0;

                    // Iterate over sorted finish times
                    for (LocalTime finish : sortedSegmentFinishes)
                    {
                        // Iterate a second time, over the key set of riderResults
                        for (int key : riderResults.keySet())
                        {
                            int index = this.intLinearSearch(ranking, key);
                            // Check if the rider has the same time as the sorted time
                            if (finish.equals(riderResults.get(key).get(i)) && sortedRidersIndex < sortedRiders.length && index != -1)
                            {
                                // Add the correct number of points to the "index"th term of ranking
                                try {
                                    points[index] += segmentPointsMap.get(segment.getType())[sortedRidersIndex];
                                    sortedRidersIndex++;
                                }
                                catch (IndexOutOfBoundsException e)
                                {
                                    // Number of points = 0, by default
                                    sortedRidersIndex++;
                                }
                            }
                        }
                    }


                }
            }
            return points;
        }
	}
	}

	@Override
	public void loadCyclingPortal(String filename) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
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
}
	
	
