/* 575 - Distribute Candies 
- Traverse the array and then insert it into an set (unique elements)
- Return the minimum of set size or candy length / 2
*/

class Solution {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : candies)
            set.add(i);
        return Math.min(set.size(), candies.length / 2);
        
    }
}