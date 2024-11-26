/*Explanation of Changes:
Class Name: Changed the instantiation of obj to be of type maxCircularSubarraySum instead of Main as that was inconsistent with the class name.

Method Name: The method circularSubarraySum is called in the main method, which is consistent with the class method definition.

Edge Case Handling:

The edge case where all elements in the array are negative is handled by checking if the circular subarray sum (circularMax) is equal to 0 (i.e., when totalSum == -maxInvertedKadane).
If all elements are negative, the circular subarray is not valid, and the result should simply be the result of Kadane’s algorithm (the maximum subarray sum in the linear case).
Dry Run (for Test Case 1):
Let's walk through the test case arr = [8, -8, 9, -9, 10, -11, 12]:

Kadane's Algorithm (Non-Circular):

We find the maximum sum subarray using Kadane’s algorithm. The maximum sum is 12.
Inverting the Array:

We invert the array to find the minimum subarray sum. The inverted array is [-8, 8, -9, 9, -10, 11, -12].
Kadane's Algorithm (On Inverted Array):

The minimum sum subarray in the inverted array will be -11.
Total Sum:

The total sum of the original array is 22.
Circular Subarray Maximum:

circularMax = totalSum + maxInvertedKadane = 22 + (-11) = 33.
Final Result:

The final result is the maximum between maxKadane (which is 12) and circularMax (which is 33).
Thus, the maximum circular subarray sum is 33.
 */

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
