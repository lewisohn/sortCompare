package sortcompare.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Flexible-sized list. Currently just an extension of ArrayList but will
 * eventually be replaced with a custom implementation.
 *
 * @author Oliver Lewisohn
 * @param <E> The type of Object the list will contain.
 */
public class FlexList<E> extends ArrayList<E> {

	public void addAll(E[] array) {
		this.addAll(Arrays.asList(array));
	}

	@Override
	public String toString() {
		Iterator<E> iterator = iterator();
		if (!iterator.hasNext()) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		while (true) {
			E e = iterator.next();
			sb.append(e.toString());
			if (!iterator.hasNext()) {
				return sb.toString();
			}
			sb.append(", ");
		}
	}

}
