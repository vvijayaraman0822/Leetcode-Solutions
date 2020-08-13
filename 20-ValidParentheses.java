// 20-Valid Parentheses
class Solution {  
   public boolean isValid(String s) {
        char arr[] = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for(Character ch : arr){
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
                else if(ch == '}'){
                    if(st.isEmpty() || st.peek() != '{'){
                    return false;
                    }
            st.pop();
                }
                else if(ch == ')'){
                    if(st.isEmpty() || st.peek() != '('){
                    return false;
                    }
            st.pop();
                }
                else if(ch == ']'){
                    if(st.isEmpty() || st.peek() != '['){
                    return false;
                    }
            st.pop();
            }
        }
        
        if(st.size() == 0)
            return true;
        else 
            return false;
    }
}