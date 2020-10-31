// 42. Trapping Rain Water
// Not optmized solution

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0; 
        }
        // Solve this by using minimum of local maximas (Find the max of the left side and right side, and use it's minimum, subtract yourself)
        int size = height.length;
        int maxTotal = 0;
        int maxLeft = 0;
        int maxRight = 0;
        
        for(int i = 0; i < size - 1; i++) {
            maxLeft = height[i];
            for(int j = 0; j < i; j++) {
                maxLeft = Math.max(maxLeft, height[j]); // max of left hand side
            }
            
            maxRight = height[i];
            for(int j = i+1; j < size; j++) {
                maxRight = Math.max(maxRight, height[j]); // max of right hand side
            }
            
            maxTotal = maxTotal + Math.min(maxLeft, maxRight) - height[i]; // min of left & right - current val
        }
        
        return maxTotal;
          
    }
}

// O(n) Time solution, optmized

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0; 
        }
        int result = 0;
        int i = 0;
        int j = height.length - 1;
        
        int maxLeft = 0;
        int maxRight = 0;
        
        while (i < j) {
            if (height[i] < height[j]) { // then calculate maxLeft
                maxLeft = Math.max(maxLeft, height[i]);
                result += maxLeft - height[i];
                i++;
            } else { // then calculate maxRight;
                maxRight = Math.max(maxRight, height[j]);
                result += maxRight - height[j];
                j--; 
            }
        }
        return result;
          
    }
}