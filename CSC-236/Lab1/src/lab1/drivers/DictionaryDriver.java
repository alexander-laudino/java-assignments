package lab1.drivers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import lab1.Dictionary;

/**
 * The DictionaryDriver class is used to test the Dictionary class
 * 
 * CSC-236-03 Lab 1
 * 
 * @author Alexander Laudino
 */
public class DictionaryDriver {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Dictionary dict;
		try {
			dict = new Dictionary(input);
			System.out.println(dict.getSize());
			Scanner fileInput = new Scanner(new File("tests\\decryptedtext.txt"));
			String concat = checkInput(dict, fileInput);
			if (concat == null)
				System.out.println("Unable to break cipher");
			else
				System.out.println(concat.stripLeading());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * The checkInput method takes file input and tests if each word is a valid word
	 * in the dictionary
	 * 
	 * @param dict      Dictionary object
	 * @param fileInput Scanner object with file input param
	 * @return Valid word String or null
	 */
	public static String checkInput(Dictionary dict, Scanner fileInput) {
		String concat = "";
		while (fileInput.hasNext()) {
			String line = fileInput.nextLine();
			String[] words = line.split("\\s+");
			boolean allWords = isAllWords(dict, words);
			if (!allWords) {
				concat = null;
				break;
			} else
				concat = concat + "\n" + line;
		}
		return concat;
	}

	/**
	 * The isAllWords method tests if all the words in a given String array are
	 * valid words in the dictionary
	 * 
	 * @param dict  Dictionary object
	 * @param words String of words
	 * @return True if all words are valid, false if not
	 */
	private static boolean isAllWords(Dictionary dict, String[] words) {
		boolean allWords = false;
		for (String word : words) {
			word = word.replaceAll("\\p{Punct}", "");
			if (!dict.isWord(word)) {
				allWords = false;
				break;
			} else
				allWords = true;
		}
		return allWords;
	}

}