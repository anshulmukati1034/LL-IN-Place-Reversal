public class Q3_ReverseNodesinkGroup {

    static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}


    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            // 1️⃣ Find kth node
            ListNode kth = groupPrev;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null)
                break;

            ListNode groupNext = kth.next;

            // 2️⃣ Reverse group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // 3️⃣ Connect
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
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

        int k = 2;
        head = reverseKGroup(head, k);

        System.out.println("Reversed in groups of " + k + ":");
        printList(head);
    }
}


