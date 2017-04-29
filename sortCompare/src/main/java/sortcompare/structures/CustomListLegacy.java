package sortcompare.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Flexible-sized list. Deprecated by CustomList.
 *
 * @author Oliver Lewisohn
 * @param <E> The type of Object the list will contain.
 */
public class CustomListLegacy<E> extends ArrayList<E> {

	/**
	 * Creates a new CustomList.
	 */
	public CustomListLegacy() {
		super();
	}

	/**
	 * Creates a new CustomList with the specified initial capacity.
	 * @param size The initial capacity.
	 */
	public CustomListLegacy(int size) {
		super(size);
	}

	/**
	 * Adds all elements from an array to the list.
	 * @param array The array to copy elements from.
	 */
	public void addAll(E[] array) {
		this.addAll(Arrays.asList(array));
	}

	/**
	 * Removes and returns the first element of the list (first in, first out).
	 * @return The first element of the list.
	 */
	public E poll() {
		if (!this.isEmpty()) {
			E e = this.get(0);
			this.remove(0);
			return e;
		} else {
			return null;
		}
	}

	/**
	 * Adds all elements from a CustomList to the list.
	 * @param list The source CustomList to copy elements from.
	 */
	public void append(CustomList<E> list) {
		for (E e : list) {
			this.add(e);
		}
	}

	// Override, no Javadoc
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
