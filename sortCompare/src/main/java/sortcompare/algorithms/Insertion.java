package sortcompare.algorithms;

import sortcompare.structures.CustomList;

/**
 * Insertion sort. Adds one item at a time to a previously sorted region.
 *
 * @author Oliver Lewisohn
 */
public class Insertion extends Sort {

	@Override
	public CustomList<Integer> sort(CustomList<Integer> data) {
		if (!data.isEmpty()) {
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
		}
		return data;
	}

	@Override
	public String toString() {
		return "Insertion";
	}

}
