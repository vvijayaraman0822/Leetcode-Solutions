/* 345 - Reverse Vowels
- Set i to 0 and j to end, and keep swapping vowels i < j
- When i is not lesser than j, return new string
*/

class Solution {
    public String reverseVowels(String s) {
         int i = 0;
         int j = s.length()-1;
        String vowels = "aeiouAEIOU";
        char temp;
        char[] c = s.toCharArray();
        while(i < j){
          while(i < j && !vowels.contains(c[i] + ""))
                i++;
          while( i < j && !vowels.contains(c[j] + ""))
              j--;                        
            
            if(i < j){
            temp = c[i];
            c[i] = c[j];
            c[j] = temp;
                
            i++;
            j--;
                
            }
        }
               
        return new String(c);

    }
}
