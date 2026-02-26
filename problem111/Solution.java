package problem111;

import java.util.ArrayList;
import java.util.List;

import problem101.TreeNode;

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        int count = 1;
        while (true) {
            // update list
            nodes = updateList(nodes);
            // check condition to stop loop
            count++;
            if (isStopLoop(nodes))
                break;

        }
        return count;
    }

    List<TreeNode> updateList(List<TreeNode> nodes) {
        List<TreeNode> tempList = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) != null) {
                if (nodes.get(i).left != null)
                    tempList.add(nodes.get(i).left);
                if (nodes.get(i).right != null)
                    tempList.add(nodes.get(i).right);
            }
        }
        return tempList;
    }

    boolean isStopLoop(List<TreeNode> nodes) {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) != null) {
                if (nodes.get(i).left == null && nodes.get(i).right == null)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        root.right.right.right.right = new TreeNode(6);
        Solution solution = new Solution();
        System.out.println(solution.minDepth(root));

    }
}
