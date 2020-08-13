/* 804 - Unique Morse Code Words 
- Create a String array of [a,b,c,d] etc
- Append according to letters and create a whole string'
- Insert into set, so duplicates will be avoided
- Return set size
*/

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        String [] input = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
    Set<String> set = new HashSet<>();
    for(String word : words){
        StringBuilder join = new StringBuilder();
        
        for(char ch : word.toCharArray())
            join.append(input[ch - 'a']);
        
     set.add(join.toString());
        
    }
    
    return set.size();       
            
    }
}