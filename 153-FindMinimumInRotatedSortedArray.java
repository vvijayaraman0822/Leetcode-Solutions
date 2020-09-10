153. Find Minimum in Rotated Sorted Array

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
           return nums[0];
       } 
        int start = 0;
        int end = nums.length - 1;
       return returnMin(nums, start, end);
    }
        
        public int returnMin(int[] nums, int start, int end) {
            while (start < end) {
            int mid = (start + end) / 2;
            
            // No rotation if last element is greater than first element    
            if (nums[end] > nums[0]) {
                return nums[0];
            }
                
             // if mid element greater than mid+1 element, it means rotation starts at mid + 1    
             if (nums[mid] > nums[mid + 1]) {
                return nums[mid+1];
            }    
              
             // if mid element lesser than mid-1  element, it means rotation starts at mid      
            if (nums[mid] < nums[mid-1]) {
                return nums[mid];
            }
            
            if (nums[mid] < nums[end]) {
                end = mid - 1;
            } else {
                start = mid + 1;
                }
            }
            
            return -1;
        }
}

