// 777. Swap Adjacent in LR String

class Solution {
    public boolean canTransform(String start, String end) {
        
       // If there are not equal amount of X's, you can return false;
        int count = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'X') {
                count++;
            }
            if (end.charAt(i) == 'X') {
                count--;
            }
        }
            
        
        if (count != 0) {
            return false;
        }
    
        int i = 0; // first string pointer
        int j = 0; // second string pointer
        
        while (i < start.length() && j < end.length()) {
            while (i < start.length() && start.charAt(i) == 'X') { // Move pointer until you hit a L or R
                i++;
            }
            
            while (j < end.length() && end.charAt(j) == 'X') {
               j++; 
            } 
    
            // Both string have reached at the END, return true
            if (i == start.length() || j == end.length()) { 
                return i == start.length() && j == end.length();
            }
            
            // After removing X's, i and j has to be same    
            if (start.charAt(i) != end.charAt(j)) {
                return false;
            }    
            
            // if both characters are L, i > j is good because L can move left 
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }   
                
             // if both characters are L, i < j is good because R can move right     
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }  
            
            i++;
            j++;
                
            }
        
        return true;               
                
    }
}