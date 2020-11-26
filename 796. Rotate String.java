// 796. Rotate String


// Naive solution
class Solution {
    public boolean rotateString(String A, String B) {
        if (A == null || B == null || A.length() != B.length()) {
            return false;
        }
        
        if (A.equals("") || B.equals("")) {
            return true;
        }
        
       for(int i = 0; i < A.length(); i++) {
           String firstLetter = A.substring(0,1); // first Letter
           String otherLetters = A.substring(1, A.length()); // remaining letters
           A = otherLetters + firstLetter;
           if (A.equals(B)) {
               return true;
           }
       }
        
        return false;        
        
    }
}

// Better solution 
// A + A will have all the possible strings that can occur after shifting to right

class Solution {
    public boolean rotateString(String A, String B) {
        if (A == null || B == null || A.length() != B.length()) {
            return false;
        }
        
        if (A.equals("") || B.equals("")) {
            return true;
        }
        
        String newString = A + A; // adcdeabcde -> contains all possible strings
        if (newString.contains(B)) {
            return true;
        }
        
        return false;
        
    }
}