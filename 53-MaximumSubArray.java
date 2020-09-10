53. Maximum Subarray

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
       int maxSumSoFar = nums[0];    // maxSum that needs to be returned at the end
       int maxContigousSum = nums[0];  // keep track of best possible sub problem sum
       for (int i=1; i < nums.length; i++) {
	   
            maxContigousSum = Math.max(nums[i], maxContigousSum  + nums[i]);
            maxSumSoFar = Math.max(maxSumSoFar, maxContigousSum); 
       } 
        
        return maxSumSoFar;
    }
}