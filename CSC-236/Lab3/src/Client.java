import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

// Alexander Laudino
// CSC-236-03
// Lab 3

public class Client {

	/*
	 * Prompts user for output file name, then reads CSV file and passes the Scanner
	 * object to construct a new Billboard100 object to be used by the program
	 */
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Searchable Billboard Hot 100 Database - January 2018 to May 2021");
		System.out.print("Please enter name for output file: ");
		String outputFile = keyboard.next();

		try {
			Scanner songsIn = new Scanner(new FileReader("hot.stuff.2018.csv"));
			Billboard100 songList = new Billboard100(songsIn);
			try {
				FileWriter writer = new FileWriter(outputFile);
				boolean continueInput = true;
				while (continueInput) {
					printMenu();
					continueInput = selectOption(keyboard, songList, writer);
				}

			} catch (IOException e) {
				System.out.println("Error! Unable to write to output file.");
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error! Unable to build song list.");
			e.printStackTrace();
		} finally {
			System.out.println("\nProgram exited successfully.");
		}

	}

	/*
	 * Give the user a menu so they can perform all the tasks
	 */
	private static void printMenu() {
		System.out.println("\nPlease select an option. All output will be printed to file.");
		System.out.println("0 - Quit program");
		System.out.println("1 - Print all Billboard Hot 100 Songs in the List");
		System.out.println("2 - Print all songs in the list that have been on the chart for more than 12 weeks");
		System.out.println("3 - Display all songs in a specific week");
		System.out.println("4 - Search for a performer");
		System.out.println("5 - Search for a song name");
		System.out.println("6 - Print all the songs in the list with an Instance greater than 1");
		System.out.println("7 - Print all the songs in the list whose peak position is 1");
		System.out.println("8 - Print all Songs in order by WeekID");
		System.out.println("9 - Print all Songs in alphabetical order by Song Name");
		System.out.println("10 - Print all songs in alphabetical order by Performer Name");
	}

	/*
	 * Provides selection of options to user, continues until user quits program,
	 * provides error message for when user enters invalid option
	 */
	private static boolean selectOption(Scanner keyboard, Billboard100 songList, FileWriter writer) {
		boolean nextInput = true;
		boolean dataWritten = false;
		int option = 0;
		boolean continueInput = true;
		while (continueInput) {
			System.out.print("\nEnter option #: ");
			try {
				option = keyboard.nextInt();
				if (option >= 0 && option <= 10)
					continueInput = false;
				else
					System.out.println("\nMust be between 1 and 10.");
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid input! Must be integer.");
				keyboard.nextLine();
				continue;
			}
			switch (option) {

			case 0:
				nextInput = false;
				break;
			case 1:
				songList.printAllSongs(writer);
				dataWritten = true;
				break;
			case 2:
				songList.over12Weeks(writer);
				dataWritten = true;
				break;
			case 3:
				printByWeek(keyboard, songList, writer);
				dataWritten = true;
				break;
			case 4:
				printByPerformer(keyboard, songList, writer);
				dataWritten = true;
				break;
			case 5:
				printBySong(keyboard, songList, writer);
				dataWritten = true;
				break;
			case 6:
				songList.multiInstance(writer);
				dataWritten = true;
				break;
			case 7:
				songList.topOfChart(writer);
				dataWritten = true;
				break;
			case 8:
				songList.sortByWeekID(writer);
				dataWritten = true;
				break;
			case 9:
				songList.sortBySongName(writer);
				dataWritten = true;
				break;
			case 10:
				songList.sortByPerformer(writer);
				dataWritten = true;
				break;
			default:
				System.out.println("Please enter a correct option number.");
			}
		}
		if (dataWritten) {
			System.out.println("\nData written to file.");
			try {
				writer.write("\n\n");
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else
			System.out.println("\nQuit with no output written.");
		return nextInput;
	}

	/*
	 * Helper method for Searching by Specific Week to get user input
	 */
	private static void printByWeek(Scanner keyboard, Billboard100 songList, FileWriter writer) {
		Date selection = new Date();
		boolean continueInput = true;
		while (continueInput) {
			System.out.println("\nEnter date to display all songs for specific week.");
			System.out.println("Date must be between 1/1/2018 and 5/29/2021");
			try {
				System.out.print("Enter month: ");
				int month = keyboard.nextInt();
				if (month > 12 || month < 1) {
					System.out.println("\n***** Please enter valid month number *****");
					continue;
				}
				System.out.print("Enter day: ");
				int day = keyboard.nextInt();
				if (day > 31 || day < 1) {
					System.out.println("\n***** Please enter valid day number *****");
					continue;
				}
				System.out.print("Enter year: ");
				int year = keyboard.nextInt();
				if ((year >= 2021 && month > 5) || year < 2018) {
					System.out.println("\n***** Date not in range *****");
					continue;
				} else {
					selection = new Date(month, day, year);
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("");
				continue;
			}
		}
		songList.printWeek(writer, selection);
	}

	/*
	 * Helper method for Searching by Song Performer to get user input
	 */
	private static void printByPerformer(Scanner keyboard, Billboard100 songList, FileWriter writer) {
		System.out.print("Enter performer(s) name: ");
		String performer = keyboard.next();
		songList.byPerformer(writer, performer);

	}

	/*
	 * Helper method for Searching by Song to get user input
	 */
	private static void printBySong(Scanner keyboard, Billboard100 songList, FileWriter writer) {
		System.out.print("Enter song name: ");
		String song = keyboard.next();
		songList.bySongName(writer, song);
	}

}
