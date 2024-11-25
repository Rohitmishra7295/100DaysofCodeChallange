/*
The code initializes maxProdLeftToRight, maxProdRightToLeft, and maxProd to the first element of the array, ensuring we have a baseline value to start with.
Left-to-Right Traversal:

We traverse the array from left to right. For each element, we multiply it with the running product (leftToRight). If the product becomes negative, we reset it by encountering zero. We continuously update the maximum product encountered so far during the traversal.
Right-to-Left Traversal:

This is similar to the left-to-right traversal, except the array is traversed in reverse. We again multiply the elements and track the maximum product encountered.
Final Result:

The function returns the maximum product found from either the left-to-right traversal or the right-to-left traversal.
Time Complexity:
O(n): We traverse the array twice — once from left to right and once from right to left. Each traversal takes linear time.
Space Complexity:
O(1): We use a constant amount of space to track the products (leftToRight, rightToLeft, maxProd).
Example Walkthrough:
For the array {-2, 6, -3, -10, 0, 2}:

Left-to-right traversal:

At index 0: leftToRight = -2, maxProdLeftToRight = -2
At index 1: leftToRight = -2 * 6 = -12, maxProdLeftToRight = -2
At index 2: leftToRight = -12 * -3 = 36, maxProdLeftToRight = 36
At index 3: leftToRight = 36 * -10 = -360, maxProdLeftToRight = 36
At index 4: leftToRight = -360 * 0 = 0, maxProdLeftToRight = 36
At index 5: leftToRight = 0 * 2 = 0, maxProdLeftToRight = 36
Right-to-left traversal:

At index 5: rightToLeft = 2, maxProdRightToLeft = 2
At index 4: rightToLeft = 2 * 0 = 0, maxProdRightToLeft = 2
At index 3: rightToLeft = 0 * -10 = 0, maxProdRightToLeft = 2
At index 2: rightToLeft = 0 * -3 = 0, maxProdRightToLeft = 2
At index 1: rightToLeft = 0 * 6 = 0, maxProdRightToLeft = 2
At index 0: rightToLeft = 0 * -2 = 0, maxProdRightToLeft = 2
Final Result:

The maximum product subarray is 180, as it was found in the left-to-right traversal.


Alogrithm

Left-to-Right Traversal:

Traverse the array from left to right, maintaining a running product.
If the product becomes negative, reset it.
Track the maximum product seen so far.
Right-to-Left Traversal:

Traverse the array from right to left and repeat the process.
Similarly, handle the negative product case and keep track of the maximum product.
Final Result:

The result will be the maximum product found in either traversal.
*/




public class MaxProductSubarray {
    public static long maxProduct(int[] arr) {
        int n = arr.length;
        
        // Edge case: If the array is empty or null
        if (arr == null || n == 0) {
            return 0;
        }
        
        long maxProdLeftToRight = arr[0]; 
        long maxProdRightToLeft = arr[0]; 
        long maxProd = arr[0];
        
        // Left to Right Traversal
        long leftToRight = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                leftToRight = 1;
            } else {
                leftToRight *= arr[i]; 
                maxProdLeftToRight = Math.max(maxProdLeftToRight, leftToRight); 
            }
        }
        
       
        long rightToLeft = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                rightToLeft = 1; 
            } else {
                rightToLeft *= arr[i];
                maxProdRightToLeft = Math.max(maxProdRightToLeft, rightToLeft);
            }
        }
        

        return Math.max(maxProdLeftToRight, maxProdRightToLeft);
    }

    public static void main(String[] args) {
        int[] arr1 = {-2, 6, -3, -10, 0, 2};
        System.out.println("Maximum Product Subarray: " + maxProduct(arr1)); 
        
        int[] arr2 = {-1, -3, -10, 0, 6};
        System.out.println("Maximum Product Subarray: " + maxProduct(arr2)); 
        
        int[] arr3 = {2, 3, 4};
        System.out.println("Maximum Product Subarray: " + maxProduct(arr3)); 
    }
}
