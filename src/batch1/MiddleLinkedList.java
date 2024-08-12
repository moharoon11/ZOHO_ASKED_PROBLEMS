package batch1;

public class MiddleLinkedList {

   public class Node {

       int data;
       Node next;
   }

   // TIME COMPLEXITY: O(2n) if we ignore constant it is O(n)
    // SPACE COMPLEXITY: O(1)
    int getMiddle(Node head) {
        int length = getLength(head);

        int middleIndex = (length / 2) + 1;

        Node temp = head;
        int result = -1;
        while(temp != null) {
            middleIndex--;

            if(middleIndex == 0) {
                result = temp.data;
                break;
            }

            temp = temp.next;
        }
        return result;
    }

    int getLength(Node head) {

        Node temp = head;
        int length = 0;

        while(temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }


    /****************** SLOW AND FAST POINTER APPROACH *********************************/
    // TIME COMPLEXITY: O(n)
    // SPACE COMPLEXITY: O(1)
    int getMiddleNode(Node head) {

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        return slow.data;
    }
}
