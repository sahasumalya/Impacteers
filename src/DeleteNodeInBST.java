
class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return root;
        }

        return dfs(root, key);
    }
    public void insert(TreeNode root1, TreeNode root2){
        if(root2.val>root1.val){
            if(root1.right!=null){
                insert(root1.right, root2);
            } else {
                root1.right = root2;
            }
        } else {
            if(root1.left!=null){
                insert(root1.left, root2);
            } else {
                root1.left = root2;
            }
        }
    }
    public TreeNode dfs(TreeNode root, int key){
        if(root.val == key){

            if(root.left==null && root.right==null){
                return null;
            }

            if(root.left==null){
                return root.right;
            }

            if(root.right==null){
                return root.left;
            }

            TreeNode rightTree = root.right;
            insert(root.left, rightTree);
            return root.left;

        }

        if(key>root.val && root.right!=null){
            root.right = dfs(root.right, key);
        }
        if(key<=root.val && root.left!=null){
            root.left = dfs(root.left, key);
        }

        return root;
    }
}
