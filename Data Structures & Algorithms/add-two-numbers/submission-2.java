/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        int c=0;
        while(l1!=null || l2!=null || c!=0){
            int n1=0;
            int n2=0;
            if(l1!=null){
                n1=l1.val;
            }
            if(l2!=null){
                n2=l2.val;
            }
            int sum=n1+n2+c;
            int d=sum%10;
            c=sum/10;
            temp.next=new ListNode(d);
            temp=temp.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        return dummy.next;
    }
}
