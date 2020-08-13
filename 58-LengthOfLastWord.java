// 58. Length of Last Word
class Solution {
    public int lengthOfLastWord(String s) {
        if (s==null || s.length() == 0)
            return 0;
        int count = 0;
        int max = 0;
        for(int i=0; i< s.length(); i++) {
            if (s.charAt(i) != ' ') {
                count++;
                max = count;
            } else {
                count = 0;
            }
        }
    if (max > count) 
        return max;
    else
        return count;
    }
}