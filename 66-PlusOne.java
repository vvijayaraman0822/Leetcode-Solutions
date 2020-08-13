/* Leetcode 66 - Plus one 
- Iterate from the end of the loop. If you see a 9, make it a 0 and carry over one to
   previous digit
*/

class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for(int i = digits.length-1; i >= 0; i--){
            if(digits[i] != 9){
                digits[i] = digits[i] +1;
                break;
            }
            else {
                digits[i] = 0;
            }
            if(digits[0] == 0){
                int [] newArr = new int[digits.length+1];
                newArr[0] = 1;
                return newArr;
            }
                    
        }
        
        return digits;
        
    }
}
