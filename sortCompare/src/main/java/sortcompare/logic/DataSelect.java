package sortcompare.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import sortcompare.structures.FlexList;

public class DataSelect extends Select {

	private final FlexList<Integer> data;
	private final BufferedReader reader;

	public DataSelect() {
		data = new FlexList();
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	public FlexList<Integer> populate() {
		System.out.println("To compare sorting algorithms, we need some data to sort.");
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
				if (data.isEmpty()) {
					prompt("You must provide some data; please try again:");
				} else {
					return data;
				}
			} else if (input == 1) {
				manual();
			} else if (input == 2) {
				consecutive();
			} else if (input == 3) {
				random();
			} else if (input == 4) {
				preview();
			} else if (input == 5) {
				reset();
			} else if (input == 9) {
				options();
			} else {
				invalid();
			}

		}
	}

	private void manual() {
		prompt("Enter some positive or negative integers. One number per line, 0 to finish:");
		int input = -1;
		while (true) {
			try {
				input = Integer.parseInt(reader.readLine());
			} catch (IOException | NumberFormatException ex) {
				invalid();
			}
			if (input != 0) {
				data.add(input);
				System.out.print("> ");
			} else {
				break;
			}
		}
		done();
	}

	private void consecutive() {
		int[] range = range();
		if (range[1] > range[0]) { // ascending or constant
			for (int i = range[0]; i <= range[1]; i++) {
				data.add(i);
			}
		} else { // descending
			for (int i = range[0]; i >= range[1]; i--) { // descending
				data.add(i);
			}
		}
		done();
	}

	private void random() {
		int[] range = range();
		int min;
		int size;
		if (range[0] > range[1]) {
			min = range[1];
			size = range[0] - range[1] + 1;
		} else {
			min = range[0];
			size = range[1] - range[0] + 1;
		}
		prompt("How many random numbers should be chosen?");
		int input = -1;
		int number = 1;
		while (true) {
			try {
				input = Integer.parseInt(reader.readLine());
			} catch (IOException | NumberFormatException ex) {
				invalid();
			}
			if (input > 0) {
				number = input;
				break;
			} else {
				invalid();
			}
		}
		Random random = new Random();
		for (int i = 0; i < number; i++) {
			data.add(min + random.nextInt(size));
		}
		done();
	}

	@Override
	void preview() {
		if (data.isEmpty()) {
			System.out.println("There are currently no data.");
		} else {
			System.out.println("Current data: " + data);
		}
	}

	@Override
	void options() {
		System.out.println("  1  Manual entry"
				+ "\n  2  Consecutive integers"
				+ "\n  3  Random integers"
				+ "\n  4  Preview current data"
				+ "\n  5  Reset data"
				+ "\n  9  See these options again"
				+ "\n  0  End generation");
	}

	@Override
	void reset() {
		prompt("This will remove all data from the list. Enter 1 to proceed or 0 to cancel:");
		int input = -1;
		while (true) {
			try {
				input = Integer.parseInt(reader.readLine());
			} catch (IOException | NumberFormatException ex) {
				invalid();
			}
			if (input == 1) {
				data.clear();
				System.out.println("The list is now empty.");
				break;
			} else if (input == 0) {
				System.out.println("No action taken.");
				break;
			} else {
				invalid();
			}
		}
	}

	private int[] range() {
		int[] range = new int[2];
		for (int i = 0; i < 2; i++) {
			prompt("Enter " + (i == 0 ? "a lower" : "an upper") + " bound (inclusive):");
			int input = -1;
			while (true) {
				try {
					input = Integer.parseInt(reader.readLine());
				} catch (IOException | NumberFormatException ex) {
					invalid();
				}
				range[i] = input;
				break;
			}
		}
		return range;
	}

	private void done() {
		System.out.print("Finished adding numbers. ");
	}

}
