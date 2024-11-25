public class MaxProductSubarray {

    // Function to find the maximum product of a subarray
    public static long maxProduct(int[] arr) {
        int n = arr.length;
        
        // Edge case: If the array is empty or null
        if (arr == null || n == 0) {
            return 0;
        }
        
        long maxProdLeftToRight = arr[0]; // Track the max product from left to right
        long maxProdRightToLeft = arr[0]; // Track the max product from right to left
        long maxProd = arr[0]; // Overall maximum product
        
        // Left to Right Traversal
        long leftToRight = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                leftToRight = 1; // Reset product on encountering zero
            } else {
                leftToRight *= arr[i]; // Multiply the element with the running product
                maxProdLeftToRight = Math.max(maxProdLeftToRight, leftToRight); // Update max product
            }
        }
        
        // Right to Left Traversal
        long rightToLeft = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                rightToLeft = 1; // Reset product on encountering zero
            } else {
                rightToLeft *= arr[i]; // Multiply the element with the running product
                maxProdRightToLeft = Math.max(maxProdRightToLeft, rightToLeft); // Update max product
            }
        }
        
        // Return the maximum product found in both directions
        return Math.max(maxProdLeftToRight, maxProdRightToLeft);
    }

    public static void main(String[] args) {
        int[] arr1 = {-2, 6, -3, -10, 0, 2};
        System.out.println("Maximum Product Subarray: " + maxProduct(arr1)); // Output: 180
        
        int[] arr2 = {-1, -3, -10, 0, 6};
        System.out.println("Maximum Product Subarray: " + maxProduct(arr2)); // Output: 30
        
        int[] arr3 = {2, 3, 4};
        System.out.println("Maximum Product Subarray: " + maxProduct(arr3)); // Output: 24
    }
}
