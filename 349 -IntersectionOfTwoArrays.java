/* 349 - Intersection of Two Arrays
- Insert all numbers into a set
- Iterate through the second array and check to see if values match
- If they do, insert it into another set 
- Create array and place the values in an array
- Return array
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set <Integer> set = new HashSet<>();
        Set <Integer> join = new HashSet<>();
        
       for(int i = 0; i < nums1.length; i++) {
           set.add(nums1[i]);
       }
        
        for(int i=0; i < nums2.length; i++ ){
            if(set.contains(nums2[i]))
                join.add(nums2[i]);
        }
         
        int[] arr = new int[join.size()];
            int x= 0;
            
       for(int ans : join)
           arr[x++] = ans;

        return arr;
    
    }
}