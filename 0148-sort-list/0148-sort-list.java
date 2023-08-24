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
    public ListNode findmid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode mergesort (ListNode head1, ListNode head2 ){
        ListNode newNode = new ListNode (-1);
        ListNode temp = newNode;
        while(head1 != null && head2 !=null){
        if(head1.val < head2.val){
            temp.next = head1;
            temp = temp.next;
            head1 = head1.next;
            }
        else{
            temp.next = head2;
            temp = temp.next;
            head2 = head2.next; 
        }
        }
        while(head1 != null){
        temp.next = head1;
            temp = temp.next;
            head1 = head1.next;
        }
        while(head2 != null){
        temp.next = head2;
            temp = temp.next;
            head2 = head2.next; 
        }
        return newNode.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next==null) {
        return head;
        }
        
        //find mid
        ListNode mid = findmid(head);
        
        //lefthalf and right half
        ListNode righthead = mid.next;
        mid.next = null;
       ListNode leftSort = sortList(head);
        ListNode rightSort= sortList(righthead);
        
        //merge sort
        return mergesort(leftSort,rightSort);
    }
}