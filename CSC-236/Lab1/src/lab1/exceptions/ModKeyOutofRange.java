package lab1.exceptions;

/**
 * The ModKeyOutofRange class extends the Exception class to validate mod key
 * input 
 * 
 * CSC-236-03 Lab 1
 * @author Alexander Laudino
 *
 */
public class ModKeyOutofRange extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * This constructor creates an exception object for mod key out of range
	 * 
	 * @param modKey Current mod key value
	 * @param shiftKey Current shift key value
	 */
	public ModKeyOutofRange(int modKey, int shiftKey) {
		super("Invalid mod key! Value: " + modKey
				+ "\nMust be greater than or equal to 0 and less than shiftKey value: " + shiftKey);
	}

}