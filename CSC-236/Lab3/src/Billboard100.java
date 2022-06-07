import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

// Alexander Laudino
// CSC-236-03
// Lab 3

public class Billboard100 {

	private SortedArrayCollection<Song> songs;
	private String heading = String.format("%-53s|%-12s|%-56s|%-115s|%-125s|%-10s|%-15s|%-16s", "URL", "WeekID",
			"Song Title", "Performer", "SongID", "Instance", "Peak Position", "Weeks on Chart");

	/*
	 * Constructs new Billboard100 object using Scanner input file
	 */
	public Billboard100(Scanner input) {
		songs = new SortedArrayCollection<>();
		addSongs(input);
	}

	/*
	 * Read each line of file, split into array, declare and initialize fields to
	 * create new Song object, adds Song object to SortedArrayCollection
	 */
	private void addSongs(Scanner input) {
		input.nextLine();
		while (input.hasNext()) {
			String songLine = input.nextLine();
			String[] songInfo = songLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			String url = songInfo[0];
			Date date = new Date(songInfo[1]);
			String songName = songInfo[2];
			String performer = songInfo[3];
			String songID = songInfo[4];
			int instance = Integer.valueOf(songInfo[5]);
			int peak = Integer.valueOf(songInfo[6]);
			int weeks = Integer.valueOf(songInfo[7]);
			Song song = new Song(url, date, songName, performer, songID, instance, peak, weeks);
			songs.add(song);
		}
	}

