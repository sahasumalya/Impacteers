import java.util.Stack;

class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        leftDfs(root, stack);
    }

    public int next() {
        TreeNode cur = stack.pop();
        if(cur.right!=null){
            leftDfs(cur.right, stack);
        }
        return cur.val;
    }

    public boolean hasNext() {
        return stack.size() > 0;
    }

    public void leftDfs(TreeNode root, Stack<TreeNode> stack){
        stack.push(root);
        if(root.left!=null){
            leftDfs(root.left, stack);
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
