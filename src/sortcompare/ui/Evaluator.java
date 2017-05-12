package sortcompare.ui;

import sortcompare.algorithms.Sort;
import sortcompare.structures.CustomList;
import sortcompare.structures.CustomPair;

/**
 * Evaluates sorting algorithms.
 *
 * @author Oliver Lewisohn
 */
public class Evaluator {

    private final CustomList<Integer> data;
    private final CustomList<Sort> algorithms;

    /**
     * Creates a new Evaluator.
     *
     * @param data The data to be sorted.
     * @param sorters The algorithms to compare.
     */
    public Evaluator(final CustomList<Integer> data,
            final CustomList<Sort> sorters) {
        this.data = data;
        this.algorithms = sorters;
    }

    /**
     * Evaluates the selected sorting algorithms with the provided data.
     *
     * @param repeat How many times each data set should be sorted.
     */
    public final void evaluate(final int repeat) {
        System.out.println("");
        System.out.println("Sorting with n = " + data.size()
                + ", r = " + repeat + ", please wait.");
        System.out.println("");
        long[][] results = new long[algorithms.size()][6];
        CustomPair pair;
        for (int i = 0; i < algorithms.size(); i++) {
            results = initialise(results, i);
            for (int j = 0; j <= repeat; j++) {
                pair = algorithms.get(i).measure(
                        (CustomList<Integer>) data.copy());
                if (j > 0) { // results from first run are ignored
                    results = update(results, i, pair);
                }
            }
            results = complete(results, i, repeat);
        }
        print(results);
    }

    /* Private methods, getters, setters, overrides - no Javadoc */
    private long[][] initialise(final long[][] results, final int i) {
        for (int j = 0; j < results.length; j++) {
            if (j == 0 || j == 3) {
                results[i][j] = Long.MAX_VALUE;
            } else {
                results[i][j] = 0;
            }
        }
        return results;
    }

    private long[][] update(final long[][] results, final int i,
            final CustomPair pair) {
        long space = pair.getFirst();
        long time = pair.getSecond();
        results[i][0] = Math.min(results[i][0], space);
        results[i][1] = Math.max(results[i][1], space);
        results[i][2] += space;
        results[i][3] = Math.min(results[i][3], time);
        results[i][4] = Math.max(results[i][4], time);
        results[i][5] += time;
        return results;
    }

    private long[][] complete(final long[][] results, final int i,
            final int repeat) {
        results[i][0] /= 1024;
        results[i][1] /= 1024;
        results[i][2] /= (1024 * repeat);
        results[i][5] /= repeat;
        return results;
    }

    private void print(final long[][] results) {
        System.out.println(
                "Algorithm               | Memory / KiB          | Time / ms\n"
                + "                        | min    max    mean    "
                + "| min    max    mean\n"
                + "------------------------+-----------------------"
                + "+-----------------------");
        for (int i = 0; i < results.length; i++) {
            StringBuilder sb = new StringBuilder(algorithms.get(i).toString());
            sb = pad(sb, 23);
            sb.append(" | ");
            for (int j = 0; j < results[i].length; j++) {
                StringBuilder sb2 = new StringBuilder(
                        Long.toString(results[i][j]));
                sb2 = pad(sb2, 7);
                sb.append(sb2);
                if (j == 2) {
                    sb.append(" | ");
                }
            }
            System.out.println(sb);
        }
    }

    private StringBuilder pad(final StringBuilder sb, final int length) {
        while (sb.length() < length) {
            sb.append(" ");
        }
        return sb;
    }

}
