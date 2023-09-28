package recoverTree;

class Solution {
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);


    public void recoverTree(TreeNode root) {
        dfs(root);
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val =tmp;

    }

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        if (firstNode == null && preNode.val > root.val) firstNode = preNode;
        if (firstNode != null && preNode.val > root.val) secondNode = root;
        preNode = root;
        dfs(root.right);

    }
}
