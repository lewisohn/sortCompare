package sortcompare.algorithms;

import sortcompare.structures.CustomHeap;
import sortcompare.structures.CustomList;

/**
 * Heap sort. Divides data into a sorted region and an unsorted region then
 * shrinks the unsorted region until it is empty.
 *
 * @author Oliver Lewisohn
 */
public class Heap extends Sort {

	@Override
	public CustomList<Integer> sort(CustomList<Integer> data) {
		if (!data.isEmpty()) {
			CustomHeap<Integer> heap = new CustomHeap<>();
			for (Integer i : data) {
				heap.add(i);
			}
			for (int i = 0; i < data.size(); i++) {
				data.set(i, heap.remove());
			}
		}
		return data;
	}

	@Override
	public String toString() {
		return "Heap";
	}

}
