// 912. Sort an Array
class Solution {
    public int[] sortArray(int[] nums) {
        // Implementation of Quick Sort Algorithm
        if (nums == null || nums.length == 0)
            return nums;
        else
            return quickSort(nums, 0, nums.length-1);
      
    }
    
    private int[] quickSort(int[] arr, int begin, int end) {
        
        if(begin < end) {
            int PartitionIndex = Partition(arr, begin, end);
            quickSort(arr, begin, PartitionIndex-1);
            quickSort(arr, PartitionIndex+1, end);
        }
        
        return arr;
    }
    
    private int Partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = begin-1;
        
        for(int j = begin; j < end; j++){
            if(arr[j] <= pivot) {
                i++;
                int swap = arr[j];
                arr[j] = arr[i];
                arr[i] = swap;
            }
        }
        int swap = arr[end];
        arr[end] = arr[i + 1];
        arr[i + 1] = swap;
        return i+1;
    }
}