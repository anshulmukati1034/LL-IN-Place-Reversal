public class Q7_ReverseNodesinEvenLengthGroups {
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

     public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;
        int groupSize = 1;

        while (curr != null) {
            // 1️⃣ Count actual group length
            ListNode temp = curr;
            int count = 0;

            while (temp != null && count < groupSize) {
                temp = temp.next;
                count++;
            }

            // 2️⃣ If even length → reverse
            if (count % 2 == 0) {
                ListNode lastCurr = curr;
                ListNode next = null;
                ListNode prevNode = null;

                for (int i = 0; i < count; i++) {
                    next = curr.next;
                    curr.next = prevNode;
                    prevNode = curr;
                    curr = next;
                }

                prev.next = prevNode;
                lastCurr.next = curr;
                prev = lastCurr;
            }
            // 3️⃣ If odd length → skip
            else {
                for (int i = 0; i < count; i++) {
                    prev = curr;
                    curr = curr.next;
                }
            }

            groupSize++;
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
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);

        System.out.println("Original List:");
        printList(head);

        Q7_ReverseNodesinEvenLengthGroups solution = new Q7_ReverseNodesinEvenLengthGroups();
        head = solution.reverseEvenLengthGroups(head);

        System.out.println("Modified List:");
        printList(head);
    } 
}
