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
	 * @param algorithms The algorithms to compare.
	 */
	public Evaluator(CustomList<Integer> data, CustomList<Sort> algorithms) {
		this.data = data;
		this.algorithms = algorithms;
	}

	/**
	 * Evaluates the selected sorting algorithms with the provided data.
	 *
	 * @param repeat How many times each data set should be sorted.
	 */
	public void evaluate(int repeat) {
		long[][] results = new long[algorithms.size()][6];
		CustomPair pair;
		for (int i = 0; i < algorithms.size(); i++) {
			results = initialise(results, i);
			for (int j = 0; j <= repeat; j++) {
				pair = algorithms.get(i).measure((CustomList<Integer>) data.copy());
				if (j > 0) { // results from first run are ignored
					results = update(results, i, pair);
				}
			}
			results = complete(results, i, repeat);
		}
		print(results);
	}

	private long[][] initialise(long[][] results, int i) {
		for (int j = 0; j < results.length; j++) {
			if (j == 0 || j == 3) {
				results[i][j] = Long.MAX_VALUE;
			} else {
				results[i][j] = 0;
			}
		}
		return results;
	}

	private long[][] update(long[][] results, int i, CustomPair pair) {
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

	private long[][] complete(long[][] results, int i, int repeat) {
		results[i][0] /= 1024;
		results[i][1] /= 1024;
		results[i][2] /= (1024 * repeat);
		results[i][5] /= repeat;
		return results;
	}

	private void print(long[][] results) {
		StringBuilder sb0 = new StringBuilder("n = " + data.size());
		while (sb0.length() < 24) { // fill to 24 characters
			sb0.append(" ");
		}
		sb0.append("| Memory / KiB\t\t| Time / ms");
		System.out.println(sb0);
		System.out.println("Algorithm\t\t| min\tmax\tmean\t| min\tmax\tmean");
		System.out.println("------------------------+-----------------------+--------------------");
		for (int i = 0; i < results.length; i++) {
			StringBuilder sb = new StringBuilder(algorithms.get(i).toString());
			while (sb.length() < 24) { // fill to 24 characters
				sb.append(" ");
			}
			sb.append("| ");
			for (int j = 0; j < results[i].length; j++) {
				sb.append(results[i][j]).append("\t");
				if (j == 2) {
					sb.append("| ");
				}
			}
			System.out.println(sb);
		}
		System.out.println("");
	}

}
