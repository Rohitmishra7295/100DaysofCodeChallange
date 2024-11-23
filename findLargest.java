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

 
Steps for an Optimal Solution:

Initial Setup:
Start by initializing a variable (max) to hold the maximum value found in the array. Set it to the first element of the array, or in some cases, a very low value (like Integer.MIN_VALUE for large numbers).

Edge Case Handling (Empty Array):
Before proceeding to find the maximum value, check if the array is empty (arr.length == 0). If it's empty, print a message that the array is empty and terminate the function early. This ensures no errors occur during execution (such as trying to access arr[0] in an empty array).

Iterate through the Array:
Traverse through the array starting from the second element (since the first element is used to initialize max).

For each element, compare it with the current value of max. If the element is greater than max, update max with the new value.
Output the Result:

After the iteration is complete, print the max value, which will now contain the maximum element from the array.


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
