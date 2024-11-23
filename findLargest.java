/*Edge Case: Handles empty arrays and negative values gracefully.
Time Complexity: O(n), as it iterates through the array once.
Space Complexity: O(1), constant space usage.*/


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
