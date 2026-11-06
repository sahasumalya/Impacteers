class CoinChange2 {
    public int change(int amount, int[] coins) {

        int dp[][] = new int[amount+1][coins.length+1];
        for(int i=0;i<=coins.length;i++){
            dp[0][i] = 1;
        }
        for(int i=1;i<=amount;i++){
            for(int j=1;j<=coins.length;j++){
                int res = 0;
                if(i>=coins[j-1]){
                    res = res + dp[i-coins[j-1]][j];
                }
                res = res + dp[i][j-1];
                dp[i][j] = res;
            }

        }

        return dp[amount][coins.length];

    }
}
