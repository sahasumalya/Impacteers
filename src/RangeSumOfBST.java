
class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {

        int sum = 0;
        if(root.val >= low && root.val<=high){
            sum = sum + root.val;
            if(root.left!=null)
                sum = sum + rangeSumBST(root.left, low, root.val-1);
            if(root.right!=null)
                sum = sum + rangeSumBST(root.right, root.val+1, high);
        }
        else if(root.val>low && root.val>high && root.left!=null){
            sum = sum + rangeSumBST(root.left, low, high);
        } else if(root.val<low && root.val<high && root.right!=null){
            sum = sum + rangeSumBST(root.right, low, high);
        }
        return sum;
    }
}
