import java.util.*;

class BinaryTreeZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(queue.size() > 0){
            int t = queue.size();
            List<Integer> arr = new ArrayList<>();
            while(t>0){
                TreeNode cur = queue.poll();
                arr.add(cur.val);
                t--;
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }
            if(level%2==1){
                Collections.reverse(arr);
            }
            res.add(arr);
            level++;
        }
        return res;


    }
}
