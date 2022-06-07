import java.util.Comparator;

// Alexander Laudino
// CSC-236-03
// Lab 3

public class Song implements Comparable<Song> {

	private String url;
	private Date weekID;
	private String songName;
	private String performer;
	private String songID;
	private int instance;
	private int peakPosition;
	private int weeksOnChart;

	// default constructor
	public Song() {
	}

	/*
	 * Construct new Song object using input from Billboard100 file
	 */
	public Song(String url, Date weekID, String songName, String performer, String songID, int instance,
			int peakPosition, int weeksOnChart) {
		this.url = url;
		this.weekID = weekID;
		this.songName = songName;
		this.performer = performer;
		this.songID = songID;
		this.instance = instance;
		this.peakPosition = peakPosition;
		this.weeksOnChart = weeksOnChart;
	}

	/*
	 * Returns song name
	 */
	public String getName() {
		return songName;
	}

	/*
	 * Returns true if Weeks on Chart is greater then parm
	 */
	public boolean overWeeks(int weeks) {
		return weeksOnChart > weeks;
	}

	/*
	 * Return true if weekIDs are equal
	 */
	public boolean isWeek(Date date) {
		return weekID.equals(date.getWeek());
	}

	/*
	 * Return true if performers are equal
	 */
	public boolean performedBy(String artist) {
		return performer.toLowerCase().equals(artist.toLowerCase());
	}

	/*
	 * Return true if songs are equal
	 */
	public boolean isSong(String name) {
		return songName.toLowerCase().equals(name.toLowerCase());
	}

	/*
	 * Returns true if Instance is greater then parm
	 */
	public boolean overInstance(int times) {
		return instance > times;
	}

	/*
	 * Return true if peakPosition equals 1
	 */
	public boolean isNumberOne() {
		return peakPosition == 1;
	}

	@Override
	/*
	 * Uses SongID for comparison
	 */
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Song)) {
			return false;
		} else {
			Song s = (Song) o;
			return songID.equals(s.songID);
		}

	}

	@Override
	/*
	 * Sorts by SongID, if equal, sorts by weekID
	 */
	public int compareTo(Song other) {
		if (this.equals(other))
			return weekID.compareTo(other.weekID);
		return songID.compareTo(other.songID);
	}

	@Override
	public String toString() {
		return String.format("%-53s|%-12s|%-56s|%-115s|%-125s|%-10s|%-15s|%-16s", url, weekID, songName, performer,
				songID, instance, peakPosition, weeksOnChart);
	}

	/*
	 * Sort Song objects by WeekID
	 */
	public static Comparator<Song> byWeekID() {
		return new Comparator<Song>() {
			public int compare(Song one, Song two) {
				if (one.weekID == two.weekID)
					return one.compareTo(two);
				else
					return one.weekID.compareTo(two.weekID);
			}
		};
	}

	/*
	 * Sort Song objects by Song Name
	 */
	public static Comparator<Song> bySongName() {
		return new Comparator<Song>() {
			public int compare(Song one, Song two) {
				if (one.songName.equals(two.songName))
					return one.weekID.compareTo(two.weekID);
				else
					return one.songName.compareTo(two.songName);
			}
		};
	}

	/*
	 * Sort Song objects by Performer
	 */
	public static Comparator<Song> byPerformer() {
		return new Comparator<Song>() {
			public int compare(Song one, Song two) {
				if (one.performer.equals(two.performer))
					if (one.songName.equals(two.songName))
						return one.weekID.compareTo(two.weekID);
					else
						return one.songName.compareTo(two.songName);
				else
					return one.performer.compareTo(two.performer);
			}
		};
	}

	/*
	 * Sort Song objects by Instance on Chart
	 */
	public static Comparator<Song> byInstance() {
		return new Comparator<Song>() {
			public int compare(Song one, Song two) {
				if (one.instance == two.instance)
					return one.performer.compareTo(two.performer);
				else
					return (two.instance - one.instance);
			}
		};
	}
}
