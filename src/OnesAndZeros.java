
class OnesAndZeros {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] arr = new int[m+1][n+1][strs.length+1];
        int[][] zeroones = new int[strs.length][2];
        for(int i=0;i<strs.length;i++){
            String cur = strs[i];
            int zeros = 0, ones = 0;
            for(int j=0;j<cur.length();j++){
                if(cur.charAt(j)=='1'){
                    ones++;
                }
                else{
                    zeros++;
                }
            }
            zeroones[i][0]=zeros;
            zeroones[i][1]=ones;
        }
        for(int i=0;i<strs.length;i++){
            int ones = zeroones[i][1];
            int zeros = zeroones[i][0];
            for(int j=0;j<=m;j++){
                for(int k=0;k<=n;k++){
                    if(j>=zeros && k>=ones){
                        arr[j][k][i+1] = Math.max(arr[j][k][i], arr[j-zeros][k-ones][i]+1);
                    } else {
                        arr[j][k][i+1] = arr[j][k][i];
                    }
                }
            }
        }
        return arr[m][n][strs.length];
    }
}
