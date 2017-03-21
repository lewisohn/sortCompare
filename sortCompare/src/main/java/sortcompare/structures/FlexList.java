package sortcompare.structures;

import java.util.ArrayList;
import java.util.Iterator;

/*
	This class will eventually replicate the functionality of ArrayList
	but for now it's just an extension.
 */
public class FlexList<E> extends ArrayList<E> {

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
