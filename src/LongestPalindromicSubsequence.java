
class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int mat[][] = new int[len][len];
        for(int i=0;i<len;i++){
            mat[i][i] = 1;
        }
        for(int i=2;i<=len;i++){
            int start = 0;
            int end = start+i-1;
            while(end<len){
                if(s.charAt(start)==s.charAt(end)){
                    if(i==2)
                        mat[start][end] = 2;
                    else{
                        mat[start][end] = Math.max(2 + mat[start+1][end-1], Math.max(mat[start][end-1], mat[start+1][end]));
                    }

                } else {
                    if(i==2)
                        mat[start][end] = 1;
                    else
                        mat[start][end] = Math.max(mat[start+1][end-1], Math.max(mat[start+1][end], mat[start][end-1]));
                }
                start++;
                end++;
            }
        }

        return mat[0][len-1];
    }
}