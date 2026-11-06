
class PartitionEqualSubSetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
        }
        if(sum%2==1){
            return false;
        }
        int amount = sum/2;

        boolean dp[][] = new boolean[amount+1][nums.length+1];
        for(int i=0;i<=nums.length;i++){
            dp[0][i] = true;
        }
        for(int i=1;i<=amount;i++){
            for(int j=1;j<=nums.length;j++){
                boolean res = dp[i][j-1];
                if(i>=nums[j-1]){
                    res = (res || dp[i-nums[j-1]][j-1]);
                }
                dp[i][j] = res;
            }
        }
        return dp[amount][nums.length];

    }
}