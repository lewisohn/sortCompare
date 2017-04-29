package sortcompare.algorithms;

import sortcompare.structures.CustomList;
import sortcompare.structures.CustomPair;

/**
 * Abstract class extended by sorting algorithms.
 *
 * @author Oliver Lewisohn
 */
public abstract class Sort {

	
	private static Integer temp;
	
	/**
	 * Benchmarks and calls the sorting algorithm.
	 *
	 * @param data The list of integers to be sorted.
	 * @return A pair of long integers representing the memory and time used by
	 * the algorithm.
	 */
	public CustomPair measure(CustomList<Integer> data) {
		Runtime rt = Runtime.getRuntime();
		rt.gc();
		long space = rt.totalMemory() - rt.freeMemory();
		long time = System.currentTimeMillis();
		sort(data);
		time = System.currentTimeMillis() - time;
		space = ((rt.totalMemory() - rt.freeMemory()) - space);
		return new CustomPair(space, time);
	}

	/**
	 * Sorts the data into ascending order.
	 *
	 * @param data The list of integers to be sorted.
	 * @return The sorted data.
	 */
	abstract CustomList<Integer> sort(CustomList<Integer> data);

	/**
	 * Swaps two elements of a list.
	 * @param data The list containing the elements to be swapped.
	 * @param i The index of the first element.
	 * @param j The index of the second element.
	 */
	
	void swap(CustomList<Integer> data, int i, int j) {
		temp = data.get(i);
		data.set(i, data.get(j));
		data.set(j, temp);
	}

}
