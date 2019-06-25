/* 1 - Two Sum
- Brute Force - 1st method
- Use HashMap

*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        /* Naive Solution with O(N^2) complexity
        for(int i=0; i < nums.length-1; i++)
            for(int j=i+1; j<nums.length; j++)
                if(nums[i] + nums[j] == target)
                    return new int[]{i,j};
        return new int[]{0,0};
        */
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] arr = new int[2];
        for(int i=0; i < nums.length; i++){
            int difference = target - nums[i];
            if(map.containsKey(difference)){
                arr[0] = map.get(difference);
                arr[1] = i;
                return arr;
            }
             
            map.put(nums[i],i);
        }
        
        return arr;
        
    }
          
    
}