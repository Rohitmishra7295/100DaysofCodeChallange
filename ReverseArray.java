
class ReverseArray{

    public static void revArr(int[] arr){

        int left=0; //left pinter initialized to 0th element
        int right=arr.length-1; //right pinter initialized to size-1 element

        while(left<right){
           int temp= arr[left];
           arr[left]=arr[right];
           arr[right]=temp;
           left++;
           right--;
           
        }
    }
    public static void main(String[] args) {
        int arr1[]={1,1,1,1,1,};
        int arr2[]={1,3,5,7,0,90,1};

       revArr(arr1);
        System.out.println(java.util.Arrays.toString(arr1));
       revArr(arr2);
        System.out.println(java.util.Arrays.toString(arr2));
    }
}