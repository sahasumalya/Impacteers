class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        boolean visited[] = new boolean[graph.length];
        boolean colour[] = new boolean[graph.length];
        int n = graph.length;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                boolean res = dfs(graph, visited, colour, i, true);
                if(!res){
                    return false;
                }
            }
        }
        return true;

    }

    public boolean dfs(int[][] graph, boolean visited[], boolean colour[], int n, boolean isWhite){

        visited[n] = true;
        colour[n] = isWhite;
        int[] neighbours = graph[n];

        for(int i=0;i<neighbours.length;i++){
            int cur = neighbours[i];
            //System.out.println("root="+n+" neigbour="+cur);
            if(visited[cur] && colour[cur]==colour[n]){
                //System.out.println("entering");
                return false;
            }
            if(!visited[cur]){
                boolean res = dfs(graph, visited, colour, cur, !colour[n]);
                if(!res){
                    return false;
                }
            }
        }
        return true;

    }
}
