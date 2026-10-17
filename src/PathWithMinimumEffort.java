import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


class PQComparator3 implements Comparator<List<Integer>> {
    public int compare(List<Integer> triplet1, List<Integer> triplet2){
        if(triplet1.get(2) > triplet2.get(2)){
            return 1;
        }
        return -1;
    }
}
class PathWithMinimumEffort {

    public void updateWeights(int x, int y, int a, int b, int[][] heights, int dist[][], PriorityQueue<List<Integer>> pq, int rows, int cols, int curDist) {
        if(a>=0 && a<rows && b>=0 && b<cols && Math.max(curDist, Math.abs(heights[x][y]-heights[a][b])) < dist[a][b]){
            dist[a][b] = Math.max(curDist, Math.abs(heights[x][y]-heights[a][b]));
            List<Integer> curTriplet = new ArrayList<>();
            curTriplet.add(a);
            curTriplet.add(b);
            curTriplet.add(dist[a][b]);
            pq.add(curTriplet);
        }
    }
    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        int dist[][] = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new PQComparator3());
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(0);
        arr.add(0);
        dist[0][0] = 0;

        pq.add(arr);


        while(pq.size()>0){

            List<Integer> cur = pq.poll();
            int x = cur.get(0);
            int y = cur.get(1);
            int curDist = cur.get(2);
            updateWeights(x, y, x-1, y, heights, dist, pq, rows, cols, curDist);
            updateWeights(x, y, x+1, y, heights, dist, pq, rows, cols, curDist);
            updateWeights(x, y, x, y-1, heights, dist, pq, rows, cols, curDist);
            updateWeights(x, y, x, y+1, heights, dist, pq, rows, cols, curDist);

        }

        return dist[rows-1][cols-1];

    }
}
