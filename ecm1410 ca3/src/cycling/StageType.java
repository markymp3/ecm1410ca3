package cycling;
/**
 * This enum is used to represent the stage types on road races
 * @author marcusconnolly
 *
 */

public enum StageType {
	/*
	 * USed for mainly flat stages
	 */
	FLAT, 
	
	/*
	 * Used for high mountain finish or stages with multiple categorised climbs.
	 */
	HIGH_MOUNTAIN, 
	
	/*
	 * Used for hilly finish or stages with moderate amounts of mountains.
	 */
	MEDIUM_MOUNTAIN, 
	
	/*
	 * Used for time trails.
	 */
	TT;
}
