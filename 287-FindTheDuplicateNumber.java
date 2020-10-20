// 287. Find the Duplicate Number

// Floyd Detection Algorithm  
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0]; 
        
        do {
          slow = nums[slow]; // slow moves once
          fast = nums[nums[fast]]; // fast moves twice
        } while (slow != fast);
        
        slow = nums[0];
        while(fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return fast;
            
    }
}