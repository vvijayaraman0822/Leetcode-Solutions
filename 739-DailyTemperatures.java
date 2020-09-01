// 739 - Daily Temperatures

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] outputArray = new int[T.length];
        Stack<Integer> tempStack = new Stack<>(); 
     
        for(int i=0; i < T.length; i++) {
            while(!tempStack.isEmpty() && T[i] > T[tempStack.peek()]) {
                int pop = tempStack.pop();
                outputArray[pop] = i - pop;
            }
             tempStack.push(i);
        }
        
        return outputArray;
    }
}
