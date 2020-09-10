// 33. Search in Rotated Sorted Array

class Solution {
    public int search(int[] nums, int target) {
        
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[start] <= nums[mid]) { // you are on the left half of the array (left half is sorted )
               if (target >= nums[start] && target <= nums[mid]) {
                   end = mid - 1; // search in the left half
               } else {
                   start = mid + 1;
               }
            } else { // you are on the right half of the array (right half is sorted)
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid + 1; // search in the right half
                } else {
                    end = mid - 1;
                }
            }
        }      
        
         return -1;
    }
}
      