class KthSmallestElementInBST {
    int count = 0;
    int res = -1;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }
    public void inorder(TreeNode root, int k){
        if(res>-1){
            return;
        }
        if(root.left!=null){
            inorder(root.left, k);
        }
        count++;
        if(count==k){
            res = root.val;
            return;
        }
        if(root.right!=null){
            inorder(root.right, k);
        }

    }
}
