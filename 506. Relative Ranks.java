// 506. Relative Ranks (NLogN solution)
// TreeMap insert is LogN * N for every single element

class Solution {
    public String[] findRelativeRanks(int[] nums) {
        String[] arr = new String[nums.length];
        if (nums == null || nums.length == 0) {
            return arr;
        }
        
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
       int counter = 0; 
       for (int key : map.keySet()) {
           int index = map.get(key);
           
           if (counter == 0) {
               arr[index] = "Gold Medal";
               counter++;
           } else if (counter == 1) {
               arr[index] = "Silver Medal";
               counter++;
           } else if (counter == 2) {
                arr[index] = "Bronze Medal";
               counter++;
           } else {
               arr[index] = String.valueOf(counter + 1);
               counter++;
           }      
           
       }
        
        
        return arr;
        
    }
}