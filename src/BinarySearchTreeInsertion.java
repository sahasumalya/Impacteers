
class BinarySearchTreeInsertion {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        dfs(root, val);
        return root;
    }

    public void dfs(TreeNode root, int val){

        if(val > root.val){
            if(root.right!=null){
                dfs(root.right, val);
            } else {
                TreeNode newNode = new TreeNode(val);
                root.right = newNode;
            }
        } else {
            if(root.left!=null){
                dfs(root.left, val);
            } else {
                TreeNode newNode = new TreeNode(val);
                root.left = newNode;
            }
        }
    }
}
