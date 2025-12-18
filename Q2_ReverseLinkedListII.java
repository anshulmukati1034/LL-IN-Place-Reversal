public class Q2_ReverseLinkedListII {
    static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 1️⃣ Move prev to (left - 1)th node
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // 2️⃣ Reverse sublist
        ListNode curr = prev.next;
        ListNode next = null;

        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        int left = 2, right = 4;
        head = reverseBetween(head, left, right);

        System.out.println("Reversed List between positions " + left + " and " + right + ":");
        printList(head);
    }
}


