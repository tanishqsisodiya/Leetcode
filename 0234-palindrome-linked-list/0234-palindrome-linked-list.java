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
    public ListNode middle(ListNode head){
    ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;    
    }
    
    // public static void reverse(ListNode head){
    //     ListNode curr = head;
    //     ListNode next = head.next;
    //     ListNode prev = null;
    //     while(curr != null){
    //        next = curr.next;
    //        curr.next = prev;
    //        prev = curr;
    //        curr = next;
    //     }
    //     return prev;
    // }
    public boolean isPalindrome(ListNode head) {
        
        if(head == null && head.next == null) return true;
                
        // first step pehle middle find 
        
        ListNode mid = middle(head);
        
        // second step reverse krdo right half

        ListNode prev = null;
        ListNode curr = mid;
        ListNode next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        //third step hai check krna
        
        ListNode right = prev;
        ListNode left = head;
        
        while (right != null){
            if(left.val != right.val){
            return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
}