package problem94;

import problem101.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        helper(root, nodes);
        return nodes;
    }

    public void helper(TreeNode root, List<Integer> nodes) {
        if (root == null) return;
        helper(root.left, nodes);
        nodes.add(root.val);
        helper(root.right, nodes);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        Solution solution = new Solution();
        List<Integer> nodeValues = solution.inorderTraversal(root);
        for (Integer nodeValue : nodeValues) {
            System.out.println(nodeValue);
        }
    }
}
