class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        for(int i=0;i<n;i++){
            int a = edges[i][0]-1;
            int b = edges[i][1]-1;
            int roota = findRootParent(a,parent);
            int rootb = findRootParent(b,parent);
            if(roota==rootb){
                int[] res = {a+1, b+1};
                return res;
            }
            parent[rootb] = roota;
        }
        return new int[2];
    }

    public int findRootParent(int node, int[] parent){  // 3--2--1->1
        int curNode = node;
        while(parent[curNode]!=curNode){
            curNode = parent[curNode];
        }
        parent[node] = curNode;
        return curNode;
    }
}