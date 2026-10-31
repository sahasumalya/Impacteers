import java.util.ArrayList;
import java.util.List;

class CriticalConnectionInNetworks {
    int count = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<connections.size();i++){
            int a = connections.get(i).get(0);
            int b = connections.get(i).get(1);
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        int[] tis = new int[n];
        int[] lis = new int[n];
        boolean visited[] = new boolean[n];

        List<List<Integer>> res = new ArrayList<>();
        dfs(0, -1, adjList, tis, lis, visited, res);

        return res;
    }

    public void dfs(int node, int parent, List<List<Integer>> adjList, int[] tis, int[] lis, boolean visited[], List<List<Integer>> res){

        count++;
        tis[node] = count;
        lis[node] = count;
        visited[node] = true;

        List<Integer> neighbours = adjList.get(node);
        for(int i=0;i<neighbours.size();i++){
            int cur = neighbours.get(i);
            if(cur==parent){
                continue;
            }
            if(visited[cur]){
                lis[node] = Math.min(lis[node], lis[cur]);
            } else {
                dfs(cur, node, adjList, tis, lis, visited, res);
                if(tis[node]<lis[cur]){
                    List<Integer> edge = new ArrayList<>();
                    edge.add(node);
                    edge.add(cur);
                    res.add(edge);
                }
                lis[node] = Math.min(lis[node], lis[cur]);
            }
        }

    }
}
