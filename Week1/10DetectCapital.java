/* 520 - Detect Capital 
- Iterate through the string and check for the three cases
- Keep track of how many capital letters are present in the word
- If any one of the three cases true, then return true
*/

class Solution {
    public boolean detectCapitalUse(String word) {
        //System.out.println(word);
        int count = 0;
        for(int i=0; i < word.length(); i++){
            char c = word.charAt(i);
            if(c >= 'A' && c <= 'Z' )
                count++;
        }
        
         if(count == 0 || count == word.length())
             return true;
         if(count == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z')
            return true;
        
        return false;
       
    }
}