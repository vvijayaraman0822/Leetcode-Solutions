// 31. Next Permutation

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
           return;
        } 
        
        // second last element
        int i = nums.length - 2;
        
        /* keep iteration until the order is increasing from the last element. 
        *  When we finish the iteration, i will be at the index where i+1 was the last element 
        *  following the ascending order from the last element.
        */
        
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        
        /* i is not the fist element so we still have some work to do. (find the next greatest element)
        *  if i == 1, we just need to reverse the array since the order is strictly descending.
        */ 
        
        // Now we need to find the next greatest element than the ith value to swap. 
        if (i >= 0) {
            
            int j = nums.length - 1; // iterate from end of the array
            
            // j will have the next greatest element after this ( This works because the elements between i and j are in descending order)
            while(j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            
            // Swap the next greatest element 
            swap(nums, i, j);
        }
            
            // Reverse the descending order array to ascending
            reverse(nums, i + 1, nums.length-1);            
    }

  
        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
        public void reverse(int[] nums, int start, int end) {
            while(start < end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
}