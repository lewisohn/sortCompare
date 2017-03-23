package sortcompare.structures;

/**
 * A pair of long values used to represent memory and time usage.
 * @author Oliver Lewisohn
 */
public class SpaceTime {

	private final long space;
	private final long time;

	/**
	 * Creates a new SpaceTime.
	 * @param space Memory used in bytes.
	 * @param time Time taken in milliseconds.
	 */
	public SpaceTime(long space, long time) {
		this.space = space;
		this.time = time;
	}

	public long getSpace() {
		return space;
	}

	public long getTime() {
		return time;
	}
	
	
	
}
