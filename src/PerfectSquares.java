
class PerfectSquares {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            int res = Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                int a = j*j;
                int rem = i - a;
                res = Math.min(res, dp[rem] + 1);
            }
            dp[i] = res;
        }
        return dp[n];
    }
}
