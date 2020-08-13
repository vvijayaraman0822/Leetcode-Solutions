/* Leetcode 344 - Reverse String 
- Left & Right limit and use temp variable
- Exchange first element with last element and so on

*/

class Solution {
    
    public void reverseString(char[] s) {
        reverse(s, 0, s.length-1);    // recursion
        }
    
    void reverse(char[] s, int start, int end){
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
