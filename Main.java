import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
      System.out.println("Unsorted Array ---------------------------------------------------");
      ArrayList<Integer> integerList = Lab4.getList();
      Lab4.outputList(integerList);

      System.out.println("\n\nBubble sort results ----------------------------------------------");
      long startTime = System.nanoTime();
      ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(integerList);
      long endTime = System.nanoTime();
      Lab4.outputList(bubbleSortedList);
      System.out.println("\nTime taken for Bubble Sort: " + (endTime - startTime));


      System.out.println("\n\nInsertion sort results -------------------------------------------");
      startTime = System.nanoTime();
      ArrayList<Integer> insertionSortedList = Lab4.bubbleSort(integerList);
      endTime = System.nanoTime();
      Lab4.outputList(insertionSortedList);
      System.out.println("\nTime taken for Insertion Sort: " + (endTime - startTime));
    }
}

class Lab4 {
  public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
    // Step 1 - Implement insertion sort algorithm here
    for (int i = 1; i < integerList.size(); i++) {
      int currentElement = integerList.get(i);
      int k;
      for (k = i - 1; k >= 0 && integerList.get(k) > currentElement; k--) {
        integerList.set(k + 1, currentElement);
      }
      integerList.set(k + 1, currentElement);
    }
    return integerList;
  }

  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
    // Step 2 - Implement the bubble sort algorithm here
    boolean needNextPass = true;
    for (int k = 1; k < integerList.size() && needNextPass; k++) {
      needNextPass = false;
      for (int i = 0; i < integerList.size() - k; i++) {
        if (integerList.get(i) > integerList.get(i +1)) {
          int temp = integerList.get(i);
          integerList.set(i, integerList.get(i + 1));
          integerList.set(i + 1, temp);
          
         }needNextPass = true; 
      }
    }
    return integerList;
  }

  public static ArrayList<Integer> getList() {
    ArrayList<Integer> integerList = new ArrayList<>();
    String line;
    try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
        while ((line = br.readLine()) != null) {
            integerList.add(Integer.parseInt(line));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return integerList;
  }

  public static void outputList(ArrayList<Integer> integerList) {
    for (int i = 0; i < integerList.size(); i++) {
        System.out.print(integerList.get(i) + " ");
    }
  }
}


// 1. If you were implementing a sort algorithm for a new language, which sort would you use?
// Answer: If I were implementing a sort algorithm for a new language, I would select merge sort because it has consistent O(n log n)
// time complexity regardless of input. This choice will help to provide stable sorting for large datasets.

// 2. Was there a difference in the time it took for bubble and insertion sort to run? Does this make sense given the time complexities for these sorting algorithms?
// Answer: Yes, there was a difference between bubble and insertion sort. They both have worst-case complexity of O(n^2) but because of its nature insertion sort usually outperforms
// bubble sort. It happens because insertion sort needs fewer swaps and comparisons. It is especially advantageous for smaller datasets.

// 3. Which sort algorithm has an easier implemenation (in terms of understanding) to you?
// Answer: Insertion sort is easier for me to understand because its implementaion is shorter. Also it is very easy to understand the way it swaps elements becauses it does it one item at a time.