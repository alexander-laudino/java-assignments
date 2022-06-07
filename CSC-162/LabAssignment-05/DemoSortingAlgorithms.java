import java.util.ArrayList;

/**
 * <h1>Count Swaps</h1>
 * <p>Dr. Farrett - Lab Assignment 5</p>
 * <p>This program counts the number of swaps in various sorting algorithms,
 * it tests each method with various arrays of integers (user input, a 
 * static list, and 3 randomly-generated arrays of size 20, 30, and 40), 
 * and displays the results</p>
 * @author Alexander Laudino
 * @since 2021-10-07
 * @version 1.0
 *
 */
public class DemoSortingAlgorithms {
  /**
   * Main method
   * @param args Command-prompt arguments
   */
  public static void main(String[] args) {
    
    // Create new ArrayList of SortAlgorithms objects
    ArrayList<SortAlgorithms> algos = new ArrayList<>();
    
    // Prompt user for input and display results
    algos.add( new SortAlgorithms(SortAlgorithms.setUserList()));
    ((SortAlgorithms) algos.get(0)).displayResults();
    
    int[] list = {97, -2, 17, 22, 31, 42, -85, -13, 9, 64,
        56, -62, 10, -71, 3, 23, -20, 8, 87, 43};
    
    // Test array and display results
    algos.add( new SortAlgorithms(list));
    ((SortAlgorithms) algos.get(1)).displayResults();
    
    // Randomly-generated array of size 20 
    algos.add( new SortAlgorithms());
    ((SortAlgorithms) algos.get(2)).displayResults();
    
    // Randomly-generated array of size 30
    algos.add( new SortAlgorithms(30));
    ((SortAlgorithms) algos.get(3)).displayResults();
    
    // Randomly-generated array of size 40
    algos.add( new SortAlgorithms(40));
    ((SortAlgorithms) algos.get(4)).displayResults();
        
  }
}

