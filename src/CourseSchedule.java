import java.util.ArrayList;
import java.util.List;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            adjList.get(b).add(a);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] processed = new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                boolean res = dfs(adjList, visited, processed, i);
                if(!res)
                    return false;
            }
        }
        return true;

    }

    public boolean dfs(List<List<Integer>> adjList, boolean[] visited, boolean[] processed, int n){
        visited[n] = true;
        processed[n] = true;
        List<Integer> neighbours = adjList.get(n);
        for(int i=0;i<neighbours.size();i++){
            int cur = neighbours.get(i);
            if(processed[cur]){
                processed[n] = false;
                return false;
            }
            if(!visited[cur]){
                boolean res = dfs(adjList, visited, processed, cur);
                if(!res){
                    processed[n] = false;
                    return false;
                }
            }
        }
        processed[n] = false;
        return true;
    }
}