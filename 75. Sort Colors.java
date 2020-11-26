// 75. Sort Colors (Naive Solution)

class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }  
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        int zeroCount = map.getOrDefault(0, 0);
        int oneCount = map.getOrDefault(1, 0);
        int twoCount = map.getOrDefault(2, 0);
        
        int pointer = 0;
        
        for(int i = 0; i < zeroCount; i++) {
            nums[pointer++] = 0;
        }
        
        for(int i = 0; i < oneCount; i++) {
            nums[pointer++] = 1;
        }
        
         for(int i = 0; i < twoCount; i++) {
            nums[pointer++] = 2;
        }
        
    }
}


// One pass, two pointer algorithm
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int currIndex = 0;
        int start = 0;
        int end = nums.length - 1;
        
        while (currIndex <= end && start < end) {
            if (nums[currIndex] == 0) {
                nums[currIndex] = nums[start];
                nums[start] = 0;
                currIndex++;
                start++;                                
            } else if (nums[currIndex] == 2) {
                nums[currIndex] = nums[end];
                nums[end] = 2;
                end--;
            } else {
                currIndex++;
            }
        }        
    }
}