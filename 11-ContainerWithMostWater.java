11. Container With Most Water

class Solution {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = height.length - 1;
        
        while (start < end) {
            int base = end - start;
            max = Math.max(max, Math.min(height[start], height[end]) * base);
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        
        return max;
    }
}