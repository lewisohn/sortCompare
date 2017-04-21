package sortcompare.structures;

import java.util.Iterator;

/**
 * Flexible-sized list. Work-in-progress.
 *
 * @author Oliver Lewisohn
 * @param <E> The type of Object the list will contain.
 */
public class CustomListPrototype<E> implements Iterable<E> {

	private Object[] array;
	private int next;
	private int size;

	public CustomListPrototype() {
		array = new Object[10];
		init();
	}

	public CustomListPrototype(int size) {
		array = new Object[size];
		init();
	}

	private void init() {
		next = 0;
		size = 0;
	}

	@SuppressWarnings("unchecked")
	public Object[] getArray() {
		return array; // used for testing
	}

	public boolean add(E e) {
		if (next >= array.length) {
			if (!expand(array.length * 2)) {
				return false;
			}
		}
		array[next++] = e;
		size++;
		return true;
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

	public E poll() {
		if (this.isEmpty()) {
			return null;
		} else {
			E e = this.get(0);
			this.remove(0);
			return e;
		}
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

	private boolean expand(int size) {
		if (array.length == Integer.MAX_VALUE) {
			return false;
		} else {
			E[] bigger = (E[]) new Object[Math.min(Integer.MAX_VALUE, size)];
			System.arraycopy(array, 0, bigger, 0, array.length);
			array = bigger;
			return true;
		}
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public int size() {
		return size;
	}

	public E get(int index) {
		if ((index >= 0) && (index < array.length)) {
			return (E) array[index];
		} else {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}

	public void set(int index, E e) {
		if (index >= 0) {
			if (index >= array.length) {
				expand(Math.min(index + 1, array.length * 2));
			}
			array[index] = e;
		} else {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}

	public void remove(int index) {
		if ((index >= 0) && (index < array.length)) {
			array[index] = null;
			size--;
		} else {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}

	public boolean remove(E e) {
		int index = index(e);
		if (index > 0) {
			remove(index);
			return true;
		} else {
			return false;
		}
	}

	private int index(E e) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	public void clear() {
		for (int i = 0; i < array.length; i++) {
			array[i] = null;
		}
		size = 0;
	}

	public boolean contains(E e) {
		return (index(e) > 0);
	}

	public CustomList<E> copy() {
		CustomList<E> copy = new CustomList<>();
		copy.append(this);
		return copy;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

}
