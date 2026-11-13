import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class PairComparator implements Comparator<List<Integer>> {
    public int compare(List<Integer> pair1, List<Integer> pair2){
        if(pair1.get(1)>pair2.get(1)){
            return 1;
        }
        return -1;
    }
}
class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        int lis[] = new int[pairs.length];
        List<List<Integer>> arr = new ArrayList<>();
        for(int i=0;i<pairs.length;i++){
            List<Integer> item = new ArrayList<>();
            item.add(pairs[i][0]);
            item.add(pairs[i][1]);
            arr.add(item);
        }
        int res = 1;
        Collections.sort(arr, new PairComparator());
        lis[0] = 1;
        for(int i=1;i<pairs.length;i++){
            lis[i] = 1;
            int c = arr.get(i).get(0);
            for(int j=0;j<i;j++){
                int b = arr.get(j).get(1);
                if(c>b){
                    lis[i] = Math.max(lis[i], lis[j]+1);
                    res = Math.max(res, lis[i]);
                }
            }
        }
        return res;
    }
}
