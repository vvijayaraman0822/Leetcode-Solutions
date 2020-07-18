/* Leetcode 476 - Number Complement
- Use highest bit function an shit the bits by one to the left
- Subtract 1 and find exclusive or
*/

class Solution {
    public int findComplement(int num) {
        int newNum = (Integer.highestOneBit(num) << 1) - 1;
		return num ^ newNum;
           
    }
}
