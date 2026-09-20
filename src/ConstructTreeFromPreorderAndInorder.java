import java.util.HashMap;
import java.util.Map;

class ConstructTreeFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int i=0;i<preorder.length;i++){
            hmap.put(preorder[i], i);
        }
        return dfs(inorder, 0, inorder.length-1, hmap);

    }

    public TreeNode dfs(int[] inorder, int start, int end, Map<Integer, Integer> hmap){
        if(start==end){
            new TreeNode(inorder[start]);
        }
        int minPos = hmap.get(inorder[start]);
        int minIndex = start;
        for(int i=start+1;i<=end;i++){
            if(minPos>hmap.get(inorder[i])){
                minPos = hmap.get(inorder[i]);
                minIndex = i;
            }
        }
        TreeNode root = new TreeNode(inorder[minIndex]);
        if(minIndex>start){
            root.left = dfs(inorder, start, minIndex-1, hmap);
        }
        if(minIndex<end){
            root.right = dfs(inorder, minIndex+1, end, hmap);
        }
        return root;
    }
}
