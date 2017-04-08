package sortcompare.algorithms;

import sortcompare.structures.CustomList;

/**
 * Quick sort. Chooses a item then moves everything less than it to the left and
 * everything greater than or equal to it to the right. This is repeated
 * iteratively until the data are sorted.
 *
 * @author Oliver
 */
public class Quick extends Sort {

	@Override
	public CustomList<Integer> sort(CustomList<Integer> data) {
		if (!data.isEmpty()) {
			int size = data.size();
			int low;
			int high = size - 1;
			int[] stack = new int[size];
			int top = (size > 1 ? 1 : 0);
			stack[top] = high;
			while (top >= 0) {
				high = stack[top--];
				low = (top >= 0 ? stack[top--] : high);
				int pivot = partition(data, low, high);
				if (pivot > low + 1) {
					stack[++top] = low;
					stack[++top] = pivot - 1;
				}
				if (pivot < high - 1) {
					stack[++top] = pivot + 1;
					stack[++top] = high;
				}
			}
		}
		return data;
	}

	private int partition(CustomList<Integer> data, int low, int high) {
		int pivot = data.get(high);
		int index = (low - 1);
		for (int i = low; i < high; i++) {
			if (data.get(i) <= pivot) {
				swap(data, ++index, i);
			}
		}
		swap(data, ++index, high);
		return (index);
	}

	@Override
	public String toString() {
		return "Quick";
	}

}