/*

Enter number of elements in list (Must be at least 20): a
Try again. (Incorrect input: an integer is required.)
Enter number of elements in list (Must be at least 20): -1
Try again. (Incorrect input: Must be at least 20
Enter number of elements in list (Must be at least 20): 15
Try again. (Incorrect input: Must be at least 20
Enter number of elements in list (Must be at least 20): 20

Please enter integers in the range of -1000 to 1000.
Enter number 1: a
Try again. (Incorrect input: an integer is required.)
Enter number 1: -2000
Try again. (Incorrect input: -1000 through 1000 required.)
Enter number 1: 2000
Try again. (Incorrect input: -1000 through 1000 required.)
Enter number 1: 1
Enter number 2: 1
Enter number 3: 2
Enter number 4: 3
Enter number 5: 5
Enter number 6: 8
Enter number 7: 13
Enter number 8: 21
Enter number 9: 34
Enter number 10: 55
Enter number 11: -55
Enter number 12: -34
Enter number 13: -21
Enter number 14: -13
Enter number 15: -8
Enter number 16: -5
Enter number 17: -3
Enter number 18: -2
Enter number 19: -1
Enter number 20: -1
Unsorted list of 20 elements: 
1 1 2 3 5 8 13 21 34 55 -55 -34 -21 -13 -8 -5 -3 -2 -1 -1 

----- INSERTION SORT -----

Insertion sort list - Pre-sort: 
1 1 2 3 5 8 13 21 34 55 -55 -34 -21 -13 -8 -5 -3 -2 -1 -1 

Insertion sort list - Post-sort: 
-55 -34 -21 -13 -8 -5 -3 -2 -1 -1 1 1 2 3 5 8 13 21 34 55 

Insertion sort swaps: 119

----- BUBBLE SORT -----

Bubble sort list - Pre-sort: 
1 1 2 3 5 8 13 21 34 55 -55 -34 -21 -13 -8 -5 -3 -2 -1 -1 

Bubble sort list - Post-sort: 
-55 -34 -21 -13 -8 -5 -3 -2 -1 -1 1 1 2 3 5 8 13 21 34 55 

Bubble sort swaps: 200

----- MERGE SORT -----

Merge sort list - Pre-sort: 
1 1 2 3 5 8 13 21 34 55 -55 -34 -21 -13 -8 -5 -3 -2 -1 -1 

Merge sort list - Post-sort: 
-55 -34 -21 -13 -8 -5 -3 -2 -1 -1 1 1 2 3 5 8 13 21 34 55 

Merge sort swaps: 88

----- QUICK SORT -----

Quick sort list - Pre-sort: 
1 1 2 3 5 8 13 21 34 55 -55 -34 -21 -13 -8 -5 -3 -2 -1 -1 

Quick sort list - Post-sort: 
-55 -34 -21 -13 -8 -5 -3 -2 -1 -1 1 1 2 3 5 8 13 21 34 55 

Quick sort swaps: 38

Unsorted list of 20 elements: 
97 -2 17 22 31 42 -85 -13 9 64 56 -62 10 -71 3 23 -20 8 87 43 

----- INSERTION SORT -----

Insertion sort list - Pre-sort: 
97 -2 17 22 31 42 -85 -13 9 64 56 -62 10 -71 3 23 -20 8 87 43 

Insertion sort list - Post-sort: 
-85 -71 -62 -20 -13 -2 3 8 9 10 17 22 23 31 42 43 56 64 87 97 

Insertion sort swaps: 115

----- BUBBLE SORT -----

Bubble sort list - Pre-sort: 
97 -2 17 22 31 42 -85 -13 9 64 56 -62 10 -71 3 23 -20 8 87 43 

Bubble sort list - Post-sort: 
-85 -71 -62 -20 -13 -2 3 8 9 10 17 22 23 31 42 43 56 64 87 97 

Bubble sort swaps: 192

----- MERGE SORT -----

Merge sort list - Pre-sort: 
97 -2 17 22 31 42 -85 -13 9 64 56 -62 10 -71 3 23 -20 8 87 43 

Merge sort list - Post-sort: 
-85 -71 -62 -20 -13 -2 3 8 9 10 17 22 23 31 42 43 56 64 87 97 

Merge sort swaps: 88

----- QUICK SORT -----

Quick sort list - Pre-sort: 
97 -2 17 22 31 42 -85 -13 9 64 56 -62 10 -71 3 23 -20 8 87 43 

Quick sort list - Post-sort: 
-85 -71 -62 -20 -13 -2 3 8 9 10 17 22 23 31 42 43 56 64 87 97 

Quick sort swaps: 36

Unsorted list of 20 elements: 
-799 -708 456 887 718 26 -887 -688 755 -869 -272 936 588 -109 637 445 -64 -699 636 211 

----- INSERTION SORT -----

Insertion sort list - Pre-sort: 
-799 -708 456 887 718 26 -887 -688 755 -869 -272 936 588 -109 637 445 -64 -699 636 211 

Insertion sort list - Post-sort: 
-887 -869 -799 -708 -699 -688 -272 -109 -64 26 211 445 456 588 636 637 718 755 887 936 

Insertion sort swaps: 105

----- BUBBLE SORT -----

Bubble sort list - Pre-sort: 
-799 -708 456 887 718 26 -887 -688 755 -869 -272 936 588 -109 637 445 -64 -699 636 211 

Bubble sort list - Post-sort: 
-887 -869 -799 -708 -699 -688 -272 -109 -64 26 211 445 456 588 636 637 718 755 887 936 

Bubble sort swaps: 172

----- MERGE SORT -----

Merge sort list - Pre-sort: 
-799 -708 456 887 718 26 -887 -688 755 -869 -272 936 588 -109 637 445 -64 -699 636 211 

Merge sort list - Post-sort: 
-887 -869 -799 -708 -699 -688 -272 -109 -64 26 211 445 456 588 636 637 718 755 887 936 

Merge sort swaps: 88

----- QUICK SORT -----

Quick sort list - Pre-sort: 
-799 -708 456 887 718 26 -887 -688 755 -869 -272 936 588 -109 637 445 -64 -699 636 211 

Quick sort list - Post-sort: 
-887 -869 -799 -708 -699 -688 -272 -109 -64 26 211 445 456 588 636 637 718 755 887 936 

Quick sort swaps: 36

Unsorted list of 30 elements: 
289 -846 177 -831 -574 468 -89 718 54 -684 -409 246 919 -926 -324 140 -36 725 -160 983 -872 652 -695 240 -399 656 -746 -217 538 362 

----- INSERTION SORT -----

Insertion sort list - Pre-sort: 
289 -846 177 -831 -574 468 -89 718 54 -684 -409 246 919 -926 -324 140 -36 725 -160 983 -872 652 -695 240 -399 656 -746 -217 538 362 

Insertion sort list - Post-sort: 
-926 -872 -846 -831 -746 -695 -684 -574 -409 -399 -324 -217 -160 -89 -36 54 140 177 240 246 289 362 468 538 652 656 718 725 919 983 

Insertion sort swaps: 226

----- BUBBLE SORT -----

Bubble sort list - Pre-sort: 
289 -846 177 -831 -574 468 -89 718 54 -684 -409 246 919 -926 -324 140 -36 725 -160 983 -872 652 -695 240 -399 656 -746 -217 538 362 

Bubble sort list - Post-sort: 
-926 -872 -846 -831 -746 -695 -684 -574 -409 -399 -324 -217 -160 -89 -36 54 140 177 240 246 289 362 468 538 652 656 718 725 919 983 

Bubble sort swaps: 394

----- MERGE SORT -----

Merge sort list - Pre-sort: 
289 -846 177 -831 -574 468 -89 718 54 -684 -409 246 919 -926 -324 140 -36 725 -160 983 -872 652 -695 240 -399 656 -746 -217 538 362 

Merge sort list - Post-sort: 
-926 -872 -846 -831 -746 -695 -684 -574 -409 -399 -324 -217 -160 -89 -36 54 140 177 240 246 289 362 468 538 652 656 718 725 919 983 

Merge sort swaps: 148

----- QUICK SORT -----

Quick sort list - Pre-sort: 
289 -846 177 -831 -574 468 -89 718 54 -684 -409 246 919 -926 -324 140 -36 725 -160 983 -872 652 -695 240 -399 656 -746 -217 538 362 

Quick sort list - Post-sort: 
-926 -872 -846 -831 -746 -695 -684 -574 -409 -399 -324 -217 -160 -89 -36 54 140 177 240 246 289 362 468 538 652 656 718 725 919 983 

Quick sort swaps: 62

Unsorted list of 40 elements: 
-572 -930 -488 412 341 458 451 -411 402 -246 -417 585 177 -27 824 618 -705 -894 -32 255 619 729 -189 325 660 -260 442 124 -120 -101 526 -821 -360 -623 643 91 253 15 -977 610 

----- INSERTION SORT -----

Insertion sort list - Pre-sort: 
-572 -930 -488 412 341 458 451 -411 402 -246 -417 585 177 -27 824 618 -705 -894 -32 255 619 729 -189 325 660 -260 442 124 -120 -101 526 -821 -360 -623 643 91 253 15 -977 610 

Insertion sort list - Post-sort: 
-977 -930 -894 -821 -705 -623 -572 -488 -417 -411 -360 -260 -246 -189 -120 -101 -32 -27 15 91 124 177 253 255 325 341 402 412 442 451 458 526 585 610 618 619 643 660 729 824 

Insertion sort swaps: 418

----- BUBBLE SORT -----

Bubble sort list - Pre-sort: 
-572 -930 -488 412 341 458 451 -411 402 -246 -417 585 177 -27 824 618 -705 -894 -32 255 619 729 -189 325 660 -260 442 124 -120 -101 526 -821 -360 -623 643 91 253 15 -977 610 

Bubble sort list - Post-sort: 
-977 -930 -894 -821 -705 -623 -572 -488 -417 -411 -360 -260 -246 -189 -120 -101 -32 -27 15 91 124 177 253 255 325 341 402 412 442 451 458 526 585 610 618 619 643 660 729 824 

Bubble sort swaps: 758

----- MERGE SORT -----

Merge sort list - Pre-sort: 
-572 -930 -488 412 341 458 451 -411 402 -246 -417 585 177 -27 824 618 -705 -894 -32 255 619 729 -189 325 660 -260 442 124 -120 -101 526 -821 -360 -623 643 91 253 15 -977 610 

Merge sort list - Post-sort: 
-977 -930 -894 -821 -705 -623 -572 -488 -417 -411 -360 -260 -246 -189 -120 -101 -32 -27 15 91 124 177 253 255 325 341 402 412 442 451 458 526 585 610 618 619 643 660 729 824 

Merge sort swaps: 216

----- QUICK SORT -----

Quick sort list - Pre-sort: 
-572 -930 -488 412 341 458 451 -411 402 -246 -417 585 177 -27 824 618 -705 -894 -32 255 619 729 -189 325 660 -260 442 124 -120 -101 526 -821 -360 -623 643 91 253 15 -977 610 

Quick sort list - Post-sort: 
-977 -930 -894 -821 -705 -623 -572 -488 -417 -411 -360 -260 -246 -189 -120 -101 -32 -27 15 91 124 177 253 255 325 341 402 412 442 451 458 526 585 610 618 619 643 660 729 824 

Quick sort swaps: 94

*/