package sortcompare.algorithms;

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
			/* Insertion onto heap */
			for (int i = 0; i < data.size(); i++) {
				int child = i;
				while (child > 0) {
					int parent = (child - 1) / 2;
					if (data.get(child) > data.get(parent)) {
						swap(data, child, parent);
						child = parent;
					} else {
						break;
					}
				}
			}
			for (int i = data.size(); i > 0;) {
				swap(data, 0, --i);
				int parent = 0;
				int leftChild, rightChild;
				while (true) {
					leftChild = (parent * 2) + 1;
					if (leftChild >= i) {
						break;
					}
					rightChild = leftChild + 1;
					if (rightChild >= i) {
						if (data.get(leftChild) > data.get(parent)) {
							swap(data, leftChild, parent);
						}
						break;
					}
					if (data.get(leftChild) > data.get(parent)) {
						if (data.get(leftChild) > data.get(rightChild)) {
							swap(data, leftChild, parent);
							parent = leftChild;
						} else {
							swap(data, rightChild, parent);
							parent = rightChild;
						}
					} else {
						if (data.get(rightChild) > data.get(parent)) {
							swap(data, rightChild, parent);
							parent = rightChild;
						} else {
							break;
						}
					}
				}
			}

//			CustomHeap heap = new CustomHeap(data.size());
//			for (Integer i : data) {
//				heap.add(i);
//			}
//			for (int i = 0; i < data.size(); i++) {
//				data.set(i, heap.remove());
//			}
		}
		return data;
	}

	@Override
	public String toString() {
		return "Heap";
	}

}
