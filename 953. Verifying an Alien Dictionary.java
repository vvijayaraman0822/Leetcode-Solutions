// 953. Verifying an Alien Dictionary

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0) {
            return false;
        }
        
        int[] alpha = new int[26];
        for (int i = 0; i < order.length(); i++) {
           alpha[order.charAt(i) - 'a'] = i;
        }
        
        for(int i = 0; i < words.length-1; i++) {
            String word1 = words[i]; // first word
            String word2 = words[i+1]; // second word
            
            int minLength = Math.min(word1.length(), word2.length()); // whichever word has shorter length because that's how long we have to iterate for
            
            for(int j = 0; j < minLength; j++) {
                if (alpha[word1.charAt(j) - 'a'] < alpha[word2.charAt(j) - 'a']) { // one of the letters appears before second, so it's sorted
                    break;
                } else if (alpha[word1.charAt(j) - 'a'] > alpha[word2.charAt(j) - 'a']) { // if above case does not happen, it's not sorted
                    return false;
                } else if (j == minLength - 1 && word1.length() > word2.length()) { // if first word is longer but second word has reached the end
                    return false;
                }                
            }            
            
        }
        
     return true;
        
        
    }
}