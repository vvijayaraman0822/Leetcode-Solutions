// 844. Backspace String Compare

class Solution {
    public boolean backspaceCompare(String S, String T) {
        String first = buildString(S);
        String second = buildString(T);
        
        return first.equals(second);
    }
    
    public String buildString(String input) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++) {
            char a = input.charAt(i);
            if (a != '#') {
                stack.push(a);
            } else {
                if(!stack.isEmpty()) {
                stack.pop();
                }
            }
        }
         return String.valueOf(stack);
    }
}