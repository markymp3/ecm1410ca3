package cycling;

public class Segment {

	private int segmentId;
	private int stageId;
	private SegmentType type;
	private double length;
	private double averageGradient;
	private double location;
	
	
	public Segment(int segmentId, int stageId, SegmentType type, double length, double averageGradient, double location) {
		this.segmentId = segmentId;
		this.stageId = stageId;
		this.type = type;
		this.length = length;
		this.averageGradient = averageGradient;
		this.location = location;
	}
	
	public int getSegmentId() {return segmentId;}
	public int getStageId() {return stageId;}
	public SegmentType getType() {return type;}
	public double getLength() {return length;}
	public double getAverageGradient() {return averageGradient;}
	public double getLocation() {return location;}
	
	
}
