package sortcompare.algorithms;

import sortcompare.structures.FlexList;
import sortcompare.structures.SpaceTime;

/**
 * Abstract class extended by sorting algorithms.
 * @author Oliver Lewisohn
 */
public abstract class Sort {

	/**
	 * Benchmarks and calls the sorting algorithm.
	 * @param data The list of integers to be sorted.
	 * @return A pair of long integers representing the memory and time used by
	 * the algorithm.
	 */
	public SpaceTime measure(FlexList<Integer> data) {
		System.gc();
		Runtime rt = Runtime.getRuntime();
		long space = rt.totalMemory() - rt.freeMemory();
		long time = System.currentTimeMillis();
		sort(data);
		space = (rt.totalMemory() - rt.freeMemory() - space);
		time = System.currentTimeMillis() - time;
		return new SpaceTime(space, time);
	}
	
	/**
	 * Sorts the data into ascending order.
	 * @param data The list of integers to be sorted.
	 * @return The sorted data.
	 */
	abstract FlexList<Integer> sort(FlexList<Integer> data);
	
}
