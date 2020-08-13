
// 322. Coin Change

// Bottom Up approach of dynamic programming

class Solution {
    public int coinChange(int[] coins, int amount) {
        // Store answers to sub problems here
        int[] dp = new int[amount+1];
        
        // Initialize the DP table with amount+1 to find the min value later on
        Arrays.fill(dp, amount+1);
        
        // There are 0 ways in which 0 amount can be made up no matter the coins given
        dp[0] = 0;
        
        
        // Start solving the sub problem from 1 to n as 0 is already given
        for(int i=1; i <= amount; i++) {
            // now for each amount, we need to populate minimum for each of the given coins
            for(int j=0; j < coins.length; j++) {
                // If it is less than or equal to the sub problem amount
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
    /*
      dp[amount] has our answer. If we do not have an answer then dp[amount]
      will be amount + 1 and hence dp[amount] > amount will be true. We then
      return -1.

      Otherwise, dp[amount] holds the answer
    */
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}