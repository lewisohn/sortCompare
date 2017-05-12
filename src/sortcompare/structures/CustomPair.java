package sortcompare.structures;

/**
 * A pair of long values.
 *
 * @author Oliver Lewisohn
 */
public class CustomPair {

    private final long first;
    private final long second;

    /**
     * Creates a new CustomPair.
     *
     * @param one First long value.
     * @param two Second long value.
     */
    public CustomPair(final long one, final long two) {
        this.first = one;
        this.second = two;
    }

    /* Private methods, getters, setters, overrides - no Javadoc */
    public final long getFirst() {
        return first;
    }

    public final long getSecond() {
        return second;
    }
}
