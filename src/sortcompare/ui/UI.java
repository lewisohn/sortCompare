package sortcompare.ui;

import sortcompare.algorithms.Sort;
import sortcompare.structures.CustomList;

/**
 * Container class for user interaction.
 * @author Oliver Lewisohn
 */
public class UI {

    private CustomList<Integer> data;
    private CustomList<Sort> algorithms;

    /**
     * Interacts with the user.
     * @return Evaluator containing both data and a list of algorithms to
     * compare.
     */
    public final Evaluator run() {
        data = new DataSelector().populate();
        algorithms = new SortSelector().populate();
        return new Evaluator(data, algorithms);
    }

}
