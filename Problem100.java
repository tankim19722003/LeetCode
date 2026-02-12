import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Problem100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> resultFirstTree = new ArrayList<>();
        List<Integer> resultSecondTree = new ArrayList<>();
        convertTreeToList(p, resultFirstTree, 1);
        convertTreeToList(q, resultSecondTree, 2);
        for (int i = 0; i < resultFirstTree.size(); i++) {
            if (resultFirstTree.get(i) == null && resultSecondTree.get(i) != null)
                return false;
            if (resultFirstTree.get(i) != null && resultSecondTree.get(i) == null)
                return false;
            if (resultFirstTree.get(i) == null && resultSecondTree.get(i) == null)
                continue;
            if (!resultFirstTree.get(i).equals(resultSecondTree.get(i)))
                return false;
        }
        return true;
    }

    private void convertTreeToList(TreeNode p, List<Integer> results, int direction) {
        results.add((p != null) ? p.val : null);
        if (p == null)
            return;
        convertTreeToList(p.left, results, 1);
        convertTreeToList(p.right, results, 2);
    }

    private void printList(List<Integer> list) {
        System.out.println("List: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);

        System.out.println(new Problem100().isSameTree(root, root2));
    }
}
