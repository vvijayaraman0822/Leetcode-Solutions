// 5. Longest Palindromic Substring

class Solution {    
    int resultStart = 0;
    int resultLength = 0;
    
    public String longestPalindrome(String s) {
        int length = s.length();
        
        if (length <= 1) {
            return s;
        }
        
        for(int start = 0; start < length; start++) {
            expandRange(s, start, start);
            expandRange(s, start, start+1);
        }
        
        return s.substring(resultStart, resultStart + resultLength);
    }
        
    public void expandRange(String s, int begin, int end) {
        while(begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
                begin--;
                end++;
        }
        if (resultLength < end - begin - 1) {
            resultStart = begin + 1; // you have done begin-- at the end, so have to do +1 to get back to the original string
            resultLength = end - begin - 1; // you have done end++, you need to do -1 to get back to the original string
        }
    }
}