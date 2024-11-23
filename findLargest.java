/*Edge Case: Handles empty arrays and negative values gracefully.
Example Walkthrough:
Example 1:
Input: {1, 8, 7, 56, 90}

Initialization:

max = arr[0] = 1
Iterating through the array:

arr[1] = 8, 8 > 1, update max = 8
arr[2] = 7, 7 < 8, no change
arr[3] = 56, 56 > 8, update max = 56
arr[4] = 90, 90 > 56, update max = 90
Final result:
Return max = 90.

 
Check if the array is empty:

If yes, print a message and return a sentinel value (Integer.MIN_VALUE).
Initialize max with the first element:

Set max to arr[0] to start the comparison.
Iterate through the rest of the array:

Compare each element (arr[i]) with max. If arr[i] > max, update max.
Return max:

After finishing the loop, return the value stored in max as the largest element in the array.


Time Complexity: O(n), because we make one pass through the array.
Space Complexity: O(1), since we use only a few extra variables for tracking the max value and iterating through the array.*/


class Solution1 {
    
    public static int largest(int arr[]) {
        if (arr.length == 0) {
            System.out.println("Array is empty. Cannot find maximum value.");
            return Integer.MIN_VALUE; 
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;  
    }

    public static void main(String[] args) {
        int arr[] = {1, 8, 7, 56, 90};

        
        int res = largest(arr);
        System.out.println("Max is " + res);  
    }
}
