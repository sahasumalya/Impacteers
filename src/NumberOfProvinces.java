import java.util.ArrayList;
import java.util.List;

class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> arr = new ArrayList<>();
            for(int j=0;j<n;j++){
                if(j!=i && isConnected[i][j] == 1){
                    arr.add(j);
                }
            }
            adjList.add(arr);
        }

        int count = 0;
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(adjList, visited, i);
            }
        }

        return count;

    }

    public void dfs(List<List<Integer>> adjList, boolean visited[], int x){
        visited[x] = true;
        List<Integer> neighbours = adjList.get(x);
        for(int i=0;i<neighbours.size();i++){
            if(!visited[neighbours.get(i)]){
                dfs(adjList, visited, neighbours.get(i));
            }
        }
    }


}
