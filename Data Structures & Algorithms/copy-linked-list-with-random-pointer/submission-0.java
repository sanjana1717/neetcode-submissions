/*
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

public class Solution {

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node curr = head;

        // STEP 1:
        // Create copied nodes and insert them in between original nodes
        while (curr != null) {

            Node newNode = new Node(curr.val);

            newNode.next = curr.next;

            curr.next = newNode;

            curr = newNode.next;
        }

        curr = head;

        // STEP 2:
        // Copy random pointers
        while (curr != null) {

            if (curr.random != null) {

                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        curr = head;

        // STEP 3:
        // Separate original list and copied list
        Node newHead = head.next;

        Node newCurr = newHead;

        while (curr != null) {

            curr.next = newCurr.next;

            curr = curr.next;

            if (curr != null) {

                newCurr.next = curr.next;

                newCurr = newCurr.next;
            }
        }

        return newHead;
    }
}