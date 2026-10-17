import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {


        List<List<List<Integer>>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int source = flights[i][0];
            int dest = flights[i][1];
            int cost = flights[i][2];
            List<Integer> pair = new ArrayList<>();
            pair.add(dest);
            pair.add(cost);
            adjList.get(source).add(pair);
        }
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> srcTriplet = new ArrayList<>();
        srcTriplet.add(src);
        srcTriplet.add(0);
        srcTriplet.add(0);
        queue.add(srcTriplet);

        int dist[] = new int[n];
        for(int i=0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        while(queue.size()>0){
            int len = queue.size();

            int[] distCopy = new int[n];
            for(int i=0;i<n;i++){
                distCopy[i] = dist[i];
            }
            while(len > 0){
                List<Integer> cur = queue.poll();
                int node = cur.get(0);
                int curCost = cur.get(1);
                int steps = cur.get(2);
                if(steps>k){
                    break;
                }
                List<List<Integer>> neighbours = adjList.get(node);
                for(int i=0;i<neighbours.size();i++){
                    List<Integer> pair = neighbours.get(i);
                    int destNode = pair.get(0);
                    int wt = pair.get(1);
                    if(curCost+wt < dist[destNode]){
                        distCopy[destNode] = Math.min(distCopy[destNode],curCost+wt);
                        List<Integer> curTriplet = new ArrayList<>();
                        curTriplet.add(destNode);
                        curTriplet.add(distCopy[destNode]);
                        curTriplet.add(steps+1);
                        queue.add(curTriplet);

                    }

                }
                len--;
            }
            for(int i=0;i<n;i++){
                dist[i] = distCopy[i];
            }

        }
        if(dist[dst]==Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];
    }
}
