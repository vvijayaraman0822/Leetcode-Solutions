// 15. 3Sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> outputList = new ArrayList<>();
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        
        for(int i=0; i < nums.length-2; i++) {
            int start = i+1;
            int end = nums.length - 1;
            
            while(start < end) {
                if (nums[i] + nums[start] + nums[end] > 0) {
                   end--; 
                } else if (nums[i] + nums[start] + nums[end] < 0) {
                    start++;
                } else {
                    if(!set.contains(new Pair(nums[start], nums[end]))) {
                        outputList.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        set.add(new Pair(nums[start], nums[end]));
                    }
                    start++;
                    end--;
                }
            }
        }
        
        return outputList;
    }
        
}