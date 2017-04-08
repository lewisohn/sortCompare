package sortcompare.algorithms;

import java.math.BigInteger;
import sortcompare.structures.CustomList;

/**
 * Bucket sort. Divides items into buckets, sorts them and recombines them.
 * Relies on an inner sorting algorithm (defaults to Quick, can be changed).
 *
 * @author Oliver Lewisohn
 */
public class Bucket extends Sort {

	private final Sort innerSort;

	/**
	 * Creates a new Bucket with an inner quick sort.
	 */
	public Bucket() {
		this.innerSort = new Quick();
	}

	/**
	 * Creates a new Bucket with a specified inner sort.
	 *
	 * @param innerSort The inner sorting algorithm.
	 */
	public Bucket(Sort innerSort) {
		this.innerSort = innerSort;
	}

	@Override
	public CustomList<Integer> sort(CustomList<Integer> data) {
		if (!data.isEmpty()) {
			int min = data.get(0);
			int max = data.get(0);
			for (int i = 1; i < data.size(); i++) {
				if (data.get(i) < min) {
					min = data.get(i);
				} else if (data.get(i) > max) {
					max = data.get(i);
				}
			}
			int count = (int) Math.sqrt(data.size());
			/* We have to use BigIntegers in this algorithm to avoid Integer
			size limitations.
			 */
			BigInteger size = BigInteger.valueOf(max);
			size = size.subtract(BigInteger.valueOf(min)).divide(BigInteger.valueOf(count)).add(BigInteger.ONE);
			CustomList<CustomList<Integer>> buckets = new CustomList<>(count);
			for (int i = 0; i < count; i++) {
				buckets.add(new CustomList<>());
			}
			int n;
			for (int i = 0; i < data.size(); i++) {
				BigInteger m = BigInteger.valueOf(data.get(i));
				m = m.subtract(BigInteger.valueOf(min)).divide(size);
				buckets.get(m.intValue()).add(data.get(i));
			}
			int index = 0;
			CustomList<Integer> bucket;
			for (int i = 0; i < buckets.size(); i++) {
				bucket = innerSort.sort(buckets.get(i));
				for (Integer j : bucket) {
					data.set(index++, j);
				}
			}
		}
		return data;
	}

	@Override
	public String toString() {
		return "Bucket";
	}

}
