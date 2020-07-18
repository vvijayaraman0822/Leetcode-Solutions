/* 868 - Binary Gap
- Create an array of size 32 and initialize with 1's wherever it exists in the integer number
*/

class Solution {
    public int binaryGap(int N) {
        int number = 0;
      int[] store = new int[32];
        for(int i = 0; i < 32; i++){
                if(((N >> i) & 1) !=0)
                    store[number++] = i;
        }
        int answer = 0;
        for(int j = 0; j < number-1; j++){
            answer = Math.max(answer, store[j+1]- store[j]);
        }
            return answer;
    }
}
