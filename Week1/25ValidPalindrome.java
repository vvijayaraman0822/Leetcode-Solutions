/* 125 - Valid Palindrome */

class Solution {
    public boolean isPalindrome(String s) {
        
       // Brute Force Solution. O(N^2) complexity
        /*
        if(s.length() == 0 || s == null)
            return true;
         s = s.replaceAll("\\s", "");
         s = s.toLowerCase();
        String reversed = "";
        String original = "";
        
        for(int j =0; j <s.length();j++){
            if(Character.isLetterOrDigit(s.charAt(j)))
                original = original + s.charAt(j);
        }
      //System.out.println(original);
        
        for(int i = s.length()-1; i>=0 ; i--){
            if(Character.isLetterOrDigit(s.charAt(i)))
                reversed = reversed + s.charAt(i);
        }
    //   System.out.println(reversed);
        if(reversed.equals(original))
            return true;
        else
            return false;
            */
            
        if(s.length() == 0 || s == null)
            return true;
         s = s.replaceAll("\\s", "");
         s = s.toLowerCase();
         int i = 0;
         int j = s.length()-1;
        
        while(i < j){
            while(i<j && (!Character.isLetterOrDigit(s.charAt(i)))){
                i++;
            }
            while(i<j && (!Character.isLetterOrDigit(s.charAt(j)))){
                j--;
            }
            if(i<j && s.charAt(i++) != s.charAt(j--)){
               // i++;
               // j--;
                return false;
            }
        }
    return true;
    }
}
      