package sortcompare.structures;

/**
 * A pair of long values.
 * @author Oliver Lewisohn
 */
public class CustomPair {

	private final long first;
	private final long second;

	/**
	 * Creates a new CustomPair.
	 * @param first First long value.
	 * @param second Second long value.
	 */
	public CustomPair(long first, long second) {
		this.first = first;
		this.second = second;
	}

	public long getFirst() {
		return first;
	}

	public long getSecond() {
		return second;
	}
	
	
	
}
