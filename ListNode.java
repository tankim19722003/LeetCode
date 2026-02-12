import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode startNode = head;

        while (head != null && head.next != null) {
            if (head.next.val == head.val)
                head.next = head.next.next;
            else
                head = head.next;
        }

        return startNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ListNode nodeAfterRemovingDouble = new Solution().deleteDuplicates(head);

        // print node
        while (nodeAfterRemovingDouble != null) {
            System.out.println(nodeAfterRemovingDouble.val);
            nodeAfterRemovingDouble = nodeAfterRemovingDouble.next;

        }

    }
}