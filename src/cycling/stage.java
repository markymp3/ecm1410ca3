package cycling;
import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class stage {

	private int stageID;
	private String stageName;
	private String stageDescription;
	private double stageLength;
	private StageType stageType;
	private segmentType segType;
	private LocalDateTime startTime;
	
	
	public stage(int stageID, String stageName, String stageDescription, double stageLength, StageType stageType, segmentType segType, LocalDateTime startTime){
		this.stageID = stageID;
		this.stageName = stageName;
		this.stageDescription = stageDescription;
		this.stageLength = stageLength;
		this.stageType = stageType;
		this.segType = segType;
		this.startTime = startTime;
	}
	
	public int getStageID() {return stageID;}
	public String getStageName() {return stageName;}
	public String getStageDescription() {return stageDescription;}
	public double getStageLength() {return stageLength;}
	public StageType getStageType() {return stageType;}
	public segmentType getSegType() {return segType;}
	public LocalDateTime getStartTime() {return startTime;}
	
	@Override
	public String toString() {
		return this.stageID + "," + this.stageName  + "," + this.stageDescription + "," 
				+ this.stageLength + "," + this.stageType + "," + this.segType;
	}
	
}