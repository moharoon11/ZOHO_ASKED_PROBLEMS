package LinkedList;

public class MiddleOfLinkedList {

    public class ListNode {

        int data;
        ListNode next;

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    // Brute approach
    public static ListNode findMiddleNoe(ListNode head) {
        int length = findLengthLL(head);

        int middleNodeIndex = (length / 2) + 1;

        ListNode temp = head;
        ListNode middleNode = null;
        while(temp != null) {
            middleNodeIndex -= 1;
            if(middleNodeIndex == 0) {
                middleNode = temp;
                break;
            }
            temp = temp.next;
        }

        return middleNode;
    }

    // find the length of linkedlist
    public static int findLengthLL(ListNode head) {
        ListNode temp = head;
        int length = 0;
        while(temp != null ){
            length++;
            temp = temp.next;
        }
        return length;
    }

    // TC: O(N)
    // SC: O(1)
    // optimal approach
    public static ListNode getMiddle(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }


}
