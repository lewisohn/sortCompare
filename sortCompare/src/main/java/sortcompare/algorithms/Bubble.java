package sortcompare.algorithms;

import sortcompare.structures.FlexList;

/**
 * Bubble sort. Compares adjacent items and swaps them if they're in the wrong
 * order.
 * @author Oliver Lewisohn
 */
public class Bubble extends Sort {

	@Override
	FlexList<Integer> sort(FlexList<Integer> data) {
		boolean swap = true;
		int i = 0;
		int temp;
		while (swap) {
			swap = false;
			i++;
			for (int j = 0; j < data.size() - i; j++) {
				if (data.get(j) > data.get(j + 1)) {
					temp = data.get(j);
					data.set(j, data.get(j + 1));
					data.set(j + 1, temp);
					swap = true;
				}
			}
		}
		return data;
	}

	@Override
	public String toString() {
		return "Bubble";
	}

}
