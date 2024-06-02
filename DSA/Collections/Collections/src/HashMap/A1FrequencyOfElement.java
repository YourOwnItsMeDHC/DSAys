//Problem: Given an array that may contain duplicates, print all elements, and their frequencies.

//        Note: Order of elements in output doesn't matter.

//        Examples:

//        Input :  arr[] = {10, 20, 20, 10, 10, 20, 5, 20}
//        Output : 10 3
//        20 4
//        5  1
//        10 appears 3 times in the array.
//        20 appears 4 times in the array.
//        5 appears once in the array.

//        Input : arr[] = {10, 20, 20}
//        Output : 10 1
//        20 2


package HashMap;

import java.util.HashMap;
import java.util.Map;

public class A1FrequencyOfElement {
    public static void main(String[] args) {
        int arr[] = {10, 20, 20, 10, 10, 20, 5, 20};

//        Approach - 01 :
//        Naive Solution: A simple solution is to run two loops. For every item count number of times, it occurs. To avoid duplicate printing,
//        keep track of processed items.
//        To avoid counting and printing frequencies of duplicate elements, we can simply run a loop on left of that element to check if it has
//        occurred previously
//         The time complexity of the above solution is O(N*N) in worst case
        System.out.println("Approach - 01 : Naive Solution");
        printFrequencies(arr);

        System.out.println();
//        Approach - 02 :
//        Efficient Solution: To solve this problem efficiently, we can use HashMap in Java. The idea is to store element as key and its
//        frequency as value as a key-value pair in HashMap.
//        Traverse through the array.
//        If the current element exists in the HashMap, increment its frequency in the HashMap.
//        Otherwise, insert this element as key with value 1 in the HashMap.
//        Finally, traverse the HashMap and print all elements with frequency
        System.out.println("Approach - 02 : Efficient Solution");
        printFrequenciesMap(arr);

    }

    public static void printFrequencies(int arr[]) {
        // Traverse through the array
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            // For every element check if it has occured previously
            for (int j = 0; j < i; j++) {
                if (arr[j] == arr[i]) {
                    flag = true;
                    break;
                }
            }
            // If current element has already occured move to next element
            if (flag == true) continue;
            int count = 1;
            // Otherwise, count its occurrences on right
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) count++;
            }
            // Print element along with its frequency
            System.out.println(arr[i] + " " + count);
        }
    }


    static void printFrequenciesMap(int arr[]) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry x : m.entrySet()) {
            System.out.println(x.getKey() + " " + x.getValue());
        }
    }
}
