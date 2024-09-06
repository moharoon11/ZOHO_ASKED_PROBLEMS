package Arrays;

import java.util.*;

public class ArrayDuplicates {

    /** Brute approach
     * Time Complexity: O(n2)O(n2)
     * Space Complexity: O(1)O(1) (not counting the output list)
     */
    public static ArrayList<Integer> findDuplicates(int n, int[] arr) {
        ArrayList<Integer> duplicatesList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] && !duplicatesList.contains(arr[i])) {
                    duplicatesList.add(arr[i]);
                }
            }
        }

        if (duplicatesList.isEmpty()) {
            duplicatesList.add(-1);
        }

        return duplicatesList;
    }



    /**
     * Better approach
     Time Complexity:

     Building the Frequency Map: This step is O(n).
     Iterating to Find Duplicates: This step is O(n).
     Sorting the Duplicates List: Sorting takes O(m log m), where m is the number of duplicate elements found. In the worst case, m could be n, thus O(n log n).

     Final Time Complexity: O(n + m log m). However, since m≤nm≤n, in the worst case, it simplifies to O(n log n).
     Space Complexity:

     Frequency Map: O(n) space for storing frequencies.
     Duplicates List: O(n) space in the worst case if all elements are duplicates.

     Final Space Complexity: O(n).
     **/
    public static ArrayList<Integer> duplicates(int[] arr) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        ArrayList<Integer> duplicatesList = new ArrayList<>();
        for(int i=0;i<arr.length; i++) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        for(Integer key:frequencyMap.keySet()) {
            if(frequencyMap.get(key) > 1) {
                duplicatesList.add(key);
            }
        }

        Collections.sort(duplicatesList);

        if(duplicatesList.isEmpty()) {
            duplicatesList.add(-1);
        }

        return duplicatesList;
    }


    // TIME COMPLEXITY: SAME AS BEFORE O(n log n)
    // WE DONT USE EXTRA SPACE LIKE HASHSET
    // SPACE COMPLEXITY: O(1)
    public static List<Integer> findDuplicates(int[] arr) {
        // Convert the array to a list for easy manipulation
        List<Integer> duplicatesList = new ArrayList<>();

        // Edge case: If the array is empty
        if (arr.length == 0) {
            duplicatesList.add(-1);
            return duplicatesList;
        }

        // Sort the array
        Arrays.sort(arr);

        // Find duplicates by comparing adjacent elements
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] && (duplicatesList.isEmpty() || !duplicatesList.get(duplicatesList.size() - 1).equals(arr[i]))) {
                duplicatesList.add(arr[i]);
            }
        }

        // If no duplicates found, return [-1]
        if (duplicatesList.isEmpty()) {
            duplicatesList.add(-1);
        }

        return duplicatesList;
    }

    public static void main(String[] args) {

    }
}
