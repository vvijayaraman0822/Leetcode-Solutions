// 443. String Compression

class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        
        int updateIndex = 0;
        int i = 0;
      
        while (i < chars.length) {
            int j = i; // pointer to count how many occurences of the character
            while (j < chars.length && chars[i] == chars[j]) {
                j++;
            }
            
            String count = j-i + ""; // this will give me number of occurences of the character
            chars[updateIndex++] = chars[i]; // update the array with the character
            
            // update with the character with the count if it is greater than 1;
            if (j - i > 1) {
                for (char c : count.toCharArray()) { // for loop because for example count is 12, it needs to go in the array like ["1", "2"]
                    chars[updateIndex++] = c;
                }
            }
            i = j; // this is needed because after one evaluating one group, we need i to start again at where j is currently;
        }
        
        return updateIndex;
            
        }
}