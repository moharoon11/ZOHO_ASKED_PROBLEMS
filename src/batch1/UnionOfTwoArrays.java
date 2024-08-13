package batch1;

import java.util.Set;
import java.util.HashSet;

public class UnionOfTwoArrays {

    /*
      TIME COMPLEXITY: O(N + M)
      N IS LENGTH OF ARR1
      M IS LENGTH OF ARR2
      SPACE COMPLEXITY: O(N + M)
     */
    public static int doUnion(int arr1[], int arr2[]) {
        Set<Integer> union = new HashSet<Integer>();

        for(int ele:arr1) union.add(ele);
        for(int ele:arr2) union.add(ele);

        return union.size();
    }

    public static void main(String[] args) {

    }

}
