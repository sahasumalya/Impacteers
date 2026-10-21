import java.util.*;

class PQComparator5 implements Comparator<List<Integer>> {
    public int compare(List<Integer> entry1, List<Integer> entry2){
        if(entry1.get(2)>entry2.get(2)){
            return 1;
        }
        return -1;
    }
}
class MinimumCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new PQComparator5());
        Set<String> visited = new HashSet<>();
        List<Integer> srcNode = new ArrayList<>();
        int res = 0;
        srcNode.add(points[0][0]);
        srcNode.add(points[0][1]);
        srcNode.add(0);
        pq.add(srcNode);
        while(pq.size()>0){
            if(visited.size()==points.length){
                break;
            }
            List<Integer> cur = pq.poll();
            int x = cur.get(0);
            int y = cur.get(1);
            int wt = cur.get(2);
            if(!visited.contains(x+":"+y)){
                res = res + wt;
                //System.out.println("x="+x+" y="+y+" wt="+wt);
                visited.add(x+":"+y);
                for(int i=0;i<points.length;i++){
                    if(x!=points[i][0] || y!=points[i][1]){
                        List<Integer> curNode = new ArrayList<>();
                        curNode.add(points[i][0]);
                        curNode.add(points[i][1]);
                        //System.out.println("origx="+x+" origy="+y);
                        //System.out.println("x="+points[i][0]+" y="+points[i][1]+" dist="+(Math.abs(x-points[i][0])+ Math.abs(y-points[i][1])));
                        curNode.add(Math.abs(x-points[i][0])+ Math.abs(y-points[i][1]));
                        pq.add(curNode);
                    }
                }

            }



        }
        return res;
    }
}
