package sortcompare;

import sortcompare.structures.CustomList;
import sortcompare.ui.UI;

/**
 * Comparison of sorting algorithms.
 * @author Oliver Lewisohn
 */
public class Main {

	/**
	 * Main method. Launches the user interface then calls the evaluator.
	 * @param args No arguments necessary.
	 */
	public static void main(String[] args) {
		CustomList<Integer> cl = new CustomList<>();
		System.out.println(cl);
		cl.add(5);
		cl.add(-4);
		System.out.println(cl);
		
//		new UI().run().evaluate();
	}

}
