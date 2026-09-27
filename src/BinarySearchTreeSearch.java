
class BinarySearchTreeSearch {
    public TreeNode searchBST(TreeNode root, int val) {

        if(root==null){
            return null;
        }
        if(root.val == val){
            return root;
        }

        if(val > root.val && root.right!=null){
            return searchBST(root.right, val);
        }

        if(val <= root.val && root.left!=null){
            return searchBST(root.left, val);
        }

        return null;


    }
}
