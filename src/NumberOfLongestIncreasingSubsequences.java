
class NumberOfLongestIncreasingSubsequences {
    public int findNumberOfLIS(int[] nums) {

        int[] lis = new int[nums.length];
        int[] lnum = new int[nums.length];
        lis[0] = 1;
        lnum[0] = 1;
        int res = 1;
        for(int i=1;i<nums.length;i++){
            lis[i] = 1;
            lnum[i] = 1;
            int cur = nums[i];
            for(int j=0;j<i;j++){
                if(nums[j]<cur){
                    int len = 1 + lis[j];
                    if(len > lis[i]){
                        lis[i] = len;
                        lnum[i] = lnum[j];
                    } else if(len==lis[i]){
                        lnum[i] = lnum[i] + lnum[j];
                    }
                    res = Math.max(res, lis[i]);
                }
            }
        }
        int sum = 0;
        for(int i=0;i<lnum.length;i++){
            if(lis[i]==res){
                sum = sum + lnum[i];
            }
        }
        return sum;
    }
}