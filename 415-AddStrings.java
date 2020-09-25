// 415. Add Strings

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int firstPointer = num1.length() - 1;
        int secondPointer = num2.length() - 1;
        
        int carry = 0;
        while (firstPointer >= 0 || secondPointer >= 0) {
            int x1 = firstPointer >= 0 ? num1.charAt(firstPointer) - '0' : 0;
            int x2 = secondPointer >= 0 ? num2.charAt(secondPointer) - '0' : 0;
            int sum = x1 + x2 + carry;
            
            sb.append(sum % 10);
            carry = sum / 10;
            
           
            firstPointer--;
            secondPointer--;
        }
        
        if (carry != 0) {
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
        
}