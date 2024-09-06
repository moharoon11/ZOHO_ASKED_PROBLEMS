package Arrays;

public class KadanesAlgo {


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


    // optimal approach
    //kadane's algorithm
    public static long getMax(int[] arr, int n) {
        long maxSum = Integer.MIN_VALUE;
        long sum = 0;

        for(int num: arr) {
            sum += num;
            maxSum = Math.max(maxSum, sum);
            if(sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,-7, 4,5,6};
    }
}
