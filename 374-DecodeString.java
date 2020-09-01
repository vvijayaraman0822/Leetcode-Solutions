// 394. Decode String

class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s ;
        }
        Stack<Integer> integerStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String result = "";
        int ptr = 0;
        while(ptr < s.length()) {
            char curr = s.charAt(ptr);
            if (Character.isDigit(curr)) {
                int num = 0;
                while (Character.isDigit(s.charAt(ptr))) {
                    num = num * 10 + s.charAt(ptr) - '0';
                    ptr++;
                }
                integerStack.push(num);                
            } else if (curr == '[') {
                stringStack.push(result);
                result = "";
                ptr++;
            } else if (curr == ']') {
               StringBuilder sb = new StringBuilder(stringStack.pop());
               int count = integerStack.pop();
               for(int i = 0; i < count; i++) {
                  sb.append(result);
               } 
                result = sb.toString();
                ptr++;              
            } else {
                result += curr;
                ptr++;
            }
        }
        return result;
    }
}