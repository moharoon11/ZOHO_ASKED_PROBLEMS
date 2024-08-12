package batch1;

public class ReverseLinkedList {

    public class Node  {
         int data;
         Node next;
    }
    // TIME COMPLEXITY: O(n)
    // SPACE COMPLEXITY: O(1)
    Node reverseList(Node head) {
        Node prev = null;
        Node temp = head;

        while(temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }



    /*********************** RECURSIVE APPROACH *************************/
    // Time Complexity: O(n)
    // Space Complexity: O(n) due to the recursion stack
    public static Node reverseListRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }



        // Reverse the current node's link
        Node newHead =reverseListRecursive(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;


        return newHead;
    }


}
