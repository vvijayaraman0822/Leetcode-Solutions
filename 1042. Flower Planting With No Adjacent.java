// 1042. Flower Planting With No Adjacent

class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, Set<Integer>> gPaths = new HashMap<>();
        
        // Put all the Garden and Paths into the map
        for(int i = 1; i <= n; i++) {
            gPaths.put(i, new HashSet<Integer>());
        }
        
        // Connect all the paths and add to map -> connect 1 to 2 and vice versa
        for(int i = 0; i < paths.length; i++) {
            gPaths.get(paths[i][0]).add(paths[i][1]);
            gPaths.get(paths[i][1]).add(paths[i][0]);            
        }
        
        int[] result = new int[n];
        
        // Check if the children have already used up the flow, if not add it to the result array
        for(int i = 1; i <= n; i++) {
            Set<Integer> neighbourFlowers = new HashSet<>();
            for(int neighbour : gPaths.get(i)) {
                neighbourFlowers.add(result[neighbour - 1]);
            }       
              
            
            for (int flower = 1; flower <= 4; flower++) {
                if (!neighbourFlowers.contains(flower)) {
					// Flower is available for use
                    result[i - 1] = flower; 
                }
            }
        }
                 
        return result;        
                
    }
}