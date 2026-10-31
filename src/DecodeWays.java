
class DecodeWays {
    public int numDecodings(String s) {

        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for(int i=1;i<=s.length();i++){
            int res = 0;
            if(s.charAt(i-1)!='0'){
                res = res + dp[i-1];
            }
            if(i>1){
                String str = s.substring(i-2,i);
                int num = Integer.parseInt(str);
                if(num>=10 && num<=26){
                    res = res + dp[i-2];
                }

            }
            dp[i] = res;
        }
        return dp[s.length()];

    }
}