	/*
	 * Print all Billboard Hot 100 Songs in the List (using the natural order)
	 */
	public void printAllSongs(FileWriter writer) {
		try {
			writer.write("----- All Billboard Hot 100 Songs Between January 2018 and May 2021 -----\n\n");
			writer.write(heading);
			writer.write("\n");
			writer.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Iterator<Song> iter = songs.iterator();
		while (iter.hasNext()) {
			Song song = iter.next();
			try {
				writer.write(song.toString());
				writer.write("\n");
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Print all songs in the list that have been on the chart for more than 12
	 * weeks.
	 */
	public void over12Weeks(FileWriter writer) {
		try {
			writer.write(
					"----- Billboard Hot 100 Songs on Chart over 12 Weeks Between January 2018 and May 2021 -----\n\n");
			writer.write(heading);
			writer.write("\n");
			writer.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Iterator<Song> iter = songs.iterator();
		while (iter.hasNext()) {
			Song song = iter.next();
			if (song.overWeeks(12)) {
				try {
					writer.write(song.toString());
					writer.write("\n");
					writer.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * Display all songs in a specific week: Prompt the user to enter a month, day
	 * and year (remember that the week starts on a Saturday), then display all
	 * songs that made the chart that week.
	 */
	public void printWeek(FileWriter writer, Date userDate) {
		try {
			writer.write("----- Billboard Hot 100 Songs on Chart week of ");
			writer.write(userDate.toString());
			writer.write(" -----\n\n");
			writer.write(heading);
			writer.write("\n");
			writer.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Iterator<Song> iter = songs.iterator();
		while (iter.hasNext()) {
			Song song = iter.next();
			if (song.isWeek(userDate)) {
				try {
					writer.write(song.toString());
					writer.write("\n");
					writer.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * Search for a performer: Prompt the user for a string, then display all songs
	 * in the list that match the performers name (regardless of case).
	 */
	public void byPerformer(FileWriter writer, String performer) {
		boolean foundPerformer = false;
		try {
			writer.write("----- Billboard Hot 100 Songs on Chart for ");
			writer.write(performer);
			writer.write(" Between January 2018 and May 2021 -----\n\n");
			writer.write(heading);
			writer.write("\n");
			writer.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Iterator<Song> iter = songs.iterator();
		while (iter.hasNext()) {
			Song song = iter.next();
			if (song.performedBy(performer))
				try {
					writer.write(song.toString());
					writer.write("\n");
					writer.flush();
					foundPerformer = true;
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		if (!foundPerformer) {
			System.out.println("\n***** Performer not found *****");
			try {
				writer.write("\n ----- Query returns no results for performer. -----\n");
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/*
	 * Search for a song name: Prompt the user for a string, then display all songs
	 * in the list that match the songs name (regardless of case).
	 */
	public void bySongName(FileWriter writer, String name) {
		boolean foundSong = false;
		try {
			writer.write("----- Billboard Hot 100 Songs on Chart for ");
			writer.write(name);
			writer.write(" Between January 2018 and May 2021 -----\n\n");
			writer.write(heading);
			writer.write("\n");
			writer.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Iterator<Song> iter = songs.iterator();
		while (iter.hasNext()) {
			Song song = iter.next();
			if (song.isSong(name))
				try {
					writer.write(song.toString());
					writer.write("\n");
					writer.flush();
					foundSong = true;
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		if (!foundSong) {
			System.out.println("***** Song not found *****");
			try {
				writer.write("\n ----- Query returns no results for song name. -----\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Print all the songs in the list with an Instance greater than 1.
	 */
	public void multiInstance(FileWriter writer) {
		try {
			writer.write(
					"----- Multiple Instances of Billboard Hot 100 Songs on Chart Between January 2018 and May 2021 (From most to least) -----\n\n");
			writer.write(heading);
			writer.write("\n");
			writer.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		SortedArrayCollection<Song> byInstance = new SortedArrayCollection<>(Song.byInstance());
		Iterator<Song> iter = songs.iterator();
		while (iter.hasNext()) {
			Song song = iter.next();
			if (song.overInstance(1))
				byInstance.add(song);
		}
		Iterator<Song> iterInstance = byInstance.iterator();
		while (iterInstance.hasNext()) {
			Song song = iterInstance.next();
			if (song.overInstance(1))
				try {
					writer.write(song.toString());
					writer.write("\n");
					writer.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	/*
	 * Print all the songs in the list whose peak position is 1.
	 */
	public void topOfChart(FileWriter writer) {
		try {
			writer.write(
					"----- Billboard Hot 100 Songs on Chart that reached Peak Position Between January 2018 and May 2021 (Multiple Instances Removed) -----\n\n");
			writer.write(heading);
			writer.write("\n");
			writer.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		SortedArrayCollection<String> list = new SortedArrayCollection<>();
		Iterator<Song> iter = songs.iterator();
		while (iter.hasNext()) {
			Song song = iter.next();
			if (song.isNumberOne() && !(list.contains(song.getName()))) {
				try {
					writer.write(song.toString());
					writer.write("\n");
					writer.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				list.add(song.getName());
			}
		}
	}

	/*
	 * Print all Songs in order by WeekID (increasing order).
	 */
	public void sortByWeekID(FileWriter writer) {
		try {
			writer.write(
					"----- Billboard Hot 100 Songs on Chart Between January 2018 and May 2021 By WeekID -----\n\n");
			writer.write(heading);
			writer.write("\n");
			writer.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		SortedArrayCollection<Song> byWeekID = new SortedArrayCollection<>(Song.byWeekID());
		Iterator<Song> iter = songs.iterator();
		while (iter.hasNext()) {
			Song song = iter.next();
			byWeekID.add(song);
		}
		Iterator<Song> iterWeekID = byWeekID.iterator();
		while (iterWeekID.hasNext()) {
			Song song = iterWeekID.next();
			try {
				writer.write(song.toString());
				writer.write("\n");
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Print all Songs in alphabetical order by Song Name.
	 */
	public void sortBySongName(FileWriter writer) {
		try {
			writer.write(
					"----- Billboard Hot 100 Songs on Chart Between January 2018 and May 2021 By Song Name -----\n\n");
			writer.write(heading);
			writer.write("\n");
			writer.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		SortedArrayCollection<Song> bySongName = new SortedArrayCollection<>(Song.bySongName());
		Iterator<Song> iter = songs.iterator();
		while (iter.hasNext()) {
			Song song = iter.next();
			bySongName.add(song);
		}
		Iterator<Song> iterSongName = bySongName.iterator();
		while (iterSongName.hasNext()) {
			Song song = iterSongName.next();
			try {
				writer.write(song.toString());
				writer.write("\n");
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Print all songs in alphabetical order by Performer Name.
	 */
	public void sortByPerformer(FileWriter writer) {
		try {
			writer.write(
					"----- Billboard Hot 100 Songs on Chart Between January 2018 and May 2021 By Performer -----\n\n");
			writer.write(heading);
			writer.write("\n");
			writer.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		SortedArrayCollection<Song> byPerformer = new SortedArrayCollection<>(Song.byPerformer());
		Iterator<Song> iter = songs.iterator();
		while (iter.hasNext()) {
			Song song = iter.next();
			byPerformer.add(song);
		}
		Iterator<Song> iterPerformer = byPerformer.iterator();
		while (iterPerformer.hasNext()) {
			Song song = iterPerformer.next();
			try {
				writer.write(song.toString());
				writer.write("\n");
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
