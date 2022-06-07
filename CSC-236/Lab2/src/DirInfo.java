/**
 * The DirInfo class contains the constructors and variables for holding
 * directory information objects.
 * 
 * CSC-236-03 Lab 2 Professor Schatz 2022-03-13
 * 
 * @author Alexander Laudino
 */
public class DirInfo {

	public String directory; // Directory path

	public int indent; // Current indent for contents

	public int index; // Current index in directory array

	public boolean prevOnStack = false; // If directory was previously on the stack

	/**
	 * This constructor is used to push the first DirInfo object on to the stack
	 * 
	 * @param directory Path to directory
	 */
	public DirInfo(String directory) {
		this.directory = directory;
		this.indent = 1;
		this.index = 0;
	}

	/**
	 * This constructor is used to create a DirInfo object for a directory that
	 * hasn't previously been on the stack
	 * 
	 * @param directory Path to directory
	 * @param indent    Current indent for directory
	 */
	public DirInfo(String directory, int indent) {
		this.directory = directory;
		this.indent = indent;
		this.index = 0;
	}

	/**
	 * This constructor is used to create DirInfo objects that have previously been
	 * on the stack
	 * 
	 * @param directory Path to directory
	 * @param indent    Current indent of parent directory
	 * @param index     Current index in directory array
	 */
	public DirInfo(String directory, int indent, int index) {
		this.directory = directory;
		this.indent = indent;
		this.index = index;
		this.prevOnStack = true;
	}

}