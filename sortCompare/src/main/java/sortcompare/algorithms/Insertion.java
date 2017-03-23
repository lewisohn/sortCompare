package sortcompare.algorithms;

import sortcompare.structures.FlexList;

/**
 * Insertion sort. Adds one item at a time to the previously sorted region.
 * @author Oliver Lewisohn
 */
public class Insertion extends Sort {

	@Override
	public FlexList<Integer> sort(FlexList<Integer> data) {
		int i, j, temp;
		for (i = 1; i < data.size(); i++) {
			temp = data.get(i);
			j = i;
			while (j > 0 && data.get(j - 1) > temp) {
				data.set(j, data.get(j - 1));
				j--;
			}
			data.set(j, temp);
		}
		return data;
	}

	@Override
	public String toString() {
		return "Insertion";
	}

}
