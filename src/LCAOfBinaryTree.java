class LCAOfBinaryTree {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(res!=null){
            return false;
        }
        boolean current = false;
        boolean left = false;
        boolean right = false;

        if(root==p || root==q){
            current = true;
        }
        if(root.left!=null){
            left = dfs(root.left, p, q);
        }
        if(root.right!=null){
            right = dfs(root.right, p, q);
        }

        if((left && right) || (left && current) || (right && current)){
            res = root;
        }

        return current || left || right;
    }

}
