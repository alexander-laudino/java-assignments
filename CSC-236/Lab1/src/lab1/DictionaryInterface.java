package lab1;

/**
 * Dictionary Interface provides the methods required to implement a Dictionary object
 * CSC-236-03 Lab 1
 * @author Alexander Laudino
 *
 */
public interface DictionaryInterface {
	void addWord(String word); // adds a new word to this dictionary

	boolean isWord(String word); // returns true if word is in the dictionary and false otherwise

	int getSize(); // number of words in the dictionary

	void writeDict(String dictFileName); // write the dictionary, param is the filename
}