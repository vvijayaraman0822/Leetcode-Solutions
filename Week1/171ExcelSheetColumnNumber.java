/* Leetcode 171 - Excel Sheet Column Number
- Iterate through the string and use ASCII indexing 
- Return total sum
*/

class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        for(int i=0; i < s.length(); i++){
            sum = sum * 26 + (s.charAt(i) - 'A'+1);
        }
        
        return sum;
    }
}