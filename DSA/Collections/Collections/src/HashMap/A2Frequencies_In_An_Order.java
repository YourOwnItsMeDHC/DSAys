// Problem: Given an array of integers, the task is to print the frequencies of elements
// of the array inthe order they appear in the array.
// That is the element that appeared first, print frequency of it before
// the element which appeared after it in the array.

//        Example:

//        Input: arr[] = {10, 15, 20, 15, 10, 15}
//        Output:
//        10 2
//        15 3
//        20 1

//        Input: arr[] = {10, 10, 20, 20, 20, 10, 10}
//        Output:
//        10 4
//        20 2

//        We discussed a similar problem before for which the order of output doesn't matter.
//        Let's try to modify the approach in that problem
//        to solve this problem.

package HashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class A2Frequencies_In_An_Order {
    public static void main(String[] args) {
        int arr[] = {10, 20, 20, 10, 10, 20, 5, 20};

//        Approach - 01 (Using HashMap) :
//        We can use a HashMap to store frequencies for every element as discussed in the previous problem.
//        Traverse through the array.
//        If the current element exists in the HashMap, increment its frequency in the HashMap.
//        Otherwise, insert this element as key with value 1 in the HashMap.
//        Now, to ensure that we print elements with frequencies in the same order they appear in the input array, we can traverse the input
//        array again, and initialize its frequency as -1 in the HashMap after printing it. By doing this, we can ensure that we don't print the
//        frequency of it again for its further occurrences
        System.out.println("Approach - 01 : Using HashMap");
        printFrequenciesHashMap(arr);

        System.out.println();
//        Approach - 02 :
//        The idea is to use LinkedHashMap instead of HashMap.
//        A LinkedHashMap in Java uses a doublylinked list internally to
//        maintain the order of elements. So, the idea is exactly the same as above,
//        we need to count frequency and store it in a
//        LinkedHashMap instead of HashMap and simply traverse an print the content of LinkedHashMap
//        as it already maintains order of elements internally
        System.out.println("Approach - 02 : Using TreeMap");
        printFrequenciesTreeMap(arr);
    }

    static void printFrequenciesHashMap(int arr[]) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            int freq = m.get(arr[i]);

            if (freq != -1) {
                System.out.println(arr[i] + " " + freq);
                m.put(arr[i], -1);
            }
        }
    }



    static void printFrequenciesTreeMap(int arr[]) {
        Map<Integer, Integer> m =
                new LinkedHashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> x : m.entrySet()) {
            System.out.println(x.getKey() + " " + x.getValue());
        }
    }

}



 /*     OUTPUT
Approach - 01 : Using HashMap
10 3
20 4
5 1

Approach - 02 : Using TreeMap
10 3
20 4
5 1
*/