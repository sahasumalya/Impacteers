
class SmallestNumberOfNeighboursAtThresholdDistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] adjMatrix = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j)
                    adjMatrix[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            int wt = edges[i][2];
            adjMatrix[a][b] = wt;
            adjMatrix[b][a] = wt;
        }

        for(int i=0;i<n;i++){
            for(int x=0;x<n;x++){
                for(int y=0;y<n;y++){
                    // dist[x][y] = dist[x][i] + dist[i][y]
                    if(adjMatrix[x][i]!=Integer.MAX_VALUE && adjMatrix[i][y]!=Integer.MAX_VALUE){
                        adjMatrix[x][y] = Math.min(adjMatrix[x][y], adjMatrix[x][i]+adjMatrix[i][y]);
                    }
                }
            }
        }

        int cityWithMinConnections = 0;
        int minimumConnections = 0;
        for(int i=0;i<n;i++){
            if(i!=0 && adjMatrix[i][0]<=distanceThreshold){
                minimumConnections++;
            }
        }

        for(int i=1;i<n;i++){
            int curConnection = 0;
            for(int j=0;j<n;j++){
                if(i!=j && adjMatrix[i][j]<=distanceThreshold){
                    curConnection++;
                }
            }
            if(curConnection<=minimumConnections){
                minimumConnections = curConnection;
                cityWithMinConnections = i;
            }

        }
        return cityWithMinConnections;

    }
}
