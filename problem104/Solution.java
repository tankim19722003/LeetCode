package problem104;

import problem101.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int maxDepth(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        int count = 1;
        if (root == null) return 0;
        while (true) {

//            if all null  break the loop
            if (canTraverse(nodes)) break;
//            add new item
            nodes = updateItem(nodes);
            count++;
        }
        return count;
    }

    public boolean canTraverse(List<TreeNode> nodes) {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).left != null || nodes.get(i).right != null) return false;
        }

        return true;
    }

    public List<TreeNode> updateItem(List<TreeNode> nodes) {
        List<TreeNode> tempNodes = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) != null) {
                if (nodes.get(i).left != null) tempNodes.add(nodes.get(i).left);
                if (nodes.get(i).right != null ) tempNodes.add(nodes.get(i).right);
            }

        }
        return tempNodes;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution solution = new Solution();
        System.out.println(solution.maxDepth(root));;
    }
}
