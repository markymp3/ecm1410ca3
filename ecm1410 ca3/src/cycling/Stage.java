package cycling;
import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Stage {

	private int stageID;
	private int raceId;
	private static String stageName;
	private String stageDescription;
	private double stageLength;
	private StageType stageType;
	private SegmentType segType;
	private LocalDateTime startTime;
	
	
	public Stage(int stageID, String stageName, String stageDescription, double stageLength, StageType stageType, SegmentType segType, LocalDateTime startTime, int raceId){
		this.stageID = stageID;
		this.raceId = raceId;
		Stage.stageName = stageName;
		this.stageDescription = stageDescription;
		this.stageLength = stageLength;
		this.stageType = stageType;
		this.segType = segType;
		this.startTime = startTime;
	}
	
	public Stage(int raceId2, String stageName2, String description, double length, LocalDateTime startTime2,
			StageType type) {
		// TODO Auto-generated constructor stub
	}

	public int getStageID() {return stageID;}
	public int getRaceID() {return raceId;}
	public static String getStageName() {return stageName;}
	public String getStageDescription() {return stageDescription;}
	public double getStageLength() {return stageLength;}
	public StageType getStageType() {return stageType;}
	public SegmentType getSegType() {return segType;}
	public LocalDateTime getStartTime() {return startTime;}
	
	@Override
	public String toString() {
		return this.stageID + "," + this.stageName  + "," + this.stageDescription + "," 
				+ this.stageLength + "," + this.stageType + "," + this.segType;
	}
	
}