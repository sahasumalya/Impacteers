import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class IntervalComparator implements Comparator<List<Integer>> {

    public int compare(List<Integer> interval1, List<Integer> interval2){
        if(interval1.get(0)==interval2.get(0)){
            return 0;
        }
        if(interval1.get(0)>interval2.get(0)){
            return 1;
        }

        return -1;
    }

}
class IntervalSolution {
    public int[][] merge(int[][] intervals) {

        List<List<Integer>> arr = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            List<Integer> interval = new ArrayList<>();
            interval.add(intervals[i][0]);
            interval.add(intervals[i][1]);
            arr.add(interval);
        }

        Collections.sort(arr, new IntervalComparator());
        List<List<Integer>> res = new ArrayList<>();
        res.add(arr.get(0));
        List<Integer> mergedInterval = res.get(0);
        for(int i=1;i<arr.size();i++){
            int curStart = arr.get(i).get(0);
            int curEnd = arr.get(i).get(1);
            if(curStart<=mergedInterval.get(1)){
                mergedInterval.set(1, Math.max(curEnd, mergedInterval.get(1)));
            } else {
                res.add(arr.get(i));
                mergedInterval = arr.get(i);
            }
        }

        int[][] finalRes = new int[res.size()][2];

        for(int i=0;i<res.size();i++){
            finalRes[i][0] = res.get(i).get(0);
            finalRes[i][1] = res.get(i).get(1);
        }
        return finalRes;



    }
}