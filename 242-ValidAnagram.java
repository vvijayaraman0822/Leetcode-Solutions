/* 242 - Valid Anagram
- Use Hashmap to store letters and number of times it appears
- Compare the string and every time you see the letter, decrement from hashmap
- If the size is greater than 0 at the end, then it means not all the letters are utilized
- Then it means anagram can be formed 
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap <Character,Integer> answer = new HashMap<>();
        
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if(answer.containsKey(c))
                answer.put(c , answer.get(c)+1);
            else
                answer.put(c, 1);
        }
        
       // System.out.println(Arrays.asList(answer));
        for(int j=0; j < t.length(); j++){
            char c = t.charAt(j);
            if(answer.containsKey(c))
                if(answer.get(c) == 1)
                    answer.remove(c);
                else
                    answer.put(c, answer.get(c) - 1);
            else
                return false;
        }
        
        if(answer.size() > 0)  
            return false;
        else
            return true;
                
    }
}
