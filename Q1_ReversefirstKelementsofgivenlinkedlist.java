public class Q1_ReversefirstKelementsofgivenlinkedlist {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node reverseFirstKElements(Node head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        Node current = head;
        Node prev = null;
        Node next = null;
        int count = 0;

        // Reverse first k nodes
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Connect the reversed part with the remaining list
        if (head != null) {
            head.next = current;
        }

        // prev is the new head of the reversed list
        return prev;
    }

    // Helper method to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        printList(head);

        int k = 3;
        head = reverseFirstKElements(head, k);

        System.out.println("List after reversing first " + k + " elements:");
        printList(head);
    }
}