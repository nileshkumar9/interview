package com.interview.linkedList;

/**
 * @author Nilesh Kumar
 *
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 * Interview bit :https://www.interviewbit.com/problems/list-cycle/
 *
 * Logic:
 * Slow = D + c*x + k
 * Fast = D + c*y + k
 * 2 Slow = Fast // on solving this equation we will get D is Distance before loop
 * and k is distance of meeting point from start of the loop.
 * D = ( y- 2x)* c -K.
 * So from meeting point, and head  : if we start traversing one node each we will meet at the starting point of the loop.
 *
 *
 */
public class FindCycleStartingPoint {
    public ListNode detectCycle(ListNode a) {
        // We will first find if the cycle exists;
        ListNode fast = a;
        ListNode slow = a;

        // Now iterate fast by 2 nodes and slow by one node till they meed.
        // This will give us the meeting point
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            // We found the meeting point of the both the nodes hence its a cycle.
            if (fast == slow) {
                break;
            }
        }
        // Now since a cycle is detected. Find the start of the loop.
        // bring one pointer to begining and other at the end.
        // D = (2f-s)C - K where k is the distance from start of the loop
        // One pointer will move N-K distance while other will move D distance before the start of the loop
        if (fast == null) {
            return null;
        }
        fast = a;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;

        }
        return fast;
    }
}

