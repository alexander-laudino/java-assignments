package lab1;

import java.io.FileNotFoundException;
import java.util.Scanner;

import lab1.drivers.BreakerDriver;
import lab1.drivers.CipherDriver;

/**
 * The Client class acts as the controller for the rest of the classes to
 * create, test, and break an Enhanced Caesar Cipher 
 * 
 * CSC-236-03 Lab 1
 * @author Alexander Laudino
 */
public class Client {

	public static void main(String[] args) {

		try (Scanner input = new Scanner(System.in);) {
			CipherDriver.encryptPlainText(input);
			CipherDriver.decryptCipherText(input);
			BreakerDriver.breakCipherText(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}

/*
--- Console log using plaintext file with correct spelled words ---
Enter plaintext filename to read from: plainText.txt
Enter ciphertext filename to write to: tests\\cipherText.txt
Enter shift key value =< 10: 7
Enter mod value < shift key: 5
Enter ciphertext filename to decrypt: tests\\cipherText.txt
Enter filename for decrypted plaintext: tests\\decryptedText.txt
Enter shift key value =< 10: 7
Enter mod value < shift key: 5
Enter dictionary file name: dictionary.txt
Dictionary uploaded!
Dictionary created!
Enter file name of ciphertext to be broken: tests\\cipherText.txt
Enter file name to write broken ciphertext to: tests\\brokenText.txt


--- Console log using plaintext file with incorrect spelled word ---
Enter plaintext filename to read from: plainTextError.txt
Enter ciphertext filename to write to: tests\\cipherTextError.txt
Enter shift key value =< 10: 7
Enter mod value < shift key: 5
Enter ciphertext filename to decrypt: tests\\cipherTextError.txt
Enter filename for decrypted plaintext: tests\\decryptedTextError.txt
Enter shift key value =< 10: 7
Enter mod value < shift key: 5
Enter dictionary file name: dictionary.txt
Dictionary uploaded!
Dictionary created!
Enter file name of ciphertext to be broken: tests\\cipherTextError.txt
Enter file name to write broken ciphertext to: tests\\brokenTextError.txt
Unable to break ciphertext

*/