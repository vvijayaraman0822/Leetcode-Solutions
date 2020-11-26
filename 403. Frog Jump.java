// 403. Frog Jump

class Solution {
    public boolean canCross(int[] stones) {
       for (int i=3; i< stones.length; i++) {
            if (stones[i] > stones[i-1] * 2)
                return false;
        }
        // Target stone
        int targetStone = stones[stones.length - 1];
        
        // Add all stones to a HashSet for O(1) lookup
        HashSet<Integer> sto = new HashSet<>();
        for(int i = 0; i < stones.length; i++) {
            sto.add(stones[i]);
        }
        // Stack to hold the previous jumps
        Stack<Integer> jumps = new Stack<>();
        // Stack to hold all the stones that you arrived at
        Stack<Integer> arrivedStones = new Stack<>();
        arrivedStones.add(0); // first stone starting at 0
        jumps.add(0); // first jump at 0
        
        // As long as there is a stone to jump, keep iterating
        while(!arrivedStones.isEmpty()) {
            // nextStone = lastStone + lastJump
            int lastStone = arrivedStones.pop();
            int lastJump = jumps.pop();
            
            // find if combinations result to lastStone, k, k+1, k-1
            for (int i = lastJump - 1; i <= lastJump + 1; i++) {
                if (i <= 0) {
                    continue;
                }
                int nextStone = lastStone + i;
                if (nextStone == targetStone) {
                    return true;
                } else if (sto.contains(nextStone)) {
                    jumps.add(i);
                    arrivedStones.add(nextStone);
                }
            }
            
        }
        
        return false;
    }
}