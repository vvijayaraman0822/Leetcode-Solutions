// 367. Valid Perfect Square

class Solution {
    public boolean isPerfectSquare(int num) {  
        long left = 1;
        long right = num;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long product = mid * mid;
                   
            if (product == num) {
               return true;
            } else if (product > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }            
        }
        
        return false;
    }
}