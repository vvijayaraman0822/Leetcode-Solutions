// 387-First Unique Character in a String
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        for(int i=0; i< s.length(); i++){
            char letter = s.charAt(i);
            if(!hash.containsKey(letter))
                hash.put(letter, 1);
            else
                hash.put(letter, hash.get(letter) + 1);
        }
        
        for(int i=0; i < s.length(); i++){
            char ans = s.charAt(i);
            if(hash.get(ans) == 1)
                return i;
        }
            return -1;
        
   }
}