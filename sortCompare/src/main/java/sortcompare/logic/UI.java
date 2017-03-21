package sortcompare.logic;

import sortcompare.algorithms.Sort;
import sortcompare.structures.FlexList;

public class UI {

	private final FlexList<Integer> data;
	private final FlexList<Sort> algorithms;

	public UI() {
		data = new DataSelect().populate();
		algorithms = new SortSelect().populate();

		System.out.println(data);
		System.out.println(algorithms);

	}

}
