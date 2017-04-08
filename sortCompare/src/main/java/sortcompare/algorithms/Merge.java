package sortcompare.algorithms;

import sortcompare.structures.CustomList;

/**
 * Merge sort. Divides data into small subsets, sorts them, then compares and
 * combines the subsets.
 *
 * @author Oliver Lewisohn
 */
public class Merge extends Sort {

	@Override
	public CustomList<Integer> sort(CustomList<Integer> data) {
		if (!data.isEmpty()) {
			CustomList<int[]> lists = new CustomList<>();
			for (Integer i : data) {
				lists.add(new int[]{i});
			}
			int[] temp = mergesort(lists);
			for (int i = 0; i < data.size(); i++) {
				data.set(i, temp[i]);
			}
		}
		return data;
	}

	private int[] mergesort(CustomList<int[]> lists) {
		while (lists.size() > 1) {
			for (int i = 0; i < lists.size() / 2; i++) {
				lists.set(i, merge(lists.get(i), lists.get(i + 1)));
				lists.remove(i + 1);
			}
		}
		return lists.get(0);
	}

	private int[] merge(int[] left, int[] right) {
		int[] merged = new int[left.length + right.length];
		int l = 0, r = 0;
		while (l < left.length || r < right.length) {
			if (l >= left.length || (r < right.length && right[r] < left[l])) {
				merged[l + r] = right[r];
				r++;
			} else {
				merged[l + r] = left[l];
				l++;
			}
		}
		return merged;
	}

	@Override
	public String toString() {
		return "Merge";
	}

}
