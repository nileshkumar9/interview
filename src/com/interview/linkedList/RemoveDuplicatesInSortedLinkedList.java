package com.interview.linkedList;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 *
 * For example,
 *
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 *
 * Given 1->1->1->2->3, return 2->3.
 *
 * Logic : make sure that we are going to have a proper previous and previous.next assignment.
 * Previous.next is removing all the duplicate values.
 * We are shifting previous pointer so as that it will remove all duplicate nodes.
 * https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 */
public class RemoveDuplicatesInSortedLinkedList {

    public static ListNode deleteDuplicates(ListNode A) {
        ListNode tempHead = new ListNode(0);
        tempHead.next = A;
        ListNode prev = tempHead;

        while(A !=null){
            // Since its a sorted list loop till we have duplicates
            while(A.next!=null && A.val == A.next.val){
                A = A.next;
            }
            if(prev.next == A){
                prev = prev.next;
            } else{
                prev.next = A.next;
            }
            A = A.next;
        }
        return tempHead.next;
    }
    public static void main (String[] args){
        ListNode tempHead = new ListNode(0);
        ListNode tempHead1 = new ListNode(1);
        ListNode tempHead2 = new ListNode(1);
        ListNode tempHead3 = new ListNode(2);
        ListNode tempHead4 = new ListNode(2);
        ListNode tempHead5 = new ListNode(3);
        ListNode tempHead6 = new ListNode(4);


        tempHead.next = tempHead1;
        tempHead1.next = tempHead2;
        tempHead2.next = tempHead3;
        tempHead3.next = tempHead4;
        tempHead4.next = tempHead5;
        tempHead5.next = tempHead6;
        tempHead6.next = null;

        ListNode result = deleteDuplicates(tempHead);
        while(result!=null){
           System.out.println(result.val);
            result=result.next;

        }
    }
}
