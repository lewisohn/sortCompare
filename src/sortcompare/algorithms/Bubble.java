package sortcompare.algorithms;

import sortcompare.structures.CustomList;

/**
 * Bubble sort. Compares adjacent items and swaps them if they're in the wrong
 * order.
 *
 * @author Oliver Lewisohn
 */
public class Bubble extends Sort {

    /* Private methods, getters, setters, overrides - no Javadoc */
    @Override
    final CustomList<Integer> sort(final CustomList<Integer> data) {
        if (!data.isEmpty()) {
            boolean swapped = true;
            int i = 0;
            while (swapped) {
                swapped = false;
                i++;
                for (int j = 0; j < data.size() - i; j++) {
                    if (data.get(j) > data.get(j + 1)) {
                        swap(data, j, j + 1);
                        swapped = true;
                    }
                }
            }
        }
        return data;
    }

    @Override
    public final String toString() {
        return "Bubble";
    }

}
