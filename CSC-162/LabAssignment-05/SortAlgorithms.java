import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class SortAlgorithms {
  
  
  // -------------------- VARIABLES ---------------------
  
  
  /**
   * Scanner object for user input, used in the inputNumber 
   * methods which are called by the setUserList method  
   */
  private static final Scanner INPUT = new Scanner(System.in);
  
  /**
   * Random object used to populate list with integers in 
   * generateLists methods
   */
  private Random rand = new Random();
  
  /**
   * Original list of integers
   */
  private ArrayList<Integer> oList = new ArrayList<>();
  
  /**
   * Insertion sort list
   */
  private ArrayList<Integer> iList = new ArrayList<>();
  
  /**
   * Bubble sort list
   */
  private ArrayList<Integer> bList = new ArrayList<>();
  
  /**
   * Merge sort list
   */
  private int[] mList;
  
  /**
   * Quick sort list
   */
  private int[] qList;
  
  /**
   * Insertion sort swaps
   */
  private int iSwaps = 0;
  
  /**
   * Bubble sort swaps
   */
  private int bSwaps = 0;
  
  /**
   * Merge sort swaps
   */
  private int mSwaps = 0;
  
  /**
   * Quick sort swaps
   */
  private int qSwaps = 0;
  
  
  // ------------------- CONSTRUCTORS -------------------
  
  
  /**
   * Constructs arrays of integers of size 20
   */
  public SortAlgorithms() {
    generateLists();
  }
  
  /**
   * Constructs arrays of integers of size n
   * @param n Non-negative integer
   */
  public SortAlgorithms(int n) {
    generateLists(n);
  }
  
  /**
   * Constructs arrays from list of integers
   * @param nList Integer array
   */
  public SortAlgorithms(int[] nList) {
    generateLists(nList);
  }
  
  /**
   * Constructs arrays from arraylist of integers
   * @param uList Integer arraylist
   */
  public SortAlgorithms(ArrayList<Integer> uList) {
    generateLists(uList);
  }
  
  
  // --------------------- METHODS ----------------------
  
  
  /**
   * Generate a list of integers of size 20 in range -1000 to 1000
   * and copy the list to other arrays/arraylists to be used in the
   * sort algorithms
   */
  private void generateLists() {
    
    // Generate list of 20 integers in range -1000 to 1000 and add to original arraylist
    for (int i = 0; i < 20; i++) {
      if (rand.nextInt(10) % 2 == 0)
        oList.add(rand.nextInt(1000)); // Positive integers
      else
        oList.add((rand.nextInt(1000) * -1)); // Negative integers
    }
    
    copyArray(oList, iList); // Copy original arraylist to insertion sort arraylist
    copyArray(oList, bList); // Copy original arraylist to bubble sort arraylist
    mList = new int[oList.size()]; // Set size of merge sort array to size of original arraylist
    copyArray(oList, mList); // Copy original arraylist to merge sort array 
    qList = new int[oList.size()]; // Set size of quick sort array to size of original arraylist
    copyArray(oList, qList); // Copy original arraylist to quick sort array
  }
  
  /**
   * Generate a list of integers of size n in range -1000 to 1000 and
   * copy the list to other arrays/arraylists to be used in the sort
   * algorithms
   * @param n Non-negative integer
   */
  private void generateLists(int n) {
    
    // Generate list of n integers in range -1000 to 1000
    // and add to original arraylist
    for (int i = 0; i < n; i++) {
      if (rand.nextInt(10) % 2 == 0)
        oList.add(rand.nextInt(1000)); // Positive integers
      else
        oList.add((rand.nextInt(1000) * -1)); // Negative integers
    }
    
    copyArray(oList, iList); // Copy original arraylist to insertion sort arraylist
    copyArray(oList, bList); // Copy original arraylist to bubble sort arraylist
    mList = new int[oList.size()]; // Set size of merge sort array to size of original arraylist
    copyArray(oList, mList); // Copy original arraylist to merge sort array
    qList = new int[oList.size()]; // Set size of quick sort array to size of original arraylist
    copyArray(oList, qList); // Copy original arraylist to quick sort array
  }
  
  /**
   * Take array of integers and copy to other arrays/arraylists to be
   * used in the sort algorithms
   * @param nList Non-empty integer array
   */
  private void generateLists(int[] nList) {
    copyArray(nList, oList); // Copy array to original arraylist
    copyArray(nList, iList); // Copy array to insertion sort arraylist
    copyArray(nList, bList); // Copy array to bubble sort arraylist
    mList = new int[nList.length]; // Set size of merge sort array to length of nList array
    copyArray(nList, mList); // Copy array to merge sort array
    qList = new int[nList.length]; // Set size of quick sort array to length of nList array
    copyArray(nList, qList); // Copy array to quick sort array
  }
  
  /**
   * Take arraylist of integers and copy to other arrays/arraylists to be
   * used in the sort algorithms
   * @param uList Non-empty integer arraylist
   */
  private void generateLists(ArrayList<Integer> uList) {
    copyArray(uList, oList); // Copy arraylist to original arraylist
    copyArray(uList, iList); // Copy arraylist to insertion sort arraylist
    copyArray(uList, bList); // Copy arraylist to bubble sort arraylist
    mList = new int[uList.size()]; // Set size of merge sort array to size of uList arraylist
    copyArray(uList, mList); // Copy arraylist to merge sort array
    qList = new int[uList.size()]; // Set size of quick sort array to size of uList arraylist
    copyArray(uList, qList); // Copy arraylist to quick sort array
  }

  /**
   * Copy arraylist to arraylist
   * @param fromList Non-empty arraylist of integers
   * @param toList Empty arraylist
   */
  private void copyArray(ArrayList<Integer> fromList, ArrayList<Integer> toList) {
    for (Integer i: fromList) {
      toList.add(i);
    }
  }
  
  /**
   * Copy arraylist to array
   * @param fromList Non-empty arraylist of integers
   * @param toList Empty array
   */
  private void copyArray(ArrayList<Integer> fromList, int[] toList) {
    for (int i = 0; i < toList.length; i++) {
      toList[i] = fromList.get(i);
    }
  }
  
  /**
   * Copy array to arraylist
   * @param fromList Non-empty array of integers
   * @param toList Empty arraylist
   */
  private void copyArray(int[] fromList, ArrayList<Integer> toList) {
    for (int i = 0; i < fromList.length; i++) {
      toList.add(fromList[i]);
    }
  }
  
  /**
   * Copy array to array
   * @param fromList Non-empty array of integers
   * @param toList Empty array
   */
  private void copyArray(int[] fromList, int[] toList) {
    for (int i = 0; i < fromList.length; i++) {
      toList[i] = fromList[i];
    }
  }
  
  /**
   * Prompt user to enter number of list elements of size n then 
   * prompt user to enter n integers in range -1000 to 1000
   * @return Non-empty arraylist of integers
   */
  public static ArrayList<Integer> setUserList() {
    
    // Number of elements in list
    int n = inputNumber();
    
    // Create new ArrayList object
    ArrayList<Integer> uList = new ArrayList<>();
    
    System.out.println("\nPlease enter integers in the range of -1000 to 1000.");
    
    // Loop to call inputNumber method to get user input and add it to arraylist
    for (int index = 1; index < n + 1; index++) {
      int i = inputNumber(index);      
      uList.add(i);
    }
    
    return uList;
  }
  
  /**
   * Prompt user to enter number of list elements 
   * @return Integer in range -1000 to 1000
   */
  private static int inputNumber() {
    
    // Variable used to hold user input
    int num = 0;
    
    // For ending user input in do-while loop
    boolean continueInput = true;
    
    // For user input validation
    do {
      
      // For data type validation
      try {
        
        // Prompt user for input
        System.out.print("Enter number of elements in list (Must be at least 20): ");
        num = INPUT.nextInt();
        
        // Validate integer is in range, if not continue loop 
        if (num < 20) {
          System.out.println("Try again. (Incorrect input: Must be at least 20");
          continue;
        }
        // If in range, break out of loop
        else {
          continueInput = false;
        }
                
      } // End try statement
      
      // Catch invalid data type input, clear input cache, continue loop
      catch (InputMismatchException e) {
        System.out.println("Try again. (Incorrect input: an integer is required.)");
        INPUT.nextLine();
      }
      
    } while (continueInput); // End of user input validation do-while loop
    
    return num;
    
  }
  
  /**
   * Prompt user to enter an integer in range -1000 to 1000
   * @param index Non-negative integer representing current element to be enter in list
   * @return Integer in range -1000 to 1000
   */
  private static int inputNumber(int index) {
    
    // Variable used to hold user input
    int num = 0;
    
    // For ending user input in do-while loop
    boolean continueInput = true;
    
    // For user input validation
    do {
      
      // For data type validation
      try {
        
        // Prompt user for input
        System.out.print("Enter number " + (index) + ": ");
        num = INPUT.nextInt();
        
        // Validate integer is in range, if not continue loop 
        if (num > 1000 || num < -1000) {
          System.out.println("Try again. (Incorrect input: -1000 through 1000 required.)");
          continue;
        }
        
        // If in range, break out of loop
        else {
          continueInput = false;
        }
        
      } // End try statement
      
      // Catch invalid data type input, clear input cache, continue loop
      catch (InputMismatchException e) {
        System.out.println("Try again. (Incorrect input: an integer is required.)");
        INPUT.nextLine();
      }
      
    } while (continueInput); // End of user input validation do-while loop
    
    return num;
    
  }
  
  /**
   * Get original list
   * @return Non-empty arraylist of integers
   */
  private ArrayList<Integer> getOList() {
    return oList;
  }
  
  /**
   * Display each element in arraylist
   * @param numList Non-empty arraylist of integers
   */
  private void displayList(ArrayList<Integer> numList) {
    for (Integer n: numList)
      System.out.print(n + " ");
  }
  
  /**
   * Display each element in array
   * @param numList Non-empty array of integers
   */
  private void displayList(int[] numList) {
    for (int n: numList) {
      System.out.print(n + " ");
    }
  }
  
  /**
   * Insertion sort method, increment insertion sort swap counter
   * for each element swap in list
   */
  private void insertionSort() {
    
    for (int i = 1; i < iList.size(); i++) {
      /** Insert list[i] into a sorted sublist list [0..i-1] so that
       *  list is sorted */
      int currentElement = iList.get(i);
      int k;
      for (k = i - 1; k >= 0 && iList.get(k) > currentElement; k--) {
        iList.set(k + 1, iList.get(k));
        iSwaps++; // Increment counter
      }
      
      // Insert the current element into list[k + 1]
      iList.set(k + 1, currentElement);
      iSwaps++; // Increment counter
    }
  }
  
  /**
   * Get number of insertion sort swaps
   * @return Non-negative integer
   */
  private int getISwaps() {
    return iSwaps;
  }
  
  /**
   * Get insertion sort list
   * @return Non-empty arraylist of integers
   */
  private ArrayList<Integer> getIList() {
    return iList;
  }
     
  /**
   * Bubble sort method, increment bubble sort swap counter for each
   * element swap in list
   */
  private void bubbleSort() {
    
    boolean needNextPass = true;
    
    for (int k = 1; k < bList.size() && needNextPass; k++) {
      // Array may be sorted and next pass not needed
      needNextPass = false;
      for (int i = 0; i < bList.size() - k; i++) {
        if (bList.get(i) > bList.get(i + 1)) {
          // Swap list[i] with list[i + 1]
          int temp = bList.get(i);
          bList.set(i, bList.get(i + 1));
          bSwaps++; // Increment counter
          bList.set(i + 1, temp);
          bSwaps++; // Increment counter
          needNextPass = true; // Next pass still needed
        }
      }
    }
  }
  
  /**
   * Get number of bubble sort swaps
   * @return Non-negative integer
   */
  private int getBSwaps() {
    return bSwaps;
  }
  
  /**
   * Get bubble sort list
   * @return Non-empty arraylist of integers
   */
  private ArrayList<Integer> getBList() {
    return bList;
  }
  
  /**
   * Merge sort method
   * @param list Non-empty array of integers
   */
  private void mergeSort(int[] list) {
    if (list.length > 1) {
      // Merge sort the first half
      int[] firstHalf = new int[list.length / 2];
      System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
      mergeSort(firstHalf);
      
      // Merge sort the second half
      int secondHalfLength = list.length - list.length / 2;
      int[] secondHalf = new int[secondHalfLength];
      System.arraycopy(list, list.length / 2,
        secondHalf, 0, secondHalfLength);
      mergeSort(secondHalf);
      
      // Merge firstHalf with secondHalf into list
      merge(firstHalf, secondHalf, list);
    }
  }
  
  /**
   * Merge sort helper function, increment merge sort swap counter for each
   * element swap in lists
   * @param list1 Non-empty array of integers
   * @param list2 Non-empty array of integers
   * @param temp Non-empty array of integers used for temporary swaps
   */
  private void merge(int[] list1, int[] list2, int[] temp) {
    int current1 = 0; // Current index in list1
    int current2 = 0; // Current index in list2
    int current3 = 0; // Current index in temp
        
    while (current1 < list1.length && current2 < list2.length) {
      if (list1[current1] < list2[current2]) {
        temp[current3++] = list1[current1++];
        mSwaps++; // Increment counter
      }
      else {
        temp[current3++] = list2[current2++];
        mSwaps++; // Increment counter
      }
    }
    
    while (current1 < list1.length) {
      temp[current3++] = list1[current1++];
      mSwaps++; // Increment counter
    }
    
    while (current2 < list2.length ) {
      temp[current3++] = list2[current2++];
      mSwaps++; // Increment counter
    }
  }
  
  /**
   * Get number of merge sort swaps
   * @return Non-negative integer
   */
  private int getMSwaps() {
    return mSwaps;
  }
  
  /**
   * Get merge sort list
   * @return Non-empty array of integers
   */
  private int[] getMList() {
    return mList;
  }
  
  /** 
   * Quick sort method
   * @param list Non-empty array of integers
   */
  private void quickSort(int[] list) {
    quickSort(list, 0, list.length - 1);
  }
  
  /**
   * Quick sort helper function
   * @param list Non-empty array of integers
   * @param first Non-negative integer represents index for forward search
   * @param last Non-negative integer represents index for backward search
   */
  private void quickSort(int[] list, int first, int last) {
    if (last > first) {
      int pivotIndex = partition(list, first, last);
      quickSort(list, first, pivotIndex - 1);
      quickSort(list, pivotIndex + 1, last);
    }
  }
  
  /** 
   * Partition the array list[first..last] and increment quick sort swap counter
   * for each element swap in lists
   * @param list Non-empty array of integers
   * @param first Non-negative integer used as index for forward search
   * @param last Non-negative integer used as index for backward search
   * @return Non-negative integer representing index of next pivot element
   */
  private int partition(int[] list, int first, int last) {
    int pivot = list[first]; // Choose the first element as the pivot
    int low = first + 1; // Index for forward search
    int high = last; // Index for backward search
    
    while (high > low) {
      // Search forward from left
      while ( low <= high && list[low] <= pivot)
        low++;
      
      // Search backward from right
      while (low <= high && list[high] > pivot)
        high--;
      
      // Swap two elements in the list
      if (high > low) {
        int temp = list[high];
        list[high] = list[low];
        qSwaps++; // Increment counter
        list[low] = temp;
        qSwaps++; // Increment counter
      }
    }
    
    while (high > first && list[high] >= pivot)
      high--;
    
    // Swap pivot with list[high]
    if (pivot > list[high]) {
      list[first] = list[high];
      qSwaps++; // Increment counter
      list[high] = pivot;
      qSwaps++; // Increment counter
      return high;
    }
    else {
      return first;
    }
  }
  
  /**
   * Get number of quick sort swaps
   * @return Non-negative integer
   */
  private int getQSwaps() {
    return qSwaps;
  }
  
  /**
   * Get quick sort list
   * @return Non-empty array of integers
   */
  private int[] getQList() {
    return qList;
  }
  
  /**
   * Display original list and all lists used by sorting algorithms, pre-sort
   * and post-sort, along with number of swaps performed by each algorithm
   */
  public void displayResults() {
    
    System.out.println("Unsorted list of " + oList.size() + " elements: ");
    displayList(getOList());
    
    
    System.out.println("\n\n----- INSERTION SORT -----");
    
    System.out.println("\nInsertion sort list - Pre-sort: ");
    displayList(getIList());
    
    insertionSort();
    
    System.out.println("\n\nInsertion sort list - Post-sort: ");
    displayList(getIList());
    
    System.out.println("\n\nInsertion sort swaps: " + getISwaps());    
    
    
    System.out.println("\n----- BUBBLE SORT -----");
    
    System.out.println("\nBubble sort list - Pre-sort: ");
    displayList(getBList());
    
    bubbleSort();
    
    System.out.println("\n\nBubble sort list - Post-sort: ");
    displayList(getBList());
    
    System.out.println("\n\nBubble sort swaps: " + getBSwaps());
    
    
    System.out.println("\n----- MERGE SORT -----");
    
    System.out.println("\nMerge sort list - Pre-sort: ");
    displayList(getMList());
    
    mergeSort(getMList());
    
    System.out.println("\n\nMerge sort list - Post-sort: ");
    displayList(getMList());
    
    System.out.println("\n\nMerge sort swaps: " + getMSwaps());
    
    
    System.out.println("\n----- QUICK SORT -----");
    
    System.out.println("\nQuick sort list - Pre-sort: ");
    displayList(getQList());
    
    quickSort(getQList());
    
    System.out.println("\n\nQuick sort list - Post-sort: ");
    displayList(getQList());
        
    System.out.println("\n\nQuick sort swaps: " + getQSwaps() + "\n");
  }
}