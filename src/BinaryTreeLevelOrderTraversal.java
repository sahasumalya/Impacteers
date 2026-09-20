import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(queue.size()>0){
            int t = queue.size();
            List<Integer> arr = new ArrayList<>();
            while(t>0){
                TreeNode cur = queue.poll();
                arr.add(cur.val);
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
                t--;
            }
            res.add(arr);
        }

        return res;
    }
}
