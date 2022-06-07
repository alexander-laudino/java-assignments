package lab1.exceptions;

/**
 * The ShiftKeyOutofRange class extends the Exception class to validate shift
 * key input
 * 
 * CSC-236-03 Lab 1
 * @author Alexander Laudino
 *
 */
public class ShiftKeyOutofRange extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * This constructor creates an exception object for shift key out of range
	 * 
	 * @param shiftKey Current shift key value
	 */
	public ShiftKeyOutofRange(int shiftKey) {
		super("Invalid shift key! Value: " + shiftKey + "\nMust be greater than 0 and less than or equal to 10.");
	}
}