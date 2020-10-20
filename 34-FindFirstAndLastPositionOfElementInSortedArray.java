// 34. Find First and Last Position of Element in Sorted Array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }
        
        int[] arr = new int[2];
        arr[0] = findStartingIndex(nums, target);
        arr[1] = findEndingIndex(nums, target);
     
        return arr;
    }
    
    public int findStartingIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int index = -1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (nums[mid] >= target) { // greater than or equal here because if there are consecutive targets, you are still trying to find the first occurence
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            
            if (nums[mid] == target) { // we have the last reference where the mid was equal to target on the left side
                index = mid;
            }
        }           
        
        return index;
    }
    
    
      public int findEndingIndex(int[] nums, int target) {
          int start = 0;
          int end = nums.length-1;
          int index = -1;
                 
          while (start <= end) {
            int mid = (start + end) / 2;
            
            if (nums[mid] <= target) { // greater than or equal here because if there are consecutive targets, you are still trying to find the last occurence
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            
            if (nums[mid] == target) { // we have the last reference where the mid was equal to target on the right side
                index = mid;
            }
          }
          
          return index;
          
      }
}
    
    