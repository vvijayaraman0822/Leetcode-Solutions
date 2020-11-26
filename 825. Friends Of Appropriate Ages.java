// 825. Friends Of Appropriate Ages

class Solution {
    public int numFriendRequests(int[] ages) {
        if (ages == null || ages.length == 0) {
            return 0;
        }
        
        // Initialize map with ages and its count
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < ages.length; i++) {
            if (!map.containsKey(ages[i])) {
                map.put(ages[i], 1);
            } else {
                map.put(ages[i], map.get(ages[i]) + 1);
            }
        }
        
        int count = 0;
        // For every age that exists find all pairs for which you can make friend requests, check the count from map and multiply
        // make sure to exclude the same age
        // Example 16 -> count 2 will give 2 * 2 -> 4 and then we need to subtract 2 since ages A & B are same
        for (Integer a : map.keySet()) {
            for (Integer b : map.keySet()) {
                if (canRequestBeMade(a, b)) {
                    count += map.get(a) * map.get(b);
                    if (a == b) {
                        count -= map.get(a);
                    }
                }
            }
        }
               
        return count;
    }
                         
    public boolean canRequestBeMade(int ageA, int ageB) {
        if (ageB <= 0.5 * ageA + 7 || ageB > ageA) {
            return false;
        }
        
        return true;
    }
}`