// 238. Product of Array Except Self

// Space Complexity - O(N * N)
class Solution {
    public int[] productExceptSelf(int[] nums) {
       int [] outputArray = new int[nums.length];
       int numberOfLoops = nums.length; 
       int product = 1;
       int outputIndex = 0;
       while(numberOfLoops > 0) { 
        for (int i=0; i < nums.length; i++) {
           if (i != outputIndex) {
               product = product * nums[i];  
           }
       }
         outputArray[outputIndex] = product;
         product = 1;
         outputIndex++;
         numberOfLoops--;
       }
        
        return outputArray;
    }
}

Time Complexity - O(N), Space Complexity - O(1) 
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] outputArray = new int[nums.length];
        outputArray[0] = 1;
        int product = 1;
        // calculate all the product to the left side of i
        for(int i = 1; i < nums.length; i++) {
            outputArray[i] = outputArray[i-1] * nums[i-1];         
     }   
       
        int right = 1;
        for(int i = nums.length-1; i >= 0; i--) {
            outputArray[i] = outputArray[i] * right;
            right = right * nums[i];
        }
        
        return outputArray;
    }
        
}