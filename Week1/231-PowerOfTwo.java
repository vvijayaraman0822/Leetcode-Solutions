/* 231-Power of Two
- Keep multiplying by two until lesser than n. 
- When it is not, check if the last number is equal to n
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
       long i = 1;
        while(i < n){
            i = i*2;
        }
        if (i == n)
            return true;
        else
            return false;
        
    }
}
