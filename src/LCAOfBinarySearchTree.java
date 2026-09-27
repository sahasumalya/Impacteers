class LCAOfBinarySearchTree {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root, p, q);
        return res;


    }

    public void dfs(TreeNode root, TreeNode p, TreeNode q){
        if(res!=null){
            return;
        }
        if(root.val==p.val || root.val==q.val){
            res = root;
            return;
        }
        if(p.val > root.val && q.val > root.val){
            dfs(root.right, p, q);
            return;
        }
        if(p.val < root.val && q.val < root.val){
            dfs(root.left, p, q);
            return;
        }
        // root'value is between the range of p and q's value
        res = root;
    }
}
