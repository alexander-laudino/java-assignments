import java.io.File;
import java.util.Scanner;

/**
 * The Driver class prompts for a starting directory and then uses a stack to
 * traverse the files and directories within the starting directory, if a
 * subdirectory is found, the program process the directory before it finishes
 * processing the parent directory
 * 
 * CSC-236-03 Lab 2 Professor Schatz 2022-03-13
 * 
 * @author Alexander Laudino
 */
public class Driver {

	public static void main(String[] args) {

		//
		System.out.println("This program prints a list of files and directories.\n");

		// Create new LinkedStack object
		LinkedStack<DirInfo> directories = new LinkedStack<>();

		// Prompt for path to directory
		System.out.print("Enter a directory: ");
		Scanner input = new Scanner(System.in);
		String startingDir = input.nextLine();
		directories.push(new DirInfo(startingDir));
		System.out.println();

		try {
			// Process directory stack
			while (!directories.isEmpty()) {
				// Get top directory in stack
				DirInfo currentDir = directories.top();
				directories.pop();
				String tmpDirName = currentDir.directory;
				File tmpFile = new File(tmpDirName);

				// Print directory name
				if (!currentDir.prevOnStack && !directories.isEmpty()) {
					System.out.println(tmpFile.getName());
				} else if (!currentDir.prevOnStack && directories.isEmpty()) {
					System.out.println(tmpFile.getAbsolutePath());
				}

				// Set indent for printing contents
				int currIndent = currentDir.indent;
				String indent = "";
				for (int i = 0; i < currIndent; i++) {
					indent += "   ";
				}

				// Get array of directory contents
				String[] tmpDir = tmpFile.list();

				// Set current index in directory array
				int currentIndex = currentDir.index;

				// Check if directory array is empty
				if (tmpDir != null) {
					boolean isFile = true;
					// Loop through directory array starting at current index
					while (isFile && currentIndex < tmpDir.length) {
						String fName = tmpDir[currentIndex];
						File tmp = new File(tmpDirName, tmpDir[currentIndex]);
						// Print if file
						if (tmp.isFile()) {
							System.out.println(indent + fName);
							currentIndex++;
						}
						// Process if directory
						if (tmp.isDirectory()) {
							System.out.print(indent);
							currentIndex++;
							isFile = false;
							directories.push(new DirInfo(tmpDirName, currIndent, currentIndex));
							directories.push(new DirInfo(tmpDirName + "\\" + fName, currIndent + 1));

						}

					}

				}

			}
		} catch (StackUnderflowException e) {
			e.printStackTrace();
		}

		input.close();

	}

}

/*
 * Program output: 
 * 

This program prints a list of files and directories.

Enter a directory: I:\StartingDir

I:\StartingDir
   file1
   file2
   file3
   file4
   subDirectory
      subfile1
      subfile2
      subsubDirectory
         subsubfile1
         subsubfile2
      subsubDirectory2
      subfile3
   file5
*/
