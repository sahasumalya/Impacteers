
class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return binaryDivision(nums, 0, nums.length-1);
    }

    public TreeNode binaryDivision(int[] nums, int start, int end){
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        if(mid-1>=start){
            TreeNode leftSubTree = binaryDivision(nums, start, mid-1);
            root.left = leftSubTree;
        }
        if(mid+1<=end){
            TreeNode rightSubTree = binaryDivision(nums, mid+1, end);
            root.right = rightSubTree;
        }
        return root;
    }
}