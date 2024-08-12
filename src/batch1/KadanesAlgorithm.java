package batch1;


// MAXIMUM SUBARRAY SUM
public class KadanesAlgorithm {


    // brute approach
    // TIME COMPLEXITY: O(n^2)
    // SPACE COMPLEXITY: O(1)
    long maxSubarraySum(int[] arr) {
        long max = Long.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            int sum = 0;
            for(int j=i; j<arr.length; j++) {
                sum += arr[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    // OPTIMAL APPROACH
    // TIME COMPLEXITY: O(N)
    // SPACE COMPLEXITY: O(1)
    long maximumSubarraySum(int[] arr) {
        long maxSum = 0;
        long maxi = Long.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            maxSum += arr[i];

            maxi = Math.max(maxi, maxSum);

            if(maxSum < 0) {
                maxSum = 0;
            }
        }

        return maxi;
    }

    public static void main(String... args) {

    }
}
