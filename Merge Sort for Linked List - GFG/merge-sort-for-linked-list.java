//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    
    static Node findmid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    static Node merge (Node head1,Node head2){
     Node merged = new Node (-1);
     Node temp = merged;
     
     while(head1!=null && head2!= null){
         if(head1.data<head2.data){
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
      while(head1!=null){
            temp.next = head1;
            temp = temp.next;
            head1 = head1.next;  
      }
       while(head2!=null){
            temp.next = head2;
            temp = temp.next;
            head2 = head2.next;  
      }
      return merged.next;
    }
    
    static Node mergeSort(Node head)
    {
        // add your code here
        if (head == null || head.next == null){
            return head;
        }
        
        //find mid
        Node mid = findmid(head);
        
        //left and right
        Node righthead = mid.next;
        mid.next = null;
        Node firsthalf = mergeSort(head);
        Node secondhalf = mergeSort(righthead);
        
        //call the merge fun
        return merge(firsthalf,secondhalf);
    }
}


