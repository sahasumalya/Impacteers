import java.util.ArrayList;
import java.util.List;

class PacificAtlantic {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        int[][] marker = new int[rows][cols];
        // p --2
        // a --1
        for(int i=0;i<cols;i++){
            marker[0][i] = marker[0][i] | 2;
        }
        for(int i=0;i<rows;i++){
            marker[i][0] = marker[i][0] | 2;
        }
        for(int i=0;i<cols;i++){
            marker[rows-1][i] = marker[rows-1][i] | 1;
        }
        for(int i=0;i<rows;i++){
            marker[i][cols-1] = marker[i][cols-1] | 1;
        }
        //System.out.println(marker[rows-1][cols-1]);

        boolean[][] visited = new boolean[rows][cols];
        for(int i=0;i<cols;i++){
            visited = new boolean[rows][cols];
            dfs(heights, marker, 0, i, visited, marker[0][i]);
        }
        for(int i=0;i<rows;i++){
            visited = new boolean[rows][cols];
            dfs(heights, marker, i, 0, visited, marker[i][0]);
        }
        for(int i=0;i<cols;i++){
            visited = new boolean[rows][cols];
            dfs(heights, marker, rows-1, i, visited, marker[rows-1][i]);
        }
        for(int i=0;i<rows;i++){
            visited = new boolean[rows][cols];
            dfs(heights, marker, i, cols-1, visited, marker[i][cols-1]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(marker[i][j]==3){
                    List<Integer> cords = new ArrayList<>();
                    cords.add(i);
                    cords.add(j);
                    res.add(cords);
                }
            }
        }
        return res;

    }
    public void dfs(int[][] heights, int[][] marker, int x, int y, boolean[][] visited, int color){
        visited[x][y] = true;
        marker[x][y] = marker[x][y] | color;

        if(x+1<heights.length && !visited[x+1][y] && heights[x+1][y]>=heights[x][y]){
            dfs(heights, marker, x+1, y, visited, color);
        }
        if(x-1>=0 && !visited[x-1][y] && heights[x-1][y]>=heights[x][y]){
            dfs(heights, marker, x-1, y, visited, color);
        }
        if(y+1<heights[0].length && !visited[x][y+1] && heights[x][y+1]>=heights[x][y]){
            dfs(heights, marker, x, y+1, visited, color);
        }
        if(y-1>=0 && !visited[x][y-1] && heights[x][y-1]>=heights[x][y]){
            dfs(heights, marker, x, y-1, visited, color);
        }

    }
}
