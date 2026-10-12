import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        int[] inorder = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            adjList.get(b).add(a);
            inorder[a]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inorder[i]==0){
                queue.add(i);
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while(queue.size()>0){
            int cur = queue.poll();
            res[index] = cur;
            index++;
            List<Integer> neighbours = adjList.get(cur);
            for(int i=0;i<neighbours.size();i++){
                int cn = neighbours.get(i);
                inorder[cn]--;
                if(inorder[cn]==0){
                    queue.add(cn);
                }
            }
        }
        if(index<numCourses){
            int[] emptyArr = {};
            return emptyArr;
        }
        return res;



    }
}
