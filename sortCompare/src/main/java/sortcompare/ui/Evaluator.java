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
	 */
	public void evaluate() {
		evaluate(1);
	}

	public void evaluate(int repeat) {
		CustomPair pair;
		long space, time;
		long[][] results = new long[algorithms.size()][6];
		for (int i = 0; i < algorithms.size(); i++) {
			results = init(results, i);
			for (int j = 0; j <= repeat; j++) {
				pair = algorithms.get(i).measure((CustomList<Integer>) data.clone());
				if (j > 0) { // results from first run are ignored
					space = pair.getFirst();
					time = pair.getSecond();
					results[i][0] = Math.min(results[i][0], space);
					results[i][1] = Math.max(results[i][1], space);
					results[i][2] += space;
					results[i][3] = Math.min(results[i][3], time);
					results[i][4] = Math.max(results[i][4], time);
					results[i][5] += time;
				}
			}
			results[i][0] /= 1024;
			results[i][1] /= 1024;
			results[i][2] /= (1024 * repeat);
			results[i][5] /= repeat;
		}
		print(results);
	}

	private long[][] init(long[][] results, int i) {
		for (int j = 0; j < results.length; j++) {
			if (j == 0 || j == 3) {
				results[i][j] = Long.MAX_VALUE;
			} else {
				results[i][j] = 0;
			}
		}
		return results;
	}

	private void print(long[][] results) {
		System.out.println("n = " + data.size() + "\tspace/KiB \t \ttime/ms");
		System.out.println("Algorithm \tmin \tmax \tmean \tmin \tmax \tmean");
		System.out.println("-------------------------------------------------------------");
		for (int i = 0; i < results.length; i++) {
			StringBuilder sb = new StringBuilder(algorithms.get(i).toString());
			sb.append("\t");
			if (i != 3) {
				sb.append("\t");
			}
			for (int j = 0; j < results[i].length; j++) {
				sb.append(results[i][j]).append("\t");
			}
			System.out.println(sb);
		}
		System.out.println("");
	}

}
