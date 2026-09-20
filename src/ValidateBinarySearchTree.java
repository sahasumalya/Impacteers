
class BSTResult{
    boolean isBST;
    int minValue;
    int maxValue;

    public BSTResult(boolean isBST, int minValue, int maxValue){
        this.isBST = isBST;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

}
class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return dfs(root).isBST;
    }

    public BSTResult dfs(TreeNode root){

        boolean isLeftBST = true;
        boolean isRightBST = true;
        int maxLeft = Integer.MIN_VALUE;
        int minLeft = Integer.MAX_VALUE;
        int minRight = Integer.MAX_VALUE;
        int maxRight = Integer.MIN_VALUE;
        boolean isCurrentBST = true;

        if(root.left!=null){
            BSTResult res = dfs(root.left);
            isLeftBST = res.isBST;
            if(!isLeftBST){
                return new BSTResult(false, 0, 0);
            }
            maxLeft = res.maxValue;
            minLeft = res.minValue;
            isCurrentBST = root.val > maxLeft;
            if(!isCurrentBST){
                return new BSTResult(false, 0, 0);
            }

        }

        if(root.right!=null){
            BSTResult res = dfs(root.right);
            isRightBST = res.isBST;
            if(!isRightBST){
                return new BSTResult(false, 0, 0);
            }
            minRight = res.minValue;
            maxRight = res.maxValue;
            isCurrentBST = root.val < minRight;
            if(!isCurrentBST){
                return new BSTResult(false, 0, 0);
            }
        }




        int maxVal = Math.max(root.val, Math.max(maxLeft, maxRight));
        int minVal = Math.min(root.val, Math.min(minLeft, minRight));

        //return 0;

        return new BSTResult(isCurrentBST, minVal, maxVal);

    }


}
