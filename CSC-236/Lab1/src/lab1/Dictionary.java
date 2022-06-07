package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Dictionary class is used to create an object to hold a list of valid
 * words 
 * 
 * CSC-236-03 Lab 1
 * @author Alexander Laudino
 */
public class Dictionary implements DictionaryInterface {

	// ---------- VARIABLES ----------

	private ArrayList<String> words = new ArrayList<>(); // holds dictionary words

	private Scanner input;

	// ---------- CONSTRUCTORS ----------

	public Dictionary() {
		super();
	}

	/**
	 * This constructor creates a Dictionary object using a Scanner to read the file
	 * containing the words for the dictionary.
	 * 
	 * Scanner object reads words and stores them in the words ArrayList
	 * 
	 * @param input Scanner object
	 */
	public Dictionary(Scanner input) throws FileNotFoundException {
		super();
		this.input = input;
		System.out.print("Enter dictionary file name: ");
		String dictFileName = input.next();
		writeDict(dictFileName);
		System.out.println("Dictionary uploaded!");
	}

	// ---------- METHODS ----------

	@Override
	/**
	 * Adds a new word to this dictionary
	 * 
	 * @param Word String object
	 */
	public void addWord(String word) {
		words.add(word);
	}

	@Override
	/**
	 * Returns true if word is in the dictionary and false otherwise
	 * 
	 * @param word Word String object
	 */
	public boolean isWord(String word) {
		if (words.contains(word.toLowerCase()))
			return true;
		else
			return false;
	}

	@Override
	/**
	 * Returns number of words in the dictionary
	 */
	public int getSize() {
		return words.size();
	}

	@Override
	/**
	 * Writes the dictionary using input file
	 * 
	 * @param dictFileName Filename of dictionary
	 */
	public void writeDict(String dictFileName) {
		File dict = new File(dictFileName);
		try {
			input = new Scanner(dict);
			while (input.hasNext()) {
				String word = input.nextLine();
				addWord(word);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}