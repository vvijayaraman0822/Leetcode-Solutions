// 3. Longest Substring Without Repeating Characters

// Time Complexity - O(N) - Sliding window Algorithm 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int startWindow = 0;
        int endWindow = 0;
        Set<Character> set = new HashSet<>();
        while(endWindow < s.length()) {
            char a = s.charAt(endWindow);
            if (!set.contains(a)) {
                set.add(a);
                maxLength = Math.max(maxLength, set.size());
                endWindow++;
            } else {
                set.remove(s.charAt(startWindow));
                startWindow++;       
            }
        }
        
        return maxLength;
    }
}
