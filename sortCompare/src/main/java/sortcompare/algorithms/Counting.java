package sortcompare.algorithms;

import sortcompare.structures.CustomList;

/**
 * Counting sort. This was my first attempt at a Bucket algorithm. It turned out
 * to be too memory-intensive; it wouldn't pass my tests due to "Java heap
 * space" errors. After some further reading on bucket sort I discovered that I
 * had effectively implemented something called counting sort instead, which is
 * just bucket sort with bucket size 1. I'm not going to include it in the final
 * program but I'm leaving it here for posterity.
 *
 * @author Oliver Lewisohn
 */
public class Counting extends Sort {

	@Override
	public CustomList<Integer> sort(CustomList<Integer> data) {
		if (!data.isEmpty()) {
			/* First we have to divide the data into positive and negative parts */
			CustomList<Integer> neg = new CustomList<>();
			CustomList<Integer> pos = new CustomList<>();
			for (Integer i : data) {
				if (i < 0) {
					neg.add(-i);
				} else {
					pos.add(i);
				}
			}
			/* Then we can sort them as if they were both positive */
			neg = positiveSort(neg);
			pos = positiveSort(pos);
			int value;
			/* Finally, recombine them, restoring the negative part's sign */
			for (int i = 0; i < data.size(); i++) {
				if (i < neg.size()) {
					value = -neg.get(neg.size() - i - 1);
				} else {
					value = pos.get(i - neg.size());
				}
				data.set(i, value);
			}
		}
		return data;
	}

	private CustomList<Integer> positiveSort(CustomList<Integer> data) {
		if (!data.isEmpty()) {
			int min = data.get(0);
			int max = data.get(0);
			for (int i = 1; i < data.size(); i++) {
				if (data.get(i) > max) {
					max = data.get(i);
				} else if (data.get(i) < min) {
					min = data.get(i);
				}
			}
			int bucket[] = new int[max - min + 1]; // Java heap space error here
			for (int i = 0; i < data.size(); i++) {
				bucket[data.get(i) - min]++;
			}
			int i = 0;
			for (int b = 0; b < bucket.length; b++) {
				for (int j = 0; j < bucket[b]; j++) {
					data.set(i++, b + min);
				}
			}
		}
		return data;
	}

	@Override
	public String toString() {
		return "Counting";
	}

}
