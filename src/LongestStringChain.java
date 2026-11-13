import java.util.*;

class StringLengthComparator implements Comparator<String> {
    public int compare(String a, String b){
        if(a.length()==b.length()){
            return 0;
        }
        if(a.length()>b.length()){
            return 1;
        }
        return -1;
    }
}
class LongestStringChain {
    public int longestStrChain(String[] words) {
        List<String> arr = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            arr.add(words[i]);
        }
        Collections.sort(arr, new StringLengthComparator());
        int lis[] = new int[words.length];
        int res = 1;
        lis[0] = 1;
        for(int i=1;i<words.length;i++){
            lis[i] = 1;
            String word = arr.get(i);
            //System.out.println(word);
            Set<String> wordSet = new HashSet<>();
            for(int k=0;k<word.length();k++){
                String str = "";
                if(k>0){
                    str = str+ word.substring(0,k);
                }
                if(k<word.length()-1){
                    str = str + word.substring(k+1);
                }
                wordSet.add(str);
            }

            for(int j=0;j<i;j++){
                if(wordSet.contains(arr.get(j))){
                    lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
            //System.out.println(lis[i]);
            res = Math.max(res, lis[i]);
        }
        return res;

    }
}
