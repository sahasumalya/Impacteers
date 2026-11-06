

class TragetSum {
    int k = 1000;
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[k+1+k][nums.length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                dp[i][j] = -1;
            }
        }
        int res = rec(nums, dp, 0, target);
        return res;

    }

    public int rec(int[] nums, int[][] dp, int index, int amount){

        if(amount==0){
            return 1;
        }
        if(index>=nums.length){
            return 0;
        }

        if(dp[amount+k][index]!=-1){
            return dp[amount+k][index];
        }

        int res = rec(nums, dp, index+1, amount-nums[index]) + rec(nums, dp, index+1, amount+nums[index]);
        dp[amount+k][index] = res;

        return dp[amount+k][index];

    }
}