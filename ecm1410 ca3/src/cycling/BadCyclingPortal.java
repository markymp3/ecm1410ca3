package cycling;
import java.lang.Object;
import java.lang.Exception;
import java.time.LocalTime;


public class BadCyclingPortal implements CyclingPortalInterface {
	LocalTime GeneralClassificationTimesInRace;
	private int RidersGeneralClassificationRank;
	private int RidersMountainPointClassificationRank​;
	private int RidersMountainPointsInRace​;
	private int RidersPointClassificationRank​;
	private int RidersPointsInRace;
	private int RidersMountainPointsInRace;
	
	/**
	 * getter method for RidersGeneralClassificationRank
	 * @return RidersGeneralClassificationRank
	 */
	public int getRidersGeneralClassificationRank(int raceID) throws IDNotRecognisedException {
		return RidersGeneralClassificationRank;
	}
	
	/**
	 * getter method for RidersMountainPointClassificationRank​
	 * @return RidersMountainPointClassificationRank​,
	 * ranked list of the racers IDs from (sum) quickest to slowest
	 */
	public int getRidersMountainPointClassificationRank​(int raceID) throws IDNotRecognisedException{
		return RidersMountainPointClassificationRank​;
	}
	
	/**
	 * getter method for RidersMountainPointsInRace​​
	 * @return RidersMountainPointsInRace​​
	 */
	public int getRidersMountainPointsInRace​(int raceID) throws IDNotRecognisedException{
		return RidersMountainPointsInRace​;
	}
	
	/**
	 * getter method for RidersPointClassificationRank​​​
	 * @return RidersPointClassificationRank​​​
	 */
	public int getRidersPointClassificationRank​(int raceID) throws IDNotRecognisedException {
		return RidersPointClassificationRank​;
	}
	
	/**
	 * getter method for RidersPointsInRace​​​
	 * @return RidersPointsInRace​​​
	 */
	public int getRidersPointsInRace(int raceID) throws IDNotRecognisedException {
		return RidersPointsInRace;
	}
	
	/**
	 * getter method for RidersMountainPointsInRace​​​
	 * @return RidersMountainPointsInRace​​​
	 */
	public int getRidersMountainPointsInRace(int raceID) throws IDNotRecognisedException {
		return RidersMountainPointsInRace;
	}
	
	
}