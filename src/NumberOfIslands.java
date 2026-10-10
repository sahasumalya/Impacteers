
class NumberOfIslands {
    public int numIslands(char[][] grid) {

        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return count;


    }

    public void dfs(char[][] grid, boolean[][] visited, int x, int y){
        visited[x][y] = true;
        if(x+1<grid.length && grid[x+1][y]=='1' && !visited[x+1][y]){
            dfs(grid, visited, x+1, y);
        }
        if(x-1>=0  && grid[x-1][y]=='1' && !visited[x-1][y]){
            dfs(grid, visited, x-1, y);
        }
        if(y+1<grid[0].length && grid[x][y+1]=='1' && !visited[x][y+1]){
            dfs(grid, visited, x, y+1);
        }
        if(y-1>=0 && grid[x][y-1]=='1' &&  !visited[x][y-1]){
            dfs(grid, visited, x, y-1);
        }

    }
}
