
class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        visited[sr][sc] = true;
        dfs(image, sr, sc, color, image[sr][sc], visited);
        return image;
    }

    public void dfs(int[][] image, int x, int y, int newColor, int originalColor, boolean[][] visited){
        System.out.println("x="+x+" y="+y+" value="+image[x][y]);
        image[x][y] = newColor;
        if(x+1<image.length && !visited[x+1][y] && image[x+1][y]==originalColor){
            visited[x+1][y] = true;
            dfs(image, x+1, y, newColor, originalColor, visited);
        }
        if(x-1>=0 && !visited[x-1][y] && image[x-1][y]==originalColor){
            visited[x-1][y] = true;
            dfs(image, x-1, y, newColor, originalColor, visited);
        }
        if(y+1<image[0].length && !visited[x][y+1] && image[x][y+1]==originalColor){
            visited[x][y+1] = true;
            dfs(image, x, y+1, newColor, originalColor, visited);
        }
        if(y-1>=0 && !visited[x][y-1] && image[x][y-1]==originalColor){
            visited[x][y-1] = true;
            dfs(image, x, y-1, newColor, originalColor, visited);
        }

    }
}
