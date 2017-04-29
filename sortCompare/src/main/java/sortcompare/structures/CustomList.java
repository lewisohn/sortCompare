package sortcompare.structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Flexible-sized list.
 *
 * @author Oliver Lewisohn
 * @param <E> The type of Object the list will contain.
 */
public class CustomList<E> implements Iterable<E> {

	private static final int SIZE_DEFAULT = 10;

	private Object[] array;
	private int next = 0;
	private int size = 0;

	/**
	 * Creates a new CustomList with the specified initial capacity.
	 *
	 * @param size The initial capacity.
	 */
	public CustomList(int size) {
		array = new Object[size];
	}

	/**
	 * Creates a new CustomList with the default initial capacity.
	 */
	public CustomList() {
		array = new Object[SIZE_DEFAULT];
	}

	/**
	 * Adds an element to the list.
	 *
	 * @param e The element to be added.
	 * @return True if the list had sufficient capacity to add the element,
	 * false otherwise.
	 */
	public boolean add(E e) {
		if ((next >= array.length) && !ensure()) {
			return false;
		} else {
			array[next++] = e;
			size++;
			return true;
		}
	}

	/**
	 * Adds all elements from another CustomList.
	 *
	 * @param source The CustomList to copy elements from.
	 * @return True if the list had sufficient capacity to add all the elements
	 * in the source list, false otherwise.
	 */
	public boolean append(CustomList<E> source) {
		for (E e : source) {
			if (!add(e)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Adds all elements from an array.
	 *
	 * @param source The array to copy elements from.
	 * @return True if the list had sufficient capacity to add all the elements
	 * in the source array, false otherwise.
	 */
	public boolean append(E[] source) {
		for (E e : source) {
			if (!add(e)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Removes all elements from the list.
	 */
	public void clear() {
		for (int i = 0; i < array.length; i++) {
			array[i] = null;
		}
		next = 0;
		size = 0;
	}

	/**
	 * Checks to see if the list contains a specified element.
	 *
	 * @param e The element to look for.
	 * @return True if the element was found, false otherwise.
	 */
	public boolean contains(E e) {
		return (indexOf(e) >= 0);
	}

	/**
	 * Creates a copy of the list.
	 *
	 * @return A new CustomList with the same elements in the same
	 * order.
	 */
	public CustomList<E> copy() {
		CustomList<E> copy = new CustomList<>();
		copy.append(this);
		return copy;
	}

	/**
	 * Fetches an element by index.
	 *
	 * @param index The index of the element, must be greater than or equal to 0
	 * and less than the size of the list.
	 * @return The element at the specified index, if it exists.
	 */
	public E get(int index) {
		if ((index >= 0) && (index < array.length)) {
			return (E) array[index];
		} else {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}

	/**
	 * Checks if the list is empty.
	 *
	 * @return True if the list is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Removes and returns the first element in the list (first in, first out).
	 *
	 * @return The first element of the list.
	 */
	public E poll() {
		if (this.isEmpty()) {
			return null;
		} else {
			E e = this.get(0);
			this.remove(0);
			return e;
		}
	}

	/**
	 * Replaces an element at a specified index.
	 *
	 * @param index The index of the element to be replaced.
	 * @param e The new element.
	 */
	public void set(int index, E e) {
		if ((index >= 0) && (index < array.length)) {
			array[index] = e;
		} else {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}

	/**
	 * Returns the number of elements in the list.
	 *
	 * @return The number of elements in the list.
	 */
	public int size() {
		return size;
	}

	/**
	 * Removes an element at a specified index and moves all elements after it
	 * one place to the left.
	 *
	 * @param index The index of the element to be removed.
	 */
	public void remove(int index) {
		if ((index >= 0) && (index < array.length)) {
			if (size - index - 1 > 0) {
				System.arraycopy(array, index + 1, array, index, array.length - index - 1);
			}
			array[--size] = null;
		} else {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}

	/**
	 * Removes a specified element from the list and moves all elements after it
	 * one place to the left.
	 *
	 * @param e The element to be removed.
	 * @return True if the element was in the list, false otherwise.
	 */
	public boolean remove(E e) {
		int index = indexOf(e);
		if (index >= 0) {
			remove(index);
			return true;
		} else {
			return false;
		}
	}

	// Private methods and overrides, no Javadoc
	private boolean ensure() {
		return expand(newSize());
	}

//	private boolean ensure(int minSize) {
//		return expand(Math.min(newSize(), minSize));
//	}

	private boolean expand(int newSize) {
		if (array.length == Integer.MAX_VALUE) {
			return false;
		} else {
			Object[] newArray = new Object[newSize];
			System.arraycopy(array, 0, newArray, 0, array.length);
			array = newArray;
			return true;
		}
	}

	private int indexOf(E e) {
		for (int i = 0; i < this.size(); i++) {
			if (array[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	private int newSize() {
		return (array.length * 2 > 0 ? array.length * 2 : Integer.MAX_VALUE);
	}

	@Override
	public Iterator<E> iterator() {
		return new CustomListIterator();
	}

	@Override
	public String toString() {
		if (size == 0) {
			return "[ ]";
		} else {
			StringBuilder sb = new StringBuilder("[");
			for (Object o : array) {
				if (o != null) {
					sb.append(o.toString()).append(", ");
				}
			}
			sb.delete(sb.length() - 2, sb.length());
			return sb.append("]").toString();
		}
	}

	// Used for testing only
	@SuppressWarnings("unchecked")
	public Object[] getArray() {
		return array;
	}

	// Custom iterator
	private final class CustomListIterator<E> implements Iterator<E> {

		private int index = 0;

		@Override
		public boolean hasNext() {
			return ((index < array.length) && (array[index] != null));
		}

		@Override
		public E next() {
			if (hasNext()) {
				return (E) array[index++];
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			CustomList.this.remove(index);
		}
	}

}
