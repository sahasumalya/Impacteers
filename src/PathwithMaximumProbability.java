import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class PQComparator2 implements Comparator<List<Double>> {
    public int compare(List<Double> pair1, List<Double> pair2){
        if(pair1.get(1)<pair2.get(1)){
            return 1;
        }
        return -1;
    }
}
class PathwithMaximumProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        List<List<List<Double>>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            double prob = succProb[i];
            List<Double> pair1 = new ArrayList<>();
            pair1.add((double)a);
            pair1.add(prob);
            adjList.get(b).add(pair1);

            List<Double> pair2 = new ArrayList<>();
            pair2.add((double)b);
            pair2.add(prob);
            adjList.get(a).add(pair2);
        }

        double [] dist = new double[n];
        dist[start_node] = 1;
        PriorityQueue<List<Double>> pq = new PriorityQueue<>(new PQComparator2());
        List<Double> arr = new ArrayList<>();
        arr.add((double)start_node);
        arr.add(1.00);
        pq.add(arr);
        while(pq.size()>0){
            List<Double> cur = pq.poll();
            int node = cur.get(0).intValue();
            double curProb = cur.get(1);
            List<List<Double>> neighbours = adjList.get(node);
            for(int i=0;i<neighbours.size();i++){
                List<Double> curPair = neighbours.get(i);
                int destNode = curPair.get(0).intValue();
                double wt = curPair.get(1);
                double curDist = (double)curProb*wt;
                //System.out.println(wt+":"+curProb+":"+curDist+":"+dist[destNode]);
                if(curDist>dist[destNode]){

                    dist[destNode] = curDist;
                    List<Double> betterPair = new ArrayList<>();
                    betterPair.add((double)destNode);
                    betterPair.add((double)curDist);
                    pq.add(betterPair);
                }
            }
        }

        return dist[end_node];



    }
}