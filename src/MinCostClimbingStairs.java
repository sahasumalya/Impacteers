
class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length+1];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        int a = rec(0, dp.length-1, cost, dp);
        int b = rec(1, dp.length-1, cost, dp);
        return Math.min(a,b);

    }

    public int rec(int n, int maxNum, int[] cost, int[] dp){
        if(n>maxNum){
            return Integer.MAX_VALUE;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        if(n==maxNum){
            dp[n] = 0;
            return 0;
        }
        int res = cost[n] + Math.min(rec(n+1, maxNum, cost, dp), rec(n+2,maxNum, cost, dp));
        dp[n] = res;
        return dp[n];

    }
}