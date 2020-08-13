/* 771 - Jewels and Stones
- Insert all the Jewels in a sit since it is distinct
- Initialize a count to 0
- Check the set to see, if it contains the stone. If it does, increment count.

*/

class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
      Set <Character> set = new HashSet <Character>();
        for(int i=0; i < J.length(); i++){
            char c = J.charAt(i);
            set.add(c);
        }
        for(int j = 0; j < S.length(); j++){
            char s = S.charAt(j);
            if(set.contains(s))
                count++;            
        }
        return count;
    }
}