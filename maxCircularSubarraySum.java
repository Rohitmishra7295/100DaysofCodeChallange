public class maxCircularSubarraySum {
    // Function to find the maximum sum of circular subarray
    public int circularSubarraySum(int[] arr) {
        int n = arr.length;

        // Step 1: Find non-circular max using Kadane's algorithm
        int maxKadane = kadane(arr);

        // Step 2: Find circular max
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            arr[i] = -arr[i]; // Invert the array to find the minimum subarray sum
        }

        // Minimum subarray sum using inverted array (Kadane's again)
        int maxInvertedKadane = kadane(arr);

        // Calculate the circular subarray sum (Total sum minus the minimum subarray sum)
        int circularMax = totalSum + maxInvertedKadane; // TotalSum - (-minSubarraySum)

        // Step 3: Return the maximum of non-circular and circular sums
        if (circularMax == 0) // This happens when all elements are negative
            return maxKadane;

        return Math.max(maxKadane, circularMax);
    }

    // Standard Kadane's algorithm to find max subarray sum
    private int kadane(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        maxCircularSubarraySum obj = new maxCircularSubarraySum(); // Fixed class name
        
        int[] arr1 = {8, -8, 9, -9, 10, -11, 12};
        System.out.println("Maximum Circular Subarray Sum: " + obj.circularSubarraySum(arr1)); // Output: 22

        int[] arr2 = {10, -3, -4, 7, 6, 5, -4, -1};
        System.out.println("Maximum Circular Subarray Sum: " + obj.circularSubarraySum(arr2)); // Output: 23

        int[] arr3 = {-1, 40, -14, 7, 6, 5, -4, -1};
        System.out.println("Maximum Circular Subarray Sum: " + obj.circularSubarraySum(arr3)); // Output: 52
    }
}
