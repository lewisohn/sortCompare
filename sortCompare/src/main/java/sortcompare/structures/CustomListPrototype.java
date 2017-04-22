package sortcompare.structures;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Flexible-sized list. Work-in-progress.
 *
 * @author Oliver Lewisohn
 * @param <E> The type of Object the list will contain.
 */
public class CustomListPrototype<E> implements Iterable<E> {

	private static final int SIZE_DEFAULT = 10;

	private Object[] array;
	private int next = 0;
	private int size = 0;

	public CustomListPrototype(int size) {
		array = new Object[size];
	}

	public CustomListPrototype() {
		array = new Object[SIZE_DEFAULT];
	}

	public boolean add(E e) {
		if ((next >= array.length) && !ensure()) {
			return false;
		} else {
			array[next++] = e;
			size++;
			return true;
		}
	}

	public boolean append(CustomList<E> source) {
		for (E e : source) {
			if (!add(e)) {
				return false;
			}
		}
		return true;
	}

	public boolean append(E[] source) {
		for (E e : source) {
			if (!add(e)) {
				return false;
			}
		}
		return true;
	}

	public void clear() {
		for (int i = 0; i < array.length; i++) {
			array[i] = null;
		}
		next = 0;
		size = 0;
	}

	public boolean contains(E e) {
		return (indexOf(e) > 0);
	}

	public CustomList<E> copy() {
		CustomList<E> copy = new CustomList<>();
		copy.append(this);
		return copy;
	}

	public E get(int index) {
		if ((index >= 0) && (index < array.length)) {
			return (E) array[index];
		} else {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public E poll() {
		if (this.isEmpty()) {
			return null;
		} else {
			E e = this.get(0);
			this.remove(0);
			return e;
		}
	}

	public void set(int index, E e) {
		if ((index >= 0) && (index < array.length)) {
			array[index] = e;
		} else {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}

	public int size() {
		return size;
	}

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

	public boolean remove(E e) {
		int index = indexOf(e);
		if (index > 0) {
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

	private boolean ensure(int minSize) {
		return expand(Math.min(newSize(), minSize));
	}

	private boolean expand(int newSize) {
		if (array.length == Integer.MAX_VALUE) {
			return false;
		} else {
			E[] newArray = (E[]) new Object[newSize];
			System.arraycopy(array, 0, newArray, 0, array.length);
			array = newArray;
			return true;
		}
	}

	private int indexOf(E e) {
		for (int i = 0; i < array.length; i++) {
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
			return (index < array.length);
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
			CustomListPrototype.this.remove(index);
		}
	}

}
