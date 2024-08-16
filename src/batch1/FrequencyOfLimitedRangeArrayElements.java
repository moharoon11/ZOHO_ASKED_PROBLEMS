package batch1;

public class FrequencyOfLimitedRangeArrayElements {

    // Brute force
    // TC: O(n ^ 2) + O(n)
    // SC: O(n)
    public static void frequencyCount(int arr[], int N, int P) {
        // do modify in the given array
        int[] result = new int[N];
        for(int i=1; i<=P; i++) {
            int count = 0;
            for(int j=0; j<N; j++) {
                if(i == arr[j]) count++;
            }

            if(i <= N) {
                result[i-1] = count;
            }
        }

        for(int i=0; i<N; i++) {
            arr[i] = result[i];
        }
    }

    // Better approach
    // TC: O(2n)
    // SC: O(n)
    public static void countFrequency(int[] arr, int N, int P) {
        int[] frequency = new int[N];

        for(int i=0; i<N; i++) {
            if(arr[i] <= N) {
                frequency[arr[i] - 1]++;
            }
        }

        for(int i=0; i<frequency.length; i++) {
            arr[i] = frequency[i];
        }
    }

    // optimal solution
    // TC: O(2n) => we can ignore constant so O(n)
    // SC: O(1)
    public static void countTheFrequency(int arr[], int N, int P) {
        // do modify in the given array
        int i = 0;

        while(i < N) {

            if(arr[i] > N) {
                arr[i] = 0;
                continue;
            }

            if(arr[i] <= 0) {
                i++;
                continue;
            }

            int index = arr[i] - 1;

            if(arr[index] <= 0) {
                arr[index]--;
                arr[i] = 0;
                i++;
            } else {
                arr[i] = arr[index];
                arr[index] = -1;
            }
        }

        for(int j=0; j<N; j++) {
            arr[j] = Math.abs(arr[j]);
        }
    }
}
