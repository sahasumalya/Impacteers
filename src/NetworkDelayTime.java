import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class PQComparator4 implements Comparator<List<Integer>> {
    public int compare(List<Integer> pair1, List<Integer> pair2){
        if(pair1.get(1)>pair2.get(1)){
            return 1;
        }
        return -1;
    }
}
class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<List<Integer>>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<times.length;i++){
            int src = times[i][0] - 1;
            int dest = times[i][1] - 1;
            int time = times[i][2];
            List<Integer> pair = new ArrayList<>();
            pair.add(dest);
            pair.add(time);
            adjList.get(src).add(pair);
        }

        int[] dist = new int[n];
        for(int i=0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k-1] = 0;

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new PQComparator4());
        List<Integer> srcPair = new ArrayList<>();
        srcPair.add(k-1);
        srcPair.add(0);
        pq.add(srcPair);

        while(pq.size()>0){

            List<Integer> cur = pq.poll();
            int curNode = cur.get(0);
            int curDist = cur.get(1);

            List<List<Integer>> neighbours = adjList.get(curNode);
            for(int i=0;i<neighbours.size();i++){
                List<Integer> curPair = neighbours.get(i);
                int destNode = curPair.get(0);
                int curTime = curPair.get(1);
                if(curDist + curTime < dist[destNode]){
                    dist[destNode] = curDist + curTime;
                    List<Integer> betterPair = new ArrayList<>();
                    betterPair.add(destNode);
                    betterPair.add(dist[destNode]);
                    pq.add(betterPair);
                }
            }

        }

        int maxi = -1;
        for(int i=0;i<n;i++){
            //System.out.println(dist[i]);
            if(i!=k-1)
                maxi = Math.max(maxi, dist[i]);
        }
        if(maxi==Integer.MAX_VALUE){
            return -1;
        }
        return maxi;


    }
}
