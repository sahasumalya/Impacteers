
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class DiameterOfBinaryTree {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root){
        int leftHeight = 0;
        int rightHeight = 0;
        if(root.left != null){
            leftHeight = dfs(root.left);
        }
        if(root.right != null){
            rightHeight = dfs(root.right);
        }
        res = Math.max(res, leftHeight+rightHeight);
        return Math.max(leftHeight,rightHeight) + 1;
    }
}
