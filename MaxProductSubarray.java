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
