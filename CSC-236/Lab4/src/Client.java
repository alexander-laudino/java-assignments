import java.util.Scanner;

// Alexander Laudino
// CSC-236-03
// Lab 4

public class Client {

	public static void main(String[] args) {

		BinTree<String> ltree = new BinTree<>("tiger");
		BinTree<String> rtree = new BinTree<>("lobster");
		String question = "Are you a mammal?";
		BinTree<String> guessingGame = new BinTree<>(question, ltree, rtree);
		Scanner keyboard = new Scanner(System.in);
		boolean continueInput = true;

		System.out.println("---------- Animal Guessing Game ---------- \n");
		System.out.println("You will be asked a series of yes/no questions and I will try to guess the animal.");
		System.out.println("If I can't guess the animal, you can help me learn by providing me with new questions.");

		while (continueInput) {
			System.out.print("\nThink of an animal. When you are ready, press enter ");
			keyboard.nextLine();
			playGame(keyboard, guessingGame);
			String prompt = "\nDo you want to play again? (Type Y/N): ";
			System.out.print(prompt);
			String response = keyboard.next();
			keyboard.nextLine();
			if (response.toLowerCase().equals("n"))
				continueInput = false;
		}

	}

	/**
	 * Recursive function to traverse tree and play game
	 * @param keyboard Scanner for user input
	 * @param guessingGame Current node in BinTree
	 */
	private static void playGame(Scanner keyboard, BinTree<String> guessingGame) {
		String question;
		String response;
		if (guessingGame.left == null) {
			question = "\nAre you a " + guessingGame.getInfo() + "?";
			System.out.print(question + " (Type Y/N): ");
			response = keyboard.next();
			if (response.toLowerCase().equals("y"))
				System.out.println("\nGuessed correctly!");
			else
				addQuestion(keyboard, guessingGame);
		} else {
			question = guessingGame.getInfo();
			System.out.print("\n" + question + " (Type Y/N): ");
			response = keyboard.next();
			if (response.toLowerCase().equals("y"))
				playGame(keyboard, guessingGame.left);
			else
				playGame(keyboard, guessingGame.right);
		}

	}

	/**
	 * Adds question to guessing game at current node, creates two children nodes and
	 * attaches them to create new BinTree
	 * @param keyboard Scanner for user input
	 * @param guessingGame Current node in BinTree
	 */
	private static void addQuestion(Scanner keyboard, BinTree<String> guessingGame) {
		System.out.println("\nWe give up. What are you?");
		String newAnimal = keyboard.next();
		String oldAnimal = guessingGame.getInfo();
		System.out.println(
				"\nPlease enter a question that is true for a " + newAnimal + " and is false for a " + oldAnimal + ".");
		keyboard.nextLine();
		String newQuestion = keyboard.nextLine();
		BinTree<String> newLeftChild = new BinTree<>(newAnimal);
		BinTree<String> newRightChild = new BinTree<>(oldAnimal);
		guessingGame.setInfo(newQuestion);
		guessingGame.attachLeft(newLeftChild);
		guessingGame.attachRight(newRightChild);
	}

}
