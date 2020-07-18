/* Leetcode 728 - Self Dividing Numbers 
- For loop with left and right limit 
*/

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List <Integer> answer = new ArrayList<Integer>();
        for(int i = left; i <= right; i++){
            if(selfDividing(i))
                answer.add(i);       
            }
        return answer;
    }
        
    public boolean selfDividing(int i){
        int number = i;
        while (number > 0){
            int remainder = number % 10; // 128 % 10 == 8
            number = number / 10; // 12
                if (remainder == 0 || (i % remainder) > 0)
                    return false;
        }
        return true;
            
    }
}
