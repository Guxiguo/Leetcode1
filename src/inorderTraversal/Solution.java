package inorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        return list;
    }

    public void dfs(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }

}
