package sortcompare.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import sortcompare.algorithms.*;
import sortcompare.structures.CustomList;

/**
 * Gathers a set of algorithms to compare.
 * @author Oliver Lewisohn
 */
public class SortSelector extends Selector {

	private final CustomList<Sort> algorithms;
	private final Sort[] sorters;
	private final BufferedReader reader;

	/**
	 * Creates a new SortSelector.
	 */
	public SortSelector() {
		algorithms = new CustomList<>();
		sorters = new Sort[]{
			new Bubble(),
			new Bucket(),
			new Heap(),
			new Insertion(),
			new Merge(),
			new Quick()
		};
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * Prompts the user to select some algorithms.
	 * @return
	 */
	public CustomList<Sort> populate() {
		System.out.println("Next, let's choose some sorting algorithms to compare.");
		int input = -1;
		boolean flag = false;
		while (true) {
			if (flag) {
				prompt("Please enter a new option (9 to see the options again):");
			} else {
				System.out.println("Please enter one of the following options:");
				options();
				System.out.print("> ");
				flag = true;
			}
			try {
				input = Integer.parseInt(reader.readLine());
			} catch (IOException | NumberFormatException ex) {
				invalid();
			}
			if (input == 0) {
				if (algorithms.isEmpty()) {
					prompt("You must select at least one algorithm; please try again.");
				} else {
					System.out.println("Sorting...");
					return algorithms;
				}
			} else if (input > 0 && input < 7) {
				if (algorithms.contains(sorters[input - 1])) {
					algorithms.remove(sorters[input - 1]);
					System.out.println("Algorithm deselected.");
				} else {
					algorithms.add(sorters[input - 1]);
					System.out.println("Algorithm selected.");
				}
			} else if (input == 7) {
				preview();
			} else if (input == 9) {
				options();
			} else {
				prompt("Invalid number, please try again.");
			}
		}
	}

	@Override
	void options() {
		System.out.println("  1  Bubble sort"
				+ "\n  2  Bucket sort"
				+ "\n  3  Heap sort"
				+ "\n  4  Insertion sort"
				+ "\n  5  Merge sort"
				+ "\n  6  Quick sort (unavailable)"
				+ "\n  7  Preview selected algorithms"
				+ "\n  9  See these options again"
				+ "\n  0  End selection");
	}

	@Override
	void preview() {
		if (algorithms.isEmpty()) {
			System.out.println("There are currently no algorithms selected.");
		} else {
			System.out.println("Selected algorithms: " + algorithms);
		}
	}

	@Override
	void reset() {
		algorithms.clear();
		System.out.println("The list is now empty.");
	}

}
