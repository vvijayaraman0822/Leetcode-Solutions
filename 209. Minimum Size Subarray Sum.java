// 209. Minimum Size Subarray Sum

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int minSize = Integer.MAX_VALUE;
        
        // Use sliding window principle. For every element in the array, find minimum window.
        // If the sum >= s, move the left pointer to reduce the length
        int runningSum = 0;
        int counter = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            counter++;
            
            while (runningSum >= s) {
                minSize = Math.min(minSize, counter); 
                runningSum = runningSum - nums[left]; // subtract left first before incrementing the leftPointer, otherwise a bug.
                left++;
                counter--;
            }   
            
        }
        
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
            
            
    }
}