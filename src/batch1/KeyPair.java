package batch1;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class KeyPair {

    /**
     * BRUTE APPROACH
     * TIME COMPLEXITY: O(n^2)
     * SPACE COMPLEXITY: O(1)
     */
    boolean hasArrayTwoCandidates(int arr[], int x) {

        for(int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] + arr[j] == x) return true;
            }
        }
        return false;
    }

    /*********** BETTER APPROACH *********************/
    /*
      Time Complexity: OO(n log n)
       Space Complexity: O(1)
     */
    boolean hasArrayTwoCandidatesTwoPointer(int arr[], int x) {

        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;

        while(left < right) {
            if(arr[left] + arr[right] > x) right--;
            else if(arr[left] + arr[right] < x) left++;
            else return true;
        }

        return false;
    }


    /************* OPTIMAL APPROACH **********************************/
    /*
      TIME COMPLEXITY: O(n)
      SPACE COMPLEXITY: O(n)
     */
    boolean hasArrayTwoCandidatesUsingHashSet(int arr[], int x) {
        Set<Integer> set = new HashSet<>();

        for(int num:arr) {
            if(set.contains(x - num)) return true;
            set.add(num);
        }
        return false;
    }
}
