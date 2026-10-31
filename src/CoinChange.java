
class CoinChange {
    public int coinChange(int[] coins, int amount) {


        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            int res = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i>=coins[j] && dp[i-coins[j]]!=Integer.MAX_VALUE){
                    res = Math.min(res, 1+dp[i-coins[j]]);
                }
            }
            dp[i] = res;
        }
        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];

        /*int[][] dp = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j] = -1;
            }
        }
        int res = rec(coins, amount, 0, dp);
        if(res==Integer.MAX_VALUE){
            return -1;
        }
        return res;*/


    }

    public int rec(int[] coins, int amount, int index, int[][] dp){

        if(amount==0){
            return 0;
        }
        if(index>=coins.length){
            return Integer.MAX_VALUE;
        }
        if(dp[index][amount]!=-1){
            return dp[index][amount];
        }
        //System.out.println("enetering");
        int a = Integer.MAX_VALUE;
        if(amount>=coins[index]){
            int res = rec(coins, amount-coins[index], index, dp);
            if(res<Integer.MAX_VALUE){
                a = res + 1;
            }
        }

        int b = rec(coins, amount, index+1, dp);
        //System.out.println(b);

        dp[index][amount] = Math.min(a,b);
        return dp[index][amount];

    }
}
