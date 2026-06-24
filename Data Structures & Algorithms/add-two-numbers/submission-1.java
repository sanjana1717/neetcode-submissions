/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *
 *     ListNode() {}
 *
 *     ListNode(int val) {
 *         this.val = val;
 *     }
 *
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Dummy node to start the answer list
        ListNode dummy = new ListNode(0);

        // Pointer used to build the answer list
        ListNode temp = dummy;

        // Carry value
        int carry = 0;

        // Run until both lists become empty
        // AND no carry is left
        while (l1 != null || l2 != null || carry != 0) {

            // Store values from l1 and l2
            int num1 = 0;
            int num2 = 0;

            // If l1 exists, take its value
            if (l1 != null) {
                num1 = l1.val;
            }

            // If l2 exists, take its value
            if (l2 != null) {
                num2 = l2.val;
            }

            // Add both numbers and carry
            int sum = num1 + num2 + carry;

            // Digit to store in new node
            int digit = sum % 10;

            // Update carry
            carry = sum / 10;

            // Create new node with digit
            temp.next = new ListNode(digit);

            // Move temp forward
            temp = temp.next;

            // Move l1 forward if possible
            if (l1 != null) {
                l1 = l1.next;
            }

            // Move l2 forward if possible
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // Return answer list
        return dummy.next;
    }
}