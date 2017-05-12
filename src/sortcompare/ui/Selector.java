package sortcompare.ui;

/**
 * Abstract class extended by user interface elements.
 *
 * @author Oliver Lewisohn
 */
public abstract class Selector {

    /**
     * Displays the currently available options.
     */
    abstract void options();

    /**
     * Displays the current input.
     */
    abstract void preview();

    /**
     * Resets the current input.
     */
    abstract void reset();

    /**
     * Shorthand method for making it clear that input is expected after the
     * current message has been displayed.
     * @param message The message to display before the prompt.
     */
    final void prompt(final String message) {
        System.out.println(message);
        System.out.print("> ");
    }

    /**
     * Shorthand method for informing the user that their input is invalid.
     */
    final void invalid() {
        prompt("Invalid number; please try again:");
    }
}
