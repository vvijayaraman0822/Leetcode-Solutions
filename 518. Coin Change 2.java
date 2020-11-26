// 518. Coin Change 2

class Solution {
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        
        if (coins.length == 0) {
            return 0;
        }
        
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        // first row fill with 0 because no amount can be made with 0 coins, this is except (0,0)
        for(int i = 1; i <= amount; i++) {
            dp[0][i] = 0;
        }
        
        // first column fill with 0 because no amount can be made with 0 coins, this is except (0,0)
        for(int j = 0; j <= coins.length; j++) {
                dp[j][0] = 1;
        }
     
        
        // Fill DP table 
        for(int i = 1; i <= coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                // Calculate only if coins is <= amount, if not exclude currentcoin
                 if (j >= coins[i-1]) { 
                    // Current amount can be made summing up these two 
                    // What are the possibilities if I exclude my current coin -> dp[rows-1][col]
                    //  What are the possibilities if I include my current coin -> dp[rows][dp[amount - currentAmount]] -> coins[i-1] because coins[3] means there 
                    // 2 coins 
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];    
                 } else {
                    dp[i][j] = dp[i-1][j]; 
                 }
            }
        }
        
        return dp[coins.length][amount];
    }
}
                                                     
              
                                                     
    
        
                                        
                    
        

                                                     
              
                                                     
    
        
                                        
                    
        
