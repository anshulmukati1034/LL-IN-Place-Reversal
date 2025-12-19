public class Q5_ReverseAlternateKNode {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode reverseAlternateK(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode curr = head;
        ListNode prev = null;
        boolean reverse = true;

        while (curr != null) {
            ListNode lastPrev = prev;
            ListNode lastCurr = curr;

            // 🔁 Reverse k nodes
            if (reverse) {
                ListNode next = null;
                for (int i = 0; curr != null && i < k; i++) {
                    next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }

                if (lastPrev != null)
                    lastPrev.next = prev;
                else
                    head = prev;

                lastCurr.next = curr;
                prev = lastCurr;
            }
            // ⏭ Skip k nodes
            else {
                for (int i = 0; curr != null && i < k; i++) {
                    prev = curr;
                    curr = curr.next;
                }
            }

            reverse = !reverse; // toggle
        }
        return head;
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
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        System.out.println("Original List:");
        printList(head);

        int k = 3;
        head = reverseAlternateK(head, k);

        System.out.println("List after reversing alternate k nodes:");
        printList(head);
    }   
}


