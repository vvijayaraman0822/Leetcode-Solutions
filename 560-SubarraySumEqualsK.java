// 560. Subarray Sum Equals K


class Solution {
    public int subarraySum(int[] nums, int k) {
       if (nums == null || nums.length == 0) {
           return 0;
       }
        Map<Integer, Integer> count = new HashMap<>();
        int counter = 0;
        int runningSum = 0;
        for(int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            int difference = runningSum - k;
            
            if (runningSum == k) {
                counter++;
            }
            
            if (count.get(difference) != null) {
                counter += count.get(difference);
            }
            
            count.put(runningSum, count.getOrDefault(runningSum, 0) + 1);    
            
        }
        
        return counter;
        
    }
}